package Case2;

public class Movie {
    int id;
    String title;
    int year;
    String genres;
    double rating;
    double price;

    public Movie(){

    }
    public String getTitle(){
        String str = " " + title;
        return str;
    }
    public String getTitleAndRating(){
        String str = title + "  -  Rating: " + rating;
        return str;
    }
    public double getRating(){
        return rating;
    }
    public int getId(){
        return id;
    }
    public String getGenres(){
        return genres;
    }
}
