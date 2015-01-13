package de.mxro.async.properties.operations;

import de.mxro.async.properties.PropertyData;
import de.mxro.async.properties.PropertyOperation;


public abstract class PropertyOperationWithId implements PropertyOperation {

    protected String id;

    @Override
    public abstract void perform(PropertyData data);

    public PropertyOperationWithId setId(final String id) {
        this.id = id;
        return this;
    }

}
