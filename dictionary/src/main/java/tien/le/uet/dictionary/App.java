package tien.le.uet.dictionary;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

import tien.le.uet.dictionary.control.Word_Control;
import tien.le.uet.dictionary.global.Constant;

/**
 * Hello world!
 *
 */
public class App {
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(App.class);

	public static void main(String[] args) {
		BasicConfigurator.configure();
		PropertyConfigurator.configure(Constant.DIR_FILE_CONFIG + Constant.DATABASE_CONFIG);
		Word_Control wControl = new Word_Control();
		log.info("START App");
		// search
		String target = "he";
		List<String> listData = wControl.searchWords(target);
		System.out.println(null != listData ? listData.size() : 0);
	}
}
