package Case1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//Created by Troels, 03-08-2020
public class ReadFile {
    //Creating arraylist for storing the lines
    ArrayList<String> fileData = new ArrayList<String>();

    //Bufferedreader & FileReader initiated with the fileURL requested in the main class
    BufferedReader br = null;
    public void openFile(String url) throws IOException {
       try {
                br = new BufferedReader(new FileReader(url));
                String line;

                while ((line = br.readLine()) != null){
                    fileData.add(line);
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
