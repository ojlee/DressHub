package com.newoneplus.dresshub;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


//getBuffredImage시점에서 imageInputStream이 close됨
public class ImageProcesser {

    public BufferedImage getSmallImage(ImageInputStream imageInputStream) throws IOException {
        int smallXSize = 200;
        int smallYSize = 200;

        BufferedImage newImage = getSizedImage(imageInputStream, smallXSize, smallYSize);
        return newImage;

    }

    public BufferedImage getMediumImage(ImageInputStream imageInputStream) throws IOException {
        int mediumXSize = 500;
        int mediumYSize = 500;
        
        BufferedImage newImage = getSizedImage(imageInputStream, mediumXSize, mediumYSize);;
        return newImage;
    }

    public BufferedImage getOriginImage(ImageInputStream imageInputStream) throws IOException {
        BufferedImage image = ImageIO.read(imageInputStream);
        return image;
    }






    private BufferedImage getSizedImage(ImageInputStream imageInputStream, int X, int Y) throws IOException {
        BufferedImage image= ImageIO.read(imageInputStream);

        Image resizeImage = image.getScaledInstance(X, Y, Image.SCALE_SMOOTH);
        BufferedImage newImage = new BufferedImage(X, Y, BufferedImage.TYPE_INT_RGB);
        Graphics g = newImage.getGraphics();
        g.drawImage(resizeImage, 0, 0, null);
        g.dispose();
        return newImage;
    }


//            출처: http://jang8584.tistory.com/240 [개발자의 길]

}