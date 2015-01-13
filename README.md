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

```java
PropertyNode props = Properties.create(Properties.defaultFactory());

props.record(Properties.set("key", "value"));

System.out.println(props.retrieve("key").get());

props.stop().get();

```

### Rendering All Properties


```java
PropertyNode props = Properties.create(Properties.defaultFactory());

props.record(Properties.set("key", "value"));

Syso

props.stop().get();

```