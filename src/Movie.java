public class Movie {

	private String name;
	private String year;
	private String duration;
	private String rating;
	private String totalVotes;
	private String genre;

	
	public Movie(String name, String year, String duration, String rating,
			String totalVotes, String genre) {
		
		this.name = name;
		this.year = year;
		this.duration = duration;
		this.rating = rating;
		this.totalVotes = totalVotes;
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getTotalVotes() {
		return totalVotes;
	}

	public void setTotalVotes(String totalVotes) {
		this.totalVotes = totalVotes;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String toString() {
		
		String newLine = System.getProperty("line.separator");
		String movie = "Movie name: "+ name + newLine +"Year: "+ year + newLine +"Duration: "+ duration + newLine +"Rating: "+ rating
				+ newLine +"Total Votes: "+ totalVotes + newLine +"Genre: "+ genre + newLine+newLine+newLine;

		return movie;
	}

}
