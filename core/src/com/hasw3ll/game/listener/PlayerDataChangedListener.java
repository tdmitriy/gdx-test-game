package com.hasw3ll.game.listener;

public interface PlayerDataChangedListener {
    void playerHealthChangedListener(int receivedDamage);

    void playerMoneyChangedListener(int receivedMoney);
}
