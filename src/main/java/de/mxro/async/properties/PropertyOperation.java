package de.mxro.async.properties;

/**
 * <p>
 * An operation which changes a set of properties.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public interface PropertyOperation {

    /**
     * Performs this operation on a {@link PropertyData} collection.
     * 
     * @param data
     */
    public void perform(PropertyData data);

}
