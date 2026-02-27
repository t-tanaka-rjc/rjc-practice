import java.util.ArrayList;

public class StringUtil {
	/**
	 * 文字列の分割（区切り文字指定）
	 * @param str 対象文字列
	 * @param string 区切り文字列
	 * @return 分割後の文字列
	 */
	public static String[] split(String str, String delim) {
		//引数の区切り文字で文字列（str）を区切り、配列の要素に格納
		//StringTokenizerを使用すると空文字がると無視してしまうから
		//テストクラスでassertEquals(3, result.length);と書くと失敗する。
		//から下記のように書いている
		
		final int delimLength = delim.length();
		int pos = 0;
		int index = 0;
		//区切りで切り分けた文字を格納する用の配列
		ArrayList<String> list = new ArrayList<String>();
		
		//"a,b,c"の場合で考えると
		
		//"A*B*C"の場合でもdelimが＊になり同じ処理の流れになる。
		
		//strの中の文字列のpos（0）番以降のインデックスにdelim（,）が最初に
		//出現するインデックスをindexに再代入し、それがー１ではない時という条件式
		
		//indexOfメソッドは探している文字が見つからない場合は、ー１を返す。
		//今回の場合は最短でインデックス１
		while ((index = str.indexOf(delim, pos)) != -1) {
			//str.substring(pos, index)はposの番号の文字を含むが、
			//indexの番号の文字は含まない
			//開始位置しか指定しない場合は、開始位置以降の文字列を返す
			
			//最短でインデックス１だから下記の式の一週目は0,1
			//つまりstrが"a,b,c"であればaをリストに追加
			list.add(str.substring(pos, index));
			//下記で無限ループを防ぐ
			//下記の式で1+1をしてposは２になる
			//２週目の,の出現位置はインデックス３
			//pos=2,index3となり、2～3の間の文字をリストに格納
			//つまりbを格納
			pos = index + delimLength;
		}
		
		//上記の繰り返し処理を続けると,が見つからなくなり-1となってループを抜ける
		//その時posは4だからCがリストに追加される
		list.add(str.substring(pos));
		return ((String[]) list.toArray(new String[0]));
		
//		StringTokenizer st = new StringTokenizer(str, delim);
//		
//		int length = st.countTokens();
//		String[] result = new String[length];
//		
//		for (int i = 0; i < length; i++) {
//			result[i] = st.nextToken();
//		}
//		
//		return result;
	}

}
