package java_oops;

/**
 * Data Access Object Pattern:
 * -----------------------------------------------------------------------------
 * Data Access Object pattern abstracts the data storage and provides a uniform
 * way to access the data. This is very useful in situations when the data
 * storage may change like from file-based to LDAP to relational database and so
 * forth.
 * 
 * The basic idea of the DAO pattern is that the code required to create, read,
 * update, and delete (CRUD) an object from a data store is separated out from
 * the object itself. The benefit of doing this is that your data access code
 * may be changed later depending on data store but that does not affect the
 * entity object itself.
 * 
 * The clients talk only to DAO. Thus, the DAO shields the clients from the
 * database.
 * 
 * The persistent data storage may have to be changed later. i.e.When the
 * database changes, only the DAOs need to be changed.
 * 
 * e.g. StudentDAO class, which knows how to interact with a database and
 * implement the CRUD methods. The Student class itself will have no idea about
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * > The DAO pattern takes away the responsibility of persisting domain object
 * from business objects and let them focus just on implementing the business
 * logic. The responsibility of persisting domain objects is fulfilled by the
 * DAO, which doesn't care about the business logic. Thus, this pattern allows
 * each part to focus as a SINGLE RESPONSIBILITY PRINCIPLE.
 * 
 * 
 * > The DAO implements the access mechanism required to work with the data
 * source. The data source could be a persistent store like an RDBMS, an
 * external service like a B2B exchange, a repository like an LDAP database, or
 * a business service accessed via CORBA Internet Inter-ORB Protocol (IIOP) or
 * low-level sockets.
 * 
 * The business component that relies on the DAO uses the simpler interface
 * exposed by the DAO for its clients. The DAO completely hides the data source
 * implementation details from its clients. Because the interface exposed by the
 * DAO to clients does not change when the underlying data source implementation
 * changes, this pattern allows the DAO to adapt to different storage schemes
 * without affecting its clients or business components. Essentially, the DAO
 * acts as an adapter between the component and the data source.
 * 
 * > Domain classes do not worry about the code that interacts with the database
 * to load and store Student instance. It allows domain classes to focus on
 * domain logic instead of database access logic.
 * 
 * 
 * 
 * Composite Design Pattern:
 * -----------------------------------------------------------------------------
 * http://www.javatpoint.com/composite-pattern
 * 
 * “Compose objects into tree structure to represent part-whole hierarchies.
 * Composite lets client treat individual objects and compositions of objects
 * uniformly.”
 * 
 * In this pattern the client uses the component interface to interact with
 * objects which are part of the composition. You can imagine the composite
 * hierarchy as a tree where there are leaves and composites, and the requests
 * are sent through this tree.
 * 
 * If the recipient of the call is a leaf then the request is handled directly
 * in this leaf. If the recipient is a composite then this composite forwards
 * the requests to its children, alternatively this composite can perform
 * additional operations before and after forwarding.
 */

public class Demo_N {

}