package pkg.io.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamResearch
{
    public static void main(String[] args) throws IOException
    {
        byte[] bytes = new byte[1024];
        InputStream is = new FileInputStream("d:/1.txt");
        
        int count = is.read(bytes);
        System.out.println(count);
        System.out.println(new String(bytes,0,count));
        is.close();
    }
}
