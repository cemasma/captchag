package io.github.cemasma.captchag;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CaptchaGenerator {

    private Integer characterSize;

    private BufferedImage bufferedImage;
    private Graphics2D graphics2D;
    private Integer imageSize;

    public CaptchaGenerator(Integer characterSize) {
        this.characterSize = characterSize;

        graphics2D = bufferedImage.createGraphics();

        imageSize = characterSize * 65;

        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, imageSize, 100);

        graphics2D.setColor(Color.BLACK);

    }

    public void drawRandomCharacters() {

    }

    public Integer getCharacterSize() {
        return characterSize;
    }

    public void setCharacterSize(Integer characterSize) {
        this.characterSize = characterSize;
    }
}
