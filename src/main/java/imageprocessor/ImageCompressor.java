package imageprocessor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageCompressor {

    public static byte[] zipImage(byte[] imageBytes) throws IOException {
        ByteArrayOutputStream compressedImage = new ByteArrayOutputStream();
        ByteArrayOutputStream mismatchBuffer = new ByteArrayOutputStream(128);
        boolean isMatch = false;
        int matchCounter = 1;
        int mismatchCounter = 0;
        for (int i = 0; i < imageBytes.length - 1; i++) {
            byte thisByte = imageBytes[i];
            byte nextByte = imageBytes[i + 1];
            if (matchCounter == 127) {
                compressedImage.write(matchCounter);
                compressedImage.write(thisByte);
                matchCounter = 0;
            }
            if (mismatchCounter == -128) {
                compressedImage.write(mismatchCounter);
                compressedImage.write(mismatchBuffer.toByteArray());
                mismatchBuffer.reset();
                mismatchCounter = 0;
            }
            if (thisByte == nextByte) {
                if (!isMatch) {
                    compressedImage.write(mismatchCounter);
                    compressedImage.write(mismatchBuffer.toByteArray());
                    mismatchBuffer.reset();
                    mismatchCounter = 0;
                    isMatch = true;
                }
                matchCounter++;
                if (i + 1 == imageBytes.length - 1) {
                    compressedImage.write(matchCounter);
                    compressedImage.write(thisByte);
                }
            }
            if (thisByte != nextByte) {
                if (!isMatch) {
                    mismatchCounter--;
                    mismatchBuffer.write(thisByte);
                }
                if (isMatch) {
                    compressedImage.write(matchCounter);
                    compressedImage.write(thisByte);
                    matchCounter = 1;
                    isMatch = false;
                    if (i + 1 < imageBytes.length - 1) {
                        continue;
                    }
                }
                if (i + 1 == imageBytes.length - 1) {
                    mismatchCounter--;
                    mismatchBuffer.write(nextByte);
                    compressedImage.write(mismatchCounter);
                    compressedImage.write(mismatchBuffer.toByteArray());
                }
            }
        }
        return compressedImage.toByteArray();
    }
}
