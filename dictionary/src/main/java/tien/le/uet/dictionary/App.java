package tien.le.uet.dictionary;

import java.util.List;

import tien.le.uet.dictionary.control.Word_Control;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Word_Control wControl = new Word_Control();

		// search
		String target = "he";
		List<String> listData = wControl.searchWords(target);
		System.out.println(null != listData ? listData.size() : 0);
	}
}
