package java_nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * WatchService has two types of methods for retrieving the WatchKeys - poll and
 * take. The two poll methods return null if no key is present and it does not
 * wait for ever. The take method doesn't return null but keeps waiting until a
 * key is available.
 * 
 * 
 * WatchKey take() throws InterruptedException
 * 
 * Retrieves and removes next watch key, waiting if none are yet present. Notice
 * that this method does not take any parameter. So it waits until a key becomes
 * available (or until the WatchService is closed, in which case the method
 * throws ClosedWatchServiceException). If you want to wait for a specified
 * time, you should use the poll method.
 * 
 * 
 * WatchKey poll(long timeout, TimeUnit unit) throws InterruptedException
 * 
 * Retrieves and removes the next watch key, waiting if necessary up to the
 * specified wait time if none are yet present.
 * 
 * 
 * WatchKey poll(): Retrieves and removes the next watch key, or null if none
 * are present.
 */
public class NIOTestB {
	public static void main(String[] args) {

		// doChannelReadWrite();

		try {
			getWatchService();
		} catch (IOException e) {
			System.err.println("Error occured while invoking watch service");
		}
	}

	static void doChannelReadWrite() {

		try {
			RandomAccessFile file = new RandomAccessFile("store.txt", "rw");

			FileChannel channel = file.getChannel();

			ByteBuffer byteBuffer = ByteBuffer.allocate(512);

			// Then the buffer can be read into.
			int bytesRead = channel.read(byteBuffer, 100);

			while (bytesRead != -1) {

				System.out.println("Read " + bytesRead);

				// flip the buffer to prepare for get operation
				byteBuffer.flip();

				while (byteBuffer.hasRemaining()) {
					// Then read from the buffer.
					System.out.print((char) byteBuffer.get());
				}
				// clear the buffer ready for next sequence of read
				byteBuffer.clear();

				// Then the buffer can be read into.
				bytesRead = channel.read(byteBuffer);
			}
			file.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	static void getWatchService() throws IOException {

		WatchService watchService = null;
		try {
			watchService = FileSystems.getDefault().newWatchService();

			Path path = Paths.get("E:\\SQL\\");

			WatchKey watchKey = path.register(watchService,
					StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_MODIFY,
					StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.OVERFLOW);
			System.out.println("Watch service registered dir: "
					+ path.toString());

			while (true) {

				WatchKey queuedKey;
				try {
					System.out.println("Waiting for key to be signalled...");
					queuedKey = watchService.poll(2, TimeUnit.MINUTES);
				} catch (Exception e) {
					System.err.println("Problem in signalling");
					return;
				}

				List<WatchEvent<?>> events = queuedKey.pollEvents();
				System.out.println("Process the pending events for the key: "
						+ events.size());

				for (WatchEvent<?> event : events) {
					WatchEvent.Kind<?> eventKind = event.kind();
					System.out.println("Event kind: " + eventKind);

					WatchEvent pathEvent = event;
					Path file = (Path) pathEvent.context();
					System.out.println("File name: " + file.toString());

					boolean isValidKey = queuedKey.reset();
					System.out.println("Key reset");

					if (!isValidKey) {
						System.out.println("Invalid key");
						break;
					}
				}
			}
		} catch (IOException e) {
			System.err.println("Error occured");
		}

		watchService.close();
		System.out.println("Watch Service closed");
	}
}
