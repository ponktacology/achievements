package me.ponktacology.achievement.listener;

import me.ponktacology.achievement.AchievementService;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class AchievementDataListener implements Listener {

    private final AchievementService achievementService;

    public AchievementDataListener(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void on(AsyncPlayerPreLoginEvent event) {
        if (event.getLoginResult() != AsyncPlayerPreLoginEvent.Result.ALLOWED) return;
        achievementService.load(event.getUniqueId());
    }

    @EventHandler
    public void on(PlayerQuitEvent event) {
        achievementService.flush(event.getPlayer());
    }
}