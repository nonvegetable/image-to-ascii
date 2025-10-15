package com.mycompany.app; 

import java.awt.Graphics2D;
import java.awt.Color;
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

        String ramp = ".'^,:;Il!i><~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$";

        for(int y = 0; y < newHeight; y++){
            for(int x = 0; x < newWidth; x++){
                int pixelColor = newImage.getRGB(x, y);
                Color color = new Color(pixelColor);
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                double brightness = (double) 0.299 * red + 0.587 * green + 0.114 * blue;

                int mapping = (int) (brightness * (ramp.length() - 1) / 255);

                System.out.print(ramp.charAt(mapping));
            }

            System.out.println();
        }


    }
}