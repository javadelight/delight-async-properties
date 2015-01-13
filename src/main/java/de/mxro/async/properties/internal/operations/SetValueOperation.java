package de.mxro.async.properties.internal.operations;

import de.mxro.async.properties.PropertyData;
import de.mxro.async.properties.operations.PropertyOperationWithId;
import de.mxro.async.properties.values.v01.ObjectValue;

public class SetValueOperation extends PropertyOperationWithId {

    private final Object value;

    @Override
    public void perform(final PropertyData data) {

        final ObjectValue valueProp = data.get(id, ObjectValue.class);

        valueProp.value = value;

    }

    public SetValueOperation(final Object value) {
        super();
        this.value = value;
    }

}
