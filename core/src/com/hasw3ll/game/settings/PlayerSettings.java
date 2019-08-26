package com.hasw3ll.game.settings;

import java.util.concurrent.atomic.AtomicInteger;

public class PlayerSettings {
    private static AtomicInteger hp = new AtomicInteger(10);
    private static AtomicInteger money = new AtomicInteger(150);

    private PlayerSettings() {
    }

    public static int getHp() {
        return PlayerSettings.hp.get();
    }

    public static void setHp(int hp) {
        PlayerSettings.hp.set(hp);
    }

    public static int getMoney() {
        return money.get();
    }

    public static void setMoney(int money) {
        PlayerSettings.money.set(money);
    }
}
