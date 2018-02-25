package io.github.cemasma.captchag;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class CaptchaGenerator {

    private Integer characterSize;

    private BufferedImage bufferedImage;
    private Graphics2D graphics2D;

    private Integer width;
    private final Integer HEIGHT = 70;

    private RandomCharacterGenerator characterGenerator;
    private Random random;

    public CaptchaGenerator(Integer characterSize) {
        this.characterSize = characterSize;
        width = characterSize * 70;

        this.bufferedImage = new BufferedImage(width, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        graphics2D = bufferedImage.createGraphics();

        this.reset();

        characterGenerator = new RandomCharacterGenerator();
        random = characterGenerator.getRandom();
    }

    public void drawRandomCharacters() {
        String[] characters = characterGenerator.generateCharacters(characterSize);
        graphics2D.setFont(new Font("TimesRoman", Font.PLAIN, 48));

        for (int i = 0; i < characterSize; i++) {
            graphics2D.drawString(characters[i], ((i + 1) * random(48, 5)), 48 + random(5, 2));
        }
    }

    public void save(String path) {
        try {
            ImageIO.write(bufferedImage, "png", new File(path + "result.png"));
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reset() {
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, width, HEIGHT);
        graphics2D.setColor(Color.BLACK);
    }

    public int random(int max, int min) {
        return random.nextInt(min) + max;
    }

    public Integer getCharacterSize() {
        return characterSize;
    }

    public void setCharacterSize(Integer characterSize) {
        this.characterSize = characterSize;
    }
}
