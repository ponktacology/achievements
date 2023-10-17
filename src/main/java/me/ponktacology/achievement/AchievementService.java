package me.ponktacology.achievement;

import com.google.common.base.Preconditions;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AchievementService {

    private static final DecimalFormat PROGRESS_FORMAT = new DecimalFormat("#.##");
    private final AchievementRepository achievementRepository;
    private final Map<UUID, AchievementProgressContainer> playerProgress = new ConcurrentHashMap<>();

    public AchievementService(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

    public void incrementProgress(Player player, Achievement achievement, double value) {
        final var progress = progress(player, achievement);
        if (progress.completed()) return;
        progress.increment(value);
        if (progress.completed()) achievement.reward().giveTo(player);
    }

    public void displayProgress(Player target) {
        final var byCategory = new HashMap<Category, List<Achievement>>();
        for (Achievement achievement : Achievements.values()) {
            final var achievements = byCategory.computeIfAbsent(achievement.category(), c -> new ArrayList<>());
            achievements.add(achievement);
        }

        for (Map.Entry<Category, List<Achievement>> entry : byCategory.entrySet()) {
            final var category = entry.getKey();
            target.sendMessage("   --- " + category.displayName() + " ---");
            final var achievements = entry.getValue();
            for (Achievement achievement : achievements) {
                final var progress = progress(target, achievement);
                target.sendMessage("        " + achievement.displayName() + " (" + achievement.description() + ")" + " progress: " + PROGRESS_FORMAT.format(progress.completion() * 100) + "% ");
            }
        }
    }

    private Progress progress(Player player, Achievement achievement) {
        final var progressContainer = Preconditions.checkNotNull(playerProgress.get(player.getUniqueId()), "player failed to load");
        return progressContainer.get(achievement);
    }

    public void load(UUID uuid) {
        final var progressContainer = achievementRepository.loadProgress(uuid);
        playerProgress.put(uuid, progressContainer);
    }

    public void flush(Player player) {
        playerProgress.remove(player.getUniqueId());
    }

}
