import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FirstTest {
    public Timer mockTimer;
    private static double EPSILON = 0.0001;

    @BeforeEach
    public void initialize(){
        mockTimer = new Timer(0);
    }

    @Test
    public void shouldBe__1d2hs0m23_04sec(){
        mockTimer.stop(93623040);
        //System.out.println(mockTimer);
        assertEquals(93623040, mockTimer.getResult());
        assertEquals(1, mockTimer.getDays());
        assertEquals(2, mockTimer.getHours());
        assertEquals(0, mockTimer.getMinutes());
        assertEquals(23.04,mockTimer.getSeconds(),EPSILON);
    }

    @Test
    public void shouldBe__0(){
        mockTimer.stop(0);
        //System.out.println(mockTimer);
        assertEquals(0, mockTimer.getResult());
        assertEquals(0, mockTimer.getDays());
        assertEquals(0, mockTimer.getHours());
        assertEquals(0, mockTimer.getMinutes());
        assertEquals(0, mockTimer.getSeconds());

        Timer t = new Timer();
        t.stop();
        //System.out.println(mockTimer);
        assertEquals(0, t.getResult());
        assertEquals(0, t.getDays());
        assertEquals(0, t.getHours());
        assertEquals(0, t.getMinutes());
        assertEquals(0, t.getSeconds());
    }

    @Test
    void shouldThrowExcep() {
        Timer t = new Timer();

        assertThrows(RuntimeException.class,
                () -> {
                    t.stop(3);
                });
    }

    @Test
    void shouldThrowExcepMesage() {
        Timer t = new Timer();

        Throwable except= assertThrows(RuntimeException.class,
                () -> {
                    t.stop(3);
                });

        assertEquals("Bad end", except.getMessage());
    }
}
