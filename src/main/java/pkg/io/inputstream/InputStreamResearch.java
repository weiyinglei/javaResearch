package pkg.io.inputstream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * Created by weiyinglei on 2016-11-3.
 */
public class InputStreamResearch {
    public static void main(String [] args) throws IOException{
        InputStream is = new ByteArrayInputStream("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".getBytes());
        int i = -1;
        while ((i = is.read()) != -1){
            System.out.print(i & 0xff);
            System.out.print(" ");
        }
    }
}
