package com.jtoggles.manager.impl;

import javax.inject.Singleton;

import com.jtoggles.manager.ApplicationToggle;
import com.jtoggles.manager.ToggleManager;
import com.jtoggles.model.ConfidenceLevel;

/**
 @author narasimha.s
 Date 10/14/20
 */
@Singleton
public class ToggleManagerImpl
    implements ToggleManager {

    public ToggleManagerImpl(final ConfidenceLevel confidenceLevel,
                             final Class<? extends ApplicationToggle> toggleDefinitionClass) {
        ToggleStateCache.init(confidenceLevel, toggleDefinitionClass);
    }

    @Override
    public boolean isEnabled(final ApplicationToggle toggle) {
        return ToggleStateCache.get().getToggleState(toggle);
    }

    @Override
    public boolean isEnabled(final ApplicationToggle toggle, final String tenant) {
        return false;
    }

    @Override
    public boolean override(final ApplicationToggle toggle, final boolean state) {
        return false;
    }

    @Override
    public boolean override(final ApplicationToggle toggle, final boolean state, final String tenant) {
        return false;
    }
}
