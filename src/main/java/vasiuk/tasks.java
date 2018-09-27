package vasiuk;

import java.io.IOException;
import java.util.Scanner;

public class tasks implements  List {
    Scanner s = new Scanner(System.in);
    CSVwrite Writer = new CSVwrite();

    public void task1Met() throws IOException {
        System.out.println("Zapisac wynik do pliku albo na ekran?");
        System.out.println("ekran ----1");
        System.out.println("plik -----0");
        int ans = s.nextInt();

        if (ans == 1) System.out.println("Ilosc zamowien lacznie :" + listID.size());
        else if (ans == 0) {
            String file = Integer.toString(listID.size());
            Writer.write("Ilosc zamowien lacznie :" + file);
        }
    }


    public void task2Met() throws IOException {
        int Summ = 0;
        System.out.println("Prosze wprowadzic ID clienta");
        String name = s.nextLine();

        for (int i = 0; i < listok.size(); i += 5) {
            if (name.equals(listok.get(i))) Summ++;
        }

        System.out.println("Zapisac wynik do pliku albo na ekran?");
        System.out.println("ekran ----1");
        System.out.println("plik -----0");

        int ans = s.nextInt();
        if (ans == 1) System.out.println("Ilosc zamowien do klienta o wskazanym indefikatorze :" + Summ);
        else if (ans == 0) {
            String file = Integer.toString(Summ);
            Writer.write("Ilosc zamowien do klienta o wskazanym indefikatorze :" + file);
        }
    }


    public void task3Met() throws IOException {
        double Summ = 0.0;

        for (int a = 0; a < listID.size(); a++) {
            Summ = Summ + listQuantity.get(a) * listPrice.get(a);
        }
        double d = Summ;
        d = d * 100;
        int i = (int) Math.round(d);
        d = (double)i / 100;
        Summ = d;

        System.out.println("Zapisac wynik do pliku albo na ekran?");
        System.out.println("ekran ----1");
        System.out.println("plik -----0");

        int ans = s.nextInt();
        if (ans == 1) System.out.println("Laczna kwota zamowien :" + Summ);
        else if (ans == 0) {
            String file = Double.toString(Summ);
            Writer.write("Laczna kwota zamowien :" + file);
        }
    }


    public void task4Met() throws IOException {
        double Zalupa = 0;
        System.out.println("Prosze wprowadzic ID clienta");
        String name = s.nextLine();

        for (int i = 0, a = 3, b = 4; i < listok.size(); a += 5, b += 5, i += 5) {
            if (name.equals(listok.get(i))) {
                Zalupa = Zalupa + Double.parseDouble(listok.get(a).toString()) * Double.parseDouble(listok.get(b).toString());
            }
        }

        System.out.println("Zapisac wynik do pliku albo na ekran?");
        System.out.println("ekran ----1");
        System.out.println("plik -----0");

        int ans = s.nextInt();
        if (ans == 1) System.out.println("Laczna kwota zamowienia dla klienta " + name + Zalupa);
        else if (ans == 0) {
            String file = Double.toString(Zalupa);
            Writer.write("Laczna kwota zamowienia dla klienta  " + name + " :" + file);
        }
    }


    public void task5Met() throws IOException {
        System.out.println("Zapisac wynik do pliku albo na ekran?");
        System.out.println("ekran ----1");
        System.out.println("plik -----0");

        int ans = s.nextInt();
        if (ans == 1) System.out.println("Lista wszystkich zamowien");
        else if (ans == 0) Writer.write("Lista wszystkich zamowien");

        for (int s = 0; s < listID.size(); s++) {
            if (ans == 1) {
                System.out.println(listID.get(s) + " " + listRequest.get(s) + " " + listName.get(s) + " " + listQuantity.get(s) + " " + listPrice.get(s));
            } else if (ans == 0) {
                String file = listID.get(s) + " " + listRequest.get(s) + " " + listName.get(s) + " " + listQuantity.get(s) + " " + listPrice.get(s);
                Writer.write(file);
            }
        }
    }

    public void task6Met() throws IOException {
        System.out.println("Podaj identyfikator klienta");
        String name = s.nextLine();

        System.out.println("Zapisac wynik do pliku albo na ekran?");
        System.out.println("ekran ----1");
        System.out.println("plik -----0");
        int ans = s.nextInt();

        if (ans == 1) System.out.println("Lista zamowien klienta " + name);
        else if (ans == 0) Writer.write("Lista zamowien klienta " + name);

        for (int i = 0; i < listok.size(); i += 5) {
            if (name.equals(listok.get(i))) {
                if (ans == 1)
                    System.out.println(listok.get(i + 1) + " " + listok.get(i + 2) + " " + listok.get(i + 3) + " " + listok.get(i + 4));
                else if (ans == 0) {
                    String file = listok.get(i + 1) + " " + listok.get(i + 2) + " " + listok.get(i + 3) + " " + listok.get(i + 4);
                    Writer.write(file);
                }
            }
        }
    }


    public void task7Met() throws IOException {
        double Summ = 0.0;

        for (int d = 0; d < listID.size(); d++) {
            Summ = Summ + listQuantity.get(d) * listPrice.get(d);
        }

        System.out.println("Zapisac wynik do pliku albo na ekran?");
        System.out.println("ekran ----1");
        System.out.println("plik -----0");

        int ans = s.nextInt();
        double zamow = Summ / listID.size();
        double d = zamow;
        d = d * 100;
        int i = (int) Math.round(d);
        d = (double)i / 100;
        zamow = d;

        if (ans == 1) System.out.println("Srednia wartosc zamowienia :" + zamow);
        else if (ans == 0) {
            String file = Double.toString(Summ / listID.size());
            Writer.write("Srednia wartosc zamowienia :" + zamow);
        }
    }

    public void task8Met() throws IOException {
        double Summ = 0;
        System.out.println("Prosze wprowadzic ID clienta");
        String name = s.nextLine();
        int licznik = 0;

        for (int i = 0, a = 3, b = 4; i < listok.size(); a += 5, b += 5, i += 5) {
            if (name.equals(listok.get(i))) {
                licznik++;
                Summ = Summ + Double.parseDouble(listok.get(a).toString()) * Double.parseDouble(listok.get(b).toString());
            }
        }

        System.out.println("Zapisac wynik do pliku albo na ekran?");
        System.out.println("ekran ----1");
        System.out.println("plik -----0");

        int ans = s.nextInt();
        double file = (Summ / licznik);
        double d = file;
        d = d * 100;
        int i = (int) Math.round(d);

        d = (double)i / 100;
        file = d;
        if (ans == 1) System.out.println("Srednia wartosc zamowienia " + name + " :" + file);
        else if (ans == 0) {
            Writer.write("Srednia wartosc zamowienia " + name + " :" + file);
        }
    }
}


class NewArr implements List{
    public void CreateArr(){
        for (int b = 0; b < listID.size(); b++){
            listok.add(listID.get(b));
            listok.add(listRequest.get(b));
            listok.add(listName.get(b));
            listok.add(listQuantity.get(b));
            listok.add(listPrice.get(b));
        }
    }
}


