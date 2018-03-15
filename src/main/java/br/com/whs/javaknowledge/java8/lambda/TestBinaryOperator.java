package br.com.whs.javaknowledge.java8.lambda;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class TestBinaryOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(max(7,19));
		System.out.println(min(2003,1963));
	}

	private static int max( int a, int b) {
		BinaryOperator<Integer> bo = BinaryOperator.maxBy(Comparator.naturalOrder());
		return bo.apply(a,b);
	}
	
	private static int min( int a, int b) {
		BinaryOperator<Integer> bo = BinaryOperator.maxBy(Comparator.reverseOrder());
		return bo.apply(a,b);
	}
}
