import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScrabbleTest {
    @Test
    void shouldAbleTOCreateInstanceOfScrabbleClass() {
        Scrabble scrabble = new Scrabble();

        assertTrue(scrabble instanceof Scrabble);
    }

    @Test
    void shouldAbleTOStartTeGame() throws EmptyStringException {
        Scrabble scrabble = new Scrabble();
        int actual = scrabble.perform("RAHUL");
        assertEquals(8, actual);
    }

    @Test
    void shouldAbleToThrowExceptionIfInputISEmpty()
    {

        Scrabble scrabble = new Scrabble();
        assertThrows(EmptyStringException.class,()->{
           scrabble.perform("");
        });
    }

}
