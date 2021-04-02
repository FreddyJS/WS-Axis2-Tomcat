package movie;

public class MovieService {
    
    public String read_movie(String movie) {
        movie = movie.replace(" ", "%20");
        return MovieReader.get_movie(movie);
    }

}