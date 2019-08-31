package com.hasw3ll.game.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.hasw3ll.game.AppConstants;

import static com.hasw3ll.game.util.GameUtils.logDebug;

public abstract class AbstractScreen implements Screen, InputProcessor {

    protected Game game;
    protected Stage uiStage;
    protected Stage mainStage;

    protected Table uiTable;
    private boolean paused = false;

    public AbstractScreen(Game game) {
        logDebug("Showing " + this.getClass().getSimpleName());

        this.game = game;
        uiStage = new Stage(new StretchViewport(AppConstants.WIDTH, AppConstants.HEIGHT));
        mainStage = new Stage(new StretchViewport(AppConstants.WIDTH, AppConstants.HEIGHT));

        uiTable = new Table();
        uiTable.setFillParent(true);
        uiStage.addActor(uiTable);

        create();
    }

    public abstract void create();

    public abstract void update(float dt);

    @Override
    public void render(float delta) {
        uiStage.act(delta);

        if (!isPaused()) {
            mainStage.act(delta);
            update(delta);
        }

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mainStage.draw();
        uiStage.draw();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void resize(int width, int height) {
        uiStage.getViewport().update(width, height);
        mainStage.getViewport().update(width, height);
    }

    @Override
    public void dispose() {
        logDebug("Disposing " + this.getClass().getSimpleName());
        uiStage.dispose();
        mainStage.dispose();
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public void togglePaused() {
        this.paused = !this.paused;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }
}
