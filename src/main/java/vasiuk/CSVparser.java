package vasiuk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVparser implements List{
    protected static void parserCSV(String file) throws IOException {
        ArrayList<String> csvList = new ArrayList<>();
        String line = "";
        Check check = new Check();

        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        fileReader.readLine();

        while((line = fileReader.readLine())!=null){
            String[] elements = line.split(",");
            for(int i = 0; i < elements.length; i++){
                csvList.add(elements[i]);
            }
        }
        fileReader.close();

        for(int r = 0; r < csvList.size(); r += 5)  check.AddId(csvList.get(r));
        for(int j = 1; j < csvList.size(); j += 5)  check.AddRequest(Long.parseLong(csvList.get(j)));
        for(int q = 2; q < csvList.size(); q += 5)  check.AddName(csvList.get(q));
        for(int w = 3; w < csvList.size(); w += 5)  check.AddQuantity(Integer.parseInt(csvList.get(w)));
        for(int e = 4; e < csvList.size(); e += 5)  check.AddPrice(Double.parseDouble(csvList.get(e)));
    }
}