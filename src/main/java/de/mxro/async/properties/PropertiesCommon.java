package de.mxro.async.properties;

import java.util.Arrays;

import de.mxro.async.properties.internal.CompositeFactory;
import de.mxro.async.properties.internal.DefaultFactory;
import de.mxro.async.properties.internal.UnsafePropertyNode;
import de.mxro.async.properties.internal.operations.ClearOperation;
import de.mxro.async.properties.internal.operations.SetValueOperation;

public class PropertiesCommon {

    /**
     * <p>
     * Creates a properties node, which is not thread safe. Only use in
     * single-threaded applications or environments (such as GWT/JavaScript) or
     * when it can be assured that no concurrent access to this node will be
     * performed.
     * 
     * @param factory
     * @return
     */
    public static PropertyNode createUnsafe(final PropertyFactory factory) {
        return new UnsafePropertyNode(factory);
    }

    /**
     * Sets the specified property with to the provided value.
     * 
     * @param id
     * @param value
     * @return
     */
    public static PropertyOperation set(final String id, final Object value) {
        return new SetValueOperation(value).setId(id);
    }

    /**
     * Resets the property with the specified id.
     * 
     * @param id
     * @return
     */
    public static PropertyOperation remove(final String id) {
        return new ClearOperation().setId(id);
    }

    public static PropertyFactory defaultFactory() {
        return new DefaultFactory();
    }

    public static PropertyFactory compositeFactory(final PropertyFactory... factories) {
        return new CompositeFactory(Arrays.asList(factories));
    }

}
