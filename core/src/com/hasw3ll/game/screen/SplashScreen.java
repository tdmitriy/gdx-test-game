package com.hasw3ll.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hasw3ll.game.AppConstants;
import com.hasw3ll.game.manager.ScreenState;
import com.hasw3ll.game.manager.ScreenStateManager;

public class SplashScreen extends AbstractScreen {

    private float timer = 0f;

    public SplashScreen() {
        System.out.println("Showing SplashScreen");
    }

    @Override
    public Viewport getViewport() {
        return new StretchViewport(AppConstants.WIDTH, AppConstants.HEIGHT, new OrthographicCamera());
    }

    @Override
    public Stage getStage() {
        return null;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        timer += delta;
        if (timer >= 3)
            ScreenStateManager.getInstance().showScreen(ScreenState.GAME);
    }

    @Override
    public void dispose() {
        System.out.println("Disposing SplashScreen");
    }
}
