package com.hasw3ll.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.hasw3ll.game.TowerDefenceGame;
import com.hasw3ll.game.manager.ScreenState;
import com.hasw3ll.game.manager.ScreenStateManager;

public class SplashScreen extends AbstractScreen {

    private float timer = 0f;

    public SplashScreen(TowerDefenceGame game) {
        super(game);
    }

    @Override
    public void create() {

    }

    @Override
    public void update(float dt) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        timer += dt;
        if (timer >= 3)
            ScreenStateManager.getInstance().showScreen(ScreenState.GAME);
    }


    @Override
    public void dispose() {
        super.dispose();
    }
}
