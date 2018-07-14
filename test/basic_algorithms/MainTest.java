package basic_algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void test1() {
        Main mainClass = new Main();
        int[][] locations = {{0,0,2,2},{0,2,0,2},{0,1,5,6},{1,6,0,5},{0,0,7,7},{0,3,0,3}};
        String str = "3     0 2 0 2     0 0 2 2     0 1 5 6     1 6 0 5  0 0 7 7     0 3 0 3";
        //mainClass.test(3,locations);
    }
}