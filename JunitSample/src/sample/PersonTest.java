package sample;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PersonTest {
	
	private static Person defaultPerson;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		defaultPerson = new Person();
	}

	@Test
	void testDefaultPerson() throws IllegalArgumentException, IllegalAccessException {
		//Personクラスのインスタンス（製品）を直接通じてはアクセスできない
		//privateな情報も、設計図（Classオブジェクト）を経由することで取り扱える
		//ようになる
		//getClass()は設計図を返します。なのでdefaultPersonの中身がPersonクラスの
		//子クラスのインスタンスの場合、子クラスの設計図が返ってくる。
		//<? extends Person>は中身はPersonクラスかもしれないし、子クラスかもしれない
		Class<? extends Person> c = defaultPerson.getClass();
		
		try {
			//プライベートプロパティを取得
			
			//Fieldオブジェクトは作成ではなく取得であるからnewは不要
			//getDeclaredFieldは設計図の中にnameという項目はあるか探しに行き
			//見つかったらその情報をFieldという型に包んで返してくれる役割
			Field nameField = c.getDeclaredField("name");
			
			//アクセス可能にする
			nameField.setAccessible(true);
			
			//値を取得してテスト（第3引数はエラー時に表示されるメッセージ）
			//getメソッドの戻り値はオブジェクト型なのでキャストしている
			assertEquals("Momotaro2", 
					(String) nameField.get(defaultPerson),
					"Default Person Name");
			
		//指定した名前のフィールドが存在しない場合にこの例外が発生
		} catch (IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		//セキュリティ上アクセスが許可されなければ
		//Javaの実行環境（セキュリティマネージャ）によって、「外部から
		//内部構造を覗き見るリフレクション操作」そのものが禁止されている
	    //設定の場合に発生
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			e.printStackTrace();
		//アクセス権限がないフィールドに対して、値を取得・変更しようとしたとき
		//今回の場合は、setAccessible(true)呼んでいないのにgetメソッドを実行したとき
		} catch (NoSuchFieldException e) {
			// TODO: handle exception
			e.printStackTrace();
		//メソッドに渡した引数が、期待されているものと異なる場合に発生
		//今回の場合はnameField.get(defaultPerson) を実行する際、nameField は
		//Personクラスの設計図」から取ったものなのに、引数に全く関係のない
		//「Dogクラスのインスタンス」などを渡してしまった場合に発生
		} catch (SecurityException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
