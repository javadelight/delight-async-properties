package delight.async.properties.internal;

import delight.async.properties.PropertyData;
import delight.async.properties.PropertyFactory;
import delight.async.properties.values.ExplicitInstanceOf;
import delight.async.properties.values.ObjectValue;
import delight.json.JSON;
import delight.json.JSONObject;
import delight.json.ToJSON;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public class PropertyDataImpl implements PropertyData, ToJSON {

    private final Map<String, Object> props;
    private final PropertyFactory factory;

    public void remove(final String id) {
        props.remove(id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(final String id, final Class<T> type) {
        final Object object = props.get(id);

        if (object == null) {
            final Object newEntry = factory.create(type);
            props.put(id, newEntry);
            return (T) newEntry;
        }

        if (object.getClass().equals(type)) {
            return (T) object;
        }

        if (object instanceof ExplicitInstanceOf) {
            final ExplicitInstanceOf value = (ExplicitInstanceOf) object;
            if (value.instanceOf(type)) {
                return (T) value;
            }

            if (value instanceof ObjectValue) {
                final ObjectValue objectValue = (ObjectValue) value;

                if (type.equals(objectValue.value().getClass())) {
                    return (T) objectValue;
                }

            }

        }

        throw new RuntimeException("Id " + id + " is assigned the incompatible property type [" + object.getClass()
                + "]. Expected: " + type);

    }

    public PropertyDataImpl(final PropertyFactory factory) {
        super();
        this.factory = factory;
        this.props = new HashMap<String, Object>();
    }

    @Override
    public Object get(final String id) {
        return props.get(id);
    }

    @Override
    public String toString() {
        return toJSON().render();
    }

    @Override
    public JSON toJSON() {
        final JSONObject o = JSON.create();

        for (final Entry<String, Object> e : props.entrySet()) {
            Object value;
            if (e.getValue() instanceof ToJSON) {
                value = ((ToJSON) e.getValue()).toJSON();
            } else {
                value = e.getValue();
            }
            o.add(e.getKey(), value);
        }
        return o;
    }

}
