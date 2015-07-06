package delight.async.properties.values;

/**
 * <p>
 * Marks a class for which instanceOf can be performed as an explicit operation.
 * <p>
 * Useful for environments such as GWT, which don't support isAssignableFrom
 * during runtime.
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
