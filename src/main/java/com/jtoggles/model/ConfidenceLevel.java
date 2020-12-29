package com.jtoggles.model;

public enum ConfidenceLevel
    implements IConfidenceLevel {
    OFF(0),
    INTERNAL(1),
    PREVIEW(2),
    PRODUCTION(3);

    private final int level;

    ConfidenceLevel(final int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }
}