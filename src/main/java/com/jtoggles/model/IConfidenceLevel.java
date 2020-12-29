package com.jtoggles.model;
/**
 * <p>
 * An interface that to define the confidence level of the application runtime.
 * the confindence level is used to derive the state of the toggle.
 *</p>
 *
 * <p>A toggle will be ON if the confidence level of a toggle is greater than or equal the confidence level of the application runtime.</p>
 *
 * <p>
 * If the application is running in confidence level with value 5 and the toggle confidence level is 3 then the toggle state will be OFF. <br />
 * If the application is running in confidence level with value 5 and the toggle confidence level is 5 or 6 then the toggle state will be ON.
 * </p>
 *
 * The library comes with default confidence levels
 * <ul>
 *     <li>OFF (0)</li>
 *     <li>INTERNAL(1)</li>
 *     <li>PREVIEW (2)</li>
 *     <li>PRODUCTION (3)</li>
 * </ul>
 *
 * <p>If the appliation is running in Production confidence level, the toggle which is in Internal confidence level will be OFF</p>
 *
 * <p>
 *     If your usecase has different confidence levels than default that comes with this library, create a separate enum similar to {@link com.jtoggles.model.ConfidenceLevel}
 *     and define your own confidence levels to use in your application
 * </p>
 */
public interface IConfidenceLevel {
    int getLevel();
}
