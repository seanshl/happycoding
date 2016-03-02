package com.Algorithms.BitManipulation;

/**
 * Given a real number between 0 and 1 , that is passed in as
 * a double, print the binary representation. if the number cannot
 * be represented accurately in binary with at most 32 chars, print Error';
 * @author liushiyao
 *
 */
public class BinaryToString {
    private StringBuffer buffer = new StringBuffer();
    private int count = 0;
    private final String ERROR = "ERROR";
    
    public String toString(double x) {
        convert(x);
        String res = buffer.toString();
        if(!res.equals(ERROR)) {
            StringBuffer resBuffer = new StringBuffer();
            resBuffer.append("0.");
            resBuffer.append(res.toString());
            return resBuffer.toString();
        } else {
            return res;
        }
    }
    
    private void convert(double x) {
        if (count >= 32) {
            buffer = new StringBuffer();
            buffer.append(ERROR);
        }
        
        if (x == 0) {
            return;
        }
        
        buffer.append(getBinary(x));
        count ++;
        convert(2*x >= 1? 2*x - 1 : 2*x);
    }
    
    private int getBinary(double x) {
        return 2 * x >= 1? 1:0;
    }
    
    public static void main(String []args) {
        BinaryToString test = new BinaryToString();
        System.out.println(test.toString(0.125));
    }
    
}
