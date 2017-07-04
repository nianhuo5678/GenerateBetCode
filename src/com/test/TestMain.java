package com.test;

public class TestMain {

	/*
	 * 使用时需要删除最后一行空行
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SSQBetCode ssqBetCode = new SSQBetCode();
		FileOperation fileOperation = new FileOperation();
		for(int i = 0; i < 50000; i++) {
			fileOperation.writeFile(ssqBetCode);
		}
		
	}
}
