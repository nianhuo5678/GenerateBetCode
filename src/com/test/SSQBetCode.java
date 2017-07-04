package com.test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import javax.security.auth.x500.X500Principal;

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
			int redBall = random.nextInt(33) + 1;
			while(ballExist(redBalls, redBall, redNum)) {
				redBall = random.nextInt(33) + 1;
			}
			redBalls[i] = redBall;
			
		}
	}
	
	private void genBlueBalls(int blueNum) {
		for(int i = 0; i < blueNum; i++) {
			int blueBall = random.nextInt(16) + 1;
			while(ballExist(blueBalls, blueBall, blueNum)) {
				blueBall = random.nextInt(16) + 1;
			}
			blueBalls[i] = blueBall;
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
	
	private boolean ballExist(int[] ballArray, int ball, int size) {
		boolean exist = false;
		for(int i = 0; i < size; i++) {
			if (ballArray[i] == ball) {
				exist = true;
				break;
			} else {
				exist = false;
			}
		}
		return exist;
	}
}
