package imageprocessor;

import java.io.ByteArrayOutputStream;

public class ImageDecompressor {

    public static byte[] unzipImage(byte[] imageBytes) {
        ByteArrayOutputStream decompressedImage = new ByteArrayOutputStream();
        for (int i = 0; i < imageBytes.length; i++) {
            int counter = imageBytes[i];
            if (counter > 0) {
                i++;
                for (int y = 0; y < counter; y++) {
                    decompressedImage.write(imageBytes[i]);
                }
            }
            if (counter < 0) {
                for (int y = counter; y < 0; y++) {
                    i++;
                    decompressedImage.write(imageBytes[i]);
                }
            }
        }
        return decompressedImage.toByteArray();
    }
}
