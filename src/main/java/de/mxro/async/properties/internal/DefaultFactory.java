package de.mxro.async.properties.internal;

import de.mxro.async.properties.PropertyFactory;
import de.mxro.async.properties.values.ObjectValue;
import de.mxro.async.properties.values.v01.ObjectValueData;

public class DefaultFactory implements PropertyFactory {

    @SuppressWarnings("unchecked")
    @Override
    public <T> T create(final Class<T> type) {

        if (type.equals(ObjectValueData.class)) {
            return (T) new ObjectValueData();
        }

        if (type.equals(ObjectValue.class)) {
            return (T) new ObjectValueData();
        }

        return null;
    }

}
