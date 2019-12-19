package cn.client;



public class Judge implements Runnable{

	private byte[] bt;

	public Judge() {
	}

	public Judge(byte[] b) {
		this.bt = b;
	}
	
	@Override
	public void run() {
		
		switch (bt[2]) {
			case 0x30: {
				Register register = new Register(bt);
				Thread th = new Thread(register, "×¢²á");
				th.start();
				break;
			}
			case 0x44: {
				Heartbeat heartbeat = new Heartbeat();
				Thread th = new Thread(heartbeat, "ĞÄÌø");
				th.start();
				break;
			}
		}
	}

}
