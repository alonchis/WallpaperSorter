package com.company;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // String filename = "E:\\dev\\imageCategorizer\\src\\com\\company\\sample.jpg";
        File folder = new File("E:\\dev\\imageCategorizer\\src\\input");
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> files = new ArrayList<>();

        for (int k = 0; k < listOfFiles.length; k++) {
            if (listOfFiles[k].isFile()) {
                files.add(listOfFiles[k].getName());
            }
        }
        for (File filename : listOfFiles) {
            try {


                BufferedImage bimg = ImageIO.read(filename);
                System.out.println("image added to buffer");

                int width = bimg.getWidth();
                int height = bimg.getHeight();
                String ratio = getRatio(width, height);


                System.out.println("image width: " + width + " and height of: " + height + "with a ratio of " + ratio);
                System.out.println();
                // new File("E:\\dev\\imageCategorizer\\src\\output").mkdir();
                new File("E:\\dev\\imageCategorizer\\src\\output\\" + ratio).mkdirs();

                //move the source image file to a folder called output
                File afile = filename;


                if (afile.renameTo(new File("E:\\dev\\imageCategorizer\\src\\output\\" + ratio + "\\" + afile.getName()))) {
                    System.out.println("file moved succesfully");
                } else
                    System.out.println("File failed to move. ");
            } catch(Exception e){
                System.out.println("the error is: " + e);
            }
        }

    }

    public static String getRatio(int width, int height){
        //example ratio = width / height = 1920 / 1080 = 1.7778
        // TODO: 3/7/2018 decide whether to use int or double? most output ended up in non traditional ratios
        float w = width,
                h = height;
        float ratio = w/h;

        if (ratio == 16.0/9.0)
            return "16by9";
        else if (ratio == 21.0/9.0)
            return "21by9";
        else
            return "non traditional ratios";

    }
}
