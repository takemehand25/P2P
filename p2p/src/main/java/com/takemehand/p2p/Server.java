package com.takemehand.p2p;

import java.net.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: laiweidong
 * @date: 2021-02-07.
 */
public class Server {
	public volatile static Map<String, SocketAddress> router = new HashMap<>();
	public static DatagramSocket server;

	public static void init() {
		// 初始化服务器
		try {
			server = new DatagramSocket(10000); // 监听10000端口
			System.out.println("初始化" + server);
		} catch (SocketException e) {
			System.err.println("初始化服务器异常");
			e.printStackTrace();
		}
		receive();
	}

	// 接收数据
	private static void receive(){
		DatagramPacket dp = new DatagramPacket(new byte[1024],1024);
		new Thread(()->{
			while (true){
				try {
					server.receive(dp);     // 接收数据
					// 从Packet中获取数据
					byte[] data = dp.getData();
					String msg = new String(data,0,dp.getLength(),"UTF-8");
					System.out.println("收到来自["+dp.getSocketAddress()+"]的消息内容是 : "+msg);
					// 存入
					router.put(msg,dp.getSocketAddress());

				}catch (Exception e){
					System.err.println("消息中心异常");
					continue;
				}
			}
		},"消息中心接收线程").start();
	}


}
