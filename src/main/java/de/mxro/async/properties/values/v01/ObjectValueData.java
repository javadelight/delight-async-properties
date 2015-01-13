package de.mxro.async.properties.values.v01;

import java.io.Serializable;

import de.mxro.async.properties.values.ObjectValue;

public class ObjectValueData implements Serializable, ObjectValue {

    private static final long serialVersionUID = 1L;

    public Object value;

    @Override
    public Object value() {
        return value;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T value(final Class<T> ofType) {
        return (T) value;
    }

    public ObjectValueData() {
        super();
    }

}
