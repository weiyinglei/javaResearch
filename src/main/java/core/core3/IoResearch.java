package core.core3;
import java.util.Date;  
import java.util.Scanner;   

public class IoResearch
{

    static Scanner scanner = new Scanner(System.in);  
    public static void main(String[] args){   
          
        System.out.print("input your name:");  
        String name = scanner.next();//读入下一个单词，以空格作为标准  
        System.out.print("input your age:");  
        int age = scanner.nextInt();//读入下一个int，以空格作为标准  
        System.out.print("input your salary:");  
        double salary = scanner.nextDouble();  
        System.out.print("input detail:");  
        String detail = scanner.nextLine();//读入下一行，这里是读入上一次的回车  
        detail = scanner.nextLine();//读入下一行  
          
        //格式化输出  
        System.out.printf("Name:%s\n", name);  
        System.out.printf("Age:%d\tOct:%<o\tHex:%1$#x\n",age);//output:Age:20    Oct:24  Hex:0x14  
        System.out.printf("Salary:%#,8.2f\nDetail:",salary);  
        System.out.println(detail);  
          
        //时间输出  
        System.out.printf("Now:%tc\n",new Date());//output:星期三 一月 16 21:02:10 CST 2013  
        System.out.printf("%1$s %2$tY %2$tB %2$td\n", "Now:",new Date());//output:2013 一月 16  
        System.out.printf("%s %tY %<tB %<td\n", "Now:",new Date());//output：2013 一月 16  
          
        //使用静态的String.format方法常见一个格式化的字符串，而不打印输出  
        System.out.println(detail);  
        String message = String.format("Hello,%s! You will be %d next year", name, ++age);  
        System.out.print(message);  
    }  
}  
