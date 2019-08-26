package com.hasw3ll.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.hasw3ll.game.AppConstants;
import com.hasw3ll.game.TowerDefenceGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.forceExit = false;
        config.title = AppConstants.APP_NAME;
        config.width = AppConstants.WIDTH;
        config.height = AppConstants.HEIGHT;
        new LwjglApplication(new TowerDefenceGame(), config);
    }
}
