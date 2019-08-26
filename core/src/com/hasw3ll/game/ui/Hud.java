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

    public Hud() {
        waveNum = 0;
        score = 0;
        playerHp = PlayerSettings.getHp();

        loadLabels();
    }

    private void loadLabels() {
        labelWaveNum = new Label(valueOf(waveNum), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        labelScore = new Label(format("%03d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        labelPlayerHp = new Label(valueOf(playerHp), new Label.LabelStyle(new BitmapFont(), Color.GREEN));
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
        this.playerHp = playerHp;
        labelPlayerHp.setText(valueOf(this.playerHp));
    }
}
