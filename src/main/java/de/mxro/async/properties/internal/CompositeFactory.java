package de.mxro.async.properties.internal;

import java.util.LinkedList;
import java.util.List;

import de.mxro.async.properties.PropertyFactory;

public class CompositeFactory implements PropertyFactory {

    private final List<PropertyFactory> factories;

    @Override
    public <T> T create(final Class<T> type) {

        throw new RuntimeException("Cannot instante property of type [" + type + "]");
    }

    public CompositeFactory() {
        super();
        this.factories = new LinkedList<PropertyFactory>();
    }

}
