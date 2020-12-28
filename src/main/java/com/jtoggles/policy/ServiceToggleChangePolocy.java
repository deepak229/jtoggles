package com.jtoggles.policy;

import com.jtoggles.model.Toggle;

/**
 @author narasimha.s
 Date 10/11/20
 */
public interface ServiceToggleChangePolocy
    extends ToggleChangePolicy {

    void onChange(final Toggle toggle, final boolean newState);
}
