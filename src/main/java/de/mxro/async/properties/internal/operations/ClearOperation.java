package de.mxro.async.properties.internal.operations;

import de.mxro.async.properties.PropertyData;
import de.mxro.async.properties.operations.PropertyOperationWithId;

public class ClearOperation extends PropertyOperationWithId {

    @Override
    public void perform(final PropertyData data) {
        data.remove(id);
    }

}
