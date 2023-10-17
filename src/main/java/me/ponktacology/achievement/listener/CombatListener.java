package me.ponktacology.achievement.listener;

import me.ponktacology.achievement.AchievementService;
import me.ponktacology.achievement.Achievements;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class CombatListener implements Listener {

    private final AchievementService achievementService;

    public CombatListener(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @EventHandler(ignoreCancelled = true)
    public void on(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Player attacker) {
            achievementService.incrementProgress(attacker, Achievements.BOXER, event.getDamage());
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void on(EntityDeathEvent event) {
        if (!(event.getEntity() instanceof Creeper)) return;
        final var killer = event.getEntity().getKiller();
        if (killer == null) return;
        achievementService.incrementProgress(killer, Achievements.CREEPER_LOVER, 1);
    }
}
