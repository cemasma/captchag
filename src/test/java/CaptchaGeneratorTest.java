import io.github.cemasma.captchag.CaptchaGenerator;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class CaptchaGeneratorTest {


    @Test
    public void checkTest() {
        CaptchaGenerator captchaGenerator = new CaptchaGenerator(5);
        captchaGenerator.setCharacters(new String[]{"T", "E", "S", "4"});

        assertEquals(true, captchaGenerator.check("TES4"));
    }


    @Test
    public void backgroundTest() throws IOException {
        CaptchaGenerator captchaGenerator = new CaptchaGenerator(5);
        captchaGenerator.setTextColor(Color.BLUE);
        captchaGenerator.setBackgroundColor(Color.lightGray);

        captchaGenerator.drawRandomCharacters();
        captchaGenerator.save();

        ImageIO.write(captchaGenerator.getBufferedImage(), "png", new File("result.png"));
    }
}
