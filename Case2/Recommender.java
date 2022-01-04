package Case2;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Recommender {
    ArrayList<String> similarMovies;
    public void Recommend(ArrayList<CurrentSession> currentSessions, ArrayList<User> userArrayList, ArrayList<Movie> movieArrayList){
        ArrayList<String> recommended = new ArrayList<>();

        //Loop for using currentsession arraylist and all information used to show recommendations to the user
        for(int i = 0; i < currentSessions.size(); i++){
            int userid = currentSessions.get(i).getUserID()-1;
            int movieid = currentSessions.get(i).getMovieid()-1;
            System.out.println("Hello " + userArrayList.get(userid).getName() + "! Here are some similar movies to "
                                        + movieArrayList.get(movieid).getTitle() + " based on genres.");
            recommended = similarMovies(currentSessions.get(i).getMovieid(), movieArrayList);
            for(int j=0; j < recommended.size(); j++){
                System.out.println(recommended.get(j));
            }
            System.out.println("--------------------------");
        }

    }
    //Method for finding similar movies, by comparing genres.
    public ArrayList<String> similarMovies(int id, ArrayList<Movie> movieArrayList){
        similarMovies = new ArrayList<>();
        String genres = movieArrayList.get(id).getGenres();
        String parts[] = genres.split(";");

        ArrayList<Integer> countsArray = new ArrayList<>();
        int genresLimit = parts.length-1;

        //Find all movies that have atleast 2-4 of the similar genres, depending on the number of genres.
        for(int i= 0 ; i < movieArrayList.size();  i++){
            int count =0;
            String strGenres= movieArrayList.get(i).getGenres();
            for(int j=0; j < parts.length; j++){
                if(strGenres.contains(parts[j])){
                    count += 1;
                }
            }
            if(count > genresLimit){
                similarMovies.add(movieArrayList.get(i).getTitle());
            }
        }
        return similarMovies;
    }

}
