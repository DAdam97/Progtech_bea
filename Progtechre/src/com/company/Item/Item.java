package com.company.Item;

public abstract class Item {
    private static int ID = 0;

    public String getItemID(){ return "Item" + ID++; }

    public abstract int getItemValue();
}
