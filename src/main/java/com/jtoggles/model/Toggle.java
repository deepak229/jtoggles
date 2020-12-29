package com.jtoggles.model;

import java.util.Set;

import com.jtoggles.manager.ApplicationToggle;
import com.jtoggles.policy.ToggleChangePolicy;

/**
 * <p>A class that holds the definition of a toggle.</p>
 * <p>A toggle can be of two types:
 *      <ul>
 *          <li>Service Toggle</li>
 *          <li>Tenanted Toggle</li>
 *      </ul>
 * </p>
 *
 * <p>Toggle's confidence level along with the dependencies determine the state of the toggle</p>
 */
public abstract class Toggle {

    private final String name;
    private final IConfidenceLevel IConfidenceLevel;
    private final Set<ApplicationToggle> dependentToggles;
    private final ToggleChangePolicy toggleChangePolicy;

    protected Toggle(final String name,
                  final IConfidenceLevel IConfidenceLevel,
                  final Set<ApplicationToggle> dependentToggles,
                  final ToggleChangePolicy toggleChangePolicy) {
        this.name = name;
        this.IConfidenceLevel = IConfidenceLevel;
        this.dependentToggles = dependentToggles;
        this.toggleChangePolicy = toggleChangePolicy;
    }

    public String getName() {
        return this.name;
    }

    public IConfidenceLevel getConfidenceLevel() {
        return this.IConfidenceLevel;
    }

    public Set<ApplicationToggle> getDependentToggles() {
        return this.dependentToggles;
    }

    public ToggleChangePolicy getToggleChangePolicy() {
        return this.toggleChangePolicy;
    }
}
