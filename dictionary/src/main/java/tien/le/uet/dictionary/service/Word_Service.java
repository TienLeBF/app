package tien.le.uet.dictionary.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import tien.le.uet.dictionary.model.Word;

/**
 *
 * @author tien.le.uet
 *
 */
public interface Word_Service {

	/**
	 *
	 * @param target
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Word getWrodByTarget(String target)
			throws SQLException, ClassNotFoundException, IOException;

	/**
	 *
	 * @param word
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public boolean insertWord(Word word) throws SQLException, ClassNotFoundException, IOException;

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
			throws SQLException, ClassNotFoundException, IOException;

	/**
	 *
	 * @param target
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public List<String> searchWords(String target)
			throws SQLException, ClassNotFoundException, IOException;
}
