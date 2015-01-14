package de.mxro.async.properties.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import de.mxro.async.properties.PropertyData;
import de.mxro.async.properties.PropertyFactory;
import de.mxro.async.properties.values.ObjectValue;
import de.mxro.async.properties.values.PropertyValue;
import de.mxro.json.HasJSON;
import de.mxro.json.JSON;
import de.mxro.json.JSONObject;

/**
 * 
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public class PropertyDataImpl implements PropertyData, HasJSON {

    private final Map<String, Object> props;
    private final PropertyFactory factory;

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

        if (object instanceof PropertyValue) {
            final PropertyValue value = (PropertyValue) object;
            if (value.is(type)) {
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
        return getJSON().render();
    }

    @Override
    public JSON getJSON() {
        final JSONObject o = JSON.create();

        for (final Entry<String, Object> e : props.entrySet()) {
            Object value;
            if (e.getValue() instanceof HasJSON) {
                value = ((HasJSON) e.getValue()).getJSON();
            } else {
                value = e.getValue();
            }
            o.add(e.getKey(), value);
        }
        return o;
    }

}
