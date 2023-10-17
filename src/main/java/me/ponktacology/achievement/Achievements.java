package me.ponktacology.achievement;

import me.ponktacology.achievement.reward.CashReward;
import me.ponktacology.achievement.reward.ItemReward;
import me.ponktacology.achievement.reward.Reward;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum Achievements implements Achievement {

    TRAVELLER("Traveller",
            "Walk 10 kilometers",
            Category.MOVEMENT,
            new ItemStack(Material.LEATHER_BOOTS), new ItemReward(new ItemStack(Material.DIAMOND_BOOTS)),
            10_000),
    CLIMBER("Climber",
            "Climb 1 kilometer",
            Category.MOVEMENT,
            new ItemStack(Material.ICE), new CashReward(5_000),
            1_000),
    SWIMMER("Michael Phelps",
            "Swim 5 kilometers",
            Category.MOVEMENT,
            new ItemStack(Material.OAK_BOAT), new CashReward(1),
            5_000),
    CREEPER_LOVER("Creeper Lover",
            "Kill 100 Creepers",
            Category.COMBAT,
            new ItemStack(Material.CREEPER_SPAWN_EGG), new ItemReward(new ItemStack(Material.CREEPER_HEAD)),
            100),
    BOXER("Boxer",
            "Deal 10,000 damage to other players",
            Category.COMBAT,
            new ItemStack(Material.DIAMOND_SWORD), new ItemReward(new ItemStack(Material.NETHERITE_SWORD)),
            10_000);

    private final String displayName;
    private final String description;
    private final Category category;
    private final ItemStack icon;
    private final Reward reward;
    private final double targetProgressValue;

    Achievements(String displayName, String description, Category category, ItemStack icon, Reward reward, double targetProgressValue) {
        this.displayName = displayName;
        this.description = description;
        this.category = category;
        this.icon = icon;
        this.reward = reward;
        this.targetProgressValue = targetProgressValue;
    }

    @Override
    public String displayName() {
        return displayName;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public Category category() {
        return category;
    }

    @Override
    public ItemStack icon() {
        return icon;
    }

    @Override
    public Reward reward() {
        return reward;
    }

    @Override
    public Progress createProgress() {
        return new Progress(targetProgressValue);
    }
}
