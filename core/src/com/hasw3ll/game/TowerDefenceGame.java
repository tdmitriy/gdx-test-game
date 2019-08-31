package com.hasw3ll.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.hasw3ll.game.manager.ScreenState;
import com.hasw3ll.game.manager.ScreenStateManager;

public class TowerDefenceGame extends Game {

    @Override
    public void create() {
        if (AppConstants.DEBUG)
            Gdx.app.setLogLevel(Application.LOG_DEBUG);

        ScreenStateManager.getInstance().init(this);
        ScreenStateManager.getInstance().showScreen(ScreenState.GAME);
    }

    @Override
    public void render() {
        super.render();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
            Gdx.app.exit();
    }

    @Override
    public void dispose() {
        getScreen().dispose();
    }
}
