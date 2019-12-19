package cn.client;

public class Register implements Runnable{

	private byte[] bt;

	public Register() {
	}

	public Register(byte[] b) {
		this.bt = b;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int a = (int)bt[3];
		Receive r = new Receive();
		r.setReceive(a);
	}

}
