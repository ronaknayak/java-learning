package java_nio;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;

/*
 * http://javapapers.com/java/java-nio-tutorial/
 * http://tutorials.jenkov.com/java-nio/index.html
 * http://docs.oracle.com/javase/tutorial/essential/io/path.html
 */

/**
 * 
 * Constants provided by java.nio.file.StandardOpenOption:
 * 
 * StandardOpenOption gives you several ways of opening a file. You can mix and
 * match the options to achieve the desired objective.
 * 
 * Observe that some combinations such as CREATE and READ do not make sense if
 * put together and therefore an IllegalArgumentException will be thrown in such
 * cases.
 * 
 * JavaDoc API does not explicitly mention which combinations are invalid but it
 * many cases it is easy to spot an invalid combination. For example, if you
 * want to truncate a file, then you must open it with an option that allows
 * writing. Thus, READ and TRUNCATE_EXISTING (or WRITE, APPEND, or
 * DELETE_ON_CLOSE) cannot go together.  READ and SYNC (or DSYNC) cannot go
 * together either because when a file is opened for READ, there is nothing to
 * synch.
 * 
 * APPEND: If the file is opened for WRITE access then bytes will be written to
 * the end of the file rather than the beginning.
 * 
 * CREATE: Create a new file if it does not exist. CREATE option will cause the
 * file to be overwritten from the start of the file.
 * 
 * CREATE_NEW: Create a new file, it will cause an exception to be thrown if the
 * file already exists.
 * 
 * DELETE_ON_CLOSE: Delete on close but will throw
 * java.nio.file.NoSuchFileException if the file does not exist.
 * 
 * DSYNC: D in DSYNC is for data. When you open a file with this attribute, it
 * means that every update to the file's content will be written synchronously
 * to the underlying storage device. The meta data may still remain
 * unsynchronized.
 * 
 * In other words, any change in the data of the file will be written to the
 * storage device synchronously, but any change in the meta data may be batched
 * and written to the storage device later. Thus, it makes file operations a
 * slower as compared to when you open the file without any option.
 * 
 * READ: Open for read access.
 * 
 * SPARSE: Sparse file.
 * 
 * SYNC makes sure that both - the data and meta data are synchronized with the
 * storage device. Thus, it makes files operations even slower than DSYNC
 * option.
 * 
 * TRUNCATE_EXISTING: If the file already exists and it is opened for WRITE
 * access, then its length is truncated to 0.
 * 
 * WRITE: Open for write access & it will cause an exception to be thrown if the
 * file does not exist.
 */

public class NIOTestA {

	static void doTraverseDirectories() {

		/**
		 * > Two wild-card characters that are widely used are * and ?. Asterisk
		 * * stands for “any string of characters” and question mark ? stands
		 * for “any one character” (as opposed to zero or one in a REGEX).
		 * 
		 * 
		 * > java.nio.file.PathMatcher is an interface that declares only one
		 * method:
		 * 
		 * boolean matches(Path path) Tells if given path matches this matcher's
		 * pattern. Returns: true if, and only if, the path matches this
		 * matcher's pattern
		 * 
		 * 
		 * > If we use a single * (which means it won't cross directory
		 * boundaries) and the Path objects that we are checking contain the
		 * complete path including directories (such as c:\works\pathtest\a.java
		 * and not just a.java). Therefore, nothing will match. We should either
		 * get a path with just the last name using Path lastName =
		 * p.getFileName() or change the glob pattern to **.java.
		 */
		Path startDir = Paths.get("E:\\OCJP");

		// String pattern = "*.*";
		String pattern = "**.txt";
		// String pattern = "*.{txt,pdf}";
		// String pattern = "?.txt";
		// String pattern = "[a-f].txt";
		// String pattern = "*.{txt, java}";

		/**
		 * java.nio.file.FileSystem provides an interface to a file system and
		 * is the factory for objects to access files and other objects in the
		 * file system.
		 * 
		 * The default file system, obtained by invoking the
		 * FileSystems.getDefault method, provides access to the file system
		 * that is accessible to the Java virtual machine. The FileSystems class
		 * defines methods to create file systems that provide access to other
		 * types of (custom) file systems.
		 * 
		 * 
		 * A file system is the factory for several types of objects:
		 * 
		 * The getPath method converts a system dependent path string, returning
		 * a Path object that may be used to locate and access a file.
		 * 
		 * The getPathMatcher method is used to create a PathMatcher that
		 * performs match operations on paths.
		 * 
		 * The getFileStores method returns an iterator over the underlying
		 * file-stores.
		 * 
		 * The getUserPrincipalLookupService method returns the
		 * UserPrincipalLookupService to lookup users or groups by name.
		 * 
		 * The newWatchService method creates a WatchService that may be used to
		 * watch objects for changes and events.
		 */
		FileSystem fs = FileSystems.getDefault();
		final PathMatcher matcher = fs.getPathMatcher("glob:" + pattern);

		FileVisitor<Path> matchVisitor = new SimpleFileVisitor<Path>() {

			@Override
			public FileVisitResult preVisitDirectory(Path dir,
					BasicFileAttributes attrs) throws IOException {
				System.out.println("pre visit dir:" + dir);
				if (dir.endsWith("OCPJP Materials")) {
					System.out
							.println("#####################  STOP  ###########################");
					// return FileVisitResult.SKIP_SUBTREE;
					return FileVisitResult.SKIP_SIBLINGS;
				}
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFile(Path file,
					BasicFileAttributes attrs) throws IOException {
				System.out.println("visit file: " + file);
				/**
				 * Note(ENTHUWARE):
				 * 
				 * Observe that in the glob pattern, we have used a single *
				 * (which means it won't cross directory boundaries) and the
				 * Path objects that we are checking contain the complete path
				 * including directories (such as c:\works\pathtest\a.java and
				 * not just a.java).
				 * 
				 * Therefore, nothing will match. We should either get a path
				 * with just the last name using Path lastName = p.getFileName()
				 * or change the glob pattern to **.java.
				 */
				// Path path = file.getFileName();
				if (matcher.matches(file)) {
					System.out.println(file);
				}
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFileFailed(Path file, IOException exc)
					throws IOException {
				System.out.println("FILE SEARCH FAILED");
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc)
					throws IOException {
				System.out.println("post visit dir: " + dir);
				return FileVisitResult.CONTINUE;
			}
		};

		try {
			/**
			 * Note that Files.walkFileTree method will cause each sub=directory
			 * under the given directory to be traveled. For each file in each
			 * directory, the FileVisitor's visitFile will be invoked. This
			 * particular visitor simply tries to match the full file name with
			 * the given glob pattern.
			 */
			Files.walkFileTree(startDir, matchVisitor);
		} catch (IOException e) {
			System.out
					.println("Error while traversing a directory tree recursively "
							+ e);
		}
	}

	public static void main(String[] args) {

		showPathClassDetails();

		// doTraverseDirectories();

		// doPathOperations();
	}

	static void showPathClassDetails() {

		/**
		 * java.nio.file.InvalidPathException will be thrown when the argument
		 * passed while creating Path object is invalid. For example,
		 * "c:c:test.txt". The existence of the file is not checked at the time
		 * of creation of Path object.
		 * 
		 * Note that a real file is required in the file system when we have to
		 * operations, otherwise there will be an exception:
		 * java.nio.file.NoSuchFileException, a subclass of java.io.IOException.
		 */
		Path path = Paths.get(".", "test.txt");
		System.out.println("Relative path:	" + path + "\n"
				+ path.toAbsolutePath());

		path = Paths.get("E:\\SQL\\test.txt");
		System.out.println("Absolute path:	" + path);

		System.out.println("File Name:	" + path.getFileName());

		/**
		 * 1. Indices for path names start from 0. 2. Root (i.e. c:\) is not
		 * included in path names. 3. \ is NOT a part of a path name.
		 */
		System.out.println("Return path element:	" + path.getName(0));

		System.out.println(path.getNameCount());

		/**
		 * beginIndex, endIndex-1
		 * 
		 * Root (i.e. c:\) is not included in path names
		 * 
		 * paths do not start or end with \
		 */
		System.out.println("Sub-path:	" + path.subpath(0, 2));

		// Returns the parent path, or null if this path does not have a parent.
		System.out.println("Parent:	" + path.getParent());

		System.out.println("Root:	" + path.getRoot());

		path = Paths.get(".");
		System.out.println("Current directoty:	" + path.toAbsolutePath());
		System.out.println("Normalize the path:	"
				+ path.toAbsolutePath().normalize());

		path = Paths.get("..");
		System.out.println("parent directoty:	" + path.toAbsolutePath());
		System.out.println("Normalize the path:	"
				+ path.toAbsolutePath().normalize());

		/**
		 * If the argument to resolve starts with c:\\ or \\, the result will be
		 * the same as the argument. If the argument doesn't start with a \ and
		 * it doesn't start with a root such as c:, the output is the result on
		 * appending the argument to the path on which the method is invoked.
		 */
		Path path1 = Paths.get("C:\\Users\\Java\\examples");
		Path path2 = path1.resolve("\\test.sql");
		System.out.println("Join paths:	" + path2);

		/**
		 * Constructs a relative path between this path and a given path.
		 * 
		 * Note that if one path has a root (for example, if a path starts with
		 * a // or c: means absolute path) and the other does not, RELATIVIZE
		 * cannot work and it will throw an IllegalArgumentException.
		 */
		Path path3 = Paths.get("C:\\Users");
		Path path4 = Paths.get("C:\\Users\\Java\\examples");
		Path path3_to_path4 = path3.relativize(path4);
		System.out.println(path3_to_path4);

		Path path4_to_path3 = Paths.get("C:\\Users\\.\\Java\\..\\examples")
				.relativize(Paths.get("C:\\Users\\index.html"));
		System.out.println(path4_to_path3);

		/**
		 * Roots of the default file system.
		 */
		FileSystem fs = FileSystems.getDefault();
		Iterable<Path> sysRoots = fs.getRootDirectories();
		for (Path p : sysRoots) {
			System.out.println(p);
		}

		/**
		 * In other words, when we are trying to get the ABSOLUTE PATH for a
		 * file that exists in the same directory as the original file. The
		 * method resolveSibling is meant exactly for this purpose.
		 */
		Path p1 = Paths.get("E:\\SQl\\first.txt");
		Path p2 = p1.resolveSibling("second.txt");
		System.out.println(p2);
	}

	static void doPathOperations() {
		Path path = Paths.get("E:\\SQL\\sql\\java_io\\");

		/**
		 * LinkOption.NOFOLLOW_LINKS which means that the Files.exists() method
		 * should not follow symbolic links in the file system to determine if
		 * the path exists.
		 */
		boolean isExist = Files.exists(path,
				new LinkOption[] { LinkOption.NOFOLLOW_LINKS });
		System.out.println(isExist);

		isExist = Files.notExists(path,
				new LinkOption[] { LinkOption.NOFOLLOW_LINKS });
		System.out.println(isExist);

		/**
		 * If the directory already exists, a
		 * java.nio.file.FileAlreadyExistsException will be thrown.
		 */
		Path newPath = null;
		try {
			newPath = Files.createDirectory(path);
			System.out.println("Directory created: " + newPath);
		} catch (FileAlreadyExistsException e) {
			System.out.println("Error - Dir already exist");
		} catch (IOException e) {
			System.out.println("Error - while creating directory");
		}

		Path newFilePath = null;
		Path file = null;
		try {
			newFilePath = Paths.get(newPath.toString()).resolve("io.txt");
			System.out.println(newFilePath);
			file = Files.createFile(newFilePath);
		} catch (FileAlreadyExistsException e) {
			System.out.println("Error - File already exist");
		} catch (IOException e) {
			System.out.println("Error - while creating file");
		}

		// Checking file accessibility
		System.out.println("Is Readable? " + Files.isReadable(file));
		System.out.println("Is Executable? " + Files.isExecutable(file));
		System.out.println("Is Regular? "
				+ Files.isRegularFile(file,
						new LinkOption[] { LinkOption.NOFOLLOW_LINKS }));

		try {
			System.out.println("Is Hidden? " + Files.isHidden(file));
		} catch (IOException e2) {
		}

		System.out.println("Is Directory? "
				+ Files.isDirectory(file,
						new LinkOption[] { LinkOption.NOFOLLOW_LINKS }));
		System.out.println("Is Writable? " + Files.isWritable(file));

		/**
		 * Tests if two paths locate the same file.
		 * 
		 * If both Path objects are equal then this method returns true without
		 * checking if the file exists.
		 */
		try {
			System.out.println(file + "\n" + newFilePath);
			System.out.println("Is Samefile? "
					+ Files.isSameFile(file, newFilePath));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Path sourcePath = Paths.get("E:\\SQL\\sql\\java_copy_source\\io.txt");
		Path destinationPath = Paths
				.get("E:\\SQL\\sql\\java_copy__dest_path\\dest.txt");

		/**
		 * If the destination file already exists, a
		 * java.nio.file.FileAlreadyExistsException is thrown.
		 * 
		 * If destination file is not available then it'll be created.
		 * 
		 * This method copies a file to the target file with the options
		 * parameter specifying how the copy is performed. By default, the copy
		 * fails if the target file already exists or is a symbolic link.
		 * 
		 * REPLACE_EXISTING, COPY_ATTRIBUTES, NOFOLLOW_LINKS
		 */
		try {
			Path copiedPath = Files.copy(sourcePath, destinationPath,
					new CopyOption[] { StandardCopyOption.REPLACE_EXISTING,
							StandardCopyOption.COPY_ATTRIBUTES });
			System.out.println("copied:" + copiedPath);
		} catch (FileAlreadyExistsException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/**
		 * By default, this method attempts to move the file to the target file,
		 * failing if the target file exists except if the source and target are
		 * the same file, in which case this method has no effect.
		 * 
		 * REPLACE_EXISTING, ATOMIC_MOVE
		 */
		Path souPath = Paths.get("E:\\SQL\\sql\\java_io\\io.txt");
		Path destiPath = Paths.get("E:\\SQL\\sql\\java_move_path\\io.txt");
		try {
			Path movedPath = Files
					.move(souPath,
							destiPath,
							new StandardCopyOption[] { StandardCopyOption.REPLACE_EXISTING });
			System.out.println("moved:" + movedPath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// This method may be invoked to move or rename an empty directory.
		try {
			Path renamePath = Files.move(Paths.get("E:\\SQL\\sql\\java_io\\"),
					Paths.get("E:\\SQL\\sql\\java_mv_directory\\"),
					StandardCopyOption.REPLACE_EXISTING);
			System.out.println("rename:" + renamePath);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			/**
			 * Files.delete(souPath) throws java.nio.file.NoSuchFileException if
			 * one does not exist.
			 */
			// Files.delete(souPath);
			boolean isDeleted = Files.deleteIfExists(souPath);
			System.out.println("Is file deleted ? " + isDeleted);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("-------------END------------");

		showFileAttributes(destiPath);
	}

	static void showFileAttributes(Path path) {

		try {
			/**
			 * Get an instance of BasicFileAttributes by passing its class as
			 * argument using the method readAttributes.
			 */
			BasicFileAttributes attributes = Files.readAttributes(path,
					BasicFileAttributes.class,
					new LinkOption[] { LinkOption.NOFOLLOW_LINKS });

			System.out.println("Size: " + attributes.size());
			System.out
					.println("Is Regular file: " + attributes.isRegularFile());
			System.out.println("Is Directory: " + attributes.isDirectory());
			System.out.println("Is Symbolic Link: "
					+ attributes.isSymbolicLink());
			System.out.println("Other: " + attributes.isOther());

			FileTime newModifiedTime = FileTime.fromMillis(attributes
					.lastModifiedTime().toMillis() + 60000);
			Files.setLastModifiedTime(path, newModifiedTime);

			System.out.println("Last Moodified Time: "
					+ attributes.lastModifiedTime());
			System.out.println("Last access time: "
					+ attributes.lastAccessTime());
			System.out.println("Creation time: " + attributes.creationTime());
		} catch (IOException e) {
		}

		/**
		 * Get an instance of FileOwnerAttributeView by passing its class as
		 * argument using the method getFileAttributeView.
		 * 
		 * 
		 * Attributes supported by DosFileAttributeView (which extends
		 * BasicFileAttributeView) are:
		 * 
		 * READONLY, HIDDEN, SYSTEM, ARCHIVE
		 * 
		 * 
		 * 
		 * Get an instance of PosixFileAttributeView by passing its class as
		 * argument using the method getFileAttributeView.
		 * 
		 * Attributes supported by PosixFileAttributeView (which extends
		 * BasicFileAttributeView) are:
		 * 
		 * "permissions" : Set<PosixFilePermission> & "group" : GroupPrincipal
		 * 
		 * The permissions attribute is used to update the permissions, owner,
		 * or group-owner as by invoking the setPermissions, setOwner, and
		 * setGroup methods respectively.
		 */
		try {
			DosFileAttributes dos = Files.readAttributes(path,
					DosFileAttributes.class,
					new LinkOption[] { LinkOption.NOFOLLOW_LINKS });
			System.out.println("isReadOnly is " + dos.isReadOnly());
			System.out.println("isHidden is " + dos.isHidden());
			System.out.println("isArchive is " + dos.isArchive());
			System.out.println("isSystem is " + dos.isSystem() + "\n");
		} catch (IOException x) {
			System.err.println("DOS file" + " attributes not supported:" + x);
		}

		/**
		 * We can use the same NIO Files utility class and use method
		 * getFileAttributeView by passing argument FileOwnerAttributeView
		 * class.
		 * 
		 * Then we get the UserPrincipal using which we can get and set the file
		 * owner name.
		 */
		FileOwnerAttributeView fileOwnerAttributeView = Files
				.getFileAttributeView(path, FileOwnerAttributeView.class,
						new LinkOption[] { LinkOption.NOFOLLOW_LINKS });
		UserPrincipal userPrincipal = null;
		try {
			userPrincipal = fileOwnerAttributeView.getOwner();
			System.out.println("File Owner: " + userPrincipal.getName());
		} catch (IOException e) {
		}

		/**
		 * We can use NIO classes FileSystems and FileStore to get the space
		 * information.
		 */
		try {
			for (FileStore fileStore : FileSystems.getDefault().getFileStores()) {
				System.out.println("Name: " + fileStore.name());
				System.out.println("Type: " + fileStore.type());
				System.out.println("Total Space (MB): "
						+ fileStore.getTotalSpace() / 1024 / 1024);
				System.out.println("Unallocated Space (MB): "
						+ fileStore.getUnallocatedSpace() / 1024 / 1024);
				System.out.println("Usable Space (MB): "
						+ fileStore.getUsableSpace() / 1024 / 1024);
			}
		} catch (IOException i) {
		}
	}
}
