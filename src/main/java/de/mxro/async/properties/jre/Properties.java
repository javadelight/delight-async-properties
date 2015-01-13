package de.mxro.async.properties.jre;

import de.mxro.async.properties.PropertiesCommon;
import de.mxro.async.properties.PropertyFactory;
import de.mxro.async.properties.PropertyNode;
import de.mxro.async.properties.internal.SynchronizedMetricsNode;
import de.mxro.concurrency.jre.ConcurrencyJre;
import de.mxro.concurrency.schedule.AccessThread;
import de.mxro.concurrency.schedule.BetterAccessThreadImplementation;
import de.mxro.promise.jre.Promises;

public class Properties extends PropertiesCommon {

    public static PropertyNode create(final PropertyFactory factory) {
        final AccessThread accessThread = new BetterAccessThreadImplementation(ConcurrencyJre.create());

        return new SynchronizedMetricsNode(createUnsafe(factory), accessThread, Promises.factory());

    }

}
