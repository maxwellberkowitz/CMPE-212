import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Experiment {
	
	public static double[] dArray(int size) {
		double[] array = new double[size];
		for(int i = 0; i < size; i++)
			array[i] = Math.random();
		return array;
	}
	
	public static long getSize(String filename) {
		Path file = Paths.get(filename);
		long filesize = 0;
		try {
			filesize = Files.size(file);
		} catch (IOException e) {
			System.out.println("I/O Exception:" + e);
		}
		return filesize;
	}

	public static void displayResults (String filename, long runTimeNanoseconds) {
        System.out.printf("\n%-34s", filename);
        System.out.printf("%8d bytes, saved in:", getSize(filename.trim()));
        System.out.printf("%7.2f milliseconds.\n", runTimeNanoseconds * 1e-6);
	}
	
	public static void textFileWriter(String filename, double[] array) {
		Path file = Paths.get(filename);
		try (BufferedWriter writer = Files.newBufferedWriter(file)){
			for(double aVal : array)
				writer.write(aVal + "\r\n");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void binaryFileWriter(String filename, double[] array) {
		Path file = Paths.get(filename);
		try (ObjectOutputStream binFileOut = new ObjectOutputStream(new BufferedOutputStream(
						new FileOutputStream(file.toFile()))) ){
			for(double e : array)
				binFileOut.writeDouble(e);
		} catch(FileNotFoundException err) {
			System.out.println(err.getMessage());
		} catch (IOException err) {
			System.out.println(err.getMessage());
		}
	}
	
	public static void randomAccessBinaryOutput(String filename, double array[]) {
		ByteBuffer buff = ByteBuffer.allocate(8*array.length);
		DoubleBuffer dBuff = buff.asDoubleBuffer();
		for (double val : array)
			dBuff.put(val);
		Path file = Paths.get(filename);
		long bytesWritten;
		StandardOpenOption readOpt = StandardOpenOption.READ;
		StandardOpenOption writeOpt = StandardOpenOption.WRITE;
		StandardOpenOption createOpt = StandardOpenOption.CREATE;
		try(FileChannel fc = FileChannel.open(file, readOpt, createOpt, writeOpt)){
			fc.position(0);
			bytesWritten = fc.write(buff);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
        // Using random file access, Java 7
        int numNums = 10000;		// The size of the array
        long startTime, runTime;	// Used to time the execution
        String filename;			// The name of the file
        double[] testArray = dArray(numNums);
		
        // Plain text
        filename = "TextFileBufferedWriter.txt";
        startTime = System.nanoTime();
        textFileWriter(filename, testArray);
        runTime = System.nanoTime() - startTime;
        displayResults(filename, runTime);
        
        filename = "BinaryObjectOutputStreamArray.dat";
        startTime = System.nanoTime();
        binaryFileWriter(filename, testArray);
        runTime = System.nanoTime() - startTime;
        displayResults(filename, runTime);
        
		filename = "BinaryRandomAccessFileJava7.dat";
        startTime = System.nanoTime();
        randomAccessBinaryOutput(filename, testArray);
        runTime = System.nanoTime() - startTime;
        displayResults(filename, runTime);
	}

}
