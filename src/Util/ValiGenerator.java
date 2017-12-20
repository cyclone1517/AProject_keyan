package Util;

import java.util.Random;

public class ValiGenerator {
	//生成邮箱验证码
	public static String getRandom(int numOfBit) {
		String vcode = "";
		Random rand = new Random();
		for(int i=0;i<numOfBit;i++){
			switch(rand.nextInt(3)){
			case 0:
				vcode += (char)('0' + rand.nextInt(10));
				break;
			case 1:
				vcode += (char)('a' + rand.nextInt(26));
				break;
			case 2:
				vcode += (char)('A' + rand.nextInt(26));
				break;
			}
		}
		//System.out.println(vcode);
		return vcode;
	}
}
