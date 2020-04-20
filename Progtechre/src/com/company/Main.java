package com.company;

public class Main {

    public static void main(String[] args) {
        add(1);
        add(1,2);
        add(10,7,666);

    }

    public static void add(int ... nums){
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        System.out.println(sum);
    }
}
