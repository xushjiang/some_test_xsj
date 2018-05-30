package xu.sheng.jiang.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class FileTest {

	/**
	 * 返回文件的大小
	 * 
	 * @param file
	 * @return
	 */
	public static long getFileSize(File file) {

		if (file.isFile()) {// 如果目标是文件，返回文件大小
			return file.length();
		}

		File[] childFiles = file.listFiles();// 读取文件夹下的所有文件或文件夹
		long size = 0;

		for (File childFile : childFiles) {// 遍历所有的文件夹或者文件
			size += getFileSize(childFile);
		}
		return size;
	}

	private final static ForkJoinPool forkJoinPool = new ForkJoinPool();
	private static class FileSizeFinder extends RecursiveTask<Long> {


		final File file;

		public FileSizeFinder(final File theFile) {
			file = theFile;
		}

		@Override
		public Long compute() {

			long size = 0;
			if (file.isFile()) {
				size = file.length();
			} else {
				final File[] children = file.listFiles();
				if (children != null) {
					List<ForkJoinTask<Long>> tasks = new ArrayList<ForkJoinTask<Long>>();
					for (final File child : children) {
						if (child.isFile()) {
							size += child.length();
						} else {
							tasks.add(new FileSizeFinder(child));
						}
					}
					for (final ForkJoinTask<Long> task : invokeAll(tasks)) {
						size += task.join();
					}
				}
			}
			return size;
		}
	}

	public static void createFile() throws Exception {

		String str = "E:\\filePath1\\filePath2\\a.text";
		File file = new File(str);
		if (!file.exists()) {
			file.getParentFile().mkdirs();
		}
	}

	public static void main(String[] args) {

		String filePath = "E://WorkSpace4";
		File file = new File(filePath);
		final long start = System.nanoTime();
		long size = getFileSize(file);
		final long end = System.nanoTime();
		System.out.println(size);
		System.out.println("Time taken: " + (end - start) / 1.0e9);

	}

}
