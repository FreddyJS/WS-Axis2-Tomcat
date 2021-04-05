package movie;

import movie.MovieServiceStub.*;

import java.util.Scanner;
import java.io.InputStreamReader;

public class Client{

    public static void display_options() {
        System.out.println("\nEscribe cualquier película que quieras buscar: (puede no estar en la bdd)");
    }

    public static void main(java.lang.String args[]){
        try{
            System.out.println("Starting client...");
            MovieServiceStub stub =
                new MovieServiceStub
                ("http://localhost:8080/axis2/services/MovieService");
            
            String movie_title = "";
            Scanner scan = new Scanner(new InputStreamReader(System.in));
            
            System.out.println("Bienvenido al servicio de consulta de peliculas.");
            System.out.println("Escribe quit para finalizar el cliente.");

            while(!movie_title.equals("quit")) {
                display_options();

                movie_title = scan.nextLine();

                Read_movie req = new Read_movie();
                req.setMovie(movie_title);

                Read_movieResponse movie = stub.read_movie(req);

                System.out.println(" -> " + movie.get_return());
            }

        } catch(Exception e){
            e.printStackTrace();
            System.out.println("\n\n\n");
        }
    }

}