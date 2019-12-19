package cn.client;

import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

//客户端多线程
public class ClientThread3 extends Thread {
	private Socket socket;// 与服务器端进行连接的套接字对象
	private DataOutputStream out;// 输入流对象，读取服务器的响应信息
	private DataOutputStream in;// 输出流对象，向服务器发送数据
	private String msg;// 从键盘输入流读取到的数据

	// 线程对象的构造方法
	public ClientThread3(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		while(true) {	
		   try {
				sleep(18*1000);
				out = new DataOutputStream(socket.getOutputStream());// 输出信息到服务器端
				
				 byte[] bt = { 0x7f, 0x0c, 0x43, 0x31, 0x30, 0x30, 0x30, 0x30, 0x30, 0x31,
				 0x5f, (byte) 0xa0, (byte) 0xf0,
				 (byte) 0xFF };// 心跳
				
				System.out.println(Integer.toHexString(bt[0]));
				out.write(bt);// 输出信息
				out.flush();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
