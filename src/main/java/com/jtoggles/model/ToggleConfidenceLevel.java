package com.jtoggles.model;

public enum ToggleConfidenceLevel implements ConfidenceLevel{
    OFF(0),
    INTERNAL(5),
    PREVIEW(10),
    PRODUCTION(15);

    private final int level;

    ToggleConfidenceLevel(final int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }
}