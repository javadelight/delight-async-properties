# Async Properties

Async Properties is a Java library to store and retrieve properties in an asynchronous manner.

## Usage

### Storing Properties

Properties are set using the `record(operation)` method. Record operations are performed asynchronously. 

```java
PropertyNode props = Properties.create(Properties.defaultFactory());

props.record(Properties.set("key", "value"));

props.stop().get();

```

### Retrieving Properties

Properties can be retrieved using the `retrieve(key)` method. `retrieve(key)` returns a [Promise](http://modules.appjangle.com/java-promise/latest/apidocs/de/mxro/promise/Promise.html)
 which must be resolved using `.get()`.

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

### Maven Dependency

```xml
<dependency>
    <groupId>de.mxro.async.properties</groupId>
	<artifactId>async-properties</artifactId>
	<version>[latest version]</version>
</dependency>
```

Find latest version [here](http://modules.appjangle.com/async-properties/latest/project-summary.html).

Add repository if required:

```xml
<repositories>
	<repository>
		<id>Appjangle Releases</id>
		<url>http://maven.appjangle.com/appjangle/releases</url>
	</repository>
</repositories>
```

## Compatibility

This project is compatible with the following environments:

- Java 1.6+
- GWT 2.5.0+
- Android (any)
- OSGi (any)
