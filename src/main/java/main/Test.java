package main;

import imageprocessor.ImageCompressor;
import imageprocessor.ImageDecompressor;
import imageprocessor.ImageReader;
import imageprocessor.ImageWriter;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        ImageWriter.writeCompressedImage(
                ImageCompressor.zipImage(ImageReader.readImage("C:\\Users\\Pc\\Downloads\\venus.bmp")),
                "C:\\Users\\Pc\\Downloads\\venus2.rle");
        ImageWriter.writeCompressedImage(
                ImageDecompressor.unzipImage(ImageReader.readCompressedImage("C:\\Users\\Pc\\Downloads\\venus2.rle")),
                "C:\\Users\\Pc\\Downloads\\venus2.bmp");
//        showBytes();
    }

    public static void showBytes() throws IOException {
        byte[] readBytes = ImageReader.readImage("C:\\Users\\Pc\\Downloads\\poland.bmp");
//        byte[] readBytes = new byte[128];
//        for (int i = 0; i < readBytes.length; i += 4) {
//            readBytes[i] = 1;
//            readBytes[i+1] = 1;
//            readBytes[i+2] = 1;
//            readBytes[i+3] = 1;
//        }
        for (byte b : readBytes) {
            System.out.printf(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0') + " ");
        }
        System.out.println();
        byte[] compressedBytes = ImageCompressor.zipImage(readBytes);
        for (byte b : compressedBytes) {
            System.out.printf(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0') + " ");
        }
        System.out.println();
        byte[] decompressedBytes = ImageDecompressor.unzipImage(compressedBytes);
        for (byte b : decompressedBytes) {
            System.out.printf(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0') + " ");
        }
    }
}
