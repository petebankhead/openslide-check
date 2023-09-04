# openslide-check

Minimal repo to check if OpenSide can be loaded from Java

## Usage

Add 3 files to check inside a `libs` folder.
For macOS, this would be:
```
libs/openslide.jar
libs/libopenslide.dylib
libs/libopenslide-jni.jnilib
```

For other platforms, the appropriate native libraries should be used.

To test with a different JDK (e.g. to compare aarch64 and x86_64), create a `gradle.properties` file with (for example)
```
org.gradle.java.home=/path/to/JDK/Contents/Home
```
