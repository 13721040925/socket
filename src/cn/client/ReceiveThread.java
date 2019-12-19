package cn.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReceiveThread implements Runnable{
	private Socket socket;// 套接字对象
	private DataInputStream in;// 输入流对象
	
	public ReceiveThread(Socket socket) {
		this.socket = socket;
	}
	

	@Override
	public void run() {
		try {
			//读取服务器发送的数据
			in = new DataInputStream(socket.getInputStream());
			
			while(in != null) {
				byte[] bt = new byte[1024];
				in.read(bt);
				
				if(bt[0] == 0Xf7) {
					
					Judge judge = new Judge(bt);
					Thread th = new Thread(judge, "判断");
					th.start();
				}
				
				
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
