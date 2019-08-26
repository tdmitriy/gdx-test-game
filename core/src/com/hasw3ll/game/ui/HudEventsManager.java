package com.hasw3ll.game.ui;


import com.hasw3ll.game.listener.PlayerDataChangedListener;
import com.hasw3ll.game.settings.PlayerSettings;

public class HudEventsManager implements PlayerDataChangedListener {

    private Hud hud;

    public HudEventsManager(Hud hud) {
        this.hud = hud;
    }

    @Override
    public void playerHealthChangedListener(int receivedDamage) {
        int hp = PlayerSettings.getHp();

        if (hp <= 0) {
            System.out.println("GAME OVER");
        } else {
            hp -= receivedDamage;
            PlayerSettings.setHp(hp);
            hud.setLabelPlayerHp(hp);
        }
    }

    @Override
    public void playerMoneyChangedListener(int receivedMoney) {

    }
}
