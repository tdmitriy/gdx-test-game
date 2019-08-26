package com.hasw3ll.game.factory;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;


public class WaypointFactory {

    public static final Array<Vector2> WAYPOINTS = new Array<Vector2>() {{
        add(new Vector2(0, 0));
        add(new Vector2(200, 100));
        add(new Vector2(200, 300));
        add(new Vector2(400, 300));
        add(new Vector2(400, 500));
        add(new Vector2(600, 500));
        add(new Vector2(600, 300));
        add(new Vector2(600, 100));
        add(new Vector2(700, 100));
        add(new Vector2(700, 300));
        add(new Vector2(1000, 300));
    }};
    private static BitmapFont waypointFont = new BitmapFont();

    public static void debugWaypoints(final Batch batch) {
        batch.begin();
        Array<Vector2> waypoints = WAYPOINTS;

        for (int i = 0; i < waypoints.size; i++) {
            waypointFont.draw(batch, "" + i, waypoints.get(i).x, waypoints.get(i).y);
        }

        batch.end();
    }
}
