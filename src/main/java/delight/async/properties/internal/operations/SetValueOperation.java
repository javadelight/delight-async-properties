package delight.async.properties.internal.operations;

import delight.async.properties.PropertyData;
import delight.async.properties.operations.PropertyOperationWithId;
import delight.async.properties.values.v01.ObjectValueData;

public class SetValueOperation extends PropertyOperationWithId<Object> {

    private final Object value;
    private final boolean overwrite;

    @Override
    public Object perform(final PropertyData data) {

        if (!overwrite) {
            final Object inDb = data.get(id);
            if (inDb != null) {
                return inDb;
            }
        }

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
