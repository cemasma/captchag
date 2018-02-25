import io.github.cemasma.captchag.CaptchaGenerator;
import org.junit.Test;

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
}
