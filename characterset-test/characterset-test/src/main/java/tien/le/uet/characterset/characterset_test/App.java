package tien.le.uet.characterset.characterset_test;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Dao dao = new Dao();
        try {
			dao.insert();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
