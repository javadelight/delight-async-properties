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

    /**
     * <p>
     * Retrieve a property by id and type.
     * <p>
     * If no property with the specified type is defined, a new property of this
     * type is created.
     * <p>
     * If a property with a different type is already defined for the specified
     * id, an excpeiton is thrown.
     * 
     * @param id
     * @param type
     * @return
     */
    public <T> T get(String id, Class<T> type);

    /**
     * <p>
     * Retrieves the property at the specified id.
     * <p>
     * If no property with the specified id exists, returns <code>null</code>.
     * 
     * @param id
     * @return
     */
    public Object get(String id);

}