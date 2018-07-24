package day27;

public class Entry implements Runnable{
	private static int nextId = 1;
	private static Object lock = new Object();
	private String name;
	private int entryCount = 0;
	
	public Entry(String name) {
		this.name = name;
	}
	
	public void run() {
		int idSave;
		while(true) {
			synchronized(lock) {
				idSave = nextId;
				if(nextId <= 100) {		
					nextId++;
				}else {
					break;
				}
			}
			System.out.println("编号为"+idSave+"的员工从"+name + 
					"入场！拿到的双色球号码是"+new Lottery());
			entryCount++;
		}

		System.out.println("从"+name+"进入的人数是："+entryCount);
	}
}
