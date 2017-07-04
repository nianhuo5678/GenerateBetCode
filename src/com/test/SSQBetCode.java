package com.test;

import java.util.Random;

public class SSQBetCode {

	//一行投注中的红球
	private int[] redBalls;
	
	//一行投注中的蓝球
	private int[] blueBalls;
	
	//红球个数
	private int redNum;
	
	//蓝球个数
	private int blueNum;
	
	private Random random;
	
	SSQBetCode ssqBetCode = null;

	
	public int getRedNum() {
		return redNum;
	}


	public int getBlueNum() {
		return blueNum;
	}


	public int[] getRedBalls() {
		return redBalls;
	}


	public int[] getBlueBalls() {
		return blueBalls;
	}


	public SSQBetCode() {
		random = new Random();
		redBalls = new int[16];
		blueBalls = new int[16];
	}
	
	
	private void genRedBalls(int redNum) {
		for(int i = 0; i < redNum; i++) {
			redBalls[i] = random.nextInt(33) + 1;
		}
	}
	
	private void genBlueBalls(int blueNum) {
		for(int i = 0; i < blueNum; i++) {
			blueBalls[i] = random.nextInt(16) + 1;
		}
	}
	
	public void genSSQBetCode() {
		//红球个数[6,10)
		redNum = random.nextInt(5) + 6;
		//蓝球个数[1,8)
		blueNum = random.nextInt(7) + 1;
		genRedBalls(redNum);
		genBlueBalls(blueNum);
	}
}
