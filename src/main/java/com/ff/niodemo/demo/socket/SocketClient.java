package com.ff.niodemo.demo.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 
 * <ul>
 * <li>��Ŀ���ƣ�nioClientDemo </li>
 * <li>�����ƣ�  SocketClient </li>
 * <li>��������  ����һ��socket,��nio�ͷ��� </li>
 * <li>�����ˣ�jy </li>
 * <li>����ʱ�䣺2015��3��9�� </li>
 * <li>�޸ı�ע��</li>
 * </ul>
 */
public class SocketClient {

	static final String ADDR = "127.0.0.1";
	static final int PORT = 7777;

	
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket(ADDR, PORT);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String msg = reader.readLine();
			out.println(msg);
			out.flush();
			if (msg.equals("bye")) {
				break;
			}
			
			System.out.println(in.readLine());
		}
		socket.close();
	}
}
