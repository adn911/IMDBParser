import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileService {

	public String readFromFile(String filename) {

		String fileData = "";
		BufferedReader reader = null;
		String currentLine;
		String homeDirectory = System.getProperty("user.home");

		try {

			reader = new BufferedReader(new FileReader( /* homeDirectory + "/" + */
			filename));

			while ((currentLine = reader.readLine()) != null) {

				fileData += currentLine + System.getProperty("line.separator");
			}

		} catch (Exception ex) {

		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return fileData;
	}

	public void clearFileContents(String filename) {

		writeToFile(filename, "");
	}

	public void writeToFile(String filename, String data) {

		PrintWriter writer = null;

		try {
			writer = new PrintWriter(filename);
			writer.write(data);

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (writer != null)
				writer.close();

		}

	}

	public void appendToFile(String filename, String data) {

		PrintWriter writer = null;

		try {
			writer = new PrintWriter(new BufferedWriter(new FileWriter(
					filename, true)));
			writer.append(data);

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (writer != null)
				writer.close();

		}

	}

}
