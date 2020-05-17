package com.wmz.xml;

public class SomeServiceImpl implements ISomeService {
	
	@Override
	public void doFirst() {
		// TODO Auto-generated method stub
		System.out.println("执行主业务逻辑doFirst()");

	}

	@Override
	public String doSecond() {
		// TODO Auto-generated method stub
		System.out.println("执行主业务逻辑doSecond()");
		return "abcde";

	}

	@Override
	public String doThird() {
		// TODO Auto-generated method stub
		System.out.println("执行主业务逻辑doThird()");
		return "fghij";
		
	}

	@Override
	public void doFourth() {
		// TODO Auto-generated method stub
		System.out.println("执行主业务逻辑doFourth()");
	}

}
