package tien.le.uet.dictionary.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import tien.le.uet.dictionary.model.Word;
import tien.le.uet.dictionary.service.Word_Service;
import tien.le.uet.dictionary.serviceImpl.Word_ServiceImpl;

/**
 *
 * @author tien.le.uet
 *
 */
public class Word_Control {

	private Word_Service service;
	private static Logger log = Logger.getLogger(Word_Control.class.getName());

	public Word_Control() {
		this.service = new Word_ServiceImpl();
	}

	public Word getWrodByTarget(String target) {

		try {
			return this.service.getWrodByTarget(target);
		} catch (SQLException e) {
			log.info("ERROR when fetch data in database");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			log.info("ERROR class not found");
			e.printStackTrace();
		} catch (IOException e) {
			log.info("ERROR io files");
			e.printStackTrace();
		}

		return null;
	}

	public boolean insertWorld(Word word) {
		try {
			return this.service.insertWord(word);
		} catch (SQLException e) {
			log.info("ERROR when insert data in database");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			log.info("ERROR class not found");
			e.printStackTrace();
		} catch (IOException e) {
			log.info("ERROR io files");
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateWord(Word wordOld, Word wordNew) {
		try {
			return this.service.updateWord(wordOld, wordNew);
		} catch (SQLException e) {
			log.info("ERROR when update data in database");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			log.info("ERROR class not found");
			e.printStackTrace();
		} catch (IOException e) {
			log.info("ERROR io files");
			e.printStackTrace();
		}

		return false;
	}

	public List<String> searchWords(String target) {
		try {
			return this.service.searchWords(target);
		} catch (SQLException e) {
			log.info("ERROR when search data in database");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			log.info("ERROR class not found");
			e.printStackTrace();
		} catch (IOException e) {
			log.info("ERROR io files");
			e.printStackTrace();
		}

		return null;
	}
}
