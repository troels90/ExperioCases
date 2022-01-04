package Case1;

import java.text.DecimalFormat;
import java.util.ArrayList;

//Created by Troels, 03-08-2020
public class Calculator {
    ArrayList<String> pnArrayName = new ArrayList<>();
    ArrayList<Double> pnArrayTravelDistance = new ArrayList<>();
    ArrayList<Double> resultArray = new ArrayList<>();
    Double cabinCost;
    Double travelCost;
    Double travelDistanceSUM;
    Double totalTravelCost;
    Double individualCost;
    int numberOfPeople;
    DecimalFormat df = new DecimalFormat("#.00");
    //Class for extracting the necessary info and from there calculating and displaying the results given.
    //Methods are hopefully, to some extent explanatory.
    public void calculateCost(ArrayList<String> fileData){
        setCabinExpenses(fileData);
        modifyArray(fileData);
        setTravelExpenses();
        resultArray();
        //Display results
        for(int person = 0; person < numberOfPeople; person++){
            System.out.println(pnArrayName.get(person) + "  " + df.format(resultArray.get(person)));
        }

    }
    public void setCabinExpenses(ArrayList<String> fileData){
        //Retrieving the first two lines concerning costs, that are not linked to other data.
        cabinCost = Double.parseDouble(fileData.get(0));
        travelCost = Double.parseDouble(fileData.get(1));
    }

    public void modifyArray(ArrayList<String> fileData){
        //Removing the first two elements in the arraylist, as they have been stored in a variable for later use.
        fileData.remove(0);
        fileData.remove(0);
        //Splitting the arraylist from the file into two elements, name and distance travelled.
        for(int i = 0; i < fileData.size(); i++){
            String line = fileData.get(i);
            line.trim();
            String[] splitStr = line.split(" ");
            Double travelDistance = Double.parseDouble(splitStr[1]);
            pnArrayName.add(splitStr[0]);
            pnArrayTravelDistance.add(travelDistance);
        }

    }
    public void setTravelExpenses(){
        numberOfPeople = pnArrayName.size();
        //Calculate the total distance travelled to the cabin & and total cost of travel
        travelDistanceSUM = 0.0;
        for(int x = 0; x < numberOfPeople; x++){
            travelDistanceSUM += pnArrayTravelDistance.get(x);
        }
        totalTravelCost = travelDistanceSUM * travelCost;
    }
    public void resultArray(){
        //Using the given formula
        for(int y = 0; y < numberOfPeople; y++){
            individualCost = (cabinCost*(1-(pnArrayTravelDistance.get(y)/travelDistanceSUM))/ (numberOfPeople-1)) +
                    pnArrayTravelDistance.get(y)*travelCost;
            individualCost = roundTwoDecimals(individualCost);
            resultArray.add(individualCost);
        }
    }
    //Given some proper numbers, soo it's easier to request for money.
    public double roundTwoDecimals(double value){
        value *= 10;
        value = Math.round(value);
        value /= 10;

        return value;
    }
}
