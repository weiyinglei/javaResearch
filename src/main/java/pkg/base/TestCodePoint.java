/*
 * File Name: TestCodePoint.java
 * Copyright: Copyright 2012-2016 CETC52 CETITI All Rights Reserved.

 * Description: 
 * Author: weiyinglei
 * Create Date: 2016年10月31日

 * Modifier: weiyinglei
 * Modify Date: 2016年10月31日
 * Bugzilla Id: 
 * Modify Content: 
 */
package pkg.base;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author weiyinglei
 * @version STOWZ V1.0.0, 2016年10月31日
 * @see
 * @since STOWZ V1.0.0
 */

public class TestCodePoint
{
    public static void main(String[] args)
    {
        char[] ch = Character.toChars(0x10400);  
        System.out.printf("U+10400 高代理字符: %04x\n", (int)ch[0]);//d801  
        System.out.printf("U+10400 低代理字符: %04x\n", (int)ch[1]);//dc00     
        String str = new String(ch);  
        System.out.println("代码单元长度: " + str.length());//2  
        System.out.println("代码点数量: " + str.codePointCount(0, str.length()));//1  
        System.out.println(str.codePointAt(0));//返回给定位置开始或结束的代码点,66560  
        System.out.println(str.charAt(1));//返回给定位置的代码单元,由于未定义，返回?  
          
        //遍历一个字符串,打印出所有字符的代码点  
        str += "Hello,world!";  
        int i = 0;  
        int cp = str.codePointAt(i);  
        while(i < str.length()){  
            System.out.println(str.codePointAt(i));  
            if(Character.isSupplementaryCodePoint(cp))  
                i += 2;//如果cp所在的位置是代码点的第一部分，执行此处  
            else i++;  
        }  
        /* 
         * 66560  
         * 72  
         * 108  
         * 111  
         * 119  
         * 114  
         * 100 
         */  
    }
}
