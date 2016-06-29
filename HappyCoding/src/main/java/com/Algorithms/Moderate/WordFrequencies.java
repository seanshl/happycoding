package com.Algorithms.Moderate;

/**
 * Design a method to find the frequency of occurences of any given word in a book.
 * What if were running thi s algo multiple times?
 * @author liushiyao
 *
 */
public class WordFrequencies {
    public class testclass {
        
    }
    private String answer;
    
    private String thought;
    
    public String getThought() {
        String thought = 
                "。。。无语中";
        return thought;
    }
    
    public String getAnswer() {
        return "";
    }
    
    public int getFrequency(String[] book, String word) {
        if (book == null || book.length == 0 || word == null || "".equals("")) {
            return 0;
        }
        
        word = word.trim().toLowerCase();
        int count = 0;
        
        for (String w : book) {
            if (w.trim().toLowerCase().equals(word)) {
                count++;
            }
        }
        
        return count;
    }
}
