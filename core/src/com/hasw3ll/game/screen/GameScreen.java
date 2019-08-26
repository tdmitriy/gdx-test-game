package com.hasw3ll.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hasw3ll.game.AppConstants;
import com.hasw3ll.game.actor.Enemy;
import com.hasw3ll.game.factory.EnemyFactory;
import com.hasw3ll.game.factory.WaypointFactory;
import com.hasw3ll.game.ui.Hud;
import com.hasw3ll.game.ui.HudEventsManager;
import com.hasw3ll.game.util.Assets;

public class GameScreen extends AbstractScreen {

    private static final int ENEMIES_COUNT = 15;
    private final Stage stage;
    private Texture textureBackground;
    private Hud hud;
    private HudEventsManager hudEventsManager;

    public GameScreen() {
        System.out.println("Showing GameScreen");
        textureBackground = Assets.BACKGROUND_TEXTURE;
        stage = new Stage(getViewport());
        hud = new Hud();
        hudEventsManager = new HudEventsManager(hud);

        initUiElements();

        generateEnemies();
    }


    private void initUiElements() {
        stage.addActor(new Image(textureBackground));
        stage.addActor(hud.loadHudElements());
    }

    private void generateEnemies() {
        for (Enemy enemy : EnemyFactory.generateEnemies(ENEMIES_COUNT)) {
            enemy.setPlayerDataChangedNotifier(hudEventsManager);
            stage.addActor(enemy);
        }
    }

    @Override
    public Viewport getViewport() {
        return new StretchViewport(AppConstants.WIDTH, AppConstants.HEIGHT, new OrthographicCamera());
    }

    @Override
    public Stage getStage() {
        return stage;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();

        WaypointFactory.debugWaypoints(stage.getBatch());
    }

    @Override
    public void dispose() {
        System.out.println("Disposing GameScreen");
        textureBackground.dispose();
        stage.dispose();
    }
}
