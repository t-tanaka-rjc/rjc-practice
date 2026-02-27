package mock.sample.controller;

import mock.sample.service.ServiceA;

public class ControllerA {
	private ServiceA serviceA = new ServiceA();
	
	public String getContent(Integer id) {
		String content = serviceA.getContentById(id);
		content = serviceA.editContent(content);
		return content;
	}
}
