package com.company;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        String filename = "E:\\dev\\imageCategorizer\\src\\com\\company\\sample.jpg";


        try{
            BufferedImage bimg = ImageIO.read(new File(filename));
            System.out.println("image added to buffer");

            int width = bimg.getWidth();
            int height = bimg.getHeight();
            String ratio = getRatio(width,height);


            System.out.println("image width: " + width + " and height of: " + height + "with a ratio of " + ratio);
            System.out.println();
           // new File("E:\\dev\\imageCategorizer\\src\\output").mkdir();
            new File("E:\\dev\\imageCategorizer\\src\\output\\" + ratio).mkdirs();

            //move the source image file to a folder called output
            File afile = new File(filename);


            if(afile.renameTo(new File("E:\\dev\\imageCategorizer\\src\\output\\" + ratio + "\\" + afile.getName()))){
                System.out.println("file moved succesfully");
            }else
                System.out.println("File failed to move. ");
        } catch (Exception e){
            System.out.println("the error is: " + e);
        }

    }

    public static String getRatio(int w, int h){
        //example ratio = width / height = 1920 / 1080 = 1.7778
        float ratio = w/h;

        if (ratio == 16/9)
            return "16by9";
        else if (ratio == 21/9)
            return "21by9";
        else
            return "non traditional ratios";

    }
}
