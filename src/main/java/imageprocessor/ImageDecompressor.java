package imageprocessor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageDecompressor {

    public static byte[] unzipImage(byte[] imageBytes) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int matchCounter = imageBytes[0];
        int i = 1;
        while (i <= imageBytes.length - 1) {
            byte thisByte = imageBytes[i];
            for (int y = 0; y < matchCounter; y++) {
                baos.write(thisByte);
            }
            if (i == imageBytes.length - 1) {
                break;
            }
            i++;
            matchCounter = imageBytes[i];
            i++;
        }

        baos.flush();
        return baos.toByteArray();
    }
}
