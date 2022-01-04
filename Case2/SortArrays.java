package Case2;

import java.util.ArrayList;

public class SortArrays {
    ArrayList<Movie> moviesList = new ArrayList<>();
    ArrayList<User> userList = new ArrayList<>();
    ArrayList<CurrentSession> sessionList = new ArrayList<>();

    public void sendDataArray(ArrayList<String> dataArray){
        //Switch statement to use the arrayID and send it to the right method and Arraylist
        String arrayID = dataArray.get(0);
        switch(arrayID){
            case "Session":
                for(int i=1; i < dataArray.size(); i++){
                    sessionToArray(dataArray.get(i));
                }
                break;
            case "Users":
                for(int i=1; i < dataArray.size(); i++){
                    userToArray(dataArray.get(i));
                }
                break;
            case "Movies":
                for(int i=1; i < dataArray.size(); i++){
                    movieToArray(dataArray.get(i));
                }
                break;
        }

    }
    public void movieToArray(String strToMovies){
        //Creating movie objects, by splitting the string and seperating data.
        Movie movie = new Movie();
        //ID, TITLE, YEAR, GENRE, GENRE, GENRE, GENRE, GENRE, RATING, PRICE
        String parts[] = strToMovies.split(",");

        movie.id = Integer.parseInt(parts[0]);
        movie.title = parts[1];
        movie.year = Integer.parseInt(parts[2]);
        int y = 0;
        movie.genres = "";
        //Creating one string for all genres.
        for(int i=3; i <= 7; i++){
            if(parts[i].equals(" ")){
                break;
            }else{
                movie.genres += parts[i] + ";";
            }
        }
        movie.rating = Double.parseDouble(parts[8]);
        movie.price = Double.parseDouble(parts[9]);

        moviesList.add(movie);
    }
    public void userToArray(String strToUser){
        //Creating user objects, again by splitting the string.
        User user = new User();
        //ID, NAME, VIEWED, PURCHASED
        String parts[] = strToUser.split(",");

        user.id = Integer.parseInt(parts[0]);
        user.name = parts[1];
        user.viewed = parts[2];
        user.purchased = parts[3];

        userList.add(user);
    }
    public void sessionToArray(String strToSession){
        //Creating a Current Session object, that can be used for reference in the last part of the task.
        CurrentSession curSession = new CurrentSession();
        String parts[] = strToSession.split(",");

        //Using parts[1] made a NumberFormatException, so had to seperate and use trim() to remove additional spaces from txt
        String placeholder = parts[1].trim();
        curSession.userid = Integer.parseInt(parts[0]);
        curSession.movieid = Integer.parseInt(placeholder);

        sessionList.add(curSession);
    }

}
