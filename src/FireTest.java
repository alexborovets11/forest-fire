import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FireTest {
    @Test
    public void testTimeToBurnExample() {
        char[][] forest = {
            {'t','.','.','t','t','t','t','.','t'},
            {'.','.','t','t','.','.','.','.','t'},
            {'.','.','t','t','t','t','t','t','t'},
            {'t','t','t','t','.','.','.','.','.'}
        };

        int matchR = 2;
        int matchC = 6;

        int expected = 8;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testSingleTree() {
        char[][] forest = {
            {'t'}
        };
        assertEquals(0, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testSingleEmptySpace() {
        char[][] forest = {
            {'.'}
        };
        assertEquals(-1, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testDisconnectedTrees() {
        char[][] forest = {
            {'t', '.', 't'},
            {'.', '.', '.'},
            {'t', '.', 't'}
        };
        assertEquals(0, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testFullBlockOfTrees() {
        char[][] forest = {
            {'t', 't'},
            {'t', 't'}
        };
        assertEquals(2, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testFireStartsOnGround() {
        char[][] forest = {
            {'t', 't'},
            {'.', 't'}
        };
        assertEquals(-1, Fire.timeToBurn(forest, 1, 0));
    }

    @Test
    public void testEdgeSpread() {
        char[][] forest = {
            {'t', 't', 't', '.', '.'},
            {'.', '.', 't', '.', '.'},
            {'.', '.', 't', 't', 't'}
        };
        assertEquals(6, Fire.timeToBurn(forest, 0, 0));
    }
}
