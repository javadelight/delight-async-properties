package de.mxro.async.properties.values;

/**
 * A simple value containing any object.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public interface ObjectValue {

    public Object value();

    public <T> T value(Class<T> ofType);

}