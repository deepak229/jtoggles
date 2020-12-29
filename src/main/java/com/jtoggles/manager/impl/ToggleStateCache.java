package com.jtoggles.manager.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.jtoggles.manager.ApplicationToggle;
import com.jtoggles.model.IConfidenceLevel;
import com.jtoggles.model.Toggle;

/**
 @author narasimha.s
 Date 10/14/20
 */
public class ToggleStateCache {

    private final static Logger logger = Logger.getLogger(ToggleStateCache.class);
    private static Map<ApplicationToggle, Boolean> toggleStates;
    private static Map<String, List<ToggleOverride>> toggleOverrides;
    private static ToggleStateCache instance;
    private final IConfidenceLevel appConfidenceLevel;

    private ToggleStateCache(final IConfidenceLevel IConfidenceLevel) {
        this.appConfidenceLevel = IConfidenceLevel;
    }

    static ToggleStateCache get() {
        if (instance == null) {
            throw new IllegalStateException("Cache is not inialized");
        }
        return instance;
    }

    synchronized static void init(final IConfidenceLevel IConfidenceLevel,
                                  final Class<? extends ApplicationToggle> toggleClass) {
        if (instance != null) {
            throw new IllegalStateException("Toggle states are already initialized");
        }
        if (toggleClass == null) {
            throw new IllegalArgumentException("toggleClass is null");
        }

        if (IConfidenceLevel == null) {
            throw new IllegalArgumentException("confidenceLevel is null");
        }

        instance = new ToggleStateCache(IConfidenceLevel);
        if (toggleClass.getEnumConstants().length == 0) {
            return;
        }
        toggleStates = new HashMap<>(toggleClass.getEnumConstants().length);
        Arrays.stream(toggleClass.getEnumConstants()).forEach(appToggle -> instance.loadToggle(appToggle));
    }

    boolean getToggleState(final ApplicationToggle applicationToggle) {

        if (!toggleStates.containsKey(applicationToggle)) {
            logger.warn(String.format("toggle not found %s", applicationToggle));
        }
        return toggleStates.get(applicationToggle).booleanValue();
    }

    private Boolean loadToggle(final ApplicationToggle applicationToggle) {

        if (toggleStates.containsKey(applicationToggle)) {
            return toggleStates.get(applicationToggle);
        }

        if (applicationToggle.getToggle().getDependentToggles() != null) {
            final Set<Boolean> failedState = applicationToggle.getToggle().getDependentToggles().stream()
                .map(childToggle -> loadToggle(childToggle))
                .filter(flag -> flag == false).collect(Collectors.toSet());
            if (failedState.size() > 0) {
                toggleStates.put(applicationToggle, false);
            }
            else {
                toggleStates.put(applicationToggle, getToggleState(applicationToggle.getToggle()));
            }
        }
        else {
            toggleStates.put(applicationToggle, getToggleState(applicationToggle.getToggle()));
        }
        final Boolean state = toggleStates.get(applicationToggle);
        logger.info(String.format("loaded toggle: %s with state: %s", applicationToggle, state));
        return state;
    }

    private Boolean getToggleState(final Toggle toggle) {
        return toggle.getConfidenceLevel().getLevel() >= this.appConfidenceLevel.getLevel();
    }
}
