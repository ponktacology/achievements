package me.ponktacology.achievement.listener;

import me.ponktacology.achievement.AchievementService;
import me.ponktacology.achievement.Achievements;
import net.jafama.FastMath;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MovementListener implements Listener {

    private final AchievementService achievementService;

    public MovementListener(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @EventHandler(ignoreCancelled = true)
    public void on(PlayerMoveEvent event) {
        final var player = event.getPlayer();
        final var from = event.getFrom();
        final var to = event.getTo();

        final var deltaX = from.getX() - to.getX();
        final var deltaZ = from.getZ() - to.getZ();
        final var distanceXZ = FastMath.sqrt((deltaX * deltaX) + (deltaZ * deltaZ));

        if (player.isSwimming()) {
            achievementService.incrementProgress(player, Achievements.SWIMMER, distanceXZ);
            return;
        }

        achievementService.incrementProgress(player, Achievements.TRAVELLER, distanceXZ);

        final var deltaY = to.getY() - from.getY();
        // Only increment if player went up
        if (deltaY > 0) {
            achievementService.incrementProgress(player, Achievements.CLIMBER, deltaY);
        }
    }
}
