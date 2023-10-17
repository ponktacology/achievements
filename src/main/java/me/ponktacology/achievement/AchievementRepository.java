package me.ponktacology.achievement;

import java.util.UUID;

public class AchievementRepository {

    public AchievementProgressContainer loadProgress(UUID player) {
        return new AchievementProgressContainer();
    }

}
