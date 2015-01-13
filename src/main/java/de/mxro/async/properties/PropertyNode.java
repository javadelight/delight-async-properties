package de.mxro.async.properties;

import de.mxro.async.callbacks.ValueCallback;
import de.mxro.fn.Success;
import de.mxro.promise.Promise;

/**
 * <p>
 * Stores a set of properties by id.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public interface PropertyNode {

    /**
     * Records the specified operation for the affected properties.
     * 
     * @param op
     */
    public void record(PropertyOperation op);

    /**
     * Retrieves a property with a specified type and id.
     * 
     * @param id
     * @param type
     * @return
     */
    public <T> Promise<T> retrieve(String id, Class<T> type);

    /**
     * Retrieves a property with a specified type and id.
     * 
     * @param id
     * @param type
     * @param cb
     */
    public <T> void retrieve(String id, Class<T> type, ValueCallback<T> cb);

    /**
     * <p>
     * Retrieves a property with the specified id.
     * 
     * @param id
     * @return
     */
    public Promise<Object> retrieve(String id);

    /**
     * Retrieves a property with the specified id.
     * 
     * @param id
     * @param cb
     */
    public void retrieve(String id, ValueCallback<Object> cb);

    public Promise<Success> stop();

    public void stop(ValueCallback<Success> cb);

    /**
     * Prints all metrics to standard out.
     */
    public void print();

    /**
     * Returns a {@link String} representation of all properties.
     */
    public Promise<String> render();

    /**
     * Returns a {@link String} representation of all properties.
     */
    public void render(ValueCallback<String> cb);
}
