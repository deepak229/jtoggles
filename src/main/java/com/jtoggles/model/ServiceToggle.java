package com.jtoggles.model;

import java.util.Set;

import com.jtoggles.manager.ApplicationToggle;
import com.jtoggles.policy.ServiceToggleChangePolocy;

/**
 @author narasimha.s
 Date 10/11/20
 */
public class ServiceToggle
    extends Toggle {

    public ServiceToggle(final String name,
                         final ConfidenceLevel confidenceLevel,
                         final Set<ApplicationToggle> dependentToggles,
                         final ServiceToggleChangePolocy toggleChangePolicy) {
        super(name, confidenceLevel, dependentToggles, toggleChangePolicy);
    }
}
