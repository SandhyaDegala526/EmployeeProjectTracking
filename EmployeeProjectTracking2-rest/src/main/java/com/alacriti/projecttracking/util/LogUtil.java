package com.alacriti.projecttracking.util;




public class LogUtil
{
 public static String getCurrentMethodName()
    {
        return Thread.currentThread().getStackTrace()[3].getMethodName();
    }

}