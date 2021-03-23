# Magpie Plugin Starter
#### Base your Magpie plugins off this project for quick prototyping.

The Magpie Plugin Starter project is a set of minimal (empty) yet functional plugins packaged into a single Maven project.

This project is the easiest way to start developing your own plugins, just clone this and start coding.

### Layout
Within `/src/main/java/org.example.plugins` reside the plugin implementation along with their configuration
Classes.  Configuration classes are optional (see `SampleTerminalPlugin` on how to build a config-less
plugin).

Three types of plugins exist (Origin, Intermediate, and Terminal). See the README for [Magpie-API](https://github.com/openraven/magpie-api/)
on the role of each plugin type. 

### META-INF/services
Ensure that you update (and remove the unused) files in this folder. Magpie makes use of the [Java Service Loader](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ServiceLoader.html)
to dynamically pick up plugins at runtime.

### The Maven pom.xml
Basic plugin depenendies are included (both directly and transitively via the `magpie-api` dependency).  You've
already got SLF4J for logging and Jackson for JSON serialization.

This also sets up the fat/shaded output jar that is considered a best practice for plugin authors.

### Issues/suggestions
Please submit a bug or PR for any suggestions, issues, or questions.

