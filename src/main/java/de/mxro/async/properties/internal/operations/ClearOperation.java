package de.mxro.async.properties.internal.operations;

import de.mxro.async.properties.PropertyData;
import de.mxro.async.properties.operations.PropertyOperationWithId;

public class ClearOperation extends PropertyOperationWithId<Object> {

    @Override
    public Object perform(final PropertyData data) {
        final Object value = data.get(id);
        data.remove(id);

        return value;
    }

}
