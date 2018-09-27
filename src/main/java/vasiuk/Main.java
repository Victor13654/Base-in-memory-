package vasiuk;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) throws Exception {
        XMLparser parser = new XMLparser();
        CSVparser parser2 = new CSVparser();
        String one = args[0];
        String two = args[1];

        In format = new In();
        String form = format.Extension(one);

        if (form.equals("xml")) parser.parserXML(one);
        else if (form.equals("csv")) parser2.parserCSV(one);
        else System.out.println("Nie poprawny format");

        String form2 = format.Extension(two);
        if (form2.equals("xml")) parser.parserXML(two);
        else if (form2.equals("csv")) parser2.parserCSV(two);
        else System.out.println("Nie poprawny format");

        Input input = new Input();
        input.input();

    }
}

class In{
    public static String Extension(String filename){

        String path = filename;
        String ext = com.google.common.io.Files.getFileExtension(path);
        return ext;
    }
}


class Check implements List {

    public void AddId(String id){
        if(id.length()<=6)      listID.add(id);
        else                    System.out.println("Nie poprawny format dannych");
    }
    public void AddRequest(long request){
        listRequest.add(request);
    }
    public void AddName(String name){
        if(name.length()<=255)  listName.add(name);
        else System.out.println("Nie poprawny format name");
    }
    public void AddQuantity(int quantity){
        listQuantity.add(quantity);
    }
    public void AddPrice(double price){
        double d = price;
        d = d * 100;
        int i = (int) Math.round(d);
        d = (double)i / 100;
        listPrice.add(d);
    }


}
class Input {
    public void input() throws IOException {
        tasks Tasks = new tasks();
        NewArr list2 = new NewArr();
        list2.CreateArr();

        System.out.println("Prosze wybrać rodzaj operacji");
        System.out.println("Ilosc zamowien lacznie ---------------------------------- 1");
        System.out.println("Ilosc zamowien do klienta o wskazanym indefikatorze ----- 2");
        System.out.println("Laczna kwota zamowien ----------------------------------- 3");
        System.out.println("Laczna kwota zamowienia dla klienta --------------------- 4");
        System.out.println("Lista wszystkich zamowien ------------------------------- 5");
        System.out.println("Lista zamowien klienta ---------------------------------- 6");
        System.out.println("Srednia wartosc zamowienia ------------------------------ 7");
        System.out.println("Srednia wartosc zamowienia klienta ---------------------- 8");
        System.out.println("Zeby zakonczyc wpisz ------------------------------------ 0");


        Scanner s = new Scanner(System.in);
        System.out.println("Prosze wybrac co robimy (koniec --- 0)");
        int choice = s.nextInt();

        if (choice == 1)    Tasks.task1Met();
        if (choice == 2)    Tasks.task2Met();
        if (choice == 3)    Tasks.task3Met();
        if (choice == 4)    Tasks.task4Met();
        if (choice == 5)    Tasks.task5Met();
        if (choice == 6)    Tasks.task6Met();
        if (choice == 7)    Tasks.task7Met();
        if (choice == 8)    Tasks.task8Met();
        System.in.read();
    }
}


