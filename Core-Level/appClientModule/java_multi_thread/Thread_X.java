package java_multi_thread;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * Fork-Join Framework:
 * ---------------------------------------------------------------------------
 * 
 * 
 * The effective use of parallel cores in a Java program has always been a
 * challenge. There were few home-grown frameworks that would distribute the
 * work across multiple cores and then join them to return the result set.
 * 
 * The ForkJoinPool is similar to the Java ExecutorService but with one
 * difference. The ForkJoinPool makes it easy for tasks to split their work up
 * into smaller tasks which are then submitted to the ForkJoinPool too.
 * 
 * Tasks can keep splitting their work into smaller subtasks for as long as it
 * makes to split up the task.
 * 
 * 
 * The fork and join principle consists of two steps which are performed
 * recursively. These two steps are the fork(split) step and the join step.
 * 
 * 
 * FORK:
 * 
 * By splitting itself up into subtasks, each subtask can be executed in
 * parallel by different CPUs, or different threads on the same CPU.
 * 
 * A task only splits itself up into subtasks if the work the task was given is
 * large enough for this to make sense.
 * 
 * The limit for when it makes sense to fork a task into subtasks is also called
 * a THRESHOLD. It is up to each task to decide on a sensible threshold. It
 * depends very much on the kind of work being done.
 * 
 * JOIN:
 * 
 * When a task has split itself up into subtasks, the task waits until the
 * subtasks have finished executing.
 * 
 * Once the subtasks have finished executing, the task may join (merge) all the
 * results into one result.
 * 
 * 
 * ForkJoinPool class:
 * 
 * The ForkJoinPool class is a special thread pool which is designed to work
 * well with fork-and-join task splitting. The ForkJoinPool located in the
 * java.util.concurrent package.
 * 
 * ForkJoinPool forkJoinPool = new ForkJoinPool(4);
 * 
 * As a parameter to the ForkJoinPool constructor you pass the indicated level
 * of parallelism you desire. The parallelism level indicates how many threads
 * or CPUs you want to work concurrently on on tasks passed to the ForkJoinPool.
 * 
 * Although you specify any initial pool size, the pool adjusts its size
 * dynamically in an attempt to maintain enough active threads at any given
 * point in time. Another important difference compared to other
 * ExecutorService's is that this pool need not be explicitly shutdown upon
 * program exit because all its threads are in daemon mode.
 * 
 * You submit tasks to a ForkJoinPool similarly to how you submit tasks to an
 * ExecutorService. You can submit two types of tasks.
 * 
 * NOTE: If you use a no-argument constructor, by default, it creates a pool of
 * size that equals the number of available processors obtained using some
 * technique.
 * 
 * 
 * 
 * 
 * ForkJoinTask class:
 * ---------------------------------------------------------------------------
 * This is an abstract class for creating tasks that run within a ForkJoinPool.
 * The RecursiveAction and RecursiveTask are the only two direct, known
 * subclasses of ForkJoinTask.
 * 
 * A task that does not return any result (an "action"), and a task which does
 * return a result (a "task"). These two types of tasks are represented by the
 * RecursiveAction and RecursiveTask classes respectively.
 * 
 * 
 * RecursiveAction:
 * 
 * A RecursiveAction is a task which does not return any value. It just does
 * some work, e.g. writing data to disk, and then exits.
 * 
 * A RecursiveAction may still need to break up its work into smaller chunks
 * which can be executed by independent threads or CPUs.
 * 
 * RecursiveTask:
 * 
 * A RecursiveTask is a task that returns a result. It may split its work up
 * into smaller tasks, and merge the result of these smaller tasks into a
 * collective result. The splitting and merging may take place on several
 * levels.
 * 
 * 
 * > Difference between Fork/Join Framework And ExecutorService
 * 
 * The main difference between the Fork/Join and the Executor frameworks is the
 * WORK-STEALING ALGORITHM.
 * 
 * Unlike the Executor framework, when a task is waiting for the finalization of
 * the sub-tasks it has created using the join operation, the thread that is
 * executing that task (called worker thread ) looks for other tasks that have
 * not been executed yet and begins its execution.
 * 
 * By this way, the threads take full advantage of their running time, thereby
 * improving the performance of the application.
 * 
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * The standard way of using the Fork/Join framework. You create a RecursiveTask
 * or RecursiveAction (depending on where you need to return a value or not) and
 * in that RecursiveTask, you subdivide the task into two equal parts. You then
 * fork out one of the half and compute the second half.
 */

public class Thread_X {
	public static void main(String[] args) {

		ForkJoinPool pool = new ForkJoinPool();

		// Create three FolderProcessor tasks. Initialize each one with a
		// different folder path.
		FolderProcessor system = new FolderProcessor("E:\\Cisco_IPICS", "pdf");
		FolderProcessor apps = new FolderProcessor("E:\\Cisco_IPICS", "txt");
		FolderProcessor documents = new FolderProcessor("E:\\Cisco_IPICS",
				"doc");

		// Execute the three tasks in the pool using the execute() method.
		pool.execute(system);
		pool.execute(apps);
		pool.execute(documents);

		// Write to the console information about the status of the pool every
		// second
		// until the three tasks have finished their execution.
		do {
			System.out.printf("******************************************\n");
			System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
			System.out.printf("Main: Active Threads: %d\n",
					pool.getActiveThreadCount());
			System.out.printf("Main: Task Count: %d\n",
					pool.getQueuedTaskCount());
			System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
			System.out.printf("******************************************\n");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while ((!system.isDone()) || (!apps.isDone())
				|| (!documents.isDone()));

		// Shut down ForkJoinPool using the shutdown() method.
		pool.shutdown();

		// Write the number of results generated by each task to the console.
		List<String> results = new ArrayList<String>();
		results = system.join();
		System.out.printf("System: %d files found.\n", results.size());
		results = apps.join();
		System.out.printf("Apps: %d files found.\n", results.size());
		results = documents.join();
		System.out.printf("Documents: %d files found.\n", results.size());
	}
}

class FolderProcessor extends RecursiveTask<List<String>> {

	private static final long serialVersionUID = 1L;

	// This attribute will store the full path of the folder this task is going
	// to process.
	private String path = null;

	// This attribute will store the name of the extension of the files this
	// task is going to look for.
	private String extension = null;

	// Implement the constructor of the class to initialize its attributes
	public FolderProcessor(String path, String extension) {
		this.path = path;
		this.extension = extension;
	}

	@Override
	protected List<String> compute() {

		// List to store the names of the files stored in the folder.
		List<String> list = new ArrayList<String>();

		// FolderProcessor tasks to store the subtasks that are going to process
		// the sub-folders stored in the folder
		List<FolderProcessor> tasks = new ArrayList<FolderProcessor>();

		// Get the content of the folder.
		File file = new File(path);
		File content[] = file.listFiles();

		// For each element in the folder, if there is a sub-folder, create a
		// new FolderProcessor object and execute it asynchronously using the
		// fork() method.
		if (content != null) {

			for (int iCount = 0; iCount < content.length; iCount++) {

				if (content[iCount].isDirectory()) {
					FolderProcessor task = new FolderProcessor(
							content[iCount].getAbsolutePath(), extension);
					task.fork();
					tasks.add(task);
				}

				// Otherwise, compare the extension of the file with the
				// extension you
				// are looking for using the checkFile() method
				// and, if they are equal, store the full path of the file in
				// the list
				// of strings declared earlier.
				else {
					if (checkFile(content[iCount].getName())) {
						list.add(content[iCount].getAbsolutePath());
					}
				}
			}

			// If the list of the FolderProcessor subtasks has more than 50
			// elements,
			// write a message to the console to indicate this circumstance.
			if (tasks.size() > 50) {
				System.out.printf("%s: %d tasks ran.\n",
						file.getAbsolutePath(), tasks.size());
			}

			// add to the list of files the results returned by the subtasks
			// launched by this task.
			addResultsFromTasks(list, tasks);
			// Return the list of strings
			return list;
		}

		return null;
	}

	// For each task stored in the list of tasks, call the join() method that
	// will wait for its finalization and then will return the result of the
	// task.
	// Add that result to the list of strings using the addAll() method.
	private void addResultsFromTasks(List<String> list,
			List<FolderProcessor> tasks) {
		for (FolderProcessor item : tasks) {
			list.addAll(item.join());
		}
	}

	// This method compares if the name of a file passed as a parameter ends
	// with the extension you are looking for.
	private boolean checkFile(String name) {
		return name.endsWith(extension);
	}
}