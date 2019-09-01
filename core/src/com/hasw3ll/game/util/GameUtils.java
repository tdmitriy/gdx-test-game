package com.hasw3ll.game.util;

import com.badlogic.gdx.Gdx;

public class GameUtils {

    public static void logDebug(String message) {
        Gdx.app.debug("DEBUG", message);
    }

    public static void logError(String message) {
        Gdx.app.error("ERROR", message);
    }

    public static void log(String message) {
        Gdx.app.log("INFO", message);
    }
}
