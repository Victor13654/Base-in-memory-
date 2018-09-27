package vasiuk;

import java.io.FileWriter;
import java.io.IOException;

public class CSVwrite {
    protected void write(String string) throws IOException {
        FileWriter writer = new FileWriter("Ex.csv",true);

        writer.write(string);
        writer.append("\n");
        writer.flush();
        writer.close();
    }
}
