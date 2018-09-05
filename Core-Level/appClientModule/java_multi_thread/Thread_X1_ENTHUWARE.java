package java_multi_thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * This is the general logic of how the fork/join frame work is used:
 * 
 * 1. First check whether the task is small enough to be performed directly
 * without forking. If so, perform it without forking.
 * 
 * 2. If no, then split the task into multiple small tasks (at least 2) and
 * submit the subtasks back to the pool using invokeAll(list of tasks).
 * 
 * This is a standard way of using the Fork/Join framework. You create a
 * RecursiveTask or RecursiveAction (depending on where you need to return a
 * value or not) and in that RecursiveTask, you subdivide the task into two
 * equal parts. You then fork out one of the halfs and compute the second half.
 * 
 * 
 * 
 * 
 * 
 * Remember:
 * 
 * > There is no need to submit the sub tasks to the pool using the submit
 * method. Once you fork a subtask using the fork method, it is automatically
 * executed by the pool.
 * 
 * > There is a cost associated with forking a new task. If the cost of actually
 * finishing the task without forking new subtasks is less, then there is not
 * much benefit in breaking a task into smaller units. Therefore, a balance
 * needs to be reached where the cost of forking is less than direct
 * computation.
 * 
 * THRESHOLD determines that level. THRESHOLD value can be different for
 * different tasks. For example, for a simple sum of the numbers, you may keep
 * THRESHOLD high, but for say computing the sum of factorial of each numbers,
 * THRESHOLD may be low.
 * 
 * > The whole objective is to divide the task such that multiple threads can
 * compute it in parallel. Therefore, it is better if two sub tasks are equal in
 * terms of cost of computation, otherwise, one thread will finish earlier than
 * the other thereby reducing performance.
 * 
 * > An advantage of this framework is that it offers a portable means of
 * expressing a PARALLELIZABLE ALGORITHM without knowing in advance how much
 * parallelism the target system will offer.
 * 
 * 1. The number of threads is determined (by default) by number of CPU cores
 * available at run time.
 * 
 * 2. Since any task can be executed by any worker thread, the number of worker
 * threads need not have to be predetermined.
 * 
 * 
 * 
 * > ComplicatedTask newtask1 = new ComplicatedTask(ia, from, mid);
 *   ComplicatedTask newtask2 = new ComplicatedTask(ia, mid+1, to);
 * 
 * newtask1.fork();
 * 
 * Remember that fork() causes the sub-task to be submitted to the pool and
 * another thread can execute that task in parallel to the current thread.
 * 
 * newtask2.compute();
 * 
 * compute another subtask.
 * 
 * newtask1.join();
 * 
 * wait for another thread to finish
 */

// To understand ForkJoinPool in simple way
public class Thread_X1_ENTHUWARE {

	public static void main(String[] args) {
		int ia[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		ForkJoinPool fjp = new ForkJoinPool();
		ComplicatedTask st = new ComplicatedTask(ia, 0, 6);
		int sum = fjp.invoke(st);
		System.out.println("sum = " + sum);
	}
}

class ComplicatedTask extends RecursiveTask<Integer> {

	int[] ia;
	int from;
	int to;
	static final int THRESHOLD = 3;

	private static final long serialVersionUID = 1L;

	public ComplicatedTask(int[] ia, int from, int to) {
		this.ia = ia;
		this.from = from;
		this.to = to;
	}

	public int transform(int t) {
		// this can be a CPU intensive operation that       
		// transforms t and returns the value       
		// For now, just return t         
		return t;
	}

	protected Integer compute() {
		int sum = 0;
		if (from + THRESHOLD > to) {
			for (int i = from; i <= to; i++) {
				sum = sum + transform(ia[i]);
			}
		} else {
			int mid = (from + to) / 2;
			ComplicatedTask newtask1 = new ComplicatedTask(ia, from, mid);
			ComplicatedTask newtask2 = new ComplicatedTask(ia, mid + 1, to);
			newtask2.fork();
			sum = newtask1.compute() + newtask2.join();
		}
		return sum;
	}
}
