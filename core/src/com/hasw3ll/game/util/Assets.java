package com.hasw3ll.game.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Assets {

    public static final String BACKGROUND = "images/td_bg3.jpg";
    public static final String MONSTER2 = "images/monster2.png";

    public static Texture BACKGROUND_TEXTURE = loadTexture(BACKGROUND);
    public static Texture MONSTER2_TEXTURE = loadTexture(MONSTER2);

    public static Texture loadTexture(String path) {
        return new Texture(Gdx.files.internal(path));
    }
}
