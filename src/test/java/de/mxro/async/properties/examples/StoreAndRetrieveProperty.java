package de.mxro.async.properties.examples;

import de.mxro.async.properties.PropertyNode;
import de.mxro.async.properties.jre.Properties;

public class StoreAndRetrieveProperty {

    public static void main(final String[] args) {

        final PropertyNode props = Properties.create(Properties.defaultFactory());

        props.record(Properties.set("key", "value"));

        System.out.println(props.retrieve("key").get());

        System.out.println(props.render().get());

        props.stop().get();

    }

}
