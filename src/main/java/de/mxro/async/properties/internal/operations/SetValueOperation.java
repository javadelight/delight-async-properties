package de.mxro.async.properties.internal.operations;

import de.mxro.async.properties.PropertyData;
import de.mxro.async.properties.operations.PropertyOperationWithId;
import de.mxro.async.properties.values.v01.ObjectValueData;

public class SetValueOperation extends PropertyOperationWithId<Object> {

    private final Object value;
    private final boolean overwrite;

    @Override
    public Object perform(final PropertyData data) {

        final ObjectValueData valueProp = data.get(id, ObjectValueData.class);

        valueProp.value = value;

        return value;

    }

    public SetValueOperation(final Object value, final boolean overwrite) {
        super();
        this.value = value;
        this.overwrite = overwrite;

    }

}
