import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameTest {


    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void canRoll(){
        game.roll(0);
    }


    private void rollMany(int frames, int pins) {
        for(int i = 0; i < frames; i++) {
            game.roll(pins);
        }
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollStrike() {
        game.roll(10);
    }

    @Test
    public void gutterGame(){
        rollMany(20, 0);
        assertThat(game.getScore(), is(0));
    }

    @Test
    public void allOnes(){
        rollMany(20, 1);
        assertThat(game.getScore(), is(20));
    }


    @Test
    public void oneSpare(){
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertThat(game.getScore(), is(16));
    }

    @Test
    public void oneStrike(){
        rollStrike();
        game.roll(5);
        game.roll(3);
        assertThat(game.getScore(), is(26));
    }

    @Test
    public void perfectGame(){
        rollMany(10, 10);
        game.roll(10);
        game.roll(10);
        assertThat(game.getScore(), is(300));
    }

}
