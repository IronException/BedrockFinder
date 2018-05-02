# Bedrock finder

[![Build Status](http://jenkins.daporkchop.net/job/Minecraft/job/BedrockFinder/badge/icon)](http://jenkins.daporkchop.net/job/Minecraft/job/BedrockFinder)

A port of ChromeChrusher's bedrock pattern finder to Java, with a few optimizations, and a fancy GUI.

Also WIP support for OpenCL, and planned features include a texture rotation finder

### Dependency management

#### Maven

Add the repository:

```xml
<repository>
    <id>DaPorkchop_</id>
    <url>http://maven.daporkchop.net/</url>
</repository>
```

Dependency:

```xml
<dependency>
    <groupId>net.daporkchop</groupId>
    <artifactId>bedrock</artifactId>
    <version>0.0.1</version>
</dependency>
```

#### Gradle

Add the repository:

```groovy
maven { 
    url 'http://maven.daporkchop.net/'
}
```

Dependency:

```groovy
compile 'net.daporkchop:bedrock:0.0.1'
```