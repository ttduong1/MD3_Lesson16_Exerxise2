package rikkei.academy;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = null;
        try {
            String line;
            String PATH_FILE = "D:\\Java10f\\module3\\MD3_Lesson16_Exercise2\\src\\rikkei\\academy\\countries.csv";
            br = new BufferedReader(new FileReader(PATH_FILE));

            while ((line = br.readLine()) != null){
                printCountry(parseCsvLine(line));
            }
        }catch (IIOException e){
            e.printStackTrace();
        }finally {
            try {
                if (br != null)
                    br.close();
            }catch (IIOException e){
                e.printStackTrace();
            }
        }
    }
    public static List<String> parseCsvLine(String csvLine){
        List<String> result = new ArrayList<>();
        if (csvLine != null){
            String[] splitData = csvLine.split(",");
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }
    public static void printCountry(List<String> country){
        System.out.println(
                "Country [id= "
                + country.get(0)
                + ", code= " + country.get(1)
                + " , name=" + country.get(2)
                + "]");
    }
}