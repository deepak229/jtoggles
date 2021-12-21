package com.jtoggles;

import java.util.Collections;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.jtoggles.manager.ApplicationToggle;
import com.jtoggles.manager.ToggleManager;
import com.jtoggles.manager.impl.ToggleManagerImpl;
import com.jtoggles.model.ConfidenceLevel;
import com.jtoggles.model.ServiceToggle;
import com.jtoggles.model.TenantedToggle;
import com.jtoggles.model.Toggle;

public enum MyApplicationToggle
    implements ApplicationToggle {

    TEST(new TenantedToggle("abc", ConfidenceLevel.PRODUCTION, null, (toggle, tenant, newState) -> {
        final Logger logger = Logger.getLogger(MyApplicationToggle.class);
        logger.info(String.format("toggle %s changed to %s for tenant: %s", toggle.getName(), newState, tenant));
    })),

    TEST2(new ServiceToggle("Service Toggle", ConfidenceLevel.INTERNAL, Collections.singleton(TEST),
        (toggle, newState) -> {
            final Logger logger = Logger.getLogger(MyApplicationToggle.class);
            logger.info(String.format("toggle %s changed to %s", toggle.getName(), newState));
        })),

    TEST3(new ServiceToggle("Service Toggle", ConfidenceLevel.PRODUCTION, Collections.singleton(TEST2),
        (toggle, newState) -> {
        final Logger logger = Logger.getLogger(MyApplicationToggle.class);
        logger.info(String.format("toggle %s changed to %s", toggle.getName(), newState));
    }));

    private final Toggle toggle;
    private static ToggleManager toggleManager;

    MyApplicationToggle(final Toggle toggle) {
        this.toggle = toggle;
    }

    public Toggle getToggle() {
        return this.toggle;
    }

    static void setToggleManager(final ToggleManager manager){
        toggleManager = manager;
    }

    @Override
    public ToggleManager getToggleManager() {
        return toggleManager;
    }

    public static void main(final String[] args) {
        BasicConfigurator.configure();
        final Logger logger = Logger.getLogger(MyApplicationToggle.class);
        final ToggleManager m = new ToggleManagerImpl(ConfidenceLevel.PRODUCTION, MyApplicationToggle.class);

        setToggleManager(m);
        logger.info(m.isEnabled(TEST));
        logger.info(m.isEnabled(TEST2));
        logger.info(m.isEnabled(TEST3));
    }
}