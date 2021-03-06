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
package jcodecollector.util;

/**
 * Simple utility class for common actions.
 */
public class Utility {

    private Utility() {
    }
    
    private static final String[] invalidNames = { "null", "Remove", "New Category...",
            "New Category", "Rename...", "Show In Editor...", "Category", "Export", "Export...",
            "Set Syntax...", "Merge In...", "Merge In" };

    public static boolean nameIsValid(String name) {
        if (name == null || name.trim().length() == 0) {
            return false;
        }

        for (String s : invalidNames) {
            if (name.equalsIgnoreCase(s)) {
                return false;
            }
        }

        return true;
    }
}
