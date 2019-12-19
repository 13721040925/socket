package cn.client;

import java.net.Socket;

public class Client1 {
	private Socket socket = null;

	public Client1() {
		try {
			socket = new Socket("127.0.0.1", 9999);// 111.67.198.168
			Thread th = new ClientThread(socket);
			th.start();

			// Thread th2 = new ClientThread2(socket);
			// Thread th3 = new ClientThread3(socket);
			// th.start();// 子线程监听键盘输入内容
			// th2.start();//报警
			// th3.start();//心跳
			// //Thread.sleep(1000 * 60);
			// // 主线程监听返回数据
			// ReceiveThread receiveThread = new ReceiveThread(socket);
			// Thread th1 = new Thread(receiveThread);
			// th1.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Client1();
	}

}
