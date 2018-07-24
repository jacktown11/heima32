package day27;

import java.util.Random;

public class Drawer implements Runnable{
	private final static int[] awards = {10,5,20,50,100,200,500,800,2,80,300};	
	private static int maxIndex = awards.length-1;
	private final static Object lock = new Object();
	
	public void run() {
		while(true) {
			
			// 这里设置为sleep是为了尽量不让一个抽奖箱一次性抽完所有奖项
			try {
				Thread.sleep(15);
			}catch(Exception e) {}
			
			synchronized(lock){		
				if(maxIndex>=0) {					
					int luckyPos = new Random().nextInt(maxIndex+1);
					int award = awards[luckyPos];
					
					// 已抽取的数字放到后边以避免被再次抽取
					awards[luckyPos] = awards[maxIndex];
					awards[maxIndex] = award;
					maxIndex--;
					
					System.out.println(Thread.currentThread().getName() + "又产生了一个"+award+"元大奖");
				}
			}
			if(maxIndex < 0) break;
		}	
	}

}
