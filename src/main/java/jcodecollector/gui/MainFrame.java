/*
 * Copyright 2006-2013 Alessandro Cocco.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jcodecollector.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileFilter;

import jcodecollector.MacUtilities;
import jcodecollector.State;
import jcodecollector.common.bean.Snippet;
import jcodecollector.common.bean.Syntax;
import jcodecollector.data.Controller;
import jcodecollector.data.DBMS;
import jcodecollector.data.SearchFilter;
import jcodecollector.data.settings.ApplicationSettings;
import jcodecollector.data.settings.ApplicationSettingsManager;
import jcodecollector.io.FileManager;
import jcodecollector.io.PackageManager;
import jcodecollector.listener.iCategoryListener;
import jcodecollector.listener.iCountListener;
import jcodecollector.listener.iMenuListener;
import jcodecollector.listener.iSearchListener;
import jcodecollector.listener.iSnippetListener;
import jcodecollector.listener.iWindowListener;
import jcodecollector.util.ApplicationConstants;
import jcodecollector.util.GeneralInfo;
import jcodecollector.util.OS;
import jcodecollector.util.Utility;

import com.explodingpixels.macwidgets.BottomBar;
import com.explodingpixels.macwidgets.BottomBarSize;
import com.explodingpixels.macwidgets.MacIcons;
import com.explodingpixels.macwidgets.MacUtils;
import com.explodingpixels.macwidgets.MacWidgetFactory;
import com.explodingpixels.macwidgets.SourceList;
import com.explodingpixels.macwidgets.SourceListCategory;
import com.explodingpixels.macwidgets.SourceListContextMenuProvider;
import com.explodingpixels.macwidgets.SourceListControlBar;
import com.explodingpixels.macwidgets.SourceListItem;
import com.explodingpixels.macwidgets.SourceListModelListener;
import com.explodingpixels.macwidgets.SourceListSelectionListener;
import com.explodingpixels.macwidgets.UnifiedToolBar;

/**
 * The main application window.
 * 
 * @author Alessandro Cocco *
 */
public class MainFrame extends JFrame implements iCountListener, iSnippetListener, iCategoryListener,
        iWindowListener, iSearchListener, iMenuListener {

    // The component that graphically displays the contents of the database.
    public SourceList   sourceList;

    // The panel split.
    private JSplitPane  split       = new JSplitPane();

    // The panel containing the editor of the snippet.
    public MyDialog     mainPanel   = new MyDialog(this);

    // The label with the statistics on the database.
    private JLabel      statusLabel;

    // The text box used to enter the search keywords.
    private JTextField  searchTextField;

    // The reset button??
    private JButton     turnOffButton;

    // The button to hide the panel
    private JButton     hideButton;

    // The about window.
    private AboutWindow aboutWindow = new AboutWindow(this);

    /**
     * The 'controller' MVC, is responsible for giving the data to the
     * interface,
     * 
     * 
     * ?? Whatever the origin of the same (or database search). ?? Google
     * translate
     */
    private Controller  controller  = Controller.getInstance();

    // The reference to the state of the application.
    private State       state       = State.getInstance();

    // The tree displaying snippets
    private JPanel      sourcePanel;

    public MainFrame() {
        setTitle(GeneralInfo.APPLICATION_NAME);
        if (!OS.isMacOSX()) {
            setTitle(GeneralInfo.APPLICATION_NAME
                    + " - "
                    + new File(ApplicationSettings.getInstance().getDatabasePath())
                            .getAbsolutePath());
        }

        if (OS.isMacOSX()) {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            MacUtils.makeWindowLeopardStyle(getRootPane());
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    prepareAndSaveSettings();
                    System.exit(0);
                }
            });
        }

        setSize(ApplicationSettings.getInstance().getWindowSize());
        setMinimumSize(OS.isMacOSX() ? new Dimension(750, 393) : new Dimension(750, 383));

        initSourceList();
        initSearchComponents();

        sourcePanel = new JPanel(new BorderLayout());
        sourcePanel.add(sourceList.getComponent(), BorderLayout.CENTER);

        split.setBorder(null);
        split.setDividerSize(1);
        split.setContinuousLayout(true);
        split.setDividerLocation(ApplicationSettings.getInstance().getSourceListWidth());
        split.setLeftComponent(sourcePanel);
        split.getLeftComponent().setMinimumSize(new Dimension(250, 50));
        split.setRightComponent(mainPanel.getContentPane());
        setPreferredSize(ApplicationSettings.getInstance().getWindowSize());

        JButton newSnippet = new JButton("New Snippet");
        newSnippet.setFocusable(false);
        newSnippet.putClientProperty("JButton.buttonType", "textured");
        newSnippet.addActionListener(NEW_EMPTY_SNIPPET_ACTION);

        if (OS.isMacOSX()) {
            statusLabel = MacWidgetFactory.makeEmphasizedLabel(new JLabel("", JLabel.CENTER));
            // statusLabel.setFont(statusLabel.getFont().deriveFont(statusLabel.getFont().getSize()
            // - 1.8f));
        } else {
            statusLabel = new JLabel("", JLabel.CENTER);
        }

        UnifiedToolBar unifiedToolBar = new UnifiedToolBar();

        // workaround
        Border currentToolBarBorder = unifiedToolBar.getComponent().getBorder();
        Border newToolBarBorder = BorderFactory.createCompoundBorder(new EmptyBorder(-5, 0, 0, 0),
                currentToolBarBorder);
        unifiedToolBar.getComponent().setBorder(newToolBarBorder);
        // end workaround

        unifiedToolBar.addComponentToLeft(newSnippet);
        unifiedToolBar.disableBackgroundPainter();
        unifiedToolBar.installWindowDraggerOnWindow(this);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        if (OS.isMacOSX()) {
            unifiedToolBar.addComponentToRight(searchTextField);
            container.add(unifiedToolBar.getComponent(), BorderLayout.NORTH);
        }
        container.add(split, BorderLayout.CENTER);

        if (OS.isMacOSX()) {
            BottomBar bottomBar = new BottomBar(BottomBarSize.LARGE);
            bottomBar.addComponentToCenter(statusLabel);
            bottomBar.installWindowDraggerOnWindow(this);
            container.add(bottomBar.getComponent(), BorderLayout.SOUTH);
        } else {
            JPanel searchPanel = new JPanel(new BorderLayout(5, 5));
            searchPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
            searchPanel.add(searchTextField, BorderLayout.CENTER);

            JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 1, 0));
            controlPanel.setBorder(new EmptyBorder(5, 2, 5, 5));
            if (!OS.isMacOSX()) {
                controlPanel.add(turnOffButton);
            }

            hidePanel.setLayout(new BorderLayout());
            hidePanel.setBorder(new CompoundBorder(new EmptyBorder(-2, -2, -1, -2),
                    new EtchedBorder()));
            hidePanel.add(searchPanel, BorderLayout.CENTER);
            if (!OS.isMacOSX()) {
                JLabel searchLabel = new JLabel(
                        "<html>Press <b>ENTER</b> to start search, <b>CTRL+K</b> to cancel</html>");
                searchLabel.setBorder(new EmptyBorder(5, 5, 0, 5));
                hidePanel.add(searchLabel, BorderLayout.NORTH);
            }
        }

        pack();

        // create and add the menu bar
        buildMenuBar();

        try {
            setLocation(ApplicationSettings.getInstance().getWindowLocation());
        } catch (Exception ex) {
            setLocationRelativeTo(null);
        }

        // register various custom listeners
        state.addSnippetListener(this);
        state.addSnippetListener(mainPanel);

        state.addCategoryListener(this);
        state.addCategoryListener(mainPanel);
        state.addCountListener(this);

        state.addMenuListener(this);
        state.addWindowListener(this);
        state.addSearchListener(this);

        // ??I make some updates soon??
        state.countUpdate();
        state.updateMenu(true, true);
        state.updateLineNumbers(true);

        if (OS.isMacOSX()) {
            initMacUtilities();
        }
    }

    JPanel hidePanel = new JPanel();

    private void initMacUtilities() {
        new MacUtilities().installMacUtilities(this);
        // try {
        // ClassLoader loader = ClassLoader.getSystemClassLoader();
        // Class<?> clazz = loader.loadClass("jcodecollector.MacUtilities");
        // Object macUtilitiesInstance = clazz.newInstance();
        // clazz.getMethod("installMacUtilities",
        // MainFrame.class).invoke(macUtilitiesInstance, this);
        // } catch (Exception ex) {
        // System.err.println("cannot load MacUtilities class :-/");
        // ex.printStackTrace();
        // }
    }

    /**
     * Select the snippet that was "current" at the time of closing application
     */
    public void restoreSelectedSnippet() {
        String selectedSnippet = ApplicationSettings.getInstance().getSelectedSnippet();
        if (selectedSnippet != null) {
            manuallySelectItem(selectedSnippet);
        }
    }

    private void initSourceList() {
        sourceList = new SourceList();
        // TODO do not recreate everything all the time
        sourceList.setSourceListContextMenuProvider(new SourceListContextMenuProvider() {
            public JPopupMenu createContextMenu(SourceListCategory category) {
                CATEGORY_POPUP_MANAGER_ACTION.setText(category.getText());

                JMenuItem renameItem = new JMenuItem(CATEGORY_POPUP_MANAGER_ACTION);
                renameItem.setText("Rename...");

                JMenuItem removeItem = new JMenuItem(CATEGORY_POPUP_MANAGER_ACTION);
                removeItem.setText("Remove");

                JMenuItem createPackageItem = new JMenuItem(CATEGORY_POPUP_MANAGER_ACTION);
                createPackageItem.setText("Export...");

                JMenu moveAllItem = new JMenu("Merge In...");

                JMenuItem separator = new JMenuItem("");
                separator.setEnabled(false);

                JMenu syntaxItem = new JMenu(CATEGORY_POPUP_MANAGER_ACTION);
                syntaxItem.setText("Set Syntax...");
                for (String s : mainPanel.getSyntaxes()) {
                    final JMenuItem item = new JMenuItem(s);
                    item.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if (controller.updateSyntax(item.getText(),
                                    CATEGORY_POPUP_MANAGER_ACTION.getText(), !state
                                            .isSnippetSaved() ? state.getNameOfSelectedSnippet()
                                            : null)) {
                                state.syntaxRenamed(item.getText(),
                                        CATEGORY_POPUP_MANAGER_ACTION.getText());
                            }
                        }
                    });
                    syntaxItem.add(item);
                }

                ArrayList<String> categories = controller.getAllCategories();
                categories.remove(category.getText());

                JPopupMenu adapter = new JPopupMenu();
                adapter.add(renameItem);
                adapter.add(removeItem);
                adapter.add(syntaxItem);
                adapter.add(createPackageItem);
                adapter.addSeparator();
                adapter.add(moveAllItem);
                for (String s : categories) {
                    JMenuItem temp = new JMenuItem(CATEGORY_POPUP_MANAGER_ACTION);
                    temp.setText(s);
                    moveAllItem.add(temp);
                }

                return adapter;
            }

            public JPopupMenu createContextMenu(SourceListItem item) {
                ITEM_POPUP_MANAGER_ACTION.setText(item.getText());
                JMenu moveItem = new JMenu("Move To...");

                JMenuItem showInEditorItem = new JMenuItem(ITEM_POPUP_MANAGER_ACTION);
                showInEditorItem.setText("Open In Editor...");

                JMenuItem showInOtherWindowItem = new JMenuItem(ITEM_POPUP_MANAGER_ACTION);
                showInOtherWindowItem.setText("Open In A New Window...");

                JMenuItem removeItem = new JMenuItem(ITEM_POPUP_MANAGER_ACTION);
                removeItem.setText("Remove");

                JMenuItem separatorItem = new JMenuItem("");
                separatorItem.setEnabled(false);

                JMenuItem newCategoryItem = new JMenuItem(ITEM_POPUP_MANAGER_ACTION);
                newCategoryItem.setText("New Category...");

                ArrayList<String> categories = controller.getAllCategories();
                categories.remove(controller.getCategoryOf(item.getText()));

                moveItem.add(newCategoryItem);
                moveItem.addSeparator();
                for (String category : categories) {
                    moveItem.add(new JMenuItem(ITEM_POPUP_MANAGER_ACTION)).setText(category);
                }

                JPopupMenu popupMenuAdapter = new JPopupMenu();
                popupMenuAdapter.add(moveItem);
                popupMenuAdapter.addSeparator();
                popupMenuAdapter.add(removeItem);

                return popupMenuAdapter;
            }

            public JPopupMenu createContextMenu() {
                return null;
            }
        });

        SourceListControlBar controlBar = new SourceListControlBar();
        controlBar.installDraggableWidgetOnSplitPane(split);
        controlBar.createAndAddButton(MacIcons.PLUS, NEW_EMPTY_SNIPPET_ACTION);
        controlBar.createAndAddButton(MacIcons.MINUS, REMOVE_SNIPPET_ACTION);

        sourceList.installSourceListControlBar(controlBar);
        sourceList.addSourceListSelectionListener(new SourceListSelectionListener() {
            public void sourceListItemSelected(SourceListItem item) {
                if (item == null) {
                    state.setNameOfSelectedCategory(null);
                    state.setNameOfSelectedSnippet(null);
                    state.setPreviousSnippet(null);
                    state.updateSnippetStatus(false, false, false);

                    mainPanel.clear();
                } else {
                    // I read the snippet corresponding to the selected
                    // name
                    Snippet snippet = controller.getSnippet(item.getText().trim());

                    // imposed as the snippet work
                    state.setPreviousSnippet(snippet);
                    state.setNameOfSelectedCategory(snippet.getCategory());
                    state.setNameOfSelectedSnippet(snippet.getName());

                    // update the editor
                    mainPanel.setSnippet(snippet);

                    // Scrolls using the arrow keys when you move
                    // between snippets
                    sourceList.scrollItemToVisible(item);

                    state.updateSnippetStatus(true, true, snippet.isLocked());
                    state.updateMenu(true, false);
                    state.updateWindowStatus(false);

                    checkAutoHideCommentPanel(snippet, false);
                }
            }
        });

        sourceList.getModel().addSourceListModelListener(new SourceListModelListener() {
            public void categoryAdded(SourceListCategory sourceListCategory, int i) {
                state.countUpdate();
            }

            public void itemChanged(SourceListItem item) {
            }

            public void categoryRemoved(SourceListCategory sourceListCategory) {
                state.countUpdate();
            }

            public void itemAddedToCategory(SourceListItem sourceListItem,
                    SourceListCategory sourceListCategory, int i) {
                state.countUpdate();
            }

            public void itemAddedToItem(SourceListItem sourceListItem,
                    SourceListItem parentSourceListItem, int i) {
                state.countUpdate();
            }

            public void itemRemovedFromCategory(SourceListItem sourceListItem,
                    SourceListCategory sourceListCategory) {
                state.countUpdate();
            }

            public void itemRemovedFromItem(SourceListItem sourceListItem,
                    SourceListItem parentsoSourceListItem) {
                state.countUpdate();
            }
        });
    }

    /**
     * <code>true</code> indicates that the snippet was previously selected No
     * comment.
     */
    private boolean previousCommentWasEmpty;

    private void checkAutoHideCommentPanel(Snippet snippet, boolean menuItemClicked) {
        int length = snippet != null ? snippet.getComment().trim().length() : 0;
        if (autoHideCommentPanelMenuItem.isSelected()) {
            if (previousCommentWasEmpty && length == 0) {
                /*
                 * Previous and current empty empty comment: hide the Panel.
                 * This is because 'can' happen that the user comments A snippet
                 * without comment, then moved to another Snippet without
                 * comment. In this case I have to hide the Panel.
                 */
                hideCommentPanel();
            } else if (!previousCommentWasEmpty && length == 0) {
                // previous comment is not empty and current empty hide the
                // Panel
                hideCommentPanel();
            } else if (previousCommentWasEmpty && length > 0) {
                // previous comment vacuum and current non-empty: the monster
                // Panel
                showCommentPanel();
            } else {
                // previous non-empty, the current non-empty: do not do anything
            }
        }

        /*
         * Check here later to click directly on the menu. If the car and hide '
         * Been activated and I'm in a snippet without comment hide the Panel.
         * If I am in a snippet with commentary and panel and ' I make the
         * hidden visible.
         */
        if (menuItemClicked) {
            if (autoHideCommentPanelMenuItem.isSelected()) {
                if (length == 0 && showCommentPanelMenuItem.isSelected()) {
                    hideCommentPanel();
                } else if (length > 0 && !showCommentPanelMenuItem.isSelected()) {
                    showCommentPanel();
                }
            }
        }

        previousCommentWasEmpty = snippet.getComment().trim().length() == 0;
    }

    void showCommentPanel() {
        if (showCommentPanelMenuItem.isSelected()) {
            // already visible, do nothing
            return;
        } else {
            showCommentPanelMenuItem.doClick();
        }
    }

    void hideCommentPanel() {
        if (showCommentPanelMenuItem.isSelected()) {
            showCommentPanelMenuItem.doClick();
        } else {
            // already visible, do nothing
            return;
        }
    }

    private void initSearchComponents() {
        searchTextField = new PromptTextField("", OS.isMacOSX() ? "Search" : "", 15);
        searchTextField.addActionListener(START_SEARCH_ACTION);
        searchTextField.putClientProperty("JTextField.variant", "search");
        searchTextField.putClientProperty("JTextField.Search.CancelAction",
                CANCEL_BUTTON_SEARCH_ACTION);

        if (OS.isMacOSX()) {
            getRootPane().registerKeyboardAction(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            searchTextField.requestFocusInWindow();
                        }
                    },
                    KeyStroke.getKeyStroke(KeyEvent.VK_F, Toolkit.getDefaultToolkit()
                            .getMenuShortcutKeyMask()), JComponent.WHEN_IN_FOCUSED_WINDOW);
        }

        getRootPane().registerKeyboardAction(
                CANCEL_BUTTON_SEARCH_ACTION,
                KeyStroke.getKeyStroke(KeyEvent.VK_K, Toolkit.getDefaultToolkit()
                        .getMenuShortcutKeyMask()), JComponent.WHEN_IN_FOCUSED_WINDOW);

        if (!OS.isMacOSX()) {
            getRootPane().registerKeyboardAction(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            searchTextField.requestFocusInWindow();
                            searchTextField.selectAll();
                        }
                    },
                    KeyStroke.getKeyStroke(KeyEvent.VK_L, Toolkit.getDefaultToolkit()
                            .getMenuShortcutKeyMask()), JComponent.WHEN_IN_FOCUSED_WINDOW);
        }

        turnOffButton = new JButton("Clear");
        turnOffButton.addActionListener(CANCEL_BUTTON_SEARCH_ACTION);
        turnOffButton.setPreferredSize(new Dimension(
                mainPanel.saveButton.getPreferredSize().width + 10, turnOffButton
                        .getPreferredSize().height));

        hideButton = new JButton("Hide");
        hideButton.addActionListener(HIDE_SEARCH_PANEL_ACTION);
    }

    /** Collects and saves the settings of the program. */
    public void prepareAndSaveSettings() {
        ApplicationSettings.getInstance().setWindowSize(getSize());
        ApplicationSettings.getInstance().setWindowLocation(getLocation());
        ApplicationSettings.getInstance().setSourceListWidth(split.getDividerLocation());
        // ApplicationSettings.getInstance().setEditorWidth(mainPanel.split.getDividerLocation());
        ApplicationSettings.getInstance().setLineNumbersEnabled(
                mainPanel.scrollPanel.getLineNumbersEnabled());
        ApplicationSettings.getInstance().setCommentPanelVisible(
                showCommentPanelMenuItem.isSelected());
        ApplicationSettings.getInstance().setSelectedSnippet(state.getNameOfSelectedSnippet());
        ApplicationSettings.getInstance().setAutoHideCommentEnabled(
                autoHideCommentPanelMenuItem.isSelected());

        ApplicationSettingsManager.saveApplicationSettings();
    }

    /** Action for creating a new snippet. */
    final ActionListener NEW_EMPTY_SNIPPET_ACTION          = new ActionListener() {
                                                               public void actionPerformed(
                                                                       ActionEvent e) {
                                                                   sourceList.clearSelection();
                                                                   mainPanel.createNewSnippet();

                                                                   state.setPreviousSnippet(null);
                                                                   state.updateSnippetStatus(false,
                                                                           false, false);

                                                                   state.updateWindowStatus(true);
                                                                   showCommentPanel();
                                                               }
                                                           };

    /** Action of creating a new snippet from the clipboard. */
    final ActionListener NEW_SNIPPET_FROM_CLIPBOARD_ACTION = new ActionListener() {
                                                               public void actionPerformed(
                                                                       ActionEvent e) {
                                                                   sourceList.clearSelection();
                                                                   mainPanel.pasteFromClipboard();

                                                                   state.setPreviousSnippet(null);
                                                                   state.updateSnippetStatus(false,
                                                                           false, false);

                                                                   state.updateWindowStatus(true);
                                                                   showCommentPanel();
                                                               }
                                                           };

    /** For removal of selected snippet. */
    final ActionListener REMOVE_SNIPPET_ACTION             = new ActionListener() {
                                                               public void actionPerformed(
                                                                       ActionEvent e) {
                                                                   if (sourceList.getSelectedItem() == null) {
                                                                       return;
                                                                   }

                                                                   String name = sourceList
                                                                           .getSelectedItem()
                                                                           .getText();
                                                                   Snippet snippet = controller
                                                                           .getSnippet(name);
                                                                   String category = snippet
                                                                           .getCategory();

                                                                   if (category == null) {
                                                                       return;
                                                                   }

                                                                   // remove the
                                                                   // snippet
                                                                   if (controller
                                                                           .removeSnippet(name)) {
                                                                       actionsAfterRemovingSnippet(snippet);
                                                                   }
                                                               }
                                                           };

    private void actionsAfterRemovingSnippet(Snippet snippet) {
        state.snippetRemoved(snippet);
        state.updateSnippetStatus(false, false, false);
        state.updateWindowStatus(false);
        state.updateMenu(true, true);
    }

    final ActionListener COPY_TO_CLIPBOARD_ACTION    = new ActionListener() {
                                                         public void actionPerformed(ActionEvent e) {
                                                             mainPanel.copyToClipboard();
                                                         }
                                                     };

    final ActionListener LOCK_SNIPPET_ACTION         = new ActionListener() {
                                                         public void actionPerformed(ActionEvent e) {
                                                             mainPanel.lockButton.doClick();
                                                         }
                                                     };

    /** Try saving the current snippet. */
    final ActionListener SAVE_SNIPPET_ACTION         = new ActionListener() {
                                                         public void actionPerformed(ActionEvent e) {
                                                             Snippet newSnippet = mainPanel
                                                                     .getSnippet();
                                                             Snippet oldSnippet = state
                                                                     .getPreviousSnippet();

                                                             if (newSnippet == null) {
                                                                 System.out
                                                                         .println("new snippet is null");
                                                                 return;
                                                             }

                                                             // the snippet
                                                             // above and null:
                                                             // it is a new
                                                             // entry
                                                             if (oldSnippet == null) {
                                                                 if (controller
                                                                         .insertNewSnippet(newSnippet)) {
                                                                     insertSnippet(newSnippet);
                                                                 } else {
                                                                     error(newSnippet.getName());
                                                                     return;
                                                                 }
                                                             } else {
                                                                 // if changes
                                                                 // are made
                                                                 // ​​correctly
                                                                 // update
                                                                 // SourceList
                                                                 if (controller.updateSnippet(
                                                                         oldSnippet, newSnippet)) {
                                                                     updateSnippetInSourceList(
                                                                             oldSnippet, newSnippet);
                                                                 } else {
                                                                     error(newSnippet.getName());
                                                                     return;
                                                                 }
                                                             }

                                                             state.updateSnippetStatus(true, true,
                                                                     false);
                                                             state.updateWindowStatus(false);
                                                             state.updateMenu(true, true);

                                                             checkAutoHideCommentPanel(newSnippet,
                                                                     false);
                                                         }

                                                         /**
                                                          * Displays an error
                                                          * message.
                                                          * 
                                                          * @param name
                                                          *            The
                                                          *            snippet
                                                          *            that
                                                          *            caused
                                                          *            the
                                                          *            error.
                                                          */
                                                         private void error(String name) {
                                                             JOptionPane
                                                                     .showMessageDialog(
                                                                             MainFrame.this,
                                                                             "<html><b>A snippet named \""
                                                                                     + name
                                                                                     + "\" already exists!</b><br><br><font size=3>"
                                                                                     + "The name of a snippet is a <i>primary key</i> "
                                                                                     + "and <b>must</b> be unique.</font></html>",
                                                                             "Houston, we have a problem...",
                                                                             JOptionPane.ERROR_MESSAGE);
                                                         }
                                                     };

    final ActionListener RELOAD_SOURCE_LIST_ACTION   = new ActionListener() {
                                                         public void actionPerformed(ActionEvent e) {
                                                             mainPanel.clear();
                                                             reloadSourceList();
                                                         }
                                                     };

    final ActionListener SHOW_SEARCH_PANEL_ACTION    = new ActionListener() {
                                                         public void actionPerformed(ActionEvent e) {
                                                             if (!OS.isMacOSX()) {
                                                                 if (hidePanel.getParent() == null) {
                                                                     sourcePanel.add(hidePanel,
                                                                             BorderLayout.NORTH);
                                                                 } else {
                                                                     sourcePanel.remove(hidePanel);
                                                                 }
                                                                 sourcePanel.validate();
                                                             }

                                                             updateMenu(true, false);
                                                             searchTextField.requestFocusInWindow();
                                                         }
                                                     };

    final ActionListener CANCEL_BUTTON_SEARCH_ACTION = new ActionListener() {
                                                         public void actionPerformed(ActionEvent e) {
                                                             searchTextField.setText("");
                                                             if (state.isSearchActive()) {
                                                                 searchEnabledMenuItem
                                                                         .setEnabled(false);
                                                                 state.updateSearch(false);
                                                             }
                                                             updateMenu(true, false);
                                                         }
                                                     };

    final ActionListener HIDE_SEARCH_PANEL_ACTION    = new ActionListener() {
                                                         public void actionPerformed(ActionEvent e) {
                                                             if (!OS.isMacOSX()
                                                                     && hidePanel.getParent() != null) {
                                                                 getContentPane().remove(hidePanel);
                                                                 getContentPane().validate();
                                                             }
                                                             updateMenu(true, false);
                                                         }
                                                     };

    final ActionListener START_SEARCH_ACTION         = new ActionListener() {
                                                         public void actionPerformed(ActionEvent e) {
                                                             // interrupt if the
                                                             // user enters an
                                                             // empty string
                                                             String text = searchTextField
                                                                     .getText().trim();
                                                             if (text.length() == 0) {
                                                                 if (e != null) {
                                                                     Toolkit.getDefaultToolkit()
                                                                             .beep();
                                                                 }

                                                                 // ??if
                                                                 // research and
                                                                 // 'active
                                                                 // off??
                                                                 if (state.isSearchActive()) {
                                                                     CANCEL_BUTTON_SEARCH_ACTION
                                                                             .actionPerformed(e);
                                                                 }

                                                                 return;
                                                             }

                                                             // the entered
                                                             // string * should
                                                             // * be valid: I
                                                             // separate the
                                                             // Various keywords
                                                             // and take off the
                                                             // spaces before
                                                             // and after the
                                                             // Text, then I do
                                                             // a search
                                                             String[] keywords = text.split(",");
                                                             for (int i = 0; i < keywords.length; i++) {
                                                                 keywords[i] = keywords[i].trim();
                                                             }

                                                             // start the search
                                                             state.startSearch();

                                                             // search result
                                                             TreeMap<String, TreeSet<String>> data = DBMS
                                                                     .getInstance().search(
                                                                             keywords,
                                                                             controller.getValue());
                                                             controller.setData(data);

                                                             // The search has
                                                             // not yielded
                                                             // results: emit a
                                                             // Sound, stop
                                                             // searching and
                                                             // give back
                                                             // control
                                                             if (data.size() == 0) {
                                                                 Toolkit.getDefaultToolkit().beep();
                                                                 state.stopSearch();
                                                             }

                                                             // ??Active chance
                                                             // to disable
                                                             // search??
                                                             searchEnabledMenuItem.setEnabled(true);

                                                             // Search results:
                                                             // inform the
                                                             // various
                                                             // listeners
                                                             state.updateSearch(true);
                                                         }
                                                     };

    final ActionListener IMPORT_PACKAGE_ACTION       = new ActionListener() {
                                                         public void actionPerformed(ActionEvent e) {
                                                             importPackage();
                                                         }
                                                     };

    final ActionListener EXPORT_ALL_SNIPPETS_ACTION  = new ActionListener() {
                                                         public void actionPerformed(ActionEvent e) {
                                                             exportPackage(null);
                                                         }
                                                     };

    final ActionListener EXPORT_CATEGORY_ACTION      = new ActionListener() {
                                                         public void actionPerformed(ActionEvent e) {
                                                             exportPackage(e.getActionCommand());
                                                         }
                                                     };

    final ActionListener MINIMIZE_WINDOW_ACTION      = new ActionListener() {
                                                         public void actionPerformed(ActionEvent e) {
                                                             if (MainFrame.this.getExtendedState() == JFrame.NORMAL) {
                                                                 setExtendedState(JFrame.ICONIFIED);
                                                             }
                                                         }
                                                     };

    final ActionListener CLOSE_WINDOW_ACTION         = new ActionListener() {
                                                         public void actionPerformed(ActionEvent e) {
                                                             MainFrame.this.setVisible(false);
                                                         }
                                                     };

    final ActionListener ZOOM_WINDOW_ACTION          = new ActionListener() {
                                                         public void actionPerformed(ActionEvent e) {
                                                             if (MainFrame.this.getExtendedState() == JFrame.NORMAL) {
                                                                 MainFrame.this
                                                                         .setExtendedState(JFrame.MAXIMIZED_BOTH);
                                                             } else {
                                                                 MainFrame.this
                                                                         .setExtendedState(JFrame.NORMAL);
                                                             }
                                                         }
                                                     };

    final ActionListener CHANGE_LOCATION_ACTION      = new ActionListener() {
                                                         public void actionPerformed(ActionEvent e) {
                                                             File newLocation = null;
                                                             File oldLocation = new File(
                                                                     ApplicationSettings
                                                                             .getInstance()
                                                                             .getDatabasePath()
                                                                             + "/jCodeCollector");

                                                             if (OS.isMacOSX()) {
                                                                 // the file
                                                                 // dialog can
                                                                 // only accept
                                                                 // directory
                                                                 // (change the
                                                                 // Default
                                                                 // behavior)
                                                                 System.setProperty(
                                                                         "apple.awt.fileDialogForDirectories",
                                                                         "true");

                                                                 FileDialog dialog = new FileDialog(
                                                                         MainFrame.this);
                                                                 dialog.setTitle("Choose New Location...");
                                                                 dialog.setModal(true);
                                                                 dialog.setMode(FileDialog.LOAD);
                                                                 dialog.setDirectory(ApplicationSettings
                                                                         .getInstance()
                                                                         .getUserHome());

                                                                 setJMenuBar(new JMenuBar());
                                                                 dialog.setVisible(true);
                                                                 setJMenuBar(menuBar);

                                                                 // restores the
                                                                 // default
                                                                 // filter file
                                                                 // dialog
                                                                 System.setProperty(
                                                                         "apple.awt.fileDialogForDirectories",
                                                                         "false");

                                                                 if (dialog.getFile() == null) {
                                                                     return;
                                                                 }

                                                                 newLocation = new File(
                                                                         dialog.getDirectory()
                                                                                 + dialog.getFile()
                                                                                 + "/");
                                                             } else {
                                                                 JFileChooser chooser = new JFileChooser();
                                                                 chooser.setAcceptAllFileFilterUsed(false);
                                                                 chooser.setDialogTitle("Choose New Location...");
                                                                 chooser.setMultiSelectionEnabled(false);
                                                                 chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                                                                 chooser.setFileFilter(new FileFilter() {
                                                                     @Override
                                                                     public String getDescription() {
                                                                         return "Folder Only";
                                                                     }

                                                                     @Override
                                                                     public boolean accept(File f) {
                                                                         return f.isDirectory();
                                                                     }
                                                                 });

                                                                 if (chooser
                                                                         .showOpenDialog(MainFrame.this) != JFileChooser.APPROVE_OPTION) {
                                                                     return;
                                                                 }

                                                                 newLocation = chooser
                                                                         .getSelectedFile();
                                                             }

                                                             // update the
                                                             // settings and
                                                             // force saving to
                                                             // file
                                                             ApplicationSettings
                                                                     .getInstance()
                                                                     .setDatabasePath(
                                                                             newLocation
                                                                                     .getAbsolutePath());
                                                             ApplicationSettingsManager
                                                                     .saveApplicationSettings();

                                                             // I make a copy of
                                                             // the database to
                                                             // the new
                                                             // position: if all
                                                             // goes
                                                             // Ok re-import the
                                                             // connection to
                                                             // the new
                                                             // database, gate
                                                             // The old one
                                                             if (DBMS.getInstance().copyDatabase(
                                                                     newLocation.getAbsolutePath())) {
                                                                 if (DBMS.getInstance()
                                                                         .resetConnection()) {
                                                                     if (!FileManager
                                                                             .deleteDirectory(oldLocation)) {
                                                                         JOptionPane
                                                                                 .showMessageDialog(
                                                                                         MainFrame.this,
                                                                                         "<html><b>An error occured while moving the database</b>.<br><br>"
                                                                                                 + "All your data has been copied successfully in the new location but the old database folder cannot be removed.<br>"
                                                                                                 + "You should manually remove the folder <b>"
                                                                                                 + oldLocation
                                                                                                         .getAbsolutePath()
                                                                                                 + "</b>.</html>",
                                                                                         "",
                                                                                         JOptionPane.WARNING_MESSAGE);
                                                                     }

                                                                     if (!OS.isMacOSX()) {
                                                                         setTitle(GeneralInfo.APPLICATION_NAME
                                                                                 + " - "
                                                                                 + ApplicationSettings
                                                                                         .getInstance()
                                                                                         .getDatabasePath());
                                                                     }
                                                                 }
                                                             }
                                                         }
                                                     };

    /**
     * Wrap in SourceList a new element representing the snippet Just inserted
     * into the database.
     * 
     * @param newSnippet
     *            The snippet you just entered in the database.
     */
    private void insertSnippet(Snippet newSnippet) {
        String category = newSnippet.getCategory();
        String name = newSnippet.getName();
        SourceListCategory sourceListCategory = getSourceListCategoryOf(category);

        if (sourceListCategory == null) {
            sourceListCategory = new SourceListCategory(category);
            sourceList.getModel().addCategory(sourceListCategory);
        }

        SourceListItem sourceListItem = new SourceListItem(name);
        sourceList.getModel().addItemToCategory(sourceListItem, sourceListCategory);

        state.setPreviousSnippet(newSnippet);
        sourceList.setSelectedItem(sourceListItem);
        sourceList.scrollItemToVisible(sourceListItem);
    }

    /**
     * Remove the snippet from SourceList.
     * 
     * @param snippet
     *            The snippet to remove.
     */
    private void removeSnippetFromSourceList(Snippet snippet) {
        String category = snippet.getCategory();
        String name = snippet.getName();

        SourceListCategory sourceListCategory = getSourceListCategoryOf(category);
        SourceListItem sourceListItem = getSourceListItemOf(name);

        // If the category contained only one snippet, remove the whole category
        if (sourceListCategory.getItemCount() == 1) {
            sourceList.getModel().removeCategory(sourceListCategory);
            return;
        }

        // otherwise remove only the snippet chosen
        sourceList.getModel().removeItemFromCategory(sourceListItem, sourceListCategory);
    }

    /**
     * Refresh the snippet of moving from one category to another SourceList.
     * 
     * @param oldSnippet
     *            The snippet changed.
     * @param newSnippet
     *            The snippet without changes.
     */
    private void updateSnippetInSourceList(Snippet oldSnippet, Snippet newSnippet) {
        String newCategory = newSnippet.getCategory();
        String oldCategory = oldSnippet.getCategory();
        String newName = newSnippet.getName();
        String oldName = oldSnippet.getName();

        // SourceListItem selectedItem = sourceList.getSelectedItem();
        SourceListItem clickedItem = getSourceListItemOf(oldName);

        // if the category does not change stop to check the names
        if (newCategory.equalsIgnoreCase(oldCategory)) {
            // if the names are different I want the new one, otherwise I will
            // not
            // have to do anything
            if (!newName.equals(oldName)) {
                clickedItem.setText(newName);
            }
        } else {
            // the old category exists
            SourceListCategory oldSourceListCategory = getSourceListCategoryOf(oldCategory);

            // the new category may not exist, I will create it and add it to
            // the source list
            SourceListCategory newSourceListCategory = getSourceListCategoryOf(newCategory);
            if (newSourceListCategory == null) {
                newSourceListCategory = new SourceListCategory(newCategory);
                sourceList.getModel().addCategory(newSourceListCategory);
            }

            // if in the old category with only one element
            if (oldSourceListCategory.getItemCount() == 1) {
                sourceList.getModel().removeCategory(oldSourceListCategory);
            } else {
                sourceList.getModel().removeItemFromCategory(clickedItem, oldSourceListCategory);
            }

            // put the item in the right position
            sourceList.getModel().addItemToCategory(clickedItem, newSourceListCategory);
            clickedItem.setText(newName);
        }

        sourceList.setSelectedItem(clickedItem);
        sourceList.scrollItemToVisible(clickedItem);

        state.setPreviousSnippet(newSnippet);
    }

    /**
     * Allows you to rename a category. If the new category does not exist,
     * Rename on the spot otherwise they are moved all the snippets of Old into
     * the new one (already 'exists) and you delete one of Start.
     * 
     * @param sourceName
     * @param destinationName
     *            The target name.
     */
    private void moveCategoryInSourceList(String sourceName, String destinationName) {
        SourceListCategory oldCategory = getSourceListCategoryOf(sourceName);
        if (sourceName.equalsIgnoreCase(destinationName)) {
            oldCategory.setText(destinationName);
            return;
        }

        SourceListCategory newCategory = getSourceListCategoryOf(destinationName);
        SourceListItem selectedItem = sourceList.getSelectedItem();

        // newCategory is null --> just rename the current
        if (newCategory == null) {
            oldCategory.setText(destinationName);
        } else {
            // Newcategory not 'null -> I have to move all the items of
            // Snippet in the new category
            List<SourceListItem> items = oldCategory.getItems();
            Iterator<SourceListItem> iterator = items.iterator();
            while (iterator.hasNext()) {
                SourceListItem item = iterator.next();
                sourceList.getModel().addItemToCategory(item, newCategory);
            }
            sourceList.getModel().removeCategory(oldCategory);
        }

        if (selectedItem != null) {
            sourceList.setSelectedItem(selectedItem);
            sourceList.scrollItemToVisible(selectedItem);
        }
    }

    /**
     * Removes the class indicated by the SourceList. The database is not
     * Touched.
     * 
     * @param name
     *            The category name to be removed from SourceList.
     */
    private void removeCategoryFromSourceList(String name) {
        SourceListCategory sourceListCategory = getSourceListCategoryOf(name);
        sourceList.getModel().removeCategory(sourceListCategory);
    }

    private abstract class MyAction extends AbstractAction {
        private static final long serialVersionUID = 3994175409007864807L;
        protected String          menuItemClicked;
        protected String          text;

        public void setText(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    final MyAction ITEM_POPUP_MANAGER_ACTION     = new MyAction() {
                                                     private static final long serialVersionUID = 6864009534779492593L;

                                                     public void actionPerformed(ActionEvent e) {
                                                         // I read the menu item
                                                         // clicked by the user
                                                         menuItemClicked = e.getActionCommand();

                                                         // The user has clicked
                                                         // on "Remove"
                                                         if (menuItemClicked.equals("Remove")) {
                                                             // get the snippet
                                                             // present at the
                                                             // point where the
                                                             // user has
                                                             // Clicked the
                                                             // right mouse
                                                             // button
                                                             Snippet snippet = controller
                                                                     .getSnippet(text);

                                                             // removes the
                                                             // snippet from the
                                                             // database and
                                                             // calls in cascade
                                                             // several
                                                             // Listener
                                                             // interested in
                                                             // the event
                                                             if (controller.removeSnippet(text)) {
                                                                 actionsAfterRemovingSnippet(snippet);
                                                             }

                                                             return;
                                                         }

                                                         // if the execution
                                                         // gets here means that
                                                         // the user has clicked
                                                         // on
                                                         // An existing category
                                                         // or create a new
                                                         // entry for

                                                         // get the snippet
                                                         // present at the point
                                                         // where the user has
                                                         // clicked
                                                         // the
                                                         // Right mouse button
                                                         Snippet oldSnippet = controller
                                                                 .getSnippet(text);

                                                         // destination of the
                                                         // snippet
                                                         String category = new String();

                                                         // the user wants to
                                                         // move the snippet
                                                         // into a new category
                                                         // then
                                                         // Ask him to
                                                         // inserirmela
                                                         if (menuItemClicked
                                                                 .equals("New Category...")) {
                                                             category = JOptionPane
                                                                     .showInputDialog(
                                                                             MainFrame.this,
                                                                             "<html><b>Please insert the name of a new category</b>"
                                                                                     + "<br><font size=-1>The name must be shorter than "
                                                                                     + ApplicationConstants.CATEGORY_LENGTH
                                                                                     + " characters.</font></html>",
                                                                             "Move Into A New Category...",
                                                                             JOptionPane.QUESTION_MESSAGE);

                                                             // the user pressed
                                                             // ESC, closed the
                                                             // dialog box
                                                             // Or has submitted
                                                             // an empty string
                                                             if (category == null
                                                                     || category.trim().length() == 0) {
                                                                 return;
                                                             }

                                                             // Check if name is
                                                             // valid, exists
                                                             // already.
                                                             if (!Utility.nameIsValid(category
                                                                     .trim())
                                                                     || category.trim().length() > ApplicationConstants.CATEGORY_LENGTH) {
                                                                 String message = String
                                                                         .format("<html>%s is not a valid name!</html>",
                                                                                 category.trim());
                                                                 JOptionPane
                                                                         .showMessageDialog(
                                                                                 MainFrame.this,
                                                                                 message,
                                                                                 "",
                                                                                 JOptionPane.WARNING_MESSAGE);
                                                                 return;
                                                             }
                                                         } else {
                                                             // in this case has
                                                             // chosen one of
                                                             // the categories
                                                             // already
                                                             // existing
                                                             category = menuItemClicked;
                                                         }

                                                         Snippet newSnippet;

                                                         try {
                                                             newSnippet = (Snippet) oldSnippet
                                                                     .clone();
                                                         } catch (CloneNotSupportedException ex) {
                                                             ex.printStackTrace();
                                                             return;
                                                         }

                                                         newSnippet.setCategory(category);

                                                         if (controller.updateSnippet(oldSnippet,
                                                                 newSnippet)) {
                                                             boolean locked = state
                                                                     .isSnippetLocked();
                                                             updateSnippetInSourceList(oldSnippet,
                                                                     newSnippet);
                                                             state.updateSnippetStatus(true, true,
                                                                     locked);
                                                             state.updateMenu(true, true);
                                                         }
                                                     }
                                                 };

    /**
     * Manager popup menu that opens to the right click on the name of a
     * SourceList in this category, you can delete or rename A category. In the
     * latter case, if you enter a name for the new Category is renamed on the
     * spot otherwise all the snippets present Are moved and deleted the current
     * category.
     */
    final MyAction CATEGORY_POPUP_MANAGER_ACTION = new MyAction() {
                                                     private static final long serialVersionUID = -8767979402119895694L;

                                                     public void actionPerformed(ActionEvent e) {
                                                         // I read the menu item
                                                         // clicked by the user
                                                         menuItemClicked = e.getActionCommand();

                                                         String newName = new String();

                                                         // the user has clicked
                                                         // on "Remove"
                                                         if (menuItemClicked.equals("Remove")) {
                                                             // I remove the
                                                             // category from
                                                             // the database and
                                                             // all its snippet.
                                                             // in
                                                             // If successful
                                                             // also remove the
                                                             // category from
                                                             // SourceList.
                                                             if (controller.removeCategory(text)) {
                                                                 state.categoryRemoved(text);
                                                                 state.updateSnippetStatus(
                                                                         state.isSnippetValidated(),
                                                                         state.isSnippetSaved(),
                                                                         state.isSnippetLocked());
                                                                 state.updateMenu(true, true);
                                                             }

                                                             // returns control
                                                             return;
                                                         }

                                                         // the user has clicked
                                                         // on "Export ..."
                                                         if (menuItemClicked.equals("Export...")) {
                                                             exportPackage(text);
                                                             return;
                                                         }

                                                         if (menuItemClicked
                                                                 .equals("Set Syntax...")) {
                                                             String[] syntaxes = mainPanel
                                                                     .getSyntaxes();
                                                             syntaxes[0] = "-- no syntax highlighting"; // workaround
                                                             String newSyntax = (String) JOptionPane
                                                                     .showInputDialog(
                                                                             MainFrame.this,
                                                                             "<html><b>Please choose a syntax for snippets in \""
                                                                                     + text
                                                                                     + "\".</b><br>"
                                                                                     + "<font size=-1>The new syntax will be set to all snippets in the category.</font></html>",
                                                                             "Set A Syntax For All Snippets...",
                                                                             JOptionPane.QUESTION_MESSAGE,
                                                                             null, syntaxes,
                                                                             syntaxes[0]);

                                                             if (newSyntax == null) {
                                                                 return;
                                                             }

                                                             if (newSyntax
                                                                     .equalsIgnoreCase("-- no syntax highlighting")) {
                                                                 newSyntax = "";
                                                             }

                                                             if (controller
                                                                     .updateSyntax(
                                                                             newSyntax,
                                                                             text,
                                                                             !state.isSnippetSaved() ? state
                                                                                     .getNameOfSelectedSnippet()
                                                                                     : null)) {
                                                                 state.syntaxRenamed(newSyntax,
                                                                         text);
                                                             }

                                                             // returns control
                                                             return;
                                                         }

                                                         if (menuItemClicked.equals("Rename...")) {
                                                             newName = JOptionPane
                                                                     .showInputDialog(
                                                                             MainFrame.this,
                                                                             "<html><b>Please insert a new name for "
                                                                                     + text
                                                                                     + ".</b><br><font size=-1>The name must be shorter than "
                                                                                     + ApplicationConstants.CATEGORY_LENGTH
                                                                                     + " characters.</font></html>",
                                                                             "Rename...",
                                                                             JOptionPane.QUESTION_MESSAGE);

                                                             // the user pressed
                                                             // ESC, closed the
                                                             // dialog box
                                                             // Or has submitted
                                                             // an empty string
                                                             if (newName == null
                                                                     || newName.trim().length() == 0) {
                                                                 return;
                                                             }

                                                             // Check if the
                                                             // name is valid or
                                                             // exists already
                                                             if (!Utility.nameIsValid(newName
                                                                     .trim())
                                                                     || newName.trim().length() > ApplicationConstants.CATEGORY_LENGTH) {
                                                                 String message = String
                                                                         .format("<html>%s is not a valid name!</html>",
                                                                                 newName.trim());
                                                                 JOptionPane
                                                                         .showMessageDialog(
                                                                                 MainFrame.this,
                                                                                 message,
                                                                                 "",
                                                                                 JOptionPane.WARNING_MESSAGE);
                                                                 return;
                                                             }
                                                         } else {
                                                             // the user has
                                                             // clicked on a
                                                             // category name
                                                             newName = menuItemClicked;
                                                         }

                                                         // after obtaining the
                                                         // new name and
                                                         // verified if and
                                                         // 'valid
                                                         // Update the database
                                                         // and the SourceList
                                                         if (controller.renameCategory(text,
                                                                 newName)) {
                                                             state.categoryRenamed(text, newName);
                                                             state.updateSnippetStatus(false,
                                                                     false, false);
                                                             state.updateWindowStatus(false);
                                                             state.updateMenu(true, true);
                                                         }
                                                     }
                                                 };

    private void importPackage() {
        File path;
        if (OS.isMacOSX()) {
            FileDialog dialog = new FileDialog(MainFrame.this);
            dialog.setTitle("Import Snippets From A Package...");
            dialog.setModal(true);
            dialog.setFilenameFilter(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.endsWith(ApplicationConstants.JCC_EXTENSION);
                }
            });
            dialog.setMode(FileDialog.LOAD);

            setJMenuBar(new JMenuBar());
            dialog.setVisible(true);
            setJMenuBar(menuBar);

            String directory = dialog.getDirectory();
            String file = dialog.getFile();

            if (file == null) {
                return;
            }
            path = new File(directory + file);
        } else {
            JFileChooser chooser = new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.setDialogTitle("Import Snippets Package...");
            chooser.setMultiSelectionEnabled(false);
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.setFileFilter(new FileFilter() {
                @Override
                public String getDescription() {
                    return "jCodeCollector Package (.jccp)";
                }

                @Override
                public boolean accept(File f) {
                    return f.getName().endsWith(ApplicationConstants.JCC_EXTENSION)
                            | f.isDirectory();
                }
            });

            if (chooser.showOpenDialog(MainFrame.this) != JFileChooser.APPROVE_OPTION) {
                return;
            }

            path = chooser.getSelectedFile();
        }

        // I read the contents of the file specified by the user
        ArrayList<Snippet> snippets = PackageManager.readPackage(path);

        if (snippets == null) {
            JOptionPane.showMessageDialog(MainFrame.this, "The selected file is not valid.",
                    "Error!", JOptionPane.ERROR_MESSAGE, null);
            return;
        }

        if (snippets.size() == 0) {
            JOptionPane.showMessageDialog(MainFrame.this,
                    "The selected file does not contain any snippets!", "Warning!",
                    JOptionPane.INFORMATION_MESSAGE, null);
            return;
        }

        for (Snippet s : snippets) {
            DBMS.getInstance().insertNewSnippet(s);
        }

        // if all goes well reloading the SourceList
        reloadSourceList();

        // I force the update of the sub-menu with the list of categories
        state.updateMenu(true, true);
    }

    public void exportPackage(String name) {
        File path;

        if (OS.isMacOSX()) {
            FileDialog dialog = new FileDialog(MainFrame.this);
            dialog.setTitle("Create A Package For " + (name == null ? "All Snippets" : name)
                    + "...");
            dialog.setModal(true);
            dialog.setFilenameFilter(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return false;
                }
            });
            dialog.setMode(FileDialog.SAVE);

            setJMenuBar(new JMenuBar());
            dialog.setVisible(true);
            setJMenuBar(menuBar);

            String directory = dialog.getDirectory();
            String file = dialog.getFile();

            if (file == null) {
                return;
            }

            path = new File(directory + file);
        } else {
            JFileChooser chooser = new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.setDialogTitle("Export Snippets Package...");
            chooser.setMultiSelectionEnabled(false);
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.setFileFilter(new FileFilter() {
                @Override
                public String getDescription() {
                    return "jCodeCollector Package (.jccp)";
                }

                @Override
                public boolean accept(File f) {
                    return f.getName().endsWith(ApplicationConstants.JCC_EXTENSION)
                            | f.isDirectory();
                }
            });

            if (chooser.showSaveDialog(MainFrame.this) != JFileChooser.APPROVE_OPTION) {
                return;
            }

            path = chooser.getSelectedFile();
        }

        if (!path.getAbsolutePath().endsWith(ApplicationConstants.JCC_EXTENSION)) {
            path = new File(path.getAbsolutePath() + ApplicationConstants.JCC_EXTENSION);
        }

        if (!PackageManager.exportSnippets(path, name)) {
            JOptionPane.showMessageDialog(MainFrame.this,
                    "An error occurred while exporting the snippets. See log file for details.",
                    "", JOptionPane.ERROR_MESSAGE);
        }
    }

    /** Empty {@link SourceList} */
    private void resetSourceList() {
        SourceListCategory[] categories = sourceList.getModel().getCategories()
                .toArray(new SourceListCategory[] {});
        for (int i = 0; i < categories.length; i++) {
            sourceList.getModel().removeCategory(categories[i]);
        }
    }

    /** Reads the contents of the database and populates the {@link SourceList}. */
    public void reloadSourceList() {
        // I reset the SourceList
        resetSourceList();

        // I get the list of categories
        ArrayList<String> categories = controller.getCategories();

        for (String category : categories) {

            /*
             * The name of a category, and 'case-insensitive: I check if the
             * Current category is already in the SourceList. If yes The re-use,
             * or do I create a new one.
             */
            SourceListCategory categoryItem = getSourceListCategoryOf(category);
            if (categoryItem == null) {
                categoryItem = new SourceListCategory(category);
                sourceList.getModel().addCategory(categoryItem);
            }

            // I get the list of snippets and ordered alphabetically
            ArrayList<String> snippets = controller.getSnippetsName(category);
            Collections.sort(snippets);

            for (String snippet : snippets) {
                SourceListItem snippetItem = new SourceListItem(snippet);
                sourceList.getModel().addItemToCategory(snippetItem, categoryItem);
            }
        }

        state.updateWindowStatus(false);
    }

    /**
     * Returns the {@link SourceListCategory} related to the category Indicated.
     * 
     * @param category
     *            The category for which you want to get the
     *            {@link SourceListCategory}.
     * @return the {@link SourceListCategory} Category List of the specified
     *         class (if * any), <code>null</code> otherwise
     */
    private SourceListCategory getSourceListCategoryOf(String category) {
        if (category == null) {
            throw new IllegalArgumentException("\"category\" must not be null");
        }

        List<SourceListCategory> categories = sourceList.getModel().getCategories();
        Iterator<SourceListCategory> iterator = categories.iterator();
        while (iterator.hasNext()) {
            SourceListCategory sourceListCategory = iterator.next();
            if (category.equalsIgnoreCase(sourceListCategory.getText())) {
                return sourceListCategory;
            }
        }

        return null;
    }

    /**
     * Permette di ottenere il <code>SourceListItem</code> relativo allo snippet
     * indicato.
     * 
     * @param snippet
     *            The snippet of the category for which you want to get the
     *            <code>SourceListItem</code>.
     * @return The <code>SourceListItem</code> dello snippet indicato (se
     *         esiste), <code>null</code> altrimenti
     */
    private SourceListItem getSourceListItemOf(String snippet) {
        List<SourceListCategory> categories = sourceList.getModel().getCategories();
        Iterator<SourceListCategory> iterator = categories.iterator();

        while (iterator.hasNext()) {
            SourceListCategory sourceListCategory = iterator.next();
            List<SourceListItem> items = sourceListCategory.getItems();
            Iterator<SourceListItem> innerIterator = items.iterator();
            while (innerIterator.hasNext()) {
                SourceListItem sourceListItem = innerIterator.next();
                if (sourceListItem.getText().equals(snippet)) {
                    return sourceListItem;
                }
            }
        }

        return null;
    }

    public AboutWindow getAboutWindow() {
        return aboutWindow;
    }

    public void countUpdate(int categories, int snippets) {
        String temp = categories + " categor";
        temp += (categories == 1) ? "y" : "ies";
        temp += " / " + snippets + " snippet";
        temp += (snippets != 1) ? "s" : "";

        statusLabel.setText(temp);
    }

    public void categoriesUpdated(String selected) {
    }

    public void categoryRemoved(String name) {
        removeCategoryFromSourceList(name);
    }

    public void categoryRenamed(String oldName, String newName) {
        moveCategoryInSourceList(oldName, newName);
    }

    public void snippetEdited(Snippet snippet) {
    }

    /**
     * Remove from SourceList the node that represents the snippet shown. This
     * method is called after the corresponding snippet ' Been removed from the
     * database.
     * 
     * @param snippet
     * 
     */
    public void snippetRemoved(Snippet snippet) {
        removeSnippetFromSourceList(snippet);
    }

    public void snippetRenamed(String oldName, String newName) {
    }

    public void syntaxUpdated(String syntax, String category) {
    }

    public void syntaxUpdated(ArrayList<Syntax> syntaxes) {
    }

    public void updateSnippetStatus(boolean validated, boolean saved, boolean locked) {
    }

    /**
     * Update window status.
     * 
     * @param documentModified
     *            <code>true</code> if there are snippets unsaved,
     *            <code>false</code> otherwise.
     */
    public void updateWindowStatus(boolean documentModified) {
        if (OS.isMacOSX()) {
            getRootPane().putClientProperty("Window.documentModified", documentModified);
        } else {
            String title = getTitle();
            if (documentModified) {
                if (!title.startsWith("*")) {
                    title = "*" + title;
                }
            } else {
                if (title.startsWith("*")) {
                    title = title.substring(1);
                }
            }
            setTitle(title);
        }
    }

    public void updateLineNumbers(boolean enabled) {
        mainPanel.getScrollPanel().setLineNumbersEnabled(
                !mainPanel.getScrollPanel().getLineNumbersEnabled());
        mainPanel.getScrollPanel().setLineNumbersEnabled(
                !mainPanel.getScrollPanel().getLineNumbersEnabled());
    }

    /** @see jcodecollector.listener.iSearchListener#updateSearch(boolean) */
    public void updateSearch(boolean oldStatus) {
        boolean newStatus = state.isSearchActive();

        if (newStatus) {
            if (!OS.isMacOSX()) {
                if (!getTitle().endsWith(" - search enabled")) {
                    setTitle(getTitle() + " - search enabled");
                }
            }
        } else {
            if (!OS.isMacOSX()) {
                setTitle(getTitle().substring(0, getTitle().lastIndexOf(" - search enabled")));
            }
        }

        // if there 'discrepancy between the current state and the state of the
        // Previous
        // Search means that I need to update the SourceList
        if ((!oldStatus && newStatus) || (oldStatus && !newStatus)) {
            String selected = null;

            if (sourceList.getSelectedItem() != null) {
                selected = sourceList.getSelectedItem().getText();
            }

            if (!newStatus) {
                searchTextField.setText(null);
            }

            reloadSourceList();

            if (oldStatus && !newStatus) {
                manuallySelectItem(selected);
            }
        }
    }

    public void syntaxRenamed(String newName, String category) {
    }

    /**
     * Select the {@link SourceListItem} that contains the specified text.
     * 
     * @param text
     *            The text in the {@link SourceListItem} to select.
     */
    private void manuallySelectItem(String text) {
        Iterator<SourceListCategory> iterator = sourceList.getModel().getCategories().iterator();
        while (iterator.hasNext()) {
            Iterator<SourceListItem> innerIterator = iterator.next().getItems().iterator();
            while (innerIterator.hasNext()) {
                SourceListItem item;
                if ((item = innerIterator.next()).getText().equals(text)) {
                    sourceList.setSelectedItem(item);
                    sourceList.scrollItemToVisible(item);
                    return;
                }
            }
        }
    }

    // top level menu
    private JMenu             fileMenu;
    private JMenu             snippetsMenu;
    private JMenu             searchMenu;
    private JMenu             viewMenu;
    private JMenu             windowMenu;

    // file menu
    private JMenuItem         reloadSourceListMenuItem;
    private JMenuItem         importFromPackageMenuItem;

    private JMenu             exportSubMenu;
    private JMenuItem         exportAllMenuItem;
    private JMenu             exportSnippetsInCategorySubMenu;
    private JMenuItem         changeDirectoryMenuItem;

    // view menu
    private JCheckBoxMenuItem showLineNumbersMenuItem;
    private JCheckBoxMenuItem showCommentPanelMenuItem;
    private JCheckBoxMenuItem autoHideCommentPanelMenuItem;

    // search menu
    private JMenuItem         searchInLabelMenuItem;
    private JCheckBoxMenuItem showSearchPanelMenuItem;
    private JCheckBoxMenuItem namesMenuItem;
    private JCheckBoxMenuItem tagsMenuItem;
    private JCheckBoxMenuItem codeMenuItem;
    private JCheckBoxMenuItem commentsMenuItem;
    private JCheckBoxMenuItem caseMenuItem;
    private JMenuItem         searchEnabledMenuItem;

    // snippet menu
    private JMenuItem         newSnippetMenuItem;
    private JMenuItem         newSnippetFromClipboardMenuItem;
    private JMenuItem         saveSnippetMenuItem;
    private JMenuItem         removeSnippetMenuItem;
    private JMenuItem         lockSnippetMenuItem;
    private JMenuItem         copyToClipboardMenuItem;

    // window menu
    private JMenuItem         minimizeWindowMenuItem;
    private JMenuItem         zoomWindowMenuItem;
    private JMenuItem         closeWindowMenuItem;

    // menu bar
    private JMenuBar          menuBar;

    private void buildMenuBar() {
        final int MENU_SHORTCUT_KEY_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

        // top level menu
        fileMenu = new JMenu("File");
        viewMenu = new JMenu("View");
        snippetsMenu = new JMenu("Snippets");
        windowMenu = new JMenu("Window");

        // file menu
        reloadSourceListMenuItem = new JMenuItem("Reload Snippets");
        reloadSourceListMenuItem.addActionListener(RELOAD_SOURCE_LIST_ACTION);

        importFromPackageMenuItem = new JMenuItem("Import From A Package...");
        importFromPackageMenuItem.addActionListener(IMPORT_PACKAGE_ACTION);
        importFromPackageMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
                MENU_SHORTCUT_KEY_MASK | InputEvent.ALT_DOWN_MASK));

        // export sub-menu
        exportSubMenu = new JMenu("Export");

        exportAllMenuItem = new JMenuItem("All Snippets...");
        exportAllMenuItem.addActionListener(EXPORT_ALL_SNIPPETS_ACTION);
        exportAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
                MENU_SHORTCUT_KEY_MASK | InputEvent.ALT_DOWN_MASK));
        exportSubMenu.add(exportAllMenuItem);

        exportSnippetsInCategorySubMenu = new JMenu("Only Snippets In");
        exportSubMenu.add(exportSnippetsInCategorySubMenu);
        // end export sub-menu

        changeDirectoryMenuItem = new JMenuItem("Change Database Location...");
        changeDirectoryMenuItem.addActionListener(CHANGE_LOCATION_ACTION);

        fileMenu.add(reloadSourceListMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(importFromPackageMenuItem);
        fileMenu.add(exportSubMenu);
        fileMenu.addSeparator();
        fileMenu.add(changeDirectoryMenuItem);

        if (!OS.isMacOSX()) {
            JMenuItem aboutItem = new JMenuItem("About jCodeCollector");
            aboutItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainFrame.this.aboutWindow.setLocationRelativeTo(null);
                    MainFrame.this.aboutWindow.setVisible(true);
                }
            });

            JMenuItem quitApplication = new JMenuItem("Quit jCodeCollector");
            quitApplication.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                    InputEvent.CTRL_DOWN_MASK));
            quitApplication.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    prepareAndSaveSettings();
                    System.exit(0);
                }
            });

            fileMenu.addSeparator();
            fileMenu.add(aboutItem);
            fileMenu.add(quitApplication);
        }
        // end file menu

        // view menu
        showLineNumbersMenuItem = new JCheckBoxMenuItem("Show Line Numbers");
        showLineNumbersMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
                MENU_SHORTCUT_KEY_MASK | InputEvent.SHIFT_DOWN_MASK));
        showLineNumbersMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.scrollPanel.setLineNumbersEnabled(showLineNumbersMenuItem.isSelected());
            }
        });
        if (ApplicationSettings.getInstance().isLineNumbersEnabled()) {
            showLineNumbersMenuItem.doClick();
        }

        showCommentPanelMenuItem = new JCheckBoxMenuItem("Show Comment");
        showCommentPanelMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
                MENU_SHORTCUT_KEY_MASK | InputEvent.SHIFT_DOWN_MASK));
        showCommentPanelMenuItem.setSelected(ApplicationSettings.getInstance()
                .isCommentPanelVisible());
        showCommentPanelMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (showCommentPanelMenuItem.isSelected()) {
                    // mainPanel.arrowDownSplitButton.doClick();
                    mainPanel.add(mainPanel.southPanel, BorderLayout.SOUTH);
                    mainPanel.mainPanel.setBorder(new EmptyBorder(5, 10, 3, 5));
                    mainPanel.southPanel.setBorder(new EmptyBorder(0, 10, 7, OS.isMacOSX() ? 7 : 5));
                } else {
                    if (mainPanel.southPanel.getParent() != null) {
                        mainPanel.remove(mainPanel.southPanel);
                        mainPanel.mainPanel.setBorder(new EmptyBorder(5, 10, OS.isMacOSX() ? 5 : 7,
                                5));
                    }
                    // mainPanel.arrowUpSplitButton.doClick();
                }
                mainPanel.getParent().validate();
            }
        });

        if (showCommentPanelMenuItem.isSelected()) {
            mainPanel.add(mainPanel.southPanel, BorderLayout.SOUTH);
            mainPanel.mainPanel.setBorder(new EmptyBorder(5, 10, 3, 5));
            mainPanel.southPanel.setBorder(new EmptyBorder(0, 10, 7, OS.isMacOSX() ? 7 : 5));
            mainPanel.getParent().validate();
        }

        autoHideCommentPanelMenuItem = new JCheckBoxMenuItem("Auto Hide Comment If Empty");
        autoHideCommentPanelMenuItem.setSelected(ApplicationSettings.getInstance()
                .isAutoHideCommentEnabled());
        autoHideCommentPanelMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAutoHideCommentPanel(
                        DBMS.getInstance().getSnippet(state.getNameOfSelectedSnippet()), true);
            }
        });

        viewMenu.add(showLineNumbersMenuItem);
        viewMenu.add(showCommentPanelMenuItem);
        viewMenu.add(autoHideCommentPanelMenuItem);
        // end view menu

        // search menu
        searchMenu = new JMenu("Search");

        showSearchPanelMenuItem = new JCheckBoxMenuItem("Show Search Panel");
        showSearchPanelMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,
                MENU_SHORTCUT_KEY_MASK));
        showSearchPanelMenuItem.addActionListener(SHOW_SEARCH_PANEL_ACTION);

        searchInLabelMenuItem = new JMenuItem("Search In...");
        searchInLabelMenuItem.setEnabled(false);

        namesMenuItem = new JCheckBoxMenuItem("Names", SearchFilter.getInstance()
                .isSearchInNameEnabled());
        namesMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, MENU_SHORTCUT_KEY_MASK
                | InputEvent.SHIFT_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
        tagsMenuItem = new JCheckBoxMenuItem("Tags", SearchFilter.getInstance()
                .isSearchInTagsEnabled());
        tagsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, MENU_SHORTCUT_KEY_MASK
                | InputEvent.SHIFT_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
        codeMenuItem = new JCheckBoxMenuItem("Code", SearchFilter.getInstance()
                .isSearchInCodeEnabled());
        codeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, MENU_SHORTCUT_KEY_MASK
                | InputEvent.SHIFT_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
        commentsMenuItem = new JCheckBoxMenuItem("Comments", SearchFilter.getInstance()
                .isSearchInCommentEnabled());
        commentsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4,
                MENU_SHORTCUT_KEY_MASK | InputEvent.SHIFT_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
        caseMenuItem = new JCheckBoxMenuItem("Case Sensitive", SearchFilter.getInstance()
                .isSearchCaseSensitive());
        caseMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, MENU_SHORTCUT_KEY_MASK
                | InputEvent.SHIFT_DOWN_MASK | InputEvent.ALT_DOWN_MASK));

        final JCheckBoxMenuItem[] searchItems = { namesMenuItem, tagsMenuItem, codeMenuItem,
                commentsMenuItem };
        ItemListener itemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int selected = 0; // number of different search enabled
                for (JCheckBoxMenuItem item : searchItems) {
                    selected += item.isSelected() ? 1 : 0;
                }

                JCheckBoxMenuItem source = (JCheckBoxMenuItem) e.getSource();

                // at least one element MUST be selected!
                if (selected < 1) {
                    source.setSelected(true);
                }

                SearchFilter filter = SearchFilter.getInstance();
                if (source == namesMenuItem) {
                    filter.setSearchInNameEnabled(namesMenuItem.isSelected());
                } else if (source == tagsMenuItem) {
                    filter.setSearchInTagsEnabled(tagsMenuItem.isSelected());
                } else if (source == codeMenuItem) {
                    filter.setSearchInCodeEnabled(codeMenuItem.isSelected());
                } else if (source == commentsMenuItem) {
                    filter.setSearchInCommentEnabled(commentsMenuItem.isSelected());
                }

                // each filter change redo the search
                START_SEARCH_ACTION.actionPerformed(null);
            }
        };

        for (JCheckBoxMenuItem item : searchItems) {
            item.addItemListener(itemListener);
        }

        caseMenuItem.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                SearchFilter.getInstance().setSearchCaseSensitive(caseMenuItem.isSelected());
            }
        });

        searchEnabledMenuItem = new JMenuItem("Clear Search");
        searchEnabledMenuItem.setEnabled(false);
        searchEnabledMenuItem.addActionListener(CANCEL_BUTTON_SEARCH_ACTION);

        if (!OS.isMacOSX()) {
            searchMenu.add(showSearchPanelMenuItem);
            searchMenu.addSeparator();
        }
        searchMenu.add(searchInLabelMenuItem);
        for (JCheckBoxMenuItem item : searchItems) {
            searchMenu.add(item);
        }
        searchMenu.addSeparator();
        searchMenu.add(caseMenuItem);
        // end search menu

        // snippet menu
        newSnippetMenuItem = new JMenuItem("New Empty Snippet...");
        newSnippetMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                MENU_SHORTCUT_KEY_MASK));
        newSnippetMenuItem.addActionListener(NEW_EMPTY_SNIPPET_ACTION);

        newSnippetFromClipboardMenuItem = new JMenuItem("New Snippet From Clipboard...");
        newSnippetFromClipboardMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                MENU_SHORTCUT_KEY_MASK | InputEvent.SHIFT_DOWN_MASK));
        newSnippetFromClipboardMenuItem.addActionListener(NEW_SNIPPET_FROM_CLIPBOARD_ACTION);

        saveSnippetMenuItem = new JMenuItem("Save");
        saveSnippetMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                MENU_SHORTCUT_KEY_MASK));
        saveSnippetMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.saveButton.doClick();
            }
        });

        removeSnippetMenuItem = new JMenuItem("Remove");
        removeSnippetMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE,
                MENU_SHORTCUT_KEY_MASK));
        removeSnippetMenuItem.addActionListener(REMOVE_SNIPPET_ACTION);

        lockSnippetMenuItem = new JMenuItem("Lock");
        lockSnippetMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
                MENU_SHORTCUT_KEY_MASK | InputEvent.SHIFT_DOWN_MASK));
        lockSnippetMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.lockButton.doClick();
            }
        });
        copyToClipboardMenuItem = new JMenuItem("Copy Code To Clipboard");
        copyToClipboardMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
                MENU_SHORTCUT_KEY_MASK | InputEvent.SHIFT_DOWN_MASK));
        copyToClipboardMenuItem.addActionListener(COPY_TO_CLIPBOARD_ACTION);

        snippetsMenu.add(newSnippetMenuItem);
        snippetsMenu.add(newSnippetFromClipboardMenuItem);
        snippetsMenu.addSeparator();
        snippetsMenu.add(saveSnippetMenuItem);
        snippetsMenu.add(removeSnippetMenuItem);
        snippetsMenu.addSeparator();
        snippetsMenu.add(lockSnippetMenuItem);
        snippetsMenu.addSeparator();
        snippetsMenu.add(copyToClipboardMenuItem);
        // end snippet menu

        // window menu
        minimizeWindowMenuItem = new JMenuItem("Minimize");
        minimizeWindowMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
                MENU_SHORTCUT_KEY_MASK));
        minimizeWindowMenuItem.addActionListener(MINIMIZE_WINDOW_ACTION);

        zoomWindowMenuItem = new JMenuItem("Zoom");
        zoomWindowMenuItem.addActionListener(ZOOM_WINDOW_ACTION);

        closeWindowMenuItem = new JMenuItem("Close Window");
        closeWindowMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
                MENU_SHORTCUT_KEY_MASK));
        closeWindowMenuItem.addActionListener(CLOSE_WINDOW_ACTION);

        windowMenu.add(minimizeWindowMenuItem);
        windowMenu.add(zoomWindowMenuItem);
        windowMenu.add(closeWindowMenuItem);
        // end window menu

        menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        menuBar.add(snippetsMenu);
        menuBar.add(searchMenu);
        if (OS.isMacOSX()) {
            menuBar.add(windowMenu);
        }

        setJMenuBar(menuBar);
    }

    public void updateMenu(boolean enabled, boolean resetExportSubMenu) {
        String name = state.getNameOfSelectedSnippet();

        // file menu
        reloadSourceListMenuItem.setEnabled(enabled);

        importFromPackageMenuItem.setEnabled(enabled);
        exportAllMenuItem.setEnabled(!state.isDatabaseEmpty() && enabled);

        // I update the sub menu with the target categories
        updateExportCategorySubMenu(enabled, resetExportSubMenu);

        changeDirectoryMenuItem.setEnabled(enabled);

        // view menu
        showLineNumbersMenuItem.setEnabled(enabled);
        showCommentPanelMenuItem.setEnabled(enabled);
        autoHideCommentPanelMenuItem.setEnabled(enabled);

        // search menu
        showSearchPanelMenuItem.setEnabled(enabled);
        namesMenuItem.setEnabled(enabled);
        tagsMenuItem.setEnabled(enabled);
        codeMenuItem.setEnabled(enabled);
        commentsMenuItem.setEnabled(enabled);
        caseMenuItem.setEnabled(enabled);
        searchEnabledMenuItem.setEnabled(state.isSearchActive() && enabled);

        // snippet menu
        newSnippetMenuItem.setEnabled(enabled);
        newSnippetFromClipboardMenuItem.setEnabled(enabled);
        saveSnippetMenuItem.setEnabled(state.isSnippetValidated() && !state.isSnippetLocked()
                && enabled);
        removeSnippetMenuItem.setEnabled(name != null && enabled);
        lockSnippetMenuItem.setEnabled((name != null) && state.isSnippetSaved()
                && state.isSnippetValidated() && enabled);
        lockSnippetMenuItem.setText((state.isSnippetLocked() ? "Unlock" : "Lock"));
        copyToClipboardMenuItem.setEnabled(name != null && enabled);

        // window menu
        minimizeWindowMenuItem.setEnabled(enabled);
        zoomWindowMenuItem.setEnabled(enabled);
        closeWindowMenuItem.setEnabled(enabled);
    }

    private void updateExportCategorySubMenu(boolean enabled, boolean resetExportSubMenu) {
        if (!resetExportSubMenu) {
            return;
        }

        exportSnippetsInCategorySubMenu.removeAll();

        ArrayList<String> categories = DBMS.getInstance().getCategories();
        for (int i = 0; i < categories.size(); i++) {
            JMenuItem categoryMenuItem = new JMenuItem(categories.get(i));
            categoryMenuItem.addActionListener(EXPORT_CATEGORY_ACTION);
            categoryMenuItem.setEnabled(enabled);
            exportSnippetsInCategorySubMenu.add(categoryMenuItem);
        }

        if (categories.size() == 0) {
            JMenuItem emptyMenuItem = new JMenuItem("No Categories Available");
            emptyMenuItem.setEnabled(false);
            exportSnippetsInCategorySubMenu.add(emptyMenuItem);
        }
    }

    /** Serial Version UID. */
    private static final long serialVersionUID = 2875157835785998264L;

}
