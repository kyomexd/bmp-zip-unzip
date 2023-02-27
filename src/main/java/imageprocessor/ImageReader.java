package imageprocessor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageReader {

    public static byte[] readImage(String pathString) throws IOException {
        return Files.readAllBytes(Paths.get(pathString));
    }
}
