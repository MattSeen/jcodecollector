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
package jcodecollector.document;

import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

import jcodecollector.State;

/**
 * Validator text components such as {@link TextArea}, {@link Text Field}, *
 * {@link JTextPane}, {@link JEditorPane} etc..
 * 
 * @author Alessandro Cocco
 */
public class EditorValidator implements DocumentListener {

    /** Text components to be validated. */
    private JTextComponent[] components;

    /** Optional items. */
    private boolean[]        optional;

    /**
     * If <code> true </ code> indicates that the validator and 'in function, if
     * <code> False </ code> the validator and 'off.
     */
    private boolean          running;

    /**
     * Constructs a validator components indicated. The second parameter
     * Indicates if there are optional components.
     * 
     * @param components
     *            I Components (JTextArea @ link} , @ link JTextField}
     *            {@link JEditorPane} etc.. da validare.
     * @param optional
     *            An array of the same size as the previous one. in each
     *            Position, <code> true </ code> indicates that the
     *            corresponding Component and 'optional <code> false </ code>
     *            and Mandatory.
     */
    public EditorValidator(JTextComponent[] components, boolean[] optional) {
        if (components.length != optional.length) {
            throw new IllegalArgumentException("components.length != optional.length");
        }

        this.components = components;
        this.optional = optional;
    }

    /** Activate the validator. */
    public void start() {
        running = true;
    }

    /** Disable the validator. */
    public void stop() {
        running = false;
    }

    /**
     * Valid text components. A text component and 'considered Valid if it
     * contains at least one character, unless it is optional.
     */
    private void validate() {
        if (!running) {
            State.getInstance().updateWindowStatus(false);
            return;
        } else {
            State.getInstance().updateWindowStatus(true);
        }

        State.getInstance().updateSnippetStatus(false, false, false);
        boolean validated = true;
        for (int i = 0; i < components.length; i++) {
            if (optional[i]) {
                continue;
            }

            validated &= components[i].getText().trim().length() > 0;
        }
        State.getInstance().updateSnippetStatus(validated, false, false);
        State.getInstance().updateMenu(true, false);
    }

    /** @see DocumentListener#changedUpdate(DocumentEvent) */
    public void changedUpdate(DocumentEvent e) {
        validate();
    }

    /** @see DocumentListener#insertUpdate(DocumentEvent) */
    public void insertUpdate(DocumentEvent e) {
        validate();
    }

    /** @see DocumentListener#removeUpdate(DocumentEvent) */
    public void removeUpdate(DocumentEvent e) {
        validate();
    }

}
