import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

public class IMDBHttpService implements HttpService, Runnable {

	String url = "http://www.imdb.com/title/";
	String movieId;

	public IMDBHttpService(String movieId) {
		this.movieId = movieId;
	}

	@Override
	public synchronized String  execute() throws Exception {

		url = url + movieId;

		HttpURLConnection con = (HttpURLConnection) new URL(url)
				.openConnection();

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));

		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine + "\n");
		}
		in.close();

		return response.toString();
	}

	@Override
	public void run() {
		try {
			String response = execute();
			Main.onDataReceived(response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}