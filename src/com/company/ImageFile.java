package com.company;

public class ImageFile {

    private String filename;
    int width;
    int height;


    public ImageFile(){
        filename = null;
    }

    public ImageFile(String file){

    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }



}


