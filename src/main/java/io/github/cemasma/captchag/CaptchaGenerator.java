package io.github.cemasma.captchag;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CaptchaGenerator {

    private Integer characterSize;

    private BufferedImage bufferedImage;
    private Graphics2D graphics2D;

    private Random random;

    public CaptchaGenerator(Integer characterSize) {
        this.characterSize = characterSize;

        graphics2D = bufferedImage.createGraphics();
        graphics2D.setBackground(Color.WHITE);

        random = new Random();
    }



    public Integer getCharacterSize() {
        return characterSize;
    }

    public void setCharacterSize(Integer characterSize) {
        this.characterSize = characterSize;
    }
}
