package Case2;

import java.util.ArrayList;

public class PopularProducts {

    public void highPurchaseRate(ArrayList<User> userArrayList, ArrayList<Movie> movieArrayList){
        //The class for display most popular movies based on purchases. Has a lot of loops, and probably got unneccessary complicated. Sorry about that...

        //Creating a string of all purchases, splitting it, and putting into an int Array instead.
        String strPurchases = "";
        for(int i=0; i < userArrayList.size(); i++){
            strPurchases += userArrayList.get(i).purchased;
        }
        strPurchases = strPurchases.trim().replaceAll(" ", ";");
        String splitPurchases[] = strPurchases.split(";");

        int arrayLen = splitPurchases.length;
        int intPurchases[] = new int[arrayLen];
        //Convert to Int Array
        for(int i=0; i < splitPurchases.length; i++){
            intPurchases[i] = Integer.parseInt(splitPurchases[i]);
        }

        //The loop for calculating frequency of purchases
        ArrayList<IntegerPair> frequency = new ArrayList<>();
        int value;
        int valueCheck;
        int count;
        for(int i=0; i < intPurchases.length; i++){
            value = intPurchases[i];
            count = 1;

            for(int j = i+1; j < intPurchases.length; j++){
                valueCheck = intPurchases[j];
                if(value == valueCheck){
                    count += 1;
                }
            }

            IntegerPair pair = new IntegerPair();
            pair.value = value;
            pair.count = count;
            frequency.add(pair);
        }
        //Loop for removing duplicates in frequency arraylist. Would be better to do in the previous loop.
        for(int i=0; i < frequency.size(); i++){
            value = frequency.get(i).getValue();
            for(int j= i+1; j < frequency.size(); j++){
                valueCheck = frequency.get(j).getValue();
                if(value == valueCheck){
                    frequency.remove(j);
                }
            }
        }
        //New loop for finding the most popular purchases and outputting them.
        int pairCount;
        int pairCountCheck = 0;


        for(int i=0; i < frequency.size(); i++){
            pairCount = frequency.get(i).getCount();
            if(pairCount > pairCountCheck){
                pairCountCheck = pairCount;
            }
        }
        //Finally, the loop connecting the "value" to the movie ID and displaying the movie title
        System.out.println("| Most purchased movies |");
        int movieId;
        for(int i=0; i < frequency.size(); i++){
            if(frequency.get(i).getCount() == pairCountCheck){
                movieId = frequency.get(i).getValue();
                System.out.println(movieArrayList.get(movieId).getTitle());

            }
        }
        System.out.println("|-----------------------|");

    }




}


