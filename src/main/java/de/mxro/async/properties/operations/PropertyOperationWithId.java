package de.mxro.async.properties.operations;

import de.mxro.async.properties.PropertyData;
import de.mxro.async.properties.PropertyOperation;

public abstract class PropertyOperationWithId<R> implements PropertyOperation<R> {

    protected String id;

    @Override
    public abstract R perform(PropertyData data);

    public PropertyOperationWithId<R> setId(final String id) {
        this.id = id;
        return this;
    }

}
