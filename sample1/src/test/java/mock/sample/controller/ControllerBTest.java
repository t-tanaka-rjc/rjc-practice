package mock.sample.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import mock.sample.service.ServiceB;

@ExtendWith(MockitoExtension.class)
class ControllerBTest {

	@Spy
	private ServiceB serviceB;
	
	@InjectMocks
	private ControllerB controller = new ControllerB();
	
	@Test
	public void test_getContentA() {
		//モックを使用する
		//getPriceメソッドのみをモック化する
		doReturn(555).when(serviceB).getPrice((Integer)any());
		
		//期待している返り値
		String expected = "id:3price:555";
		//実際の返り値
		String actual = controller.getContent();
		
		//それぞれ呼び出している回数を比較
		verify(serviceB, times(1)).getId();
		verify(serviceB, times(1)).getPrice((Integer)any());
		
		//期待している返り値と実際の返り値を比較
		assertEquals(actual, expected);
	}

}
