package Case1;

import java.io.IOException;

//Created by Troels, 03-08-2020
public class Main {


        public static void main (String args[]) throws IOException {
            //Change fileURL for trying different txt files
            String fileURL = "src/Case1/Txt/cabin1.txt";

            //Initiate the class for reading the file and the class for separating
            Calculator ma = new Calculator();
            ReadFile readFile = new ReadFile();

            readFile.openFile(fileURL);
            ma.calculateCost(readFile.fileData);

        }
    }
