import java.util.ArrayList;
import java.util.Arrays;

public class IMDBFileServiceImpl implements IMDBFileService {

	private FileService fileService;

	public IMDBFileServiceImpl(FileService fileService) {

		this.fileService = fileService;
	}

	@Override
	public ArrayList<String> readMovieIdsFromFile(String filename) {

		return new ArrayList<String>(Arrays.asList(fileService.readFromFile(
				filename).split(System.getProperty("line.separator"))));
	}

	@Override
	public void writeMovieDataToFile(String filename, Movie movie) {

		fileService.writeToFile(filename, movie.toString());
	}

	@Override
	public void appendMovieDataToFile(String filename, Movie movie) {

		fileService.appendToFile(filename, movie.toString());
	}

	@Override
	public void clearFileContents(String filename) {

		fileService.clearFileContents(filename);

	}

}
