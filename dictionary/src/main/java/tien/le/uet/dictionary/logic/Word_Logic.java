package tien.le.uet.dictionary.logic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import tien.le.uet.dictionary.dao.Word_Dao;
import tien.le.uet.dictionary.daoImpl.Word_DaoImpl;
import tien.le.uet.dictionary.model.Word;

/**
 *
 * @author tien.le.uet
 *
 */
public class Word_Logic {

	private Word_Dao dao;

	public Word_Logic() {
		this.dao = new Word_DaoImpl();
	}

	/**
	 *
	 * @param target
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Word getWrodByTarget(String target)
			throws SQLException, ClassNotFoundException, IOException {

		return this.dao.getWrodByTarget(target);
	}

	/**
	 *
	 * @param word
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public boolean insertWord(Word word) throws SQLException, ClassNotFoundException, IOException {

		return this.dao.insertWord(word);
	}

	/**
	 *
	 * @param wordOld
	 * @param wordNew
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public boolean updateWord(Word wordOld, Word wordNew)
			throws SQLException, ClassNotFoundException, IOException {

		return this.dao.updateWord(wordOld, wordNew);
	}

	/**
	 *
	 * @param target
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public List<String> searchWords(String target)
			throws SQLException, ClassNotFoundException, IOException {

		return this.dao.searchWords(target);
	}
}
