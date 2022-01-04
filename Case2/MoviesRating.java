package Case2;

import java.util.ArrayList;

public class MoviesRating {

    public void HighestMovieRating(ArrayList<Movie> movieArrayList){
        double highest=0;
        double second=0;
        double third=0;

        double rating;
        int movieIdHighest=0;
        int movieIdSecond=0;
        int movieIdThird=0;
        //Loop for iterating through the movies, and ranking the three highest rated movies.
        for(int i=0; i < movieArrayList.size(); i++){
            rating = movieArrayList.get(i).getRating();

            if(rating > highest){
                movieIdThird = movieIdSecond;
                movieIdSecond = movieIdHighest;
                movieIdHighest = movieArrayList.get(i).getId();
                highest = rating;
            }else if(rating > second){
                movieIdThird = movieIdSecond;
                movieIdSecond = movieArrayList.get(i).getId();
                second = rating;

            }else if(rating > third){
                movieIdThird = movieArrayList.get(i).getId();
                third = rating;
            }else if(rating < third){

            }
        }
        //Display the results, the -1 comes from the fact that difference between Array starts at 0, ID's start at 1.
        System.out.println("| Highest Rated Movies |");
        System.out.println( movieArrayList.get(movieIdHighest-1).getTitleAndRating());
        System.out.println( movieArrayList.get(movieIdSecond-1).getTitleAndRating());
        System.out.println( movieArrayList.get(movieIdThird-1).getTitleAndRating());
        System.out.println("|----------------------| ");
    }
}
