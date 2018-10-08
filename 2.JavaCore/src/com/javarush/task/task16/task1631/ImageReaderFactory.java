package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

import static com.javarush.task.task16.task1631.common.ImageTypes.*;

public class ImageReaderFactory {
    private static ImageReader imageReader;

    public static ImageReader getImageReader(ImageTypes type) throws IllegalAccessException {

        try {
            switch (type) {
                case BMP:
                    imageReader = new BmpReader();
                    break;
                case JPG:
                    imageReader = new JpgReader();
                    break;
                case PNG:
                    imageReader = new PngReader();
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } finally {
            if (imageReader == null) throw new IllegalAccessException("I havent this class");
        }

        return imageReader;
    }
}
