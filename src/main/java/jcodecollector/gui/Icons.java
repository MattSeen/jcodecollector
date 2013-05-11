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

import javax.swing.ImageIcon;

public final class Icons {

    public static final ImageIcon LOCK_ICON              = new ImageIcon(
                                                                 Icons.class
                                                                         .getResource("/images/lock.png"));
    public static final ImageIcon UNLOCK_ICON            = new ImageIcon(
                                                                 Icons.class
                                                                         .getResource("/images/unlock.png"));
    public static final ImageIcon APPLICATION_ICON_BIG   = new ImageIcon(
                                                                 Icons.class
                                                                         .getResource("/images/jcc.png"));
    public static final ImageIcon APPLICATION_ICON_SMALL = new ImageIcon(
                                                                 Icons.class
                                                                         .getResource("/images/jcc_small.png"));

    private Icons() {
        // do nothing
    }

}
