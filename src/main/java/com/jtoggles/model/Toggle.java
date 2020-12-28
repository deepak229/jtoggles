package com.jtoggles.model;

import java.util.Set;

import com.jtoggles.manager.ApplicationToggle;
import com.jtoggles.policy.ToggleChangePolicy;

public abstract class Toggle {

    private final String name;
    private final ConfidenceLevel confidenceLevel;
    private final Set<ApplicationToggle> dependentToggles;
    private final ToggleChangePolicy toggleChangePolicy;

    public Toggle(final String name,
                  final ConfidenceLevel confidenceLevel,
                  final Set<ApplicationToggle> dependentToggles,
                  final ToggleChangePolicy toggleChangePolicy) {
        this.name = name;
        this.confidenceLevel = confidenceLevel;
        this.dependentToggles = dependentToggles;
        this.toggleChangePolicy = toggleChangePolicy;
    }

    public String getName() {
        return this.name;
    }

    public ConfidenceLevel getConfidenceLevel() {
        return this.confidenceLevel;
    }

    public Set<ApplicationToggle> getDependentToggles() {
        return this.dependentToggles;
    }

    public ToggleChangePolicy getToggleChangePolicy() {
        return this.toggleChangePolicy;
    }
}
