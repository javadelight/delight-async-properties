package de.mxro.async.properties.jre;

import de.mxro.async.properties.PropertiesCommon;
import de.mxro.async.properties.PropertyFactory;
import de.mxro.async.properties.PropertyNode;
import de.mxro.async.properties.internal.SynchronizedPropertyNode;
import de.mxro.concurrency.jre.ConcurrencyJre;
import de.mxro.concurrency.schedule.AccessThread;
import de.mxro.concurrency.schedule.BetterAccessThreadImplementation;
import de.mxro.factories.Dependencies;
import de.mxro.factories.Factory;
import de.mxro.promise.jre.Promises;

/**
 * <p>
 * Collection of key operations for this library.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public class Properties extends PropertiesCommon {

    /**
     * Creates a new thread-safe {@link PropertyNode}.
     * 
     * @param factory
     * @return
     */
    public static PropertyNode create(final PropertyFactory factory) {
        final AccessThread accessThread = new BetterAccessThreadImplementation(ConcurrencyJre.create());

        return new SynchronizedPropertyNode(createUnsafe(factory), accessThread, Promises.factory());

    }

    public static Factory<?, ?, ?> createPropertiesFactory() {
        return new Factory<PropertyNode, Configuration, Dependencies>() {

        };
    }

}
