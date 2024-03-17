import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScrabbleTest {
    @Test
    void shouldAbleTOCreateInstanceOfScrabbleClass() {
        Scrabble scrabble = new Scrabble();

        assertTrue(scrabble instanceof Scrabble);
    }

    @Test
    void shouldAbleTOStartTeGame() throws EmptyStringException, OtherThanStringException {
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

    @Test
    void shouldAbleToThrowExceptionIfOtherThanStringFound(){
        Scrabble scrabble = new Scrabble();
        assertThrows(OtherThanStringException.class,()->{
            scrabble.perform("123raj");
        });
    }

    @Test
    void shouldAbleToPerformForTheMoreString() throws EmptyStringException, OtherThanStringException {
        Scrabble scrabble=new Scrabble();

        int actaul=scrabble.perform("Rahul Basutkar");
        assertEquals(22,actaul);

    }

    @Test
    void  shouldAbleToThrowExceptionIfMoreThanOneSpacesFoundInTheString(){

        Scrabble scrabble = new Scrabble();
        assertThrows(OtherThanStringException.class,()->{
            scrabble.perform("rahul   basutkar");
        });

    }

    @Test
    void  shouldAbleToThrowExceptionIfMoreThanOneSpacesFoundInEndTheString(){

        Scrabble scrabble = new Scrabble();
        assertThrows(OtherThanStringException.class,()->{
            scrabble.perform("rahul  basutkar    ");
        });

    }

}
