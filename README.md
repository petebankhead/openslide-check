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