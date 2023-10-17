package me.ponktacology.achievement.reward;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemReward implements Reward {

    private final ItemStack reward;

    public ItemReward(ItemStack reward) {
        this.reward = reward;
    }

    @Override
    public void giveTo(Player player) {
        player.getInventory().addItem(reward.clone());
    }
}
