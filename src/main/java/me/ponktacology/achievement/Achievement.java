package me.ponktacology.achievement;

import me.ponktacology.achievement.reward.Reward;
import org.bukkit.inventory.ItemStack;

public interface Achievement {

    String displayName();

    String description();

    Category category();

    ItemStack icon();

    Reward reward();

    /**
     * Creates a new Progress object to capture player's achievement progress
     * @return the progress
     */
    Progress createProgress();

}
