package com.hasw3ll.game.factory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.hasw3ll.game.actor.Enemy;
import com.hasw3ll.game.settings.EnemySettings;
import com.hasw3ll.game.util.Assets;

public class EnemyFactory {

    private static final Texture ENEMY_TEXTURE = Assets.MONSTER2_TEXTURE;

    public static Array<Enemy> generateEnemies(int count) {
        Array<Enemy> enemies = new Array<>(count);
        EnemySettings enemySettings = new EnemySettings();

        float x = enemySettings.getX();
        float y = enemySettings.getY();
        for (int i = 0; i < count; i++) {
            enemySettings = new EnemySettings();
            enemySettings.setTexture(ENEMY_TEXTURE);
            enemySettings.setX(x);
            enemySettings.setY(y);

            enemies.add(new Enemy(enemySettings));
            x -= 100;
        }

        return enemies;
    }
}
