package Case2;

import java.io.*;
import java.util.ArrayList;

public class ReadFiles {
    final String pathToFiles = "src/Case2/Data/";
    //Creating arraylists for the three data files, storing the lines depending on case.
    ArrayList<String> userData = new ArrayList<String>();
    ArrayList<String> movieData = new ArrayList<>();
    ArrayList<String> curUserSession = new ArrayList<>();
    String arrayID;

    //Bufferedreader & FileReader initiated with the fileURL requested in the main class

    public void findFiles() throws IOException {
        //Create a String array with urls with all the files located in the data folder
        File files = new File(pathToFiles);
        String[] urls = files.list();

        //Open each file, by using the pathname/url into the openFile method
        for(int i = 0; i < urls.length; i++){
            //Switch method is to sort the files into the proper arrays.
            switch(urls[i]){
                case "CurrentUserSession.txt":
                   //Adding an ArrayID, useful for when sorting arrays into their .
                    arrayID = "Session";
                    curUserSession.add(arrayID);
                    openFile(urls[i], curUserSession);
                    break;
                case "Users.txt":
                    arrayID = "Users";
                    userData.add(arrayID);
                    openFile(urls[i], userData);
                    break;
                case "Products.txt":
                    arrayID = "Movies";
                    movieData.add(arrayID);
                    openFile(urls[i], movieData);
                    break;
            }
        }
    }
   public void openFile(String url, ArrayList<String> dataToArray) throws IOException {
       //Add the path of the data files in the project, and use the dataToArray to fill the current array.
        url = pathToFiles+url;

        BufferedReader br = null;
        try {
           br = new BufferedReader(new FileReader(url));
           String line;

           while ((line = br.readLine()) != null){
               dataToArray.add(line);
           }

       } catch (FileNotFoundException e) {
           System.out.println("Could not find the file");
       }
       finally {
            try {
                br.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
       }
   }

}
