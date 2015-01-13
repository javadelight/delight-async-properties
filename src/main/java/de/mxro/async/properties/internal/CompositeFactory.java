package de.mxro.async.properties.internal;

import java.util.List;

import de.mxro.async.properties.PropertyFactory;

public class CompositeFactory implements PropertyFactory {

    private final List<PropertyFactory> factories;

    @Override
    public <T> T create(final Class<T> type) {

        for (final PropertyFactory factory : factories) {
            final T res = factory.create(type);

            if (res != null) {
                return res;
            }
        }

        throw new RuntimeException("Cannot instante property of type [" + type + "]");
    }

    public CompositeFactory(final List<PropertyFactory> factories) {
        super();
        this.factories = factories;
    }

}
