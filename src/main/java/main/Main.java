package main;

import exception.BadArgsException;
import imageprocessor.ImageCompressor;
import imageprocessor.ImageDecompressor;
import imageprocessor.ImageReader;
import imageprocessor.ImageWriter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            throw new BadArgsException();
        }
        String pathToInputFile = args[1];
        String pathToOutputFile = args[2];
        if (args[0].equals("zip")) {
            ImageWriter.writeImage(
                    ImageCompressor.zipImage(ImageReader.readImage(pathToInputFile)),
                    pathToOutputFile
            );
        }
        if (args[0].equals("unzip")) {
            ImageWriter.writeImage(
                    ImageDecompressor.unzipImage(ImageReader.readImage(pathToInputFile)),
                    pathToOutputFile
            );
        }
    }
}
