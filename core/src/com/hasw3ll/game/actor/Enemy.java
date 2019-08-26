package com.hasw3ll.game.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Disposable;
import com.hasw3ll.game.listener.PlayerDataChangedListener;
import com.hasw3ll.game.settings.EnemySettings;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;

public class Enemy extends Image implements Disposable {

    private EnemySettings enemySettings;
    private PlayerDataChangedListener playerDataChangedNotifier;
    private Sprite sprite;

    private int wayPointIndex = 0;

    public Enemy(EnemySettings enemySettings) {
        this.enemySettings = enemySettings;

        sprite = new Sprite(enemySettings.getTexture());
        sprite.setSize(enemySettings.getWidth(), enemySettings.getHeight());
        sprite.setPosition(enemySettings.getX(), enemySettings.getY());

        setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
    }

    private void doEnemyWalk(float delta) {
        if (wayPointIndex < enemySettings.getWayPoints().size) {
            Vector2 enemy = new Vector2(getX(), getY());
            Vector2 dest = enemySettings.getWayPoints().get(wayPointIndex);

            float angle = (float) Math.atan2(dest.y - enemy.y, dest.x - enemy.x);
            enemy.x += Math.cos(angle) * enemySettings.getSpeed() * delta;
            enemy.y += Math.sin(angle) * enemySettings.getSpeed() * delta;
            if (dest.dst2(enemy) >= 5) {
                moveActor(enemy.x, enemy.y);
            } else wayPointIndex++;
        } else {
//            playerSettings.setHp(playerSettings.getHp() - 1);
            notifyOnEnemyRichPoint();
            wayPointIndex = 0;
            moveActor(0, 0);
        }
    }

    public void setPlayerDataChangedNotifier(PlayerDataChangedListener playerDataChangedNotifier) {
        this.playerDataChangedNotifier = playerDataChangedNotifier;
    }

    private void notifyOnEnemyRichPoint() {
        if (playerDataChangedNotifier != null) {
            playerDataChangedNotifier.playerHealthChangedListener(1);
        }
    }

    public void moveActor(float x, float y) {
        addAction(moveTo(x, y));
    }

    @Override
    public void act(float delta) {
        doEnemyWalk(delta);
        sprite.setPosition(getX(), getY());
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
        super.draw(batch, parentAlpha);
    }

    @Override
    public void dispose() {
        sprite.getTexture().dispose();
    }
}
