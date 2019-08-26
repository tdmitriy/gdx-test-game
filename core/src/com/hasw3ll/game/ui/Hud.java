package com.hasw3ll.game.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.hasw3ll.game.settings.PlayerSettings;

import static java.lang.String.format;
import static java.lang.String.valueOf;

//TODO read values from properties
public class Hud {
    private int waveNum;
    private int score;
    private int playerHp;

    private Label labelWaveNum;
    private Label labelScore;
    private Label labelPlayerHp;

    //    Color color =  toRGB(51,0,204,1);
    private Color BLUE = toRGB(0, 102, 255, 1);
    private Label.LabelStyle lblStylePlayerHp = new Label.LabelStyle(new BitmapFont(), BLUE);

    public Hud() {
        waveNum = 0;
        score = 0;
        playerHp = PlayerSettings.getHp();

        loadLabels();
    }

    private void loadLabels() {
        labelWaveNum = new Label(valueOf(waveNum), new Label.LabelStyle(new BitmapFont(), BLUE));
        labelScore = new Label(format("%03d", score), new Label.LabelStyle(new BitmapFont(), BLUE));
        labelPlayerHp = new Label(valueOf(playerHp), lblStylePlayerHp);
    }

    public Table loadHudElements() {
        Table table = new Table().top();
        table.setFillParent(true);

        table.add(labelWaveNum).expandX().padTop(10).minWidth(30);
        table.add(labelScore).expandX().padTop(10).minWidth(30);
        table.add(labelPlayerHp).expandX().padTop(10).minWidth(30);

        return table;
    }

    public void setLabelPlayerHp(int playerHp) {
        if (playerHp < 5)
            lblStylePlayerHp.fontColor = Color.RED;
        else
            lblStylePlayerHp.fontColor = Color.GREEN;

        this.playerHp = playerHp;
        labelPlayerHp.setText(valueOf(this.playerHp));
    }

    public Color toRGB(int r, int g, int b, int a) {
        return new Color(r / 255.0f, g / 255.0f, b / 255.0f, a);
    }
}
