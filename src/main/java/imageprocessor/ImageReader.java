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
        BufferedImage bi = ImageIO.read(new File(pathString));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, "bmp", baos);
        baos.flush();
        return baos.toByteArray();
    }

    public static byte[] readCompressedImage(String pathString) throws IOException {
        return Files.readAllBytes(Paths.get(pathString));
    }
}
