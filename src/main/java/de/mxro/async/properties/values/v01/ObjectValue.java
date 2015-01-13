package de.mxro.async.properties.values.v01;

import java.io.Serializable;

public class ObjectValue implements Serializable {

    private static final long serialVersionUID = 1L;

    public Object value;

    public Object value() {
        return value;
    }

    public ObjectValue() {
        super();
    }

}
