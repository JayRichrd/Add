package com.jy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 输入被加数
		Scanner scanner = new Scanner(System.in);
		System.out.print("输入被加数number1:");
		int number1 = scanner.nextInt();
		System.out.print("输入被加数number2:");
		int number2 = scanner.nextInt();

		System.out.println(number1 + "+" + number2 + "=" + add(number1, number2));

		// 关闭资源
		scanner.close();
	}

	/**
	 * 不适用加减乘除做加法
	 * 
	 * @param number1
	 *            被加数1
	 * @param number2
	 *            被加数2
	 * @return 返回相加的结果
	 */
	public static int add(int number1, int number2) {
		// 先定义两个中间数
		int sum;
		int carry;
		do {
			// 第一步：各位相加不进位
			// 这里使用异或运算来实现
			sum = number1 ^ number2;

			// 第二步：做进位
			// 这里用与运算和左移运算来实现
			carry = (number1 & number2) << 1;

			// 第三步：将上面的来个结果再遵循第一、二步的方式做加法
			// 直到不产生进位为止
			number1 = sum;
			number2 = carry;
		} while (number2 != 0);

		// 返回相加的结果
		return sum;
	}

}
