package de.mxro.async.properties.examples;

import delight.async.properties.PropertyNode;
import delight.async.properties.jre.Properties;

public class StoreAndRetrieveProperty {

    public static void main(final String[] args) {

        final PropertyNode props = Properties.create(Properties.defaultFactory());

        props.record(Properties.set("key", "value"));

        System.out.println(props.retrieve("key").get());

        props.stop().get();

    }

}
