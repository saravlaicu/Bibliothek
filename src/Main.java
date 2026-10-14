import java.util.ArrayList;

public class Main{

    public static void main(String[] args){

        Buch buch1= new Buch("Clean Code", "Robert Martin", 45, 464);
        Buch buch2=new Buch("1984", "George Orwell", 18, 328);
        Buch buch3=new Buch("Animal Fram ", "George Orwell", 12, 112);

        ArrayList<Buch> Bucher= new ArrayList<Buch>();

        Bucher.add(buch1);
        Bucher.add(buch2);
        Bucher.add(buch3);


        Bibliothek biblio1=new Bibliothek(Bucher);
        biblio1.Bucher.add(buch1);

       // biblio1.printBucher(biblio1.Bucher);
        biblio1.printBucher();

        Bibliothek.printBucher(biblio1.filternNachAuthor("George Orwell"));

        System.out.println(biblio1.durchschnittRechnen(biblio1.Bucher) +"\n");

        Bibliothek.printBucher(biblio1.preisUberprufen(Bucher, 100));
        Bibliothek.printBucher(biblio1.teuersteBuchFinden(Bucher));
        Bibliothek.printBucher(biblio1.seitenAnzahlUberprufen(Bucher,300));
        biblio1.inBudgetFinden(Bucher,50);
    }
}