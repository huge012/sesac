package InputOutputCalcSub;

import java.util.Scanner;

/*
 * 2021-12-21
 *
 * 입출력과 사칙연산 11. 곱셈
 *
 * https://www.acmicpc.net/problem/10430
 *
 * 괄호 주의
 */

public class sub11 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a*(b%10));
        System.out.println(a*((b%100)/10));
        System.out.println(a*(b/100));
        System.out.println(a*b);

    }

}