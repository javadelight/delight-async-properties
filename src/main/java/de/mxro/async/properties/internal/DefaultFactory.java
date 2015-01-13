package de.mxro.async.properties.internal;

import de.mxro.async.properties.PropertyFactory;
import de.mxro.async.properties.values.v01.ObjectValue;

public class DefaultFactory implements PropertyFactory {

    @SuppressWarnings("unchecked")
    @Override
    public <T> T create(final Class<T> type) {
        if (type.equals(ObjectValue.class)) {
            return (T) new ObjectValue();
        }

        throw new RuntimeException("Cannot instante property of type [" + type + "]");
    }

}
