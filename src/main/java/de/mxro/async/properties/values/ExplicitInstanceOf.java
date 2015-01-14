package de.mxro.async.properties.values;

/**
 * <p>
 * Marks a class for which instanceOf can be performed as an explicit operation.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public interface ExplicitInstanceOf {

    public boolean is(Class<?> type);

}
