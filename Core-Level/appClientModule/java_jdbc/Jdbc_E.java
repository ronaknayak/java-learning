package java_jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**
 * JoinRowSet(I):
 * 
 * It is child interface of WebRowSet(which in turn child interface of
 * CachedRowSet).
 * 
 * A JoinRowSet implementation lets you create a SQL JOIN between RowSet objects
 * when they are not connected to a data source. This is important because it
 * saves the overhead of having to create one or more connections.
 * 
 * The Joinable interface provides methods for getting and setting a match
 * column, which is the basis for forming a SQL JOIN formed by adding RowSet
 * objects to a JoinRowSet object. The Joinable is defined in the
 * javax.sql.rowset package.
 * 
 * A JoinRowSet is a disconnected RowSet. The JoinRowSet interface makes it
 * possible to get data from one or more rowset objects consolidated into one
 * table without having to incur the expense of creating a connection to a
 * database.
 * 
 * Both connected and disconnected rowset objects can be part of a join.
 * JdbcRowSet a connected rowset, implements Joinable, and thus it can be part
 * of a join.
 * 
 * All the rowsets, CachedRowSet, FilteredRowSet, JdbcRowSet, JoinRowSet and
 * WebRowSet extend this interface.
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * The JoinRowSet jrs is set up to match the first two tables using the column
 * name. Now, when you try to add the third table with different column name as
 * the match column it tries to match column of JoinRowSet with different column
 * of third table. Obviously, nothing matches and so JoinRowSet becomes empty.
 * 
 * To achieve what the code intends to do i.e. to match the result of joining
 * FIRST and SECOND table with THIRD table on it's column, you will need to
 * create another JoinRowSet as follows:
 * 
 * JoinRowSet jrs2 = rsf.createJoinRowSet();
 * 
 * jrs.setMatchColumn("SUBJECT"); //First change the match column of first two
 * tables jrs to third table SUBJECT column.
 * 
 * jrs2.addRowSet(jrs);
 * 
 * jrs2.addRowSet(thirdTableCachedRowset, "SUBJECT"); //Now match jrs's SUBJECT
 * with thirdTableCachedRowset's SUBJECT.
 */

public class Jdbc_E {

	private static final String USERS_TABLE = "users";
	private static final String MEMBERS_TABLE = "members";
	private final static String USER_ID = "id";
	private final static String MEMBER_ID = "user_id";

	public static void main(String[] args) throws SQLException {

		DBManager dbManager = new DBManager("root", "root");
		Connection connection = dbManager.getConnection();

		CachedRowSet crs1 = getCachedRowset();
		populateRowset(crs1, connection, USERS_TABLE, USER_ID, "mail");

		CachedRowSet crs2 = getCachedRowset();
		populateRowset(crs2, connection, MEMBERS_TABLE, MEMBER_ID, "project_id");

		JoinRowSet joinRowSet = getJoinRowset(crs1, crs2);
		queryJoinRowset(joinRowSet);
	}

	private static CachedRowSet getCachedRowset() throws SQLException {

		System.out.println("- Create cached rowset");
		RowSetFactory rsFactory = RowSetProvider.newFactory();
		CachedRowSet rowset = rsFactory.createCachedRowSet();
		return rowset;
	}

	private static void populateRowset(CachedRowSet crs, Connection con,
			String tableName, String col1, String col2) throws SQLException {

		System.out.println("- Populate rowset with database table rows: "
				+ tableName);
		String sql = "SELECT * FROM " + tableName;
		crs.setCommand(sql);
		crs.execute(con);
		crs.last();

		System.out.println("Total rows: " + crs.getRow());

		queryCrs(crs, col1, col2);
	}

	private static void queryCrs(CachedRowSet crs, String col1, String col2)
			throws SQLException {

		crs.beforeFirst();

		while (crs.next()) {

			String s1 = crs.getString(col1);
			String s2 = crs.getString(col2);
			System.out.println("[" + col1 + ", " + col2 + "]: " + s1 + ", "
					+ s2);
		}
	}

	private static JoinRowSet getJoinRowset(CachedRowSet crs1, CachedRowSet crs2)
			throws SQLException {

		System.out.println("- Create join rowset");
		RowSetFactory rowSetFactory = RowSetProvider.newFactory();
		JoinRowSet joinRowSet = rowSetFactory.createJoinRowSet();

		System.out.println("- Add two cached rowsets, joined on: " + USER_ID);

		// Sets the designated column as the match column for this RowSet
		// object.
		// crs1.setMatchColumn(USER_ID);

		// Adds rowset to this JoinRowSet object and sets the designated column
		// as the match column.
		joinRowSet.addRowSet(crs1, USER_ID);

		// Adds rowset to this JoinRowSet object and sets the designated column
		// as the match column.
		joinRowSet.addRowSet(crs2, MEMBER_ID);

		return joinRowSet;
	}

	private static void queryJoinRowset(JoinRowSet jrs) throws SQLException {
		while (jrs.next()) {
			System.out
					.println(jrs.getString(USER_ID) + "|"
							+ jrs.getString("mail") + "|"
							+ jrs.getString("project_id"));
		}
	}

}
