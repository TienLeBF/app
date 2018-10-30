package tien.le.uet.dictionary.daoImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tien.le.uet.dictionary.dao.Word_Dao;
import tien.le.uet.dictionary.global.ConnectionDatabase;
import tien.le.uet.dictionary.global.ConnectionMysql;
import tien.le.uet.dictionary.model.Word;

public class Word_DaoImpl implements Word_Dao {

	public Word getWrodByTarget(String target)
			throws SQLException, ClassNotFoundException, IOException {
		Connection connection = null;
		try {
			ConnectionDatabase connectionDatabase = ConnectionMysql.getConnectionSql();
			connectionDatabase.setConnectionDB();
			connection = connectionDatabase.getConnection();

			String query = "SELECT target, mean FROM word WHERE target = ?";
			PreparedStatement prepared = connection.prepareStatement(query);
			prepared.setString(1, target);

			ResultSet result = prepared.executeQuery();
			if ((null != result) && result.next()) {
				String targetTemp = result.getString("target");
				String explainTemp = result.getString("mean");
				Word word = new Word(targetTemp, explainTemp);

				return word;
			}

			return null;

		} catch (SQLException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (null != connection) {
				connection.close();
			}
		}
	}

	public boolean insertWord(Word word) throws SQLException, ClassNotFoundException, IOException {
		Connection connection = null;
		try {
			ConnectionDatabase connectionDatabase = ConnectionMysql.getConnectionSql();
			connectionDatabase.setConnectionDB();
			connection = connectionDatabase.getConnection();
			connection.setAutoCommit(false);

			String query = "INSERT INTO word (target, mean) VALUES(?, ?)";
			PreparedStatement prepared = connection.prepareStatement(query);
			prepared.setString(1, word.getTarget());
			prepared.setString(2, word.getExplain());

			boolean result = prepared.execute();
			connection.commit();

			return result;
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (null != connection) {
				connection.close();
			}
		}
	}

	public boolean updateWord(Word wordOld, Word wordNew)
			throws SQLException, ClassNotFoundException, IOException {
		Connection connection = null;
		try {
			ConnectionDatabase connectionDatabase = ConnectionMysql.getConnectionSql();
			connectionDatabase.setConnectionDB();
			connection = connectionDatabase.getConnection();
			connection.setAutoCommit(false);

			String query = "UPDATE word SET target = ?, mean = ? WHERE target = ?";
			PreparedStatement prepared = connection.prepareStatement(query);
			prepared.setString(1, wordNew.getTarget());
			prepared.setString(2, wordNew.getExplain());
			prepared.setString(3, wordOld.getTarget());
			// prepared.setString(4, wordOld.getExplain());

			int result = prepared.executeUpdate();
			connection.commit();

			return 0 == result ? false : true;
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (null != connection) {
				connection.close();
			}
		}
	}

	public List<String> searchWords(String target)
			throws SQLException, ClassNotFoundException, IOException {
		Connection connection = null;
		try {
			ConnectionDatabase connectionDatabase = ConnectionMysql.getConnectionSql();
			connectionDatabase.setConnectionDB();
			connection = connectionDatabase.getConnection();

			String query = "SELECT target FROM word WHERE target like ? LIMIT 10";
			PreparedStatement prepared = connection.prepareStatement(query);
			prepared.setString(1, target + "%");

			List<String> listData = new ArrayList<String>();
			ResultSet result = prepared.executeQuery();
			while ((null != result) && result.next()) {
				listData.add(result.getString("target"));
			}

			return listData;
		} catch (SQLException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
	}

}
