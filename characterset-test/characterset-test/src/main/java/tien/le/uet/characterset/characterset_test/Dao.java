package tien.le.uet.characterset.characterset_test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dao {
	public void insert() throws SQLException {
		Connection con = ConnectionDB.getConnection();
		try {
			con.setAutoCommit(false);
			String query = "INSERT INTO character_test.utf8_ (NAME) VALUES(?)";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, "😞 <3");
			
			preparedStatement.execute();
			con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null == con) {
				con.close();
			}
		}
		
	}
}
