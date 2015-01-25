import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static final String INPUT_FILE = "movie-title.txt";
	public static final String OUTPUT_FILE = "movie-data.txt";

	public static void main(String[] args) throws Exception {

		IMDBFileService fileService = new IMDBFileServiceImpl(new FileService());

		fileService.clearFileContents(OUTPUT_FILE);

		ArrayList<String> movieIdList = fileService
				.readMovieIdsFromFile(INPUT_FILE);

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		MovieInfoParser parser = new IMDBMovieInfoParser();

		for (String id : movieIdList) {
			// new Thread(new IMDBHttpService(id)).start();
			executorService.execute(new IMDBHttpService(id));
		}

		executorService.shutdown();
		executorService.awaitTermination(60, TimeUnit.SECONDS);
		
		System.out.println("Finished Successfully..");

	}

	public static void onDataReceived(String data) {

		IMDBFileService fileService = new IMDBFileServiceImpl(new FileService());

		MovieInfoParser movieParser = new IMDBMovieInfoParser();

		Movie movie = movieParser.parseMovie(data);

		fileService.appendMovieDataToFile(OUTPUT_FILE, movie);

		System.out.println(movie);
	}

	
}
