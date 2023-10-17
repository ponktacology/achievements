package me.ponktacology.achievement;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AchievementCommand implements CommandExecutor {

    private final AchievementService achievementService;

    public AchievementCommand(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player sender) {
            achievementService.displayProgress(sender);
        } else commandSender.sendMessage("Only in game.");
        return true;
    }
}
