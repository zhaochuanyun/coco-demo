package com.coco.demo.io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class URLTest {

    public static void main(String[] args) throws Exception {
        BufferedImage sourceImg = ImageIO.read(new URL("https://shenma-ev-oss.shenmajr.com/20190618/1000000000000000000000000001/2555e60499b94dd8ba63ff5405f0e8f3.jpg").openStream());
        System.out.println(sourceImg.getHeight());
    }

}
