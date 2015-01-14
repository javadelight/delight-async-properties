package de.mxro.async.properties;

import java.util.Arrays;

import de.mxro.async.properties.internal.CompositeFactory;
import de.mxro.async.properties.internal.DefaultFactory;
import de.mxro.async.properties.internal.UnsafePropertyNode;
import de.mxro.async.properties.internal.operations.ClearOperation;
import de.mxro.async.properties.internal.operations.SetValueOperation;
import de.mxro.factories.Configuration;
import de.mxro.factories.Dependencies;
import de.mxro.factories.Factory;

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
    public static PropertyOperation<Object> set(final String id, final Object value) {
        return new SetValueOperation(value, true).setId(id);
    }

    /**
     * Sets the specified property with to the provided value if the property
     * doesn't exist.
     * 
     * @param id
     * @param value
     * @return
     */
    public static PropertyOperation<Object> setIfNotExists(final String id, final Object value) {
        return new SetValueOperation(value, false).setId(id);
    }

    /**
     * Resets the property with the specified id.
     * 
     * @param id
     * @return
     */
    public static PropertyOperation<Object> remove(final String id) {
        return new ClearOperation().setId(id);
    }

    public static PropertyFactory defaultFactory() {
        return new DefaultFactory();
    }

    public static PropertyFactory compositeFactory(final PropertyFactory... factories) {
        return new CompositeFactory(Arrays.asList(factories));
    }

    public static Factory<?, ?, ?> createUnsafePropertiesFactory() {
        return new Factory<PropertyNode, Configuration, Dependencies>() {

            @Override
            public boolean canInstantiate(final Configuration conf) {

                return conf instanceof PropertiesConfiguration;
            }

            @Override
            public PropertyNode create(final Configuration conf, final Dependencies dependencies) {

                return PropertiesCommon.createUnsafe(defaultFactory());
            }

        };
    }

}
