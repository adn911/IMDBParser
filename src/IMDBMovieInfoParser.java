import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IMDBMovieInfoParser implements MovieInfoParser {

	private static final String TITLE_PATTERN = "<title>(.*)</title>";
	private static final String DURATION_PATTERN = "<time itemprop=\"duration\".*>(.*)</time>";
	private static final String RATING_PATTERN = "<span itemprop=\"ratingValue\">(.*?)</span>";
	private static final String TOTAL_VOTES_PATTERN = "<span itemprop=\"ratingCount\">(.*)</span>";
	private static final String GENRE_PATTERN = "<span class=\"itemprop\" itemprop=\"genre\">(.*)</span>";

	

	@Override
	public Movie parseMovie(String data) {

		String name = parseName(data);
		String year = parseYear(data);
		String rating = parseRating(data);
		String duration = parseDuration(data);
		String totalVotes = parseTotalVotes(data);
		String genre = parseGenre(data);

		return new Movie(name, year, duration, rating, totalVotes, genre);
	}
	
	private String parseName(String source) {

		return parsePatternSingle(source, TITLE_PATTERN).split("\\(")[0];
	}

	private String parseYear(String source) {

		return parsePatternSingle(source, TITLE_PATTERN).split("\\(")[1]
				.split("\\)")[0];
	}

	private String parseDuration(String source) {

		return parsePatternSingle(source, DURATION_PATTERN);
	}

	private String parseRating(String source) {

		return parsePatternSingle(source, RATING_PATTERN);
	}

	private String parseTotalVotes(String source) {

		return parsePatternSingle(source, TOTAL_VOTES_PATTERN);
	}

	private String parseGenre(String source) {

		return parsePatternMultiple(source, GENRE_PATTERN);
	}

	private static String parsePatternSingle(String source, String pattern) {

		String returnString = "";

		Pattern r = Pattern.compile(pattern);

		Matcher m = r.matcher(source);

		if (m.find()) {
			returnString = m.group(1);
		}

		return returnString;
	}

	public static String parsePatternMultiple(String source, String pattern) {

		String returnString = "";

		Pattern r = Pattern.compile(pattern);

		Matcher m = r.matcher(source);

		while (m.find()) {
			returnString += m.group(1) + ", ";
		}

		return returnString;
	}

}
