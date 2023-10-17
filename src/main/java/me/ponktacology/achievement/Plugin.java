package me.ponktacology.achievement;

import me.ponktacology.achievement.listener.AchievementDataListener;
import me.ponktacology.achievement.listener.CombatListener;
import me.ponktacology.achievement.listener.MovementListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        final var repository = new AchievementRepository();
        final var service = new AchievementService(repository);

        List.of(new AchievementDataListener(service),
                        new CombatListener(service),
                        new MovementListener(service))
                .forEach(it -> Bukkit.getPluginManager().registerEvents(it, this));

        getCommand("achievements").setExecutor(new AchievementCommand(service));
    }
}
