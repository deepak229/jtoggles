package com.jtoggles.manager.impl;

import com.jtoggles.model.Toggle;

/**
 @author narasimha.s
 Date 10/14/20
 */
public class ToggleOverride {

    private final String tenant;
    private final Toggle toggle;
    private final Boolean overrideValue;

    public ToggleOverride(final String tenant, final Toggle toggle, final Boolean overrideValue) {
        this.toggle = toggle;
        this.overrideValue = overrideValue;
        this.tenant = tenant;
    }
}
