/*
 * Copyright 2017 Patrik Karlsson.
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
package org.nbgames.gunu;

import java.awt.Color;
import java.util.prefs.Preferences;
import org.nbgames.core.api.options.NbgOptions;
import org.openide.util.NbPreferences;
import se.trixon.almond.util.GraphicsHelper;

/**
 *
 * @author Patrik Karlsson
 */
public class Options extends NbgOptions {

    public static final String KEY_COLOR_BACKGROUND = "background";
    public static final String KEY_FROM = "from";
    public static final String KEY_PLAYER = "player";
    public static final String KEY_TO = "to";
    private static final Color DEFAULT_COLOR_BACKGROUND = Color.decode("#656610");
    private static final int DEFAULT_FROM = -100;
    private static final int DEFAULT_TO = 1000;

    public static Options getInstance() {
        return Holder.INSTANCE;
    }

    private Options() {
        mPreferences = NbPreferences.forModule(getClass());
    }

    public Color getColorBackground() {
        return Color.decode(mPreferences.get(KEY_COLOR_BACKGROUND, GraphicsHelper.colorToString(DEFAULT_COLOR_BACKGROUND)));
    }

    public int getFrom() {
        return mPreferences.getInt(KEY_FROM, DEFAULT_FROM);
    }

    public String getPlayer() {
        return mPreferences.get(KEY_PLAYER, "");
    }

    public int getTo() {
        return mPreferences.getInt(KEY_TO, DEFAULT_TO);
    }

    public void setColorBackground(Color color) {
        mPreferences.put(KEY_COLOR_BACKGROUND, GraphicsHelper.colorToString(color));
    }

    public void setFrom(int min) {
        mPreferences.putInt(KEY_FROM, min);
    }

    public void setPlayer(String player) {
        mPreferences.put(KEY_PLAYER, player);
    }

    public void setPreferences(Preferences preferences) {
        mPreferences = preferences;
    }

    public void setTo(int max) {
        mPreferences.putInt(KEY_TO, max);
    }

    private static class Holder {

        private static final Options INSTANCE = new Options();
    }
}
