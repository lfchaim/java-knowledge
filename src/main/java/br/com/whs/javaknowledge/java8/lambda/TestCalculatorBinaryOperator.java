package br.com.whs.javaknowledge.java8.lambda;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class TestCalculatorBinaryOperator {

	public Double process(double num1, double num2, BiFunction biFunc) {
		return (Double) biFunc.apply(num1, num2);
	}

	public static void main(String[] args) {
		TestCalculatorBinaryOperator hlbf = new TestCalculatorBinaryOperator();

		BinaryOperator<Double> add = (x, y) -> x + y;
		System.out.println("Addition: " + hlbf.process(4, 5, add));

		BinaryOperator<Double> subtract = (x, y) -> x - y;
		System.out.println("Subtraction: " + hlbf.process(4, 5, subtract));

		BinaryOperator<Double> multiply = (x, y) -> x / y;
		System.out.println("Multiplication: " + hlbf.process(4, 5, multiply));

		BinaryOperator<Double> division = (x, y) -> x / y;
		System.out.println("Division: " + hlbf.process(4, 5, division));
	}

}