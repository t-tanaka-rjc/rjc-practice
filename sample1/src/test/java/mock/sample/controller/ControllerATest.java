package mock.sample.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mock.sample.service.ServiceA;

@ExtendWith(MockitoExtension.class)
public class ControllerATest {

	@Mock
	private ServiceA serviceA;
	
	@InjectMocks
	private ControllerA controller = new ControllerA();
	
	@Test
	public void test_getContentA() {
		Integer id = 1;
		
		
		when(serviceA.getContentById(id)).thenReturn("Content");
		when(serviceA.editContent("Content")).thenReturn("EditedContent1");
		System.out.println("テスト");
		//期待している値
		String expected = "EditedContent1";
		//実際の返り値
		String actual = controller.getContent(id);
		
		//それぞれ呼び出している回数を比較
		verify(serviceA, times(1)).getContentById(id);
		verify(serviceA, times(1)).editContent("Content");
		
		//期待している返り値と実際の返り値を比較
		assertEquals(actual, expected);
	}

}
