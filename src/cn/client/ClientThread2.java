package cn.client;

import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

//客户端多线程
public class ClientThread2 extends Thread {
	private Socket socket;// 与服务器端进行连接的套接字对象
	private DataOutputStream out;// 输入流对象，读取服务器的响应信息
	private DataOutputStream in;// 输出流对象，向服务器发送数据
	private String msg;// 从键盘输入流读取到的数据

	// 线程对象的构造方法
	public ClientThread2(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		while(true) {
			try {
				sleep(6*1000);
				
				out = new DataOutputStream(socket.getOutputStream());// 输出信息到服务器端
				byte[] bt = { (byte) 0x7f, (byte) 0x0a, (byte) 0x4b, (byte) 0x31, (byte)
			     0x30, (byte) 0x30, (byte) 0x30,
				(byte) 0x30, (byte) 0x34, (byte) 0x31, (byte) 0x31, (byte) 0x01, (byte) 0x2b
				};// 报警
				
				System.out.println(Integer.toHexString(bt[0]));
				out.write(bt);// 输出信息
				out.flush();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
