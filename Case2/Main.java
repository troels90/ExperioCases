package Case2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //Initiate the ReadFiles class: Finds the txt files, reads and stores them into different arrays.
        ReadFiles rf = new ReadFiles();
        rf.findFiles();

        //create arraylists of custom objects, instead of using string elements from the txt files.
        SortArrays sa = new SortArrays();
        sa.sendDataArray(rf.movieData);
        sa.sendDataArray(rf.userData);
        sa.sendDataArray(rf.curUserSession);
        //Using user data and movies list, to find the most popular products... contains many loops, probably too many...
        PopularProducts pp = new PopularProducts();
        pp.highPurchaseRate(sa.userList, sa.moviesList);
        //Using movie arraylist to find the highest rated movies.
        MoviesRating mr = new MoviesRating();
        mr.HighestMovieRating(sa.moviesList);
        //The recommender class require information from all the data arrays, and gives recommendation about the current session.
        Recommender r = new Recommender();
        r.Recommend(sa.sessionList, sa.userList, sa.moviesList);
    }
}
