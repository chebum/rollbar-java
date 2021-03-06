package com.rollbar.payload.data;

import com.rollbar.payload.utilities.JsonSerializable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Information about this notifier, or one based off of this
 */
public class Notifier implements JsonSerializable {
    public static final String defaultName = "rollbar";
    public static final String defaultVersion = Notifier.class.getPackage().getImplementationVersion();

    private final String name;
    private final String version;

    /**
     * Constructor, with "rollbar" and the maven assembly version for {@code name} and {@code version}
     */
    public Notifier() {
        this.name = defaultName;
        this.version = defaultVersion;
    }

    /**
     * Constructor
     * @param name the name of the notifier
     * @param version the version of the notifier
     */
    public Notifier(String name, String version) {
        this.name = name;
        this.version = version;
    }

    /**
     * @return the name
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name on a copy of this notifier
     * @param name the new name
     * @return the name of the notifier
     */
    public Notifier name(String name) {
        return new Notifier(name, version);
    }

    /**
     * @return the version of the notifier
     */
    public String version() {
        return this.version;
    }

    /**
     * Set the version on a copy of this notifier
     * @param version the new version
     * @return a copy of this notifier with the new version
     */
    public Notifier version(String version) {
        return new Notifier(name, version);
    }

    public Map<String, Object> asJson() {
        Map<String, Object> obj = new LinkedHashMap<String, Object>();
        if (name != null) obj.put("name", name());
        if (version != null) obj.put("version", version());
        return obj;
    }
}
