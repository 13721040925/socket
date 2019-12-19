package cn.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReceiveThread implements Runnable{
	private Socket socket;// �׽��ֶ���
	private DataInputStream in;// ����������
	
	public ReceiveThread(Socket socket) {
		this.socket = socket;
	}
	

	@Override
	public void run() {
		try {
			//��ȡ���������͵�����
			in = new DataInputStream(socket.getInputStream());
			
			while(in != null) {
				byte[] bt = new byte[1024];
				in.read(bt);
				
				if(bt[0] == 0Xf7) {
					
					Judge judge = new Judge(bt);
					Thread th = new Thread(judge, "�ж�");
					th.start();
				}
				
				
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
