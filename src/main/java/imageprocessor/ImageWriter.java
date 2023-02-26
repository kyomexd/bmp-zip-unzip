package imageprocessor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageWriter {

    public static void writeCompressedImage(byte[] imageBytes, String pathString) throws IOException {
        Path path = Paths.get(pathString);
        Files.write(path, imageBytes);
    }

    public static void writeImage(byte[] imageBytes, String pathString) throws IOException {
        InputStream is = new ByteArrayInputStream(imageBytes);
        BufferedImage img = ImageIO.read(is);
        ImageIO.write(img, "bmp", new File(pathString));
    }
}
