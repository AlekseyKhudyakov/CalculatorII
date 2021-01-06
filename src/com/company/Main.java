package com.company;

import java.util.Scanner;


    public class Main {

        public static String intToRoman(int num) {
            StringBuilder sb = new StringBuilder();
            int times = 0;
            String[] romans = new String[] { "I", "IV", "V", "IX", "X", "XL", "L",
                    "XC", "C", "CD", "D", "CM", "M" };
            int[] ints = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500,
                    900, 1000 };
            for (int i = ints.length - 1; i >= 0; i--) {
                times = num / ints[i];
                num %= ints[i];
                while (times > 0) {
                    sb.append(romans[i]);
                    times--;
                }
            }
            return sb.toString();
        }

        private static int decodeSingle(char letter) {
            switch (letter) {
                case 'M':
                    return 1000;
                case 'D':
                    return 500;
                case 'C':
                    return 100;
                case 'L':
                    return 50;
                case 'X':
                    return 10;
                case 'V':
                    return 5;
                case 'I':
                    return 1;
                default:
                    return 0;
            }
        }

        public static int decode(String roman) {
            int result = 0;
            String uRoman = roman.toUpperCase(); //case-insensitive
            for (int i = 0; i < uRoman.length() - 1; i++) {//loop over all but the last character
                if (decodeSingle(uRoman.charAt(i)) < decodeSingle(uRoman.charAt(i + 1))) {
                    result -= decodeSingle(uRoman.charAt(i));
                } else {
                    result += decodeSingle(uRoman.charAt(i));
                }
            }
            result += decodeSingle(uRoman.charAt(uRoman.length() - 1));
            return result;
        }





        public static void main(String[] args) {
            System.out.println("Введите арифметическую операцию строкой:");
            Scanner sc = new Scanner(System.in);
            String[] romans = new String[] { "I", "IV", "V", "IX", "X", "XL", "L","XC", "C", "CD", "D", "CM", "M" };
            String[] arabic = new String[] { "0", "1", "2", "3", "4", "5", "6","7", "8", "9", "10" };
           /* int[] arabic = new int[] { 0, 1, 2, 3, 4, 5, 6,7, 8, 8, 9,10 };*/
                int a = 0;
                int b = 0;
                int flag =0;
                String op = "";

                do {
                    String input = sc.next();
                    if (input.equals("exit")) {
                        break;
                    }
                    String[] strings = input.split("[+-/*]");


                    String[] operator = input.split("\\w");

                    try {


                        for (int x = 0; x < 13; x = x + 1) {
                            if (input.contains(romans[x])) {

                                flag = 1;
                                break;
                            } else {

                            flag = 2;}

                        }
                        if (flag==1)
                            {
                                a = decode(strings[0]);
                                b = decode(strings[1]);
                            }
                        else
                            {
                                a = Integer.parseInt(strings[0]);
                                b = Integer.parseInt(strings[1]);
                            }

                        if (a < 0 || a > 10 || b < 0 || b > 10) {
                            System.out.println("Неверные значения.");
                            continue;
                        }
                        op = operator[operator.length - 1];

                        if (op.contains("/")) {

                            if (flag==1) {
                                System.out.println(intToRoman(operation_del_rome(a, b, op)));
                            }
                            else {
                            System.out.println(operation_del(a, b, op));}
                        } else {

                            if (flag==1) {
                                System.out.println(intToRoman(operation(a, b, op)));
                            }
                            else {
                                System.out.println(operation(a, b, op));
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Ошибка. Попробуйте ещё раз.");
                    }

                } while (true);

        }

        private static double operation_del(int a, int b, String op) {

            if (b == 0) {
                System.out.println("Деление на 0 запрещено");
            }

            return(double)a / b;

        }
        private static int operation_del_rome(int a, int b, String op) {

            if (b == 0) {
                System.out.println("Деление на 0 запрещено");
            }

            return a / b;

        }

        private static int operation(int a, int b, String op) {



                switch (op) {
                    case "*":
                        return a * b;
                    case "+":
                        return a + b;
                    case "-":
                        return a - b;
                    default:
                        return 0;
            }
        }
    }



