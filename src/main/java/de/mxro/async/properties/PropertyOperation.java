package de.mxro.async.properties;

/**
 * An operation which changes a set of properties.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public interface PropertyOperation {

    public void perform(PropertyData data);

}
