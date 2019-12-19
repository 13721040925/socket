package cn.client;

public class Heartbeat implements Runnable{
	private byte[] bt;

	public Heartbeat() {
	}

	public Heartbeat(byte[] b) {
		this.bt = b;
	}

	@Override
	public void run() {
		int year1 = (int)bt[3]; 
		int year2 = (int)bt[4]; 
		String year = Integer.toString(year1)+Integer.toString(year2);
		
		int month1 = (int)bt[5];
		int month2 = (int)bt[6];
		String month = Integer.toString(month1)+Integer.toString(month2);
		
		int day1 = (int)bt[7];
		int day2 = (int)bt[8];
		String day = Integer.toString(day1)+Integer.toString(day2);
		
		int time1 = (int)bt[9];
		int time2 = (int)bt[10];
		String time = Integer.toString(time1)+Integer.toString(time2);
		
		int branch1 = (int)bt[11];
		int branch2 = (int)bt[12];
		String branch = Integer.toString(branch1)+Integer.toString(branch2);
		
		int second1 = (int)bt[13];
		int second2 = (int)bt[14];
		String second = Integer.toString(second1)+Integer.toString(second2);
		
		System.out.println(year+"年"+month+"月"+day+"日"+time+"时"+branch+"分"+second+"秒");
	}

}
