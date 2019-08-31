package com.hasw3ll.game.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.hasw3ll.game.util.Assets;

public class GameScreen extends AbstractScreen {

    private Texture textureBackground;

    public GameScreen(Game game) {
        super(game);
    }

    @Override
    public void create() {
        textureBackground = Assets.BACKGROUND_TEXTURE;
        mainStage.addActor(new Image(textureBackground));
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void dispose() {
        textureBackground.dispose();
        super.dispose();
    }
}
