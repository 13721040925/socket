package cn.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

//客户端多线程
public class ClientThread extends Thread {
	//private BufferedReader in;
	private Socket socket;// 与服务器端进行连接的套接字对象
	private DataOutputStream out;// 输入流对象，读取服务器的响应信息
	private DataInputStream in;// 输出流对象，向服务器发送数据

	// 线程对象的构造方法
	public ClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			in = new DataInputStream(socket.getInputStream());// 键盘接收的字符
			out = new DataOutputStream(socket.getOutputStream());
			// in = new BufferedReader(new InputStreamReader(socket.getInputStream(),
			// "utf-8"));
			byte[] bt = new byte[1024];
			StringBuilder sb = new StringBuilder();
			while (in != null) {

				in.read(bt);
				for(byte b:bt) {
					if(b!=0) {
						sb.append((char)b);
					}
				}
				System.out.println(sb.toString());
				// if (sb.toString().trim().equals("~20014745A006FFA101FC33")) {
				//
				// }
				if (sb.toString().trim().equals("~20014742E002FFFD09")) {
					byte[] bt1 = CommondName.xyModel();
					out.write(bt1);// 输出信息
					out.flush();
					sb = sb.delete(0, sb.length());
				} else if (sb.toString().trim().equals("~20014744E002FFFD07")) {
					byte[] bt1 = CommondName.xyWarn();
					out.write(bt1);// 输出信息
					out.flush();
					sb = sb.delete(0, sb.length());
				} else {
					System.out.println("进来了");
					byte[] bt1 = CommondName.xyRemote();
					out.write(bt1);// 输出信息
					out.flush();
					sb = sb.delete(0, sb.length());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
