package java_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**
 * FilteredRowSet(I):
 * 
 * It is child interface of WebRowSet(which in turn child interface of
 * CachedRowSet).
 * 
 * A FilteredRowSet object lets you cut down the number of rows that are visible
 * in a RowSet object without persistent connection to the database so that you
 * can work with only the data that is relevant to what you are doing.
 * 
 * A FilteredRowSet object provides a way for a disconnected RowSet object to do
 * this filtering without having to execute a query on the data source, thus
 * avoiding having to get a connection to the data source and sending queries to
 * it.
 * 
 * Thus, Filtered RowSet has capabilities,
 * 
 * > To select which data is visible without being connected to the data source.
 * > To limit the rows that are visible according to set criteria.
 * 
 * 
 * 
 * WebRowSet(I):
 * 
 * It's child interface of CachedRowSet interface.
 * 
 * A WebRowSet object is very special because in addition to offering all of the
 * capabilities of a CachedRowSet object, it can write itself as an XML document
 * and can also read that XML document to convert itself back to a WebRowSet
 * object.
 * 
 * Because XML is the language through which disparate enterprises can
 * communicate with each other, it has become the standard for Web Services
 * communication.
 * 
 * As a consequence, a WebRowSet object fills a real need by enabling Web
 * Services to send and receive data from a database in the form of an XML
 * document.
 */

public class Jdbc_F {
	public static void main(String[] args) throws SQLException {
		DBManager dbManager = new DBManager("root", "root");
		Connection connection = dbManager.getConnection();

		RowSetFactory rowSetFactory = RowSetProvider.newFactory();
		FilteredRowSet filteredRowSet = rowSetFactory.createFilteredRowSet();
		filteredRowSet.setCommand("SELECT * FROM users");
		filteredRowSet.execute(connection);

		filteredRowSet.setFilter(new SearchFilter(51, 60, 1));
		retrieveData(filteredRowSet);
	}

	public static void retrieveData(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			System.out.println(resultSet.getString("mail"));
		}
	}
}

class SearchFilter implements Predicate {

	private int low;
	private int high;
	private int colNumber;
	private String colName;

	public SearchFilter(int low, int high, int colNumber) {
		super();
		this.low = low;
		this.high = high;
		this.colNumber = colNumber;
	}

	public SearchFilter(int low, int high, String colName) {
		super();
		this.low = low;
		this.high = high;
		this.colName = colName;
	}

	@Override
	public boolean evaluate(RowSet rs) {
		System.out.println("evaluate RowSet");
		CachedRowSet frs = (CachedRowSet) rs;
		boolean evaluation = false;

		try {
			int columnValue = -1;

			if (this.colNumber > 0) {
				columnValue = frs.getInt(this.colNumber);
			} else if (this.colName != null) {
				columnValue = frs.getInt(this.colName);
			} else {
				return false;
			}

			if ((columnValue >= this.low) && (columnValue <= this.high)) {
				evaluation = true;
			}
		} catch (SQLException e) {
			return false;
		} catch (NullPointerException npe) {
			System.err.println("NullPointerException caught");
			return false;
		}
		return evaluation;
	}

	@Override
	public boolean evaluate(Object value, int column) throws SQLException {

		System.out.println("In evaluate column number");
		boolean evaluation = true;

		if (this.colNumber == column) {
			int columnValue = ((Integer) value).intValue();
			if ((columnValue >= this.low) && (columnValue <= this.high)) {
				evaluation = true;
			} else {
				evaluation = false;
			}
		}
		return evaluation;
	}

	@Override
	public boolean evaluate(Object value, String columnName)
			throws SQLException {

		System.out.println("In evaluate column name");
		boolean evaluation = true;
		if (columnName.equalsIgnoreCase(this.colName)) {
			int columnValue = ((Integer) value).intValue();
			if ((columnValue >= this.low) && (columnValue <= this.high)) {
				evaluation = true;
			} else {
				evaluation = false;
			}
		}
		return evaluation;
	}

}