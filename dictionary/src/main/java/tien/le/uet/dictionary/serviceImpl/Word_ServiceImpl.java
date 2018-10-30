package tien.le.uet.dictionary.serviceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import tien.le.uet.dictionary.logic.Word_Logic;
import tien.le.uet.dictionary.model.Word;
import tien.le.uet.dictionary.service.Word_Service;

/**
 *
 * @author tien.le.uet
 *
 */
public class Word_ServiceImpl implements Word_Service {

	private Word_Logic logic;

	public Word_ServiceImpl() {
		this.logic = new Word_Logic();
	}

	public Word getWrodByTarget(String target)
			throws SQLException, ClassNotFoundException, IOException {

		return this.logic.getWrodByTarget(target);
	}

	public boolean insertWord(Word word) throws SQLException, ClassNotFoundException, IOException {

		return this.logic.insertWord(word);
	}

	public boolean updateWord(Word wordOld, Word wordNew)
			throws SQLException, ClassNotFoundException, IOException {

		return this.logic.updateWord(wordOld, wordNew);
	}

	public List<String> searchWords(String target)
			throws SQLException, ClassNotFoundException, IOException {

		return this.logic.searchWords(target);
	}
}
