package me.ponktacology.achievement.reward;

import org.bukkit.entity.Player;

public class CashReward implements Reward {

    private final int amount;

    public CashReward(int amount) {
        this.amount = amount;
    }

    @Override
    public void giveTo(Player player) {
        player.sendMessage("You received " + amount + "$!");
    }
}
