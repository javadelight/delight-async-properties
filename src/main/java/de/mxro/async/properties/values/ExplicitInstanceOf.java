package de.mxro.async.properties.values;

/**
 * <p>
 * Marks a class for which instanceOf can be performed as an explicit operation.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public interface ExplicitInstanceOf {

    /**
     * <p>
     * Should return true if this object is assignable to the defined type.
     * 
     * @param type
     * @return
     */
    public boolean instanceOf(Class<?> type);

}
