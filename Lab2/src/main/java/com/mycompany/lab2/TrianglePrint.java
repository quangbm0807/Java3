package com.mycompany.lab2;

import java.util.Scanner;

public class TrianglePrint {
    public static void main(String[] args) {
        System.out.println("Type any number: ");
        Scanner sc = new Scanner(System.in); 
         int n = sc.nextInt(); // Độ cao của tam giác
        
        for (int i = 1; i <= n; i++) {
            // In khoảng trắng
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }
            // In các ký tự sao
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print(k);
            }
            // Xuống dòng sau mỗi dòng
            System.out.println();
        }
    }
}