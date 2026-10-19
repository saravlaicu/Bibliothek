import java.util.ArrayList;

public class Bibliothek {
    public ArrayList<Buch> Bucher;


    public Bibliothek(ArrayList<Buch> Bucher) {
        this.Bucher = Bucher;
    }
    //1.

    public ArrayList<Buch> filternNachAuthor(String Author) {
        ArrayList<Buch> filtrierteBucher = new ArrayList<Buch>();
        for (Buch buch : Bucher) {
            if (buch.Author.equals(Author)) {
                filtrierteBucher.add(buch);
                // System.out.println(buch.Tietel);
            }
        }
        return filtrierteBucher;

    }


    public static void printBucher(ArrayList<Buch> bucher) {
        for (Buch buch : bucher) {
            System.out.println(buch.Tietel + ", " + buch.Author + ", " + buch.Preis + " Euro ," + buch.Anzahl_Seiten + " Seiten\n");
        }
    }

    //daca vreau doarp+ pt cartiile biblioitecii mele:
    public void printBucher() {
        for (Buch buch : this.Bucher) {
            System.out.println(buch.Tietel + ", " + buch.Author + ", " + buch.Preis + " Euro ," + buch.Anzahl_Seiten + " Seiten\n");
        }
    }


    //2
    public double durchschnittRechnen(ArrayList<Buch> bucher) {
        double sum = 0;
        for (Buch buch : this.Bucher) {
            sum += buch.Anzahl_Seiten;
        }
        return sum / bucher.size();

    }

    public ArrayList<Buch> preisUberprufen(ArrayList<Buch> bucher, double maximalPreis) {
        ArrayList<Buch> filtrierteBucher = new ArrayList<Buch>();
        for (Buch buch : bucher) {
            if (buch.Preis <= maximalPreis) {
                filtrierteBucher.add(buch);
                //  System.out.println(buch.Tietel);
            }
        }
        return filtrierteBucher;
    }

    public ArrayList<Buch> teuersteBuchFinden(ArrayList<Buch> bucher) {
        double maximalPreis = 0;
        ArrayList<Buch> filtrierteBucher = new ArrayList<Buch>();
        for (Buch buch : bucher) {
            if (buch.Preis > maximalPreis) {
                maximalPreis = buch.Preis;
            }
        }
        for (Buch buch : bucher) {
            if (buch.Preis == maximalPreis) {
                //System.out.println(buch.Tietel + "(" + maximalPreis + ")"); //si in caz ca am mai multe carti cu acelasi pret
                filtrierteBucher.add(buch);
            }
        }

        return filtrierteBucher;
    }

    public ArrayList<Buch> seitenAnzahlUberprufen(ArrayList<Buch> bucher, int mindenstensSeitenAnzahl) {
        ArrayList<Buch> filtrierteBucher = new ArrayList<Buch>();
        for (Buch buch : bucher) {
            if (buch.Anzahl_Seiten >= mindenstensSeitenAnzahl) {
                filtrierteBucher.add(buch);
            }
        }
        return filtrierteBucher;
        // System.out.println("Kein Buch unter "+maximalPreis+" Euro");
    }



    public ArrayList<Buch> inBudgetFinden(ArrayList<Buch> bucher, double budget) {
        double maxim_price = 0;
        int max_pages = 0;
        ArrayList<Buch> pairs = new ArrayList<Buch>();
        for (int i = 0; i < bucher.size(); i++) {
            for (int j = i + 1; j < bucher.size(); j++) {
                if (!bucher.get(i).Tietel.equals(bucher.get(j).Tietel) &&
                        bucher.get(i).Preis + bucher.get(j).Preis <= budget) {

                    if (bucher.get(i).Preis + bucher.get(j).Preis > maxim_price) {
                        maxim_price = bucher.get(i).Preis + bucher.get(j).Preis;
                        pairs.clear();
                        pairs.add(bucher.get(i));
                        pairs.add(bucher.get(j));
                        max_pages = bucher.get(i).Anzahl_Seiten + bucher.get(j).Anzahl_Seiten;

                    } else if (bucher.get(i).Preis + bucher.get(j).Preis == maxim_price) {
                        pairs.add(bucher.get(i));
                        pairs.add(bucher.get(j));

                        if (pairs.get(i).Anzahl_Seiten + pairs.get(j).Anzahl_Seiten > max_pages) {
                            max_pages = bucher.get(i).Anzahl_Seiten + bucher.get(j).Anzahl_Seiten;
                        }
                    }
                }
            }
        }

        if (pairs.isEmpty()) {
            return null;
        }

        if (pairs.size() == 2) {
            return pairs;
        }

        ArrayList<Buch> finalResult = new ArrayList<Buch>();
        for (int i = 0; i < pairs.size(); i += 2) {
            if (pairs.get(i).Anzahl_Seiten + pairs.get(i + 1).Anzahl_Seiten == max_pages) {

                finalResult.add(pairs.get(i));
                finalResult.add(pairs.get(i + 1));
                break;

            }

        }
        return finalResult;
    }

}

