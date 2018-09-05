package java_jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * All the database related operations is performed by Database Engine.
 * Internally, Database Engine performs some operation. Those are:
 * 
 * - Query TOKENIZATION
 * 
 * - Query Parsing
 * 
 * - Query Optimization
 * 
 * - Query Execution
 * 
 * 
 * Key classes & interfaces of JDBC:
 * 
 * These are present in java.sql package and javax.sql package.
 * 
 * Driver:
 * -----------------------------------------------------------------------------
 * This is the interface that every driver class must implement.
 * 
 * The Java SQL framework allows for multiple database drivers. Each driver
 * should supply a class that implements the Driver interface.
 * 
 * Each vendor driver must provide implementations of the java.sql.Connection, 
 * Statement,PreparedStatement, CallableStatement, ResultSet and Driver interfaces.
 * 
 * 
 * DriverManager:
 * -----------------------------------------------------------------------------
 * This class manages a list of database drivers & therefore it can also be 
 * considered as connection factory class. The DriverManager will try to
 * load as many drivers as it can find and then for any given connection
 * request, it will ask each driver in turn to try to connect to the target URL.
 * 
 * The DriverManager class maintains a list of Driver classes that have
 * registered themselves by calling the method as,
 * DriverManager.registerDriver().
 * 
 * When a Driver class is loaded, it create an instance of itself and
 * register it with the DriverManager.(For every Driver class implementation 
 * there is one static block and inside that an object of driver class object is created & 
 * register with driver manager.) This means that a user can load and register a 
 * driver by calling:
 * 
 * Class.forName("com.mysql.jdbc.Driver")
 * 
 * Most Required thing to know: From 1.6 version we are not required to write 
 * above line. While getting connection by connection URL it loads database 
 * driver and register it.
 * 
 * 
 * Connection:
 * -----------------------------------------------------------------------------
 * This interface used to provide connection between Java application to
 * corresponding database.
 * 
 * 
 * Statement:
 * -----------------------------------------------------------------------------
 * This interface is used for executing a static SQL queries and returning the
 * results it produces.
 * 
 * That means to carry our required query to the database and to retrieve result 
 * set from the database engine Statement object is used.
 * 
 * The execute method of a Statement implicitly close its current ResultSet if 
 * it is already open.
 * 
 * 
 * PreparedStatement:
 * -----------------------------------------------------------------------------
 * It is the child interface of Statement interface. It's also used to execute
 * the queries.
 * 
 * A prepared statement is an SQL statement that is PRE-COMPILED by the
 * database. Through PRE-COMPILATION, prepared statements improve the
 * performance of SQL commands that are executed multiple times by Database
 * Engine. Once compiled, prepared statements can be customized prior to each
 * execution by altering predefined SQL parameters.
 * 
 * One difference here is that in a Statement you pass the SQL in the execute 
 * method, but in PreparedStatement you have to pass the SQL in the prepareStatement() 
 * method while creating the PreparedStatement and leave the execute method empty.
 * 
 * 
 * CallableStatement:
 * -----------------------------------------------------------------------------
 * It is the child interface of PreparedStatement interface. To execute the
 * procedures and functions we have to use CallableStatement interface.
 * 
 * A CallableStatement is easier to build and call from JDBC code than a PreparedStatement. 
 * This is true because you don't have to write any SQL query in Java code. You just use 
 * the name of the stored procedure. The queries are already there inside the stored 
 * procedure, which exists in the Database and not in JDBC code.
 * 
 * Whereas PreparedStatement gives methods for dealing with IN parameters, 
 * CallableStatement provides methods to deal with OUT parameters as well.
 * 
 * 
 * ResultSet:
 * -----------------------------------------------------------------------------
 * When we hit query to retrieve data, Database engine returns group of records
 * from database. ResultSet object is used to store those data.
 * 
 * By default, ResultSet object can be moved forward only and it is NOT UPDATABLE.
 * 
 * To iterate the ResultSet you use its next() method. The next() method returns 
 * true if the ResultSet has a next record, and moves the ResultSet cursor to point to 
 * the next record.
 * 
 * As you can see, the next() method is actually called before the first record 
 * is accessed. That means, that the ResultSet starts out pointing before the 
 * first record. 
 * 
 * 
 * When you create a ResultSet there are three attributes you can set. These are:
 * 
 * 1.Type, 2.Concurrency & 3.HoldAbility
 * 
 * You set these already when you create the Statement or PreparedStatement.Like,
 * 
 * Statement statement = connection.createStatement(
 * 	ResultSet.TYPE_FORWARD_ONLY,
 *  ResultSet.CONCUR_READ_ONLY,
 *  ResultSet.CLOSE_CURSORS_OVER_COMMIT
 *  );
 * 
 * The default type is TYPE_FORWARD_ONLY.
 * 
 * ResultSet Types:
 * 
 * 1. ResultSet.TYPE_FORWARD_ONLY means that the ResultSet can only be navigated 
 * forward. That is, you can only move from row 1, to row 2, to row 3 etc. 
 * You cannot move backwards in the ResultSet.
 * 
 * 2. ResultSet.TYPE_SCROLL_INSENSITIVE means that the ResultSet can be navigated 
 * (scrolled) both forward and backwards. You can also jump to a position relative 
 * to the current position, or jump to an absolute position. 
 * 
 * The ResultSet is insensitive to changes in the underlying data source while the 
 * ResultSet is open. That means, if a record in the ResultSet is changed in the database 
 * by another thread or process, it will not be reflected in already opened ResulsSet's 
 * of this type.
 * 
 * 3. ResultSet.TYPE_SCROLL_SENSITIVE means that the ResultSet can be navigated 
 * (scrolled) both forward and backwards. You can also jump to a position relative 
 * to the current position, or jump to an absolute position. 
 * 
 * The ResultSet is sensitive to changes in the underlying data source while the 
 * ResultSet is open. That is, if a record in the ResultSet is changed in the database 
 * by another thread or process, it will be reflected in already opened ResulsSet's of 
 * this type.
 * 
 * 
 * ResultSet Concurrency:
 * 
 * The ResultSet concurrency determines whether the ResultSet can be updated, or only read.
 * 
 * 1. ResultSet.CONCUR_READ_ONLY means that the ResultSet can only be read.
 * 
 * 2. ResultSet.CONCUR_UPDATABLE means that the ResultSet can be both read and updated.
 * 
 * The default type is CONCUR_READ_ONLY.
 * 
 * 
 * ResultSet HoldAbility:
 * 
 * The ResultSet HoldAbility determines if a ResultSet is closed when the commit() method 
 * of the underlying connection is called.
 * 
 * 1. ResultSet.CLOSE_CURSORS_OVER_COMMIT means that all ResultSet instances are closed when 
 * connection.commit() method is called on the connection that created the ResultSet.
 * 
 * 2. ResultSet.HOLD_CURSORS_OVER_COMMIT means that the ResultSet is kept open when the 
 * connection.commit() method is called on the connection that created the ResultSet.
 * 
 * REFERENCE: 
 * http://tutorials.jenkov.com/jdbc/resultset.html
 * https://www.tutorialspoint.com/jdbc/jdbc-result-sets.htm
 * 
 * 
 * ResultSetMetaData:
 * -----------------------------------------------------------------------------
 * It's used to get data about the data.  i.e. we can get further information from 
 * the data. For example, column count, name of the columns etc.
 * 
 * Consider an example where you are passed a ResultSet to a method and you don’t know 
 * the number or type of columns in the ResultSet.
 * 
 * 
 * DataBaseMetaData:
 * -----------------------------------------------------------------------------
 * This interface is used to get information about the database. For example, 
 * database product name, database product version, name of total number of tables etc.
 * 
 * 
 * SavePoint:
 * -----------------------------------------------------------------------------
 * This interface is used to roll back the transaction up to certain point. We
 * can set more number of SavePoint.
 * 
 * 
 * SQLException: 
 * --------------------------------------------------------------------------------
 * This class is an exception class that provides information on a database access error 
 * or other errors. 
 * 
 * 
 * SQL Statements:
 * 
 * DDL: create,alter, drop, truncate, rename
 * DML: insert, update, delete
 * DQL: select
 */

/**
 * Using Transaction Management:
 * ===========================================================================
 * By default when we create a database connection, it runs in auto-commit mode.
 * It means that whenever we execute a query and it’s completed, the commit is
 * fired automatically.
 * 
 * So every SQL query we fire is a transaction and if we are running some DML or
 * DDL queries, the changes are getting saved into database after every SQL
 * statement finishes.
 * 
 * Sometimes we want a group of SQL queries to be part of a transaction so that
 * we can commit them when all the queries runs fine. If we get any exception,
 * we have a choice of ROLLBACK all the queries executed as part of the
 * transaction.
 * 
 * Objectives:
 * 
 * Fast performance It makes the performance fast because database is hit at the
 * time of commit.
 * 
 * To maintain the integrity of business processes.
 * 
 * 
 * In JDBC, Connection interface provides methods to manage transaction.
 * 
 * If we pass a boolean false to setAutoCommit( ) method, you turn off
 * auto-commit.
 * 
 * Once you are done with your changes and you want to commit the changes then
 * call commit() method.
 * 
 * We can use rollback() method to cancels the transaction.
 * 
 * 
 * JDBC Savepoint:
 * =============================================================================
 * Sometimes a transaction can be group of multiple statements and we would like
 * to rollback to a particular point in the transaction. JDBC Savepoint helps us
 * in creating checkpoints in a transaction and we can rollback to that
 * particular checkpoint.
 * 
 * Any savepoint created for a transaction is automatically released and become
 * invalid when the transaction is committed, or when the entire transaction is
 * rolled back.
 * 
 * In JDBC, Connection interface provides methods to manage transaction.
 * 
 * setSavepoint(String savepointName): Defines a new savepoint. It also returns
 * a Savepoint object.
 * 
 * releaseSavepoint(Savepoint savepointName): Deletes a savepoint. Notice that
 * it requires a Savepoint object as a parameter. This object is usually a
 * savepoint generated by the setSavepoint() method.
 * 
 * There is one rollback (String savepointName) method, which rolls back work to
 * the specified savepoint.
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * > Note that there is nothing like "enabling the transactions". In JDBC,
 * transactions are always enabled. Every statement is a part of a transaction.
 * If auto-commit is set to true, the transaction is committed after every
 * statement (and a new transaction is started with the next query), if it is
 * set to false, the transaction is committed when connection.commit() is called
 * explicitly.
 * 
 * > Once a Connection object is closed, you cannot access any of the subsequent
 * objects such as Statement and ResultSet that are retrieved from that
 * Connection.
 * 
 * When we close the Statement object from which the ResultSet was retrieved if
 * exists, is also closed.
 */

public class Jdbc_B {
	public static void main(String[] args) {

		/*
		 * Get connect with Database
		 */

		/**
		 * Step 1: Load the driver implementation.
		 */

		// Approach-1
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Approach-2
		Driver driver = null;
		try {
			driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/**
		 * Step 2: Provide the connection between Java-Database
		 * 
		 * Attempts to establish a connection to the given database URL. The
		 * DriverManager attempts to select an appropriate driver from the set
		 * of registered JDBC drivers.
		 * 
		 * getConnection() method returns Connection class implementation class
		 * object. i.e.ParentInterface i = new ImplementationClass();
		 */
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/site", "root", "root");

			System.out.println("Coonected to "
					+ connection.getClass().getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/**
		 * Step 3: Create statement
		 * 
		 * Creates a Statement object for sending SQL statements to the
		 * database. SQL statements without parameters are normally executed
		 * using Statement objects.
		 * 
		 * If the same SQL statement is executed many times, it may be more
		 * efficient to use a PreparedStatement object
		 * 
		 * public Statement createStatement() throws SQLException
		 */
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/**
		 * Step 4: execute SQL statement
		 * 
		 * executeUpdate(): create, insert, update, delete, alter, drop
		 * 
		 * int i = st.executeUpdate(SQL);
		 * 
		 * Returns (In case we use Type-4 driver),
		 * 
		 * 0 - create
		 * 
		 * 1 - insert
		 * 
		 * ROW_COUNT - update
		 * 
		 * 0 - drop
		 * --------------------------------------------------------------
		 * 
		 * executeQuery(): select
		 * 
		 * ResultSet result = st.executeQuery(SQL);
		 * --------------------------------------------------------------
		 * 
		 * execute(): Both Selection & Update group of SQL statements
		 * 
		 * boolean b = st.execute(SQL);
		 * 
		 * Returns, true - selection statement & false - update statement
		 */
		String query = "SELECT login FROM users";
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				String login = resultSet.getString("login");
				System.out.println(login);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/**
		 * Step 5: Committing Transactions
		 * 
		 * When a connection is created, it is in auto-commit mode. This means
		 * that each individual SQL statement is treated as a transaction and is
		 * automatically committed in database right after it is executed.
		 * 
		 * The way to allow two or more statements to be grouped into a
		 * transaction is to disable the auto-commit mode.
		 * 
		 * Transaction commit apply for only DML queries.
		 */

		/**
		 * Step 6: Close the resources
		 * 
		 * There are a few things to note:
		 * 
		 * 1. Once a Connection object is closed, you cannot access any of the
		 * subsequent objects such as Statement and ResultSet that are retrieved
		 * from that Connection.
		 * 
		 * 2. The references declared in the try block (in this case, c and
		 * ResultSet) are not visible outside the try block. Not even in the
		 * catch block.
		 * 
		 * 3. When a resource is created in the try-with-resources block ( in
		 * this case, c), it is closed at the end of the try block irrespective
		 * of whether there is an exception in the try block or not.
		 */
		finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				System.out
						.println("Error occured while closing the resources.");
			}
		}

		System.out.println("*********ResultSet Navigation methods*********");
		allNavigationMethods();
		System.out.println("*********ResultSet Updation methods*********");
		allUpdationMethods();
	}

	public static void allNavigationMethods() {

		Statement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/orms_integration", "root", "root");

			statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			String query = "SELECT * FROM users";
			resultSet = statement.executeQuery(query);

			System.out.println("Moving cursor to the last...");
			resultSet.last();

			String firstName = resultSet.getString(4);
			String lastName = resultSet.getString(5);
			String email = resultSet.getString(6);
			System.out.println(firstName + " " + lastName + " ->" + email);

			System.out.println("Moving cursor to the first row...");
			resultSet.first();

			firstName = resultSet.getString(4);
			lastName = resultSet.getString(5);
			email = resultSet.getString(6);
			System.out.println(firstName + " " + lastName + " ->" + email);

			System.out.println("Moving cursor to the specified row...");
			resultSet.absolute(10);

			firstName = resultSet.getString(4);
			lastName = resultSet.getString(5);
			email = resultSet.getString(6);
			System.out.println(firstName + " " + lastName + " ->" + email);

			System.out
					.println("Moving cursor  number of rows forward or backward, from where it is currently pointing...");
			resultSet.relative(10);

			firstName = resultSet.getString(4);
			lastName = resultSet.getString(5);
			email = resultSet.getString(6);
			System.out.println(firstName + " " + lastName + " ->" + email);

			System.out.println("Moving cursor to the next row...");
			resultSet.next();

			firstName = resultSet.getString(4);
			lastName = resultSet.getString(5);
			email = resultSet.getString(6);
			System.out.println(firstName + " " + lastName + " ->" + email);

			System.out.println("Moving cursor to the previous row...");
			resultSet.previous();

			firstName = resultSet.getString(4);
			lastName = resultSet.getString(5);
			email = resultSet.getString(6);
			System.out.println(firstName + " " + lastName + " ->" + email);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
			}
		}
	}

	public static void allUpdationMethods() {

		Statement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/orms_integration", "root", "root");

			statement = connection.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			String query = "SELECT * FROM users";
			resultSet = statement.executeQuery(query);

			System.out.println("Moving cursor to the specific...");
			resultSet.absolute(10);

			String firstName = resultSet.getString(4);
			String lastName = resultSet.getString(5);
			String email = resultSet.getString(6);
			System.out.println(firstName + " " + lastName + " ->" + email);

			System.out.println("Updating the current row...");
			resultSet.updateString(4, "amol_in_pune");
			// resultSet.updateRow();
			firstName = resultSet.getString(4);
			System.out.println(firstName + " " + lastName + " ->" + email);

			System.out.println("Inserting the New Row...");

			resultSet.moveToInsertRow();

			resultSet.updateString(4, "ayaz");
			resultSet.updateString(5, "Shaikh");
			resultSet.updateString(6, "ayaz.shaikh@ei.com");

			// resultSet.insertRow();

			while (resultSet.next()) {
				if (resultSet.getString(4).equals("ayaz")) {
					firstName = resultSet.getString(4);
					lastName = resultSet.getString(5);
					email = resultSet.getString(6);
					System.out.println(firstName + " " + lastName + " ->"
							+ email);
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
			}
		}
	}
}