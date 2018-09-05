package java_jdbc;

/**
 * In web application there would be:
 * 
 * 1) Presentation logic 2) Request data gathering logic 3) Validation logic 4)
 * Business logic
 * 
 * The logic we need to implement to perform database related operations is,
 * 5)Persistence logic
 * 
 * 6) session management logic
 * 
 * JDBC API is used to write persistence logic.
 * 
 * 
 * JDBC architecture:
 * ----------------------------------------------------------------------------
 * > Application layer
 * 
 * > Database layer
 * 
 * JDBC API is part of application layer and JDBC driver classes are part of
 * database layer.
 * 
 * From our application by using JDBC API if we want to talk with any database
 * then we require that database relevant driver.
 * 
 * So, when our java application submit any data , JDBC API will take that data
 * and pass that data to the driver classes, driver classes will pass to the
 * database (by converting database understandable SQL statement) then database
 * will give response to the driver classes and same response driver classes
 * will forward to JDBC API (after converting that data into Java understandable
 * format).
 * 
 * *****************************************************************************
 * 
 * Types of drivers:
 * 
 * JDBC driver is used to convert Java statements into database understandable
 * SQL statement. Because as our database understands only SQL language.
 * 
 * Earlier, we were using ODBC API which provides ODBC driver to connect with
 * any database. But, the problem was it written in C language. So, to overcome
 * that platform dependency JDBC comes in picture.
 * 
 * 1.JDBC-ODBC bridge driver:
 * 
 * -> when our java application submit any data , JDBC API will take that data
 * and pass that data to the JDBC-ODBC bridge driver, It converts java
 * statements into ODBC calls (Before that we have to create ODBC specific DSN
 * name which is considered as ODBC application in our system. It's for specific
 * database so that ODBC know which database being converted) and that ODBC
 * calls converted into corresponding database calls.
 * 
 * This is now discouraged because of thin driver.
 * 
 * Down-sides:
 * 
 * If we use this type of driver then we must set ODBC application along with
 * our java application and database. Generally, MICROSOFT windows OS provides
 * ODBC application internally along with our OS installation.
 * 
 * It's useful when our java application,database and ODBC application exists in
 * only one machine. So, it's useful for only STANDALONE application because The
 * ODBC driver needs to be installed on the client machine.
 * 
 * 
 * 2.Native-API driver:
 * 
 * -> When our java application submit any data , JDBC will take that data and
 * pass that data to the driver classes where JDBC API calls are converted into
 * native C/C++ API calls by using database native API library, and which are
 * unique to the database.
 * 
 * It's useful for STANDALONE and web application as well.
 * 
 * Down-sides:
 * 
 * The Native driver needs to be installed on the each client machine.
 * 
 * The Database Vendor specific native API library needs to be installed on
 * client machine.
 * 
 * If we change the Database, we have to change the native API, as it is
 * specific to a database.
 * 
 * 
 * 3.Network protocol java driver:
 * 
 * -> when our java application submit any data , JDBC will take that data and
 * pass that data to the database application server and for that our java
 * application requires that database application server jar file.
 * 
 * Later, database application server take that call and pass to the database
 * and for that database application server also requires database vendor
 * specific file.
 * 
 * It's useful for STANDALONE and web application as well.
 * 
 * Down-sides:
 * 
 * We compulsory requires third party support i.e. we have to maintain network.
 * 
 * We may have to write some piece of the code in database application server.
 * 
 * 
 * 4.pure java driver(thin driver):
 * 
 * when our java application submit any data , JDBC will directly talk to the
 * database. By using some protocol and same way database gives response by
 * using that protocol. For that we just requires database vendor specific jar
 * file.
 * 
 * It's recommended for enterprise application.
 * 
 * It's useful for STANDALONE and web application as well.
 * 
 * Down-sides: It's specific to database.
 */

public class Jdbc_A {

}
