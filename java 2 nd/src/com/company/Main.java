package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Type your name:");
        String name = s.nextLine();
        System.out.print("HI:"+name);
        s.next();
    }
}
