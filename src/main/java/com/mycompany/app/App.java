package com.mycompany.app; 
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class App {
    public static void main(String[] args) throws IOException {

        if (args.length < 1) {
            System.out.println("Error: Please provide an image path as an argument.");
            return; 
        }

        String imagePath = args[0];
        File imageFile = new File(imagePath);

        BufferedImage image = ImageIO.read(imageFile);

        if (image == null) {
            System.out.println("Error: Could not load the image. Check the path and file format.");
            return;
        }

        System.out.println("Image loaded successfully!");
        System.out.println("Width: " + image.getWidth() + "px");
        System.out.println("Height: " + image.getHeight() + "px");

        int originalHeight = image.getHeight();
        int originalWidth = image.getWidth();

        int newWidth = 100; //100 beacuse of 100 characters
        int newHeight = (int) (((double)originalHeight / originalWidth) * newWidth * 0.5) ;

        BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = newImage.createGraphics();

        g2d.drawImage(image, 0, 0, newWidth, newHeight, null);

        System.out.println("Resized to: " + newImage.getWidth() + "x" + newImage.getHeight());

    }
}