/*
 * Copyright 2016 Patrik Karlsson.
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

import javax.swing.JPanel;
import org.nbgames.core.GameCategory;
import org.nbgames.core.GameController;
import org.nbgames.core.api.LogicGameProvider;
import org.nbgames.core.base.GamePanel;
import org.nbgames.core.base.NewGamePanel;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

/**
 *
 * @author Patrik Karlsson
 */
@ServiceProviders(value = {
    @ServiceProvider(service = GameController.class)
    ,
    @ServiceProvider(service = LogicGameProvider.class)
}
)
public class Gunu extends GameController implements LogicGameProvider {

    public static final String TAG = "Gunu";
    private GunuPanel mGamePanel;

    public Gunu() {
    }

    @Override
    public GameCategory getCategory() {
        return GameCategory.LOGIC;
    }

    @Override
    public String getHelp() {
        return "gunu help";
    }

    @Override
    public NewGamePanel getNewGamePanel() {
        return new GunuNewGamePanel();
    }

    @Override
    public GamePanel getPanel() {
        if (mGamePanel == null) {
            mGamePanel = new GunuPanel();
        }

        return mGamePanel;
    }

    @Override
    public JPanel getOptionsPanel() {
        return null;
    }

    @Override
    public void onRequestNewGameStart() {
        System.out.println("onRequestNewGameStart " + getName());
        getPanel().newGame();
    }
}
