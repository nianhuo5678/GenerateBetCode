package com.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileOperation {
	
	//一次投注的行数[1,5)
	int lines;
	String path = "E:\\testtools\\jmeter\\404\\apache-jmeter-3.1\\bin\\404\\betcode.csv";
	
	public FileOperation() {
		Random random = new Random();
		lines = random.nextInt(4) + 1;
	}


	public void writeFile(SSQBetCode ssqBetCode) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		StringBuilder sb = new StringBuilder();
		try {
			fw = new FileWriter(path,true);
			bw = new BufferedWriter(fw);
			for(int i = 0; i < lines; i++) {
				//生成一行投注号码
				ssqBetCode.genSSQBetCode();
				
				//写入红球
				for(int r = 0; r < ssqBetCode.getRedNum(); r++) {
					int redBall = ssqBetCode.getRedBalls()[r];
					//小于10补零
					if (redBall < 10) {
						sb.append("0");
					} 
					sb.append(redBall);
					//添加逗号分隔，除了之后一个。
					if( r != (ssqBetCode.getRedNum() - 1) ) {
						sb.append(",");
					}
				}
				
				//插入竖线分隔红球和蓝球
				sb.append("|");
				
				//写入蓝球
				for(int b = 0; b < ssqBetCode.getBlueNum(); b++) {
					int blueBall = ssqBetCode.getBlueBalls()[b];
					//小于10补零
					if (blueBall < 10) {
						sb.append("0");
					}
					sb.append(blueBall);
					//添加逗号分隔，除了之后一个。
					if( b != (ssqBetCode.getBlueNum() - 1) ) {
						sb.append(",");
					}
				}
				//插入分号分隔不同行
				sb.append(";");
			}
			//删除最后一个分号
			sb.deleteCharAt(sb.length() - 1);
			//插入回车
			sb.append("\n");
			bw.write(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//关闭
		try {
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
