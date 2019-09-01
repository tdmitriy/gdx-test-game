package com.hasw3ll.game.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.hasw3ll.game.TowerDefenceGame;
import com.hasw3ll.game.actor.FlyBat;
import com.hasw3ll.game.actor.Skeleton;
import com.hasw3ll.game.util.Assets;

public class GameScreen extends AbstractScreen {

    private Texture textureBackground;
    private Skeleton skeleton;
    private FlyBat flyBat;

    public GameScreen(TowerDefenceGame game) {
        super(game);
    }

    @Override
    public void create() {
        textureBackground = Assets.BACKGROUND_TEXTURE;
        skeleton = new Skeleton(game.getTextureAtlas());
        flyBat = new FlyBat(game.getTextureAtlas());
        mainStage.addActor(new Image(textureBackground));
        mainStage.addActor(flyBat);
        mainStage.addActor(skeleton);
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
