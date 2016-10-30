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
import org.nbgames.core.game.NewGameController;
import org.nbgames.core.game.NewGameDialogManager;
import org.openide.DialogDisplayer;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;
import org.openide.windows.WindowManager;

/**
 *
 * @author Patrik Karlsson
 */
@ServiceProviders(value = {
    @ServiceProvider(service = GameController.class)
    ,
    @ServiceProvider(service = LogicGameProvider.class)}
)
public class GunuController extends GameController implements LogicGameProvider, NewGameController {

    public static final String TAG = "Gunu";
    private GunuPanel mGamePanel;

    public GunuController() {
    }

    @Override
    public GameCategory getCategory() {
        return GameCategory.LOGIC;
    }

    @Override
    public String getId() {
        return getClass().getName();
    }

    @Override
    public JPanel getPanel() {
        if (mGamePanel == null) {
            mGamePanel = new GunuPanel();
        }

        return mGamePanel;
    }

    @Override
    public JPanel getSettingsPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onRequestNewGameCancel() {
    }

    @Override
    public void onRequestNewGameStart() {
//        getGamePanel().newGame()
        updateStatusBar();
    }

    @Override
    public void requestNewGame() {
        WindowManager.getDefault().invokeWhenUIReady(() -> {
            NewGameDialogManager manager = new NewGameDialogManager(new GunuNewGamePanel(), GunuController.this);
            DialogDisplayer.getDefault().notify(manager.getDialogDescriptor());
        });
    }

    @Override
    public void updateStatusBar() {
//        StatusDisplayer.getDefault().setStatusText(getGamePanel().getGameTitle(), StatusDisplayer.IMPORTANCE_ERROR_HIGHLIGHT);
    }
}
