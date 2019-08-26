package com.hasw3ll.game.manager;

import com.badlogic.gdx.Screen;
import com.hasw3ll.game.TowerDefenceGame;
import com.hasw3ll.game.screen.AbstractScreen;
import com.hasw3ll.game.screen.GameScreen;
import com.hasw3ll.game.screen.SplashScreen;

public class ScreenStateManager {

    private static ScreenStateManager instance;
    private TowerDefenceGame game;

    private ScreenStateManager() {
    }

    public static ScreenStateManager getInstance() {
        if (instance == null)
            instance = new ScreenStateManager();
        return instance;
    }

    public void init(final TowerDefenceGame game) {
        this.game = game;
    }

    public void showScreen(ScreenState state) {
        Screen currentScreen = game.getScreen();

        game.setScreen(getScreen(state));

        if (currentScreen != null)
            currentScreen.dispose();
    }

    private AbstractScreen getScreen(ScreenState state) {
        switch (state) {
            case SPLASH:
                return new SplashScreen();
            case GAME:
                return new GameScreen();
            default:
                throw new IllegalStateException("Can't get screen for state: " + state);
        }
    }
}
