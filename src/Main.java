import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        Buch buch1= new Buch("Clean Code", "Robert Martin", 40, 464);
        Buch buch2=new Buch("1984", "George Orwell", 10, 328);
        Buch buch3=new Buch("Animal Fram ", "George Orwell", 12, 112);

        ArrayList<Buch> Bucher= new ArrayList<Buch>();

        Bucher.add(buch1);
        Bucher.add(buch2);
        Bucher.add(buch3);


        Bibliothek biblio1=new Bibliothek(Bucher);
        biblio1.Bucher.add(buch1);

        biblio1.printBucher(biblio1.Bucher);
        biblio1.printBucher();

        Bibliothek.printBucher(biblio1.filternNachAuthor("Robert Martin"));

        System.out.println(biblio1.durchschnittRechnen(biblio1.Bucher) +"\n");

        Bibliothek.printBucher(biblio1.preisUberprufen(Bucher, 100));
        Bibliothek.printBucher(biblio1.teuersteBuchFinden(Bucher));
        Bibliothek.printBucher(biblio1.seitenAnzahlUberprufen(Bucher,300));
        Bibliothek.printBucher(biblio1.inBudgetFinden(Bucher,50));


//        Scanner scanner= new Scanner(System.in);
//        System.out.println("Intrduce author: ");
//        String Author= scanner.nextLine();
//        //System.out.println(Author);
//        Bibliothek.printBucher(biblio1.filternNachAuthor(Author));
//
//
//        System.out.println("Intrduce Price: ");
//        double Preis= scanner.nextDouble();
//        Bibliothek.printBucher(biblio1.preisUberprufen(Bucher, Preis));
//
//        System.out.println("Intrduce Number of pages: ");
//        int SeitenAnzahl= scanner.nextInt();
//        Bibliothek.printBucher(biblio1.seitenAnzahlUberprufen(Bucher,SeitenAnzahl));
//
//
//        System.out.println("Intrduce Budget: ");
//        double Budget= scanner.nextDouble();
//        Bibliothek.printBucher(biblio1.inBudgetFinden(Bucher,Budget));



    }
}