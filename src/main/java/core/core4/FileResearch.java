package core.core4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileResearch
{
    @SuppressWarnings("resource")
    public static void main(String[] args) throws FileNotFoundException {  
        Scanner in = new Scanner(new File("G:\\in.txt"));  
        PrintWriter pw = new PrintWriter(new File("G:\\file.txt"));  
        String name = "GinSmile";  
        pw.write(name);//把字符串添加到文件末尾  
        pw.append('w');//直接把字符添加到文件末尾  
        pw.println();//仅仅打印一个换行符  
        while(in.hasNext()){  
            String s = in.nextLine();  
            pw.println(s);  
        }  
          
        pw.println();  
        pw.printf("%x", 100);  
        pw.println();  
        char[] buf = {'a','b','c','d','e','f'};  
        pw.write(buf, 0, 4);//把字符数组的一部分添加到文件末尾  
          
        pw.close();  
    }  
}
