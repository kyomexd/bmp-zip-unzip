package imageprocessor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageCompressor {

    public static byte[] zipImage(byte[] imageBytes) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte lastByte = imageBytes[0];
        int matchCount = 1;
        for (int i = 1; i < imageBytes.length; i++) {
            byte thisByte = imageBytes[i];
            if (lastByte == thisByte && matchCount < 127) {
                matchCount++;
            } else {
                baos.write((byte) matchCount);
                baos.write(lastByte);
                matchCount = 1;
                lastByte = thisByte;
            }
        }
        baos.write((byte) matchCount);
        baos.write(lastByte);
        baos.flush();
        return baos.toByteArray();
    }
}
