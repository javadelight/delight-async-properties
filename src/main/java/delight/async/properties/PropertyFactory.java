package delight.async.properties;

/**
 * <p>
 * A factory which allows instantiating property values by class.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public interface PropertyFactory {

    /**
     * Creates a property of the specified type.
     * 
     * @param type
     * @return
     */
    public <T> T create(String id, Class<T> type);

}