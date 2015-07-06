package delight.async.properties.internal.operations;

import delight.async.properties.PropertyData;
import delight.async.properties.operations.PropertyOperationWithId;

public class ClearOperation extends PropertyOperationWithId<Object> {

    @Override
    public Object perform(final PropertyData data) {
        final Object value = data.get(id);
        data.remove(id);

        return value;
    }

}
