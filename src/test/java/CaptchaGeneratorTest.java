import io.github.cemasma.captchag.CaptchaGenerator;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class CaptchaGeneratorTest {

    @Test
    public void generateTest() {
        CaptchaGenerator captchaGenerator = new CaptchaGenerator(5);
        captchaGenerator.drawRandomCharacters();
        captchaGenerator.save("");

        assertEquals(Files.exists(Paths.get("")), true);
    }
}
