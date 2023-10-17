package me.ponktacology.achievement;

import java.util.HashMap;
import java.util.Map;

public class AchievementProgressContainer {

    private final Map<Achievement, Progress> progress = new HashMap<>();

    public Progress get(Achievement achievement) {
        return progress.computeIfAbsent(achievement, Achievement::createProgress);
    }
}
