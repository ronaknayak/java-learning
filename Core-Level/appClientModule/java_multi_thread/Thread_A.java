package java_multi_thread;

/**
 * Introduction:
 * 
 * Multitasking: Executing several tasks simultaneously is the core concept of
 * multitasking.
 * 
 * There are two types of multitasking.
 * 
 * 1. Process-based multitasking:
 * 
 * Executing several tasks simultaneously, where each task is a separate
 * independent program(process) is called process based multitasking.
 * 
 * Process-based multitasking is best suitable for OS level.
 * 
 * 2. Thread-based multitasking:
 * 
 * Executing several tasks simultaneously where each task is a separate
 * independent part of the same program is called thread-based multitasking and
 * each independent part is called Thread or a single flow of execution is
 * called Thread or a separate independent job is called Thread.
 * 
 * It is best suitable for programmatic level when there is NO DEPENDENCY
 * between two threads i.e.two tasks.
 * 
 * Threads are independent because they all have separate path of execution
 * that’s the reason if an exception occurs in one thread, it doesn’t affect the
 * execution of other threads.
 * 
 * The main purpose of multi-threading is to provide simultaneous execution of
 * two or more parts of a program to maximum utilize the CPU time. A multi
 * threaded program contains two or more parts that can run concurrently. Each
 * such part of a program called thread.
 * 
 * The main important application areas of multi-threading are to develop
 * multi-media graphics,to develop video games, to develop animations, to
 * develop web servers and application servers etc.
 * 
 * When compared with the old languages developing multi-threaded application in
 * java is very easy because java provides in-built support for multi-threading
 * with Rich API(Thread, Runnable, ThreadGroup).
 * 
 * 
 * Summary:
 * 
 * A thread of execution can be thought of as a CPU executing the program. When
 * you have MULTIPLE threads executing the same program, It's like having
 * MULTIPLE CPUs execute the same program.
 * 
 * Modern computers, come with MULTIPLE core CPUs and even with MULTIPLE CPU.
 * This means that separate threads can be executed by separate threads can be
 * executed by separate cores or CPUs simultaneously.
 */
public class Thread_A {

}
