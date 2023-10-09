import java.util.Scanner;

public class h17p {

    public static void main(String[] args) {
        //Loob skaneeri sisendi lugemiseks
        Scanner scanner = new Scanner(System.in); //loob uue "scanner" objekti, mis võimaldab programmil kasutajalt sisendit lugeda.
        
        System.out.println("Sisestage arvude jada komadega:"); //väljastab teksti
        String input = scanner.nextLine(); //lükkab programmi uude liini
        
        // Jagame sisendi komade järgi ja teisendame arvudeks
        String[] arvudTekstina = input.split(","); //võimaldab jagada stringi erinevateks osadeks, kasutades eraldajana komasid, mis on sageli kasutatud väärtuste eraldamiseks.
        
        System.out.print("Paarisarvud on: "); //väljastab teksti, paarisarvud on:
        
        //Integeerib läbi sisestatud arvude.
        for (String arvTekstina : arvudTekstina) { //võimaldab tsükliliselt läbida iga elemendi massiivis "arvudTekstina", kus iga element on tekst (String).
            int arv = Integer.parseInt(arvTekstina.trim()); //Teisendab arvu tekstist integeriks

            //Kontrollib, kas arv on paarisarv
            if (arv % 2 == 0) { //tingimuslause, mis kontrollib, kas muutuja ("arv") on paarisarv.
                System.out.print(arv + ", "); //Kuvab välja paarisarvu
            }
        }
        
        scanner.close(); //sulgeb programmi.
    }
}
