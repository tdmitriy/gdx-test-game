//package com.hasw3ll.game.listener;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PlayerDataChangedNotifier {
//
//    private final List<PlayerDataChangedListener> listeners = new ArrayList<>();
//
//    public void addListener(PlayerDataChangedListener listener) {
//        if (!listeners.contains(listener))
//            listeners.add(listener);
//    }
//
//    public void removeListener(PlayerDataChangedListener listener) {
//        listeners.remove(listener);
//    }
//
//    public void healthChanged(int receivedDamage) {
//        for (PlayerDataChangedListener listener : listeners)
//            listener.playerHealthChangedListener(receivedDamage);
//    }
//
//    public void moneyChanged(int receivedMoney) {
//        for (PlayerDataChangedListener listener : listeners)
//            listener.playerMoneyChangedListener(receivedMoney);
//    }
//
//    public interface PlayerDataChangedListener {
//        void playerHealthChangedListener(int receivedDamage);
//
//        void playerMoneyChangedListener(int receivedMoney);
//    }
//}
