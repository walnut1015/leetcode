package Other;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.charset.Charset;

/**
 * @author tanya
 * @date 2018/8/21 13:59
 */
public class MyReader {
    public static void main(String[] args){
        File file = new File("description.txt");
        try {
            FileReader fr = new FileReader(file);
            FileInputStream fis = new FileInputStream(file);
            char[] buffer = new char[64];
            byte[] bufferBytes = new byte[1024];
            int len = 0;
            while (( len = fis.read(bufferBytes))>0){
                System.out.println(new String(bufferBytes, 0, len,"utf-8"));
            }

            while (fr.read(buffer)>0){
                String temp = new String(buffer);
                System.out.println(new String(temp.getBytes(),"utf-8"));
            }
            System.out.println(Charset.defaultCharset());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
