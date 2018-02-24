import io.github.cemasma.captchag.RandomCharacterGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterGeneratorTest {

    @Test
    public void generateTest() {
        RandomCharacterGenerator randomCharacterGenerator = new RandomCharacterGenerator();
        String[] characters = randomCharacterGenerator.generateCharacters(5);

        assertEquals(5, characters.length);

        for(String c : characters) {
            System.out.print(c);
        }
    }
}
