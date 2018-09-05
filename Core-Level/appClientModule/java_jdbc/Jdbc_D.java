package java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;

/**
 * CachedRowSet(I):
 * 
 * It extends RowSet interface.
 * 
 * A CachedRowSet object is special in that it can operate without being
 * connected to its data source, that is, it is a disconnected RowSet object.
 * 
 * It gets its name from the fact that it stores (caches) its data in memory so
 * that it can operate on its own data rather than on the data stored in a
 * database.
 * 
 * Oftentimes it is not desirable to maintain a persistent connection while
 * extracting query data from a ResultSet object.
 * 
 * In the case of a production database that serves millions of queries a day,
 * it would be more responsible to create a connection, execute a query, quickly
 * grab the results, and then immediately close the connection, leaving the data
 * processing itself to a middle-tier application.
 * 
 * In ordinary scenario, the ResultSet is closed as soon as the Statement itself
 * is closed, or used to retrieve another ResultSet. Therefore, the pointer that
 * once provided a handle to the query results is no longer valid, and this is
 * where CachedRowSet comes in.
 * 
 * Unlike a ResultSet, a CachedRowSet stores all rows obtained from a query in
 * local memory, which can be extremely convenient at times.
 */

public class Jdbc_D {

	private static final String QUERY = "SELECT * from users";

	public static void main(String[] args) {

		int pageSize = 10;
		int index = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter page index: ");
		index = sc.nextInt();
		int startIndex = ((pageSize * index) - pageSize) + 1;
		int endIndex = (pageSize * index);
		System.out.println("StartOfPage: " + startIndex + " EndOfPage: "
				+ endIndex);

		DBManager dbManager = new DBManager("root", "root");
		Connection connection = dbManager.getConnection();
		
		/** COMMENTED OUT BECAUSE JAVA8
		try {
			CachedRowSet crs = new CachedRowSetImpl();
			populateTableData(connection, startIndex, endIndex, crs);
		} catch (SQLException e) {
			System.out.println("Error Occured...");
		} finally {
			sc.close();
		}
		*/
	}

	public static void populateTableData(Connection conn, int startIndex,
			int endIndex, CachedRowSet crs) throws SQLException {

		// Sets the CachedRowSet object's page-size.
		crs.setPageSize(endIndex);

		crs.setCommand(QUERY);
		crs.execute(conn);

		// connection close won't effect
		conn.close();

		System.out.println("CachedRowSet: " + crs.size());

		/**
		 * Moves the cursor to the given row number in this ResultSet object
		 * 
		 * Calling absolute(1) is the same as calling first(). Calling
		 * absolute(-1) is the same as calling last().
		 */
		if (crs.absolute(startIndex)) {
			crs.previous();
			while (crs.next()) {
				if (!crs.getString(2).equals("")) {
					System.out.println(crs.getString(2) + "|"
							+ crs.getString(6));
				}
			}
		}
	}
}

class DBManager {

	private String url;

	public DBManager(String user, String password) {
		url = "jdbc:mysql://localhost:3306/orms_integration?user=" + user
				+ "&password=" + password;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			conn = DriverManager.getConnection(url);

			return conn;

		} catch (SQLException | InstantiationException | IllegalAccessException
				| ClassNotFoundException se) {
			return conn;
		}

	}

}
