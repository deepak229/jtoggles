package com.jtoggles.model;

import java.util.Set;

import com.jtoggles.manager.ApplicationToggle;
import com.jtoggles.policy.TenantedToggleChangePolicy;

/**
 @author narasimha.s
 Date 10/11/20
 */
public class TenantedToggle
    extends Toggle {

    public TenantedToggle(final String name,
                          final ConfidenceLevel confidenceLevel,
                          final Set<ApplicationToggle> dependentToggles,
                          final TenantedToggleChangePolicy toggleChangePolicy) {
        super(name, confidenceLevel, dependentToggles, toggleChangePolicy);
    }
}
