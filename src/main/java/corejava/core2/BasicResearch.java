package corejava.core2;

/**
 * @author weiyinglei
 */

public class BasicResearch
{
    @SuppressWarnings("unused")
    public static void main(String... args)
    {
        float f = 1.0F;// float必须有后缀，没有后缀的是double
        double d = 2.0;
        System.out.println(Float.SIZE);// 32
        System.out.println(Double.SIZE);// 64
        System.out.println(Float.MAX_VALUE);// 3.4028235E38
        System.out.println(Float.MIN_VALUE);// 1.4E-45
        System.out.println(Double.MAX_VALUE);// 1.7976931348623157E308
        System.out.println(Double.MIN_VALUE);// 4.9E-324

        test(12.0 / 0);// The variable is infinite!
        test(-12.0 / 0);// The variable is infinite!
        test(0.0 / 0);// The variable is not a number!
        test(Math.sqrt(-1));// The variable is not a number!
    }

    public static void test(double dou)
    {
        if (Double.isNaN(dou))
        {
            System.out.println("The varible is not a number!");
        }
        else if (Double.isInfinite(dou))
        {
            System.out.println("The varible is infinite!");
        }
        else
            System.out.println("Good!");
    }
}