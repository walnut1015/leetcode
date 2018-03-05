package Other;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Tanya on 2017/9/18.
 */
public class LoadClassTest {

    @Test
    public void testLoad() throws Exception {
        LoadClass l = new LoadClass();
        l.load();
        System.out.println(LoadClassTest.class.getResource("").getPath());

        System.out.println(LoadClassTest.class.getResource("/").getPath());
        File f = new File("/");
        System.out.println(f.getAbsolutePath());
        f.delete();
    }
}