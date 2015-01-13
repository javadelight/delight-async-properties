package de.mxro.async.properties;

import de.mxro.async.properties.internal.UnsafePropertyNode;

public class Properties {

    public static PropertyNode createUnsafe(final PropertyFactory factory) {
        return new UnsafePropertyNode(factory);
    }

}
