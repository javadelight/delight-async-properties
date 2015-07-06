package delight.async.properties;

/**
 * <p>
 * An operation which changes a set of properties.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public interface PropertyOperation<R> {

    /**
     * <p>
     * Performs this operation on a {@link PropertyData} collection.
     * 
     * @param data
     */
    public R perform(PropertyData data);

}
