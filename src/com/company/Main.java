package com.company;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.*;
import java.util.ArrayList;
/*todos
    add images directory source and target
    add a recursive option
    add a copy or move option
    figure out the error reading png image data
 */
public class Main {

    public static void main(String[] args) {

       // String filename = "E:\\dev\\imageCategorizer\\src\\com\\company\\sample.jpg";
        // TODO: 3/25/2018 make path as an arg 
        File folder = new File("E:\\Onedrive\\Pictures\\wallpapers\\");
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> files = new ArrayList<>();

        for(int k = 0; k < listOfFiles.length;k++){
            if(listOfFiles[k].isFile()){
                files.add(listOfFiles[k].getName());
            }
        }
        System.out.println("creating list of images");
        try{
            for (File filename: listOfFiles) {
                // TODO: 3/25/2018 move the try block into a function
                try {
                    BufferedImage bimg = ImageIO.read(filename);

                    System.out.println("image added to buffer");

                    int width = bimg.getWidth();
                    int height = bimg.getHeight();
                    String ratio = getRatio(width, height);


                    System.out.println("image width: " + width + " and height of: " + height + "with a ratio of " + ratio);
                    System.out.println();
                    // new File("E:\\dev\\imageCategorizer\\src\\output").mkdir();
                    // TODO: 3/25/2018 make path as another arg
                    new File("E:\\Onedrive\\Pictures\\" + ratio).mkdirs();

                    //move the source image file to a folder called output
                    File afile = filename;
                    if (!afile.isFile())
                        continue;

                    if (afile.renameTo(new File("E:\\Onedrive\\Pictures\\" + ratio + "\\" + afile.getName()))) {
                        System.out.println("file moved succesfully");
                    } else
                        System.out.println("File failed to move. ");
                } catch(Exception e) {
                    System.out.println("idk what happened");
                }
            }
        } catch (Exception e){
            System.out.println("the error is: " + e);
        }

    }

    public static String getRatio(int w, int h){
        // TODO: 3/26/2018 increase decimal digits to maybe 4 significant digits 
        //example ratio = width / height = 1920 / 1080 = 1.7778
        int ratio = w/h;

        if (ratio == 16/9)
            return "16by9";
        else if (ratio == 21/9)
            return "21by9";
        else if(ratio == 8/5 )
            return "8 by 5";
        else
            return "non traditional ratios";

    }
}
