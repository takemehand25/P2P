package com.takemehand.p2p;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: laiweidong
 * @date: 2021-01-26.
 */

@RestController
@RequestMapping("/router")
public class RouterController {

	@GetMapping("/getRouter")
	public List<DatagramPacket> getRouter(){
		List<DatagramPacket> list = new ArrayList<>();
		System.out.println("路由表"+Server.router);
		for (Map.Entry<String, DatagramPacket> entry : Server.router.entrySet()) {
			list.add(entry.getValue());
		}
		System.out.println(list);
		return list;
	}

	@GetMapping("/getMsgCenterSize")
	public int getMsgCenterSize(){
		System.out.println("getMsgCenterSize");
		return Server.router.size();
	}
}

/*
* List<RouterVO> list = new ArrayList<>();
		Map<String, SocketAddress> map = UdpServer.router;
		for (Map.Entry<String, SocketAddress> entry : map.entrySet()) {
			RouterVO routerVO = new RouterVO();
			routerVO.setUuid(entry.getKey());
			routerVO.setAddress(entry.getValue());
			list.add(routerVO);
		}
		return list;
* */
