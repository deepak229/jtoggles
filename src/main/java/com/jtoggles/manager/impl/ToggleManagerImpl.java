package com.jtoggles.manager.impl;

import javax.inject.Singleton;

import com.jtoggles.manager.ApplicationToggle;
import com.jtoggles.manager.ToggleManager;
import com.jtoggles.model.IConfidenceLevel;

/**
 @author narasimha.s
 Date 10/14/20
 */
@Singleton
public class ToggleManagerImpl
    implements ToggleManager {

    private static ToggleManager INSTANCE;

    public ToggleManagerImpl(final IConfidenceLevel IConfidenceLevel,
                             final Class<? extends ApplicationToggle> toggleDefinitionClass) {
        if (INSTANCE != null){
            throw new IllegalStateException("Toggle is already initialized.");
        }
        ToggleStateCache.init(IConfidenceLevel, toggleDefinitionClass);
        INSTANCE = this;
    }

    public static ToggleManager get(){
        if(INSTANCE == null){
            throw new IllegalStateException("Toggle is NOT initialized.");
        }
        return INSTANCE;
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
