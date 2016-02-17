package com.shiyaoeating.spring.autowiring;

import org.springframework.beans.factory.annotation.Autowired;

public class Logger {
    @Autowired
    private ConsoleWriter consoleWriter;
    
    @Autowired
    private FileWriter fileWriter;
    
    public ConsoleWriter getConsoleWriter() {
        return consoleWriter;
    }
    
//    public void setConsoleWriter(ConsoleWriter consoleWriter) {
//        this.consoleWriter = consoleWriter;
//    }
    public FileWriter getFileWriter() {
        return fileWriter;
    }
    
//    public void setFileWriter(FileWriter fileWriter) {
//        this.fileWriter = fileWriter;
//    }
    public void writeFile(String text) {
        fileWriter.write(text);
    }
    public void writeConsole(String text) {
        consoleWriter.write(text); 
    }
}
