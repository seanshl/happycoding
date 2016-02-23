package com.Utils;

public class Util {
    public static boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0);
    }
    
    public static int setBit(int num, int i) {
        return (num | (1 << i));
    }
    
    public static int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }
}
