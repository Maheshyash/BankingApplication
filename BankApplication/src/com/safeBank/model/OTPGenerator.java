package com.safeBank.model;

import java.util.*;
public class OTPGenerator {
    public static String otp(){
    Random random=new Random();
    int  otp=random.nextInt(100000);
        System.out.println(otp);
        String otp1=otp+"";
        return otp1;
    }
}
