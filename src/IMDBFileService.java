import java.util.ArrayList;

public interface IMDBFileService {

	public ArrayList<String> readMovieIdsFromFile(String filename);

	public void writeMovieDataToFile(String filename, Movie movie);

	public void appendMovieDataToFile(String filename, Movie movie);
	
	public void clearFileContents(String filename);

}