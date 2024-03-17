import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScrabbleTest {
    @Test
    void shouldAbleTOCreateInstanceOfScrabbleClass(){
        Scrabble scrabble=new Scrabble();

        assertTrue(scrabble instanceof Scrabble);
    }


}
