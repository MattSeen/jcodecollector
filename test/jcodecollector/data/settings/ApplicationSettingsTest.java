package jcodecollector.data.settings;

import java.awt.Dimension;
import java.awt.Point;
import junit.framework.*;

/**
 * The class <code>ApplicationSettingsTest</code> contains tests for the class <code>{@link ApplicationSettings}</code>.
 *
 * @generatedBy CodePro at 12/05/13 15:21
 * @author matthew
 * @version $Revision: 1.0 $
 */
public class ApplicationSettingsTest extends TestCase {
    /**
     * Run the String getDatabasePath() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testGetDatabasePath_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        String result = fixture.getDatabasePath();

        // add additional test code here
        assertEquals("\\", result);
    }

    /**
     * Run the String getDatabasePath() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testGetDatabasePath_2()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath((String) null);
        fixture.setSelectedSnippet((String) "null");

        String result = fixture.getDatabasePath();

        // add additional test code here
        assertEquals(null, result);
    }

    /**
     * Run the String getDatabasePath() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testGetDatabasePath_3()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        String result = fixture.getDatabasePath();

        // add additional test code here
        assertEquals("\\", result);
    }

    /**
     * Run the Integer getEditorWidth() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testGetEditorWidth_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        Integer result = fixture.getEditorWidth();

        // add additional test code here
        assertNotNull(result);
        assertEquals("1", result.toString());
        assertEquals((byte) 1, result.byteValue());
        assertEquals((short) 1, result.shortValue());
        assertEquals(1, result.intValue());
        assertEquals(1L, result.longValue());
        assertEquals(1.0f, result.floatValue(), 1.0f);
        assertEquals(1.0, result.doubleValue(), 1.0);
    }

    /**
     * Run the ApplicationSettings getInstance() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testGetInstance_1()
        throws Exception {

        ApplicationSettings result = ApplicationSettings.getInstance();

        // add additional test code here
        assertNotNull(result);
        assertEquals(true, result.isSearchCaseSensitive());
        assertEquals(true, result.isLineNumbersEnabled());
        assertEquals(new Integer(1), result.getSourceListWidth());
        assertEquals(true, result.isCommentPanelVisible());
        assertEquals(new Integer(1), result.getEditorWidth());
        assertEquals(true, result.isSearchInCodeEnabled());
        assertEquals(true, result.isAutoHideCommentEnabled());
        assertEquals("\\", result.getDatabasePath());
        assertEquals(true, result.isSearchInNameEnabled());
        assertEquals(true, result.isSearchInTagsEnabled());
        assertEquals(null, result.getSelectedSnippet());
        assertEquals(true, result.isSearchInCommentEnabled());
        assertEquals("C:\\Users\\matthew\\Documents", result.getUserHome());
        assertEquals("", result.getPreferencesPath());
    }

    /**
     * Run the String getPreferencesPath() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testGetPreferencesPath_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        String result = fixture.getPreferencesPath();

        // add additional test code here
        assertEquals("", result);
    }

    /**
     * Run the String getSelectedSnippet() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testGetSelectedSnippet_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        String result = fixture.getSelectedSnippet();

        // add additional test code here
        assertEquals(null, result);
    }

    /**
     * Run the Integer getSourceListWidth() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testGetSourceListWidth_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        Integer result = fixture.getSourceListWidth();

        // add additional test code here
        assertNotNull(result);
        assertEquals("1", result.toString());
        assertEquals((byte) 1, result.byteValue());
        assertEquals((short) 1, result.shortValue());
        assertEquals(1, result.intValue());
        assertEquals(1L, result.longValue());
        assertEquals(1.0f, result.floatValue(), 1.0f);
        assertEquals(1.0, result.doubleValue(), 1.0);
    }

    /**
     * Run the String getUserHome() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testGetUserHome_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        String result = fixture.getUserHome();

        // add additional test code here
        assertEquals("C:\\Users\\matthew\\Documents", result);
    }

    /**
     * Run the Point getWindowLocation() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testGetWindowLocation_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        Point result = fixture.getWindowLocation();

        // add additional test code here
        assertNotNull(result);
        assertEquals("java.awt.Point[x=0,y=0]", result.toString());
        assertEquals(0.0, result.getX(), 1.0);
        assertEquals(0.0, result.getY(), 1.0);
    }

    /**
     * Run the Dimension getWindowSize() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testGetWindowSize_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        Dimension result = fixture.getWindowSize();

        // add additional test code here
        assertNotNull(result);
        assertEquals("java.awt.Dimension[width=0,height=0]", result.toString());
        assertEquals(0.0, result.getHeight(), 1.0);
        assertEquals(0.0, result.getWidth(), 1.0);
    }

    /**
     * Run the boolean isAutoHideCommentEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsAutoHideCommentEnabled_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        boolean result = fixture.isAutoHideCommentEnabled();

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean isAutoHideCommentEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsAutoHideCommentEnabled_2()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(false);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        boolean result = fixture.isAutoHideCommentEnabled();

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the boolean isCommentPanelVisible() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsCommentPanelVisible_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        boolean result = fixture.isCommentPanelVisible();

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean isCommentPanelVisible() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsCommentPanelVisible_2()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(false);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        boolean result = fixture.isCommentPanelVisible();

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the boolean isLineNumbersEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsLineNumbersEnabled_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        boolean result = fixture.isLineNumbersEnabled();

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean isLineNumbersEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsLineNumbersEnabled_2()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(false);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        boolean result = fixture.isLineNumbersEnabled();

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the boolean isSearchCaseSensitive() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsSearchCaseSensitive_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        boolean result = fixture.isSearchCaseSensitive();

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean isSearchCaseSensitive() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsSearchCaseSensitive_2()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(false);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        boolean result = fixture.isSearchCaseSensitive();

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the boolean isSearchInCodeEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsSearchInCodeEnabled_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        boolean result = fixture.isSearchInCodeEnabled();

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean isSearchInCodeEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsSearchInCodeEnabled_2()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(false);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        boolean result = fixture.isSearchInCodeEnabled();

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the boolean isSearchInCommentEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsSearchInCommentEnabled_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        boolean result = fixture.isSearchInCommentEnabled();

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean isSearchInCommentEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsSearchInCommentEnabled_2()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(false);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        boolean result = fixture.isSearchInCommentEnabled();

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the boolean isSearchInNameEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsSearchInNameEnabled_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        boolean result = fixture.isSearchInNameEnabled();

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean isSearchInNameEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsSearchInNameEnabled_2()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(false);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        boolean result = fixture.isSearchInNameEnabled();

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the boolean isSearchInTagsEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsSearchInTagsEnabled_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        boolean result = fixture.isSearchInTagsEnabled();

        // add additional test code here
        assertEquals(true, result);
    }

    /**
     * Run the boolean isSearchInTagsEnabled() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testIsSearchInTagsEnabled_2()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(false);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");

        boolean result = fixture.isSearchInTagsEnabled();

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the void setAutoHideCommentEnabled(boolean) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetAutoHideCommentEnabled_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");
        boolean autoHideCommentEnabled = true;

        fixture.setAutoHideCommentEnabled(autoHideCommentEnabled);

        // add additional test code here
    }

    /**
     * Run the void setCommentPanelVisible(boolean) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetCommentPanelVisible_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");
        boolean commentPanelVisible = true;

        fixture.setCommentPanelVisible(commentPanelVisible);

        // add additional test code here
    }

    /**
     * Run the void setDatabasePath(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetDatabasePath_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");
        String databasePath = "";

        fixture.setDatabasePath(databasePath);

        // add additional test code here
    }

    /**
     * Run the void setEditorWidth(Integer) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetEditorWidth_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");
        Integer editorWidth = new Integer(1);

        fixture.setEditorWidth(editorWidth);

        // add additional test code here
    }

    /**
     * Run the void setLineNumbersEnabled(boolean) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetLineNumbersEnabled_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");
        boolean showLineNumbersEnabled = true;

        fixture.setLineNumbersEnabled(showLineNumbersEnabled);

        // add additional test code here
    }

    /**
     * Run the void setPreferencesPath(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetPreferencesPath_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");
        String preferencesPath = "";

        fixture.setPreferencesPath(preferencesPath);

        // add additional test code here
    }

    /**
     * Run the void setSearchCaseSensitive(boolean) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetSearchCaseSensitive_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");
        boolean searchCaseSensitive = true;

        fixture.setSearchCaseSensitive(searchCaseSensitive);

        // add additional test code here
    }

    /**
     * Run the void setSearchInCodeEnabled(boolean) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetSearchInCodeEnabled_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");
        boolean searchInCodeEnabled = true;

        fixture.setSearchInCodeEnabled(searchInCodeEnabled);

        // add additional test code here
    }

    /**
     * Run the void setSearchInCommentEnabled(boolean) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetSearchInCommentEnabled_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");
        boolean searchInCommentEnabled = true;

        fixture.setSearchInCommentEnabled(searchInCommentEnabled);

        // add additional test code here
    }

    /**
     * Run the void setSearchInNameEnabled(boolean) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetSearchInNameEnabled_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");
        boolean searchInNameEnabled = true;

        fixture.setSearchInNameEnabled(searchInNameEnabled);

        // add additional test code here
    }

    /**
     * Run the void setSearchInTagsEnabled(boolean) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetSearchInTagsEnabled_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");
        boolean searchInTagsEnabled = true;

        fixture.setSearchInTagsEnabled(searchInTagsEnabled);

        // add additional test code here
    }

    /**
     * Run the void setSelectedSnippet(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetSelectedSnippet_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");
        String selectedSnippet = "null";

        fixture.setSelectedSnippet(selectedSnippet);

        // add additional test code here
    }

    /**
     * Run the void setSelectedSnippet(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetSelectedSnippet_2()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");
        String selectedSnippet = null;

        fixture.setSelectedSnippet(selectedSnippet);

        // add additional test code here
    }

    /**
     * Run the void setSelectedSnippet(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetSelectedSnippet_3()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");
        String selectedSnippet = "";

        fixture.setSelectedSnippet(selectedSnippet);

        // add additional test code here
    }

    /**
     * Run the void setSourceListWidth(Integer) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetSourceListWidth_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");
        Integer sourceListWidth = new Integer(1);

        fixture.setSourceListWidth(sourceListWidth);

        // add additional test code here
    }

    /**
     * Run the void setWindowLocation(Point) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetWindowLocation_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");
        Point windowLocation = new Point();

        fixture.setWindowLocation(windowLocation);

        // add additional test code here
    }

    /**
     * Run the void setWindowSize(Dimension) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public void testSetWindowSize_1()
        throws Exception {
        ApplicationSettings fixture = ApplicationSettings.getInstance();
        fixture.setLineNumbersEnabled(true);
        fixture.setCommentPanelVisible(true);
        fixture.setEditorWidth(new Integer(1));
        fixture.setSearchInTagsEnabled(true);
        fixture.setSourceListWidth(new Integer(1));
        fixture.setWindowLocation(new Point());
        fixture.setSearchInCodeEnabled(true);
        fixture.setWindowSize(new Dimension());
        fixture.setSearchCaseSensitive(true);
        fixture.setSearchInCommentEnabled(true);
        fixture.setAutoHideCommentEnabled(true);
        fixture.setPreferencesPath("");
        fixture.setSearchInNameEnabled(true);
        fixture.setDatabasePath("");
        fixture.setSelectedSnippet((String) "null");
        Dimension windowSize = new Dimension();

        fixture.setWindowSize(windowSize);

        // add additional test code here
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *         if the initialization fails for some reason
     *
     * @see TestCase#setUp()
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    protected void setUp()
        throws Exception {
        super.setUp();
        // add additional set up code here
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *         if the clean-up fails for some reason
     *
     * @see TestCase#tearDown()
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    protected void tearDown()
        throws Exception {
        super.tearDown();
        // Add additional tear down code here
    }

    /**
     * Launch the test.
     *
     * @param args the command line arguments
     *
     * @generatedBy CodePro at 12/05/13 15:21
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            // Run all of the tests
            junit.textui.TestRunner.run(ApplicationSettingsTest.class);
        } else {
            // Run only the named tests
            TestSuite suite = new TestSuite("Selected tests");
            for (int i = 0; i < args.length; i++) {
                TestCase test = new ApplicationSettingsTest();
                test.setName(args[i]);
                suite.addTest(test);
            }
            junit.textui.TestRunner.run(suite);
        }
    }
}