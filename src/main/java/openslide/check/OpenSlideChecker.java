package openslide.check;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class to try loading OpenSlide native libraries, to help debug if it works.
 */
public class OpenSlideChecker {

    public static void main(String[] args) {

        if (args.length == 0) {
            // Try to load libraries in reverse order
            args = new String[]{"libs/libopenslide.dylib", "libs/libopenslide-jni.jnilib"};
        }

        for (String arg : args) {
            Path path = Paths.get(arg).toAbsolutePath();
            if (Files.isRegularFile(path)) {
                System.out.println("Attempting to load " + path);
                try {
                    System.load(path.toString());
                } catch (UnsatisfiedLinkError e) {
                    e.printStackTrace();
                }
            } else {
                System.err.println("File does not exist: " + path);
            }
        }

        // Try to load openslide.jar
        try {
            Class<?> cls = Class.forName("org.openslide.OpenSlide");
            Object version = cls.getMethod("getLibraryVersion").invoke(null);
            System.out.println("OpenSlide version: " + version);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
