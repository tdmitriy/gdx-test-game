package com.hasw3ll.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.hasw3ll.game.manager.ScreenState;
import com.hasw3ll.game.manager.ScreenStateManager;
import com.hasw3ll.game.util.Assets;

public class TowerDefenceGame extends Game {

    private TextureAtlas textureAtlas;

    @Override
    public void create() {
        if (AppConstants.DEBUG)
            Gdx.app.setLogLevel(Application.LOG_DEBUG);

        textureAtlas = Assets.TEXTURE_ATLAS;
        ScreenStateManager.getInstance().init(this);
        ScreenStateManager.getInstance().showScreen(ScreenState.GAME);
    }

    public TextureAtlas getTextureAtlas() {
        return textureAtlas;
    }

    @Override
    public void render() {
        super.render();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
            Gdx.app.exit();
    }

    @Override
    public void dispose() {
        textureAtlas.dispose();
        getScreen().dispose();
    }
}
