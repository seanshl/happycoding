package com.test.Utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.Exceptions.InvalidInputException;
import com.Utils.StringUtil;

public class StringUtilsTest {
    @Autowired
    private StringUtil stringUtil;
    
    @Before
    public void onInit() {
        this.stringUtil = new StringUtil();
    }
    
    @Test
    public void test() {
        try {
            assertEquals(stringUtil.toDecimalInteger("0"), 0);
            assertEquals(stringUtil.toDecimalInteger("10"), 2);
            assertEquals(stringUtil.toDecimalInteger("10101"),21);
        } catch (InvalidInputException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}