package mock.sample.service;

import java.util.HashMap;
import java.util.Map;

public class ServiceA {
	
	private Map<Integer, String> contents = new HashMap<Integer, String>();

	public ServiceA() {
		getContents();
	}
	
	private void getContents() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public String getContentById(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		String content;
		content = contents.get(id);
		return content;
	}

	public String editContent(String content) {
		// TODO 自動生成されたメソッド・スタブ
		String editContent = "Edited" + content;
		return editContent;
	}

}
