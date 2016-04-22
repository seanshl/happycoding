package com.beaverbay.prototype;

public abstract class Item {
    private int id;
    private String keywords;
    private enum Type {
        Description,
        Statement,
        PropertiesContained
    }
    private String content;
}
