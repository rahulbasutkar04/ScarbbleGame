import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScrabbleTest {
    @Test
    void shouldAbleTOCreateInstanceOfScrabbleClass() {
        Scrabble scrabble = new Scrabble();

        assertTrue(scrabble instanceof Scrabble);
    }

    @Test
    void shouldAbleTOStartTeGame() {
        Scrabble scrabble = new Scrabble();
        int actual = scrabble.perform("RAHUL");
        assertEquals(8, actual);
    }

}
