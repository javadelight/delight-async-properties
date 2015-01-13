package de.mxro.async.properties;


/**
 * <p>
 * The internal data for a {@link PropertyNode}.
 * <p>
 * Should be accessed only by {@link PropertyOperation}s.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public interface PropertyData {

    public <T> T get(String id, Class<T> type);

    public Object get(String id);

}