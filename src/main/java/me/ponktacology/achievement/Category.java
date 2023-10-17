package me.ponktacology.achievement;

public enum Category {
    COMBAT("Combat"),
    MOVEMENT("Movement");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }
}
