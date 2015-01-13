# Async Properties

Async Properties is a Java library to store and retrieve properties in an asynchronous manner.

## Usage

### Storing Properties

```java
PropertyNode props = Properties.create(Properties.defaultFactory());

props.record(Properties.set("key", "value"));

props.stop().get();

```

### Retrieving Properties

Properties can be retrieved using the `retrieve(key)` method. `retrieve(key)` returns a Promise which must be resolved using `.get()`.

```java
PropertyNode props = Properties.create(Properties.defaultFactory());

props.record(Properties.set("key", "value"));

System.out.println(props.retrieve("key").get());

props.stop().get();

```

### Rendering All Properties

Renders all properties in a human-readable JSON representation.

```java
PropertyNode props = Properties.create(Properties.defaultFactory());

props.record(Properties.set("key", "value"));

System.out.println(props.render().get());

props.stop().get();

```