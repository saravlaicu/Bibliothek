import java.util.ArrayList;

public class Bibliothek {
    public ArrayList<Buch> Bucher;


    public Bibliothek(ArrayList<Buch> Bucher ){
        this.Bucher=Bucher;
    }
    //1.

    public void filternNachAuthor(String Author){
       // ArrayList<Buch> filtrierteBucher = new ArrayList<Buch>();
        for(Buch buch : Bucher){
            if (buch.Author == Author){
                //filtrierteBucher.add(buch);
                System.out.println(buch.Tietel);
            }
        }

    }


    public void  printBucher(ArrayList<Buch> bucher){
        for (Buch buch : bucher){
            System.out.println(buch.Tietel+", "+buch.Author+", "+ buch.Preis+" Euro ,"+ buch.Anzahl_Seiten+" Seiten\n");
        }
    }

    //daca vreau doarp+ pt cartiile biblioitecii mele:
    public void  printBucher(){
        for (Buch buch : this.Bucher){
            System.out.println(buch.Tietel+", "+buch.Author+", "+ buch.Preis+" Euro ,"+ buch.Anzahl_Seiten+" Seiten\n");
        }
    }


    //2
    public double durchschnittRechnen(ArrayList<Buch> bucher){
        double sum=0;
        for (Buch buch : this.Bucher){
            sum +=buch.Anzahl_Seiten;
        }
        return sum/bucher.size();

    }

    public void preisUberprufen(ArrayList<Buch> bucher, double maximalPreis){
        for (Buch buch : bucher){
           if(buch.Preis <= maximalPreis){
               System.out.println(buch.Tietel);
           }
        }
        // System.out.println("Kein Buch unter "+maximalPreis+" Euro");
    }

    public void teuersteBuchFinden(ArrayList<Buch> bucher) {
        double maximalPreis = 0;
        for (Buch buch : bucher) {
            if (buch.Preis > maximalPreis) {
                maximalPreis = buch.Preis;
            }
        }
        if (maximalPreis != 0) {
            for (Buch buch : bucher) {
                if (buch.Preis == maximalPreis) {
                    System.out.println(buch.Tietel + "(" + maximalPreis + ")"); //si in caz ca am mai multe carti cu acelasi pret
                }
            }
        }
        else {
            System.out.println("null");
        }
    }
    
}
