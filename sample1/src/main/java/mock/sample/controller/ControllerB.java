package mock.sample.controller;

import mock.sample.service.ServiceB;

public class ControllerB {

	private ServiceB serviceB = new ServiceB();
	
	public String getContent() {
		Integer id = serviceB.getId();
		
		Integer price = serviceB.getPrice(id);
		
		String ret = "id:" + id + "price:" + price;
		return ret;
	}
}
