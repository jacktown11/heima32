package se.day03;

public class Fold {

	public static void main(String[] args) {
		double paperThick = 0.01;
		double mountainHeight = 8848;
		int foldCount = 0;

//		double foldHeight = paperThick;
//		while(foldHeight < mountainHeight) {
//			foldCount++;
//			foldHeight *= 2;
//		}
		
		foldCount =(int) Math.ceil(Math.log(mountainHeight/paperThick) / Math.log(2));
		
		System.out.println(foldCount);
	}

}
