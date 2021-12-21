package com.jtoggles.manager;

import com.jtoggles.model.Toggle;

public interface ApplicationToggle {

    Toggle getToggle();

    ToggleManager getToggleManager();
    default boolean isEnabled() {
        return getToggleManager().isEnabled(this);
    }
}
