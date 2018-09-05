package java_jdbc;

import java.sql.SQLException;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**
 * JDBC RowSet(I):
 * --------------------------------------------------------------------------
 * RowSet interface is another key interface from JDBC API, which extends the
 * ResultSet interface to provide support for the JavaBean component model and
 * java bean notification mechanism.
 * 
 * Objective-1: RowSet extends ResultSet interface to add support of Java Bean
 * model e.g. it adds methods like setUrl() which makes it easy to connect to
 * database.
 * 
 * Objective-2: RowSet objects use the JavaBeans event model, in which
 * registered components are notified when certain events occur.
 * 
 * RowSetListener is an interface that is implemented by a component that wants
 * to be notified when a significant event happens in the life of a RowSet
 * object.
 * 
 * There are three events trigger notifications (and handled by listener
 * methods):
 * 
 * > Cursor movement: cursorMoved(RowSetEvent)
 * 
 * > Update, insert or delete of a row: rowChanged(RowSetEvent)
 * 
 * > Change to the entire RowSet content: rowSetChanged(RowSetEvent)
 * 
 * Objective-3: Some DBMSs do not support result sets that can be scrolled
 * (SCROLLABLE), and some do not support result sets that can be updated
 * (UPDATABLE). If a driver for that DBMS does not add the ability to scroll or
 * update result sets, you can use a RowSet object to do it.
 * 
 * All RowSets are UPDATABLE even if they are disconnected. In case of an
 * update, disconnected RowSets update their cached data. The updates are
 * persisted to the database by calling acceptChanges(databaseConnection) method 
 * on the RowSet instance.
 * 
 * 
 * 
 * 
 * A connected RowSet always keeps connection with database, while a
 * disconnected RowSet connect to database, get the data and then close the
 * connection.
 * 
 * This doesn't prevent from working with data though, you can still change data
 * in disconnected state, but to commit, connection needs to be re-established
 * by RowSet.
 * 
 * Java provides five different types of RowSet those are JdbcRowSet,
 * JoinRowSet, CachedRowSet, FilteredRowSet and WebRowSet. Out of these five
 * only JdbcRowSet is connected RowSet, rest of them are disconnected row sets.
 * 
 * 
 * JdbcRowSet(I):
 * 
 * It extends RowSet interface.
 * 
 * A JdbcRowSet object is an enhanced ResultSet object. It maintains a
 * connection to its data source, just as a ResultSet object does. The big
 * difference is that it has a set of properties and a listener notification
 * mechanism that make it a JavaBeans component.
 * 
 * One of the main uses of a JdbcRowSet object is to make a ResultSet object
 * SCROLLABLE and UPDATABLE when it does not otherwise have those capabilities.
 * 
 * 
 * Ways to create JdbcRowSet object:
 * 
 * > Passing ResultSet Objects:
 * -----------------------------------------------------------------------------
 * JdbcRowSet jdbcRs = new JdbcRowSetImpl(resultSet);
 * 
 * > Passing Connection objects:
 * -----------------------------------------------------------------------------
 * JdbcRowSet jdbcRs = new JdbcRowSetImpl(connection);
 * 
 * > Using the Default constructor:
 * -----------------------------------------------------------------------------
 * JdbcRowSet jdbcRs = new JdbcRowSetImpl();
 * 
 * 
 * > RowSetProvider class provides factory API to get a new instance of a
 * RowSetFactory interface implementation
 * -----------------------------------------------------------------------------
 * RowSetFactory rowSetFactory = RowSetProvider.newFactory();
 * 
 * JdbcRowSet rowSet = rowSetFactory.createJdbcRowSet();
 * 
 * > In Single line
 * -----------------------------------------------------------------------------
 * JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
 * 
 * 
 * 
 * Reference: https://docs.oracle.com/javase/tutorial/jdbc/basics/rowset.html
 */

public class Jdbc_C {

	/**
	 * The following JavaDoc API description for RowSet is useful for the exam:
	 * 
	 * RowSet is an interface that adds support to the JDBC API for the
	 * JavaBeansTM component model. A rowset, which can be used as a JavaBeans
	 * component in a visual Bean development environment, can be created and
	 * configured at design time and executed at run time.
	 * 
	 * The RowSet interface provides a set of JavaBeans properties that allow a
	 * RowSet instance to be configured to connect to a JDBC data source and
	 * read some data from the data source. A group of setter methods (setInt,
	 * setBytes, setString, and so on) provide a way to pass input parameters to
	 * a rowset's command property. This command is the SQL query the rowset
	 * uses when it gets its data from a relational database, which is generally
	 * the case.
	 * 
	 * The RowSet interface supports JavaBeans events, allowing other components
	 * in an application to be notified when an event occurs on a rowset, such
	 * as a change in its value.
	 * 
	 * A RowSet object may make a connection with a data source and maintain
	 * that connection throughout its life cycle, in which case it is called a
	 * connected rowset. A rowset may also make a connection with a data source,
	 * get data from it, and then close the connection. Such a rowset is called
	 * a disconnected rowset. A disconnected rowset may make changes to its data
	 * while it is disconnected and then send the changes back to the original
	 * source of the data, but it must reestablish a connection to do so.
	 * 
	 * A disconnected rowset may have a reader (a RowSetReader object) and a
	 * writer (a RowSetWriter object) associated with it. The reader may be
	 * implemented in many different ways to populate a rowset with data,
	 * including getting data from a non-relational data source. The writer can
	 * also be implemented in many different ways to propagate changes made to
	 * the rowset's data back to the underlying data source.
	 * 
	 * Rowsets are easy to use. The RowSet interface extends the standard
	 * java.sql.ResultSet interface. The RowSetMetaData interface extends the
	 * java.sql.ResultSetMetaData interface.
	 */
	private final static String DB_URL = "jdbc:mysql://localhost:3306/orms_integration";
	private final static String USR = "root";
	private final static String PWD = "root";

	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");

		RowSetFactory factory = RowSetProvider.newFactory();

		JdbcRowSet rowSet = factory.createJdbcRowSet();

		rowSet.setUrl(DB_URL);
		rowSet.setUsername(USR);
		rowSet.setPassword(PWD);

		// To make UPDATEABLE
		rowSet.setReadOnly(false);

		// Sets the maximum number of rows that this RowSet object can contain
		// to the specified number.
		rowSet.setMaxRows(10);

		rowSet.setCommand("SELECT * FROM users");

		// Fills this RowSet object with data.
		rowSet.execute();

		rowSet.addRowSetListener(new MessageListener());

		rowSet.last();
		System.out.println("Total Records = " + rowSet.getRow());
	}
}

class MessageListener implements RowSetListener {

	public void cursorMoved(RowSetEvent event) {
		System.out.println("Cursor Moved...");
	}

	public void rowChanged(RowSetEvent event) {
		System.out.println("Cursor Changed...");
	}

	public void rowSetChanged(RowSetEvent event) {
		System.out.println("RowSet changed...");
	}

}