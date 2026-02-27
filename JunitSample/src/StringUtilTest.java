import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringUtilTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSplit() {
		//分割対象の文字
		String str = "a,b,c";
		
		//カンマで文字列を分割
		//文字列を指定した区切り文字で分割するので、分割対象の文字列と、どの区切り文字か指定
		String[] result = StringUtil.split(str, ",");
		
		//以下結果を確認---------------------
		
		//resultがnullでないことを確認
		assertNotNull(result);
		//配列の長さが3であることを確認
		assertEquals(3, result.length);
		
		//分割結果が配列に確認されていることを確認
		assertEquals("a", result[0]);
		assertEquals("b", result[1]);
		assertEquals("c", result[2]);
	}
	
	@Test
	public void testSplit2() {
		String str = null;
		String result[] = null;
		
		//別の文字列を指定
		str = "A*B*C";
		result = StringUtil.split(str, "*");
		assertNotNull(result);
		assertEquals(3, result.length);
		assertEquals("A", result[0]);
		assertEquals("B", result[1]);
		assertEquals("C", result[2]);
		
		//長い区切り文字
		str = "123 [SEP] 456 [SEP] 789";
		result = StringUtil.split(str, " [SEP] ");
		assertNotNull(result);
		assertEquals(3, result.length);
		assertEquals("123", result[0]);
		assertEquals("456", result[1]);
		assertEquals("789", result[2]);
		
	}
	
	@Test
	public void testSplit3() {
		//分割対象の文字（空文字列あり）
		String str = "a,,";
		
		//カンマで文字列を分割
		String[] result = StringUtil.split(str, ",");
		
		//以下結果を確認--------------------
		
		//resultがnullでないことを確認
		assertNotNull(result);
		//配列の長さが３であることを確認
		assertEquals(3, result.length);
		
		//分割結果が配列に確認されていることを確認
		assertEquals("a", result[0]);
		assertEquals("", result[1]);
		assertEquals("", result[2]);
			}

}
