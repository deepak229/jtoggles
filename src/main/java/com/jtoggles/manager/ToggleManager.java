package com.jtoggles.manager;

public interface ToggleManager {

    boolean isEnabled(final ApplicationToggle toggle);

    boolean isEnabled(final ApplicationToggle toggle, final String tenant);

    boolean override(final ApplicationToggle toggle, boolean state);

    boolean override(final ApplicationToggle toggle, boolean state, final String tenant);
}
