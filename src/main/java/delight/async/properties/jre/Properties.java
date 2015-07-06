package delight.async.properties.jre;

import delight.async.properties.PropertiesCommon;
import delight.async.properties.PropertiesConfiguration;
import delight.async.properties.PropertyFactory;
import delight.async.properties.PropertyNode;
import delight.async.properties.internal.SynchronizedPropertyNode;
import delight.concurrency.jre.ConcurrencyJre;
import delight.concurrency.schedule.AccessThread;
import delight.concurrency.schedule.BetterAccessThreadImplementation;
import delight.factories.Configuration;
import delight.factories.Dependencies;
import delight.factories.Factory;
import delight.promise.jre.Promises;

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

        return new SynchronizedPropertyNode(createUnsafe(factory), accessThread, Promises.createDirectFactory());

    }

    public static Factory<?, ?, ?> createPropertiesFactory() {
        return new Factory<PropertyNode, Configuration, Dependencies>() {

            @Override
            public boolean canInstantiate(final Configuration conf) {

                return conf instanceof PropertiesConfiguration;
            }

            @Override
            public PropertyNode create(final Configuration conf, final Dependencies dependencies) {

                return Properties.create(defaultFactory());
            }

        };
    }

}
