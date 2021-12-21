package com.jtoggles.model;

public enum ConfidenceLevel
    implements IConfidenceLevel {
    OFF(0),
    INTERNAL(5),
    PREVIEW(10),
    PRODUCTION(15);

    private final int level;

    ConfidenceLevel(final int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }
}