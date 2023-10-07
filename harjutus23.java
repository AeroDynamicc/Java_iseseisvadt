import java.util.Random;
import java.util.Scanner;

public class harjutus23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //sisendi lugemiseks.
        Random random = new Random(); //täisarvude genereerimine.
        
        int kasutajavoit = 0; //kasutajavõidu arv
        int arvutivoit = 0; //arvutivõidu arv
        
        System.out.println("Täringumäng algab!");
        
        do {
            int kasutajaTaring = random.nextInt(6) + 1; //kasutajapoolne täringutulemus 1 kuni 6.
            int arvutiTaring = random.nextInt(6) + 1; //arvutipoolne täringutulemus 1 kuni 6.
            
            System.out.println("Sinu täring: " + kasutajaTaring); //prindib välja teksti koos üleval oleva koodiga (mis täringutulemuse keegi sai).
            System.out.println("Arvuti täring: " + arvutiTaring);
            
            if (kasutajaTaring > arvutiTaring) {
                System.out.println("Sa võitsid!");
                kasutajavoit++;
            } else if (kasutajaTaring < arvutiTaring) {
                System.out.println("Arvuti tegi võidu.");
                arvutivoit++;
            } else {
                System.out.println("Viik!");
            }
            
            System.out.println("Hetkelised tulemused: Sinu võidud - " + kasutajavoit + ", Arvuti võidud - " + arvutivoit);
            
            System.out.println("Kas soovid jätkata? (jah/ei)"); //küsib soovi jätkata (jah,ei)
            String vastus = scanner.next();
            
            if (!vastus.equalsIgnoreCase("jah")) { //kui vastus jah, siis mäng läheb edasi, kui ei läheb mäng kinni ja kuvab tulemused (allpool on näha).
                break;
            }
        } while (true);
        
        if (kasutajavoit > arvutivoit) {
            System.out.println("Mängu võitis kasutaja!");
        } else if (kasutajavoit < arvutivoit) {
            System.out.println("Mängu võitis arvuti.");   //prindib välja kes keda võitis, või et mäng jäi viiki.
        } else {
            System.out.println("Mäng jäi viiki!");
        }
        
        scanner.close(); //suleb skaneeri
    }
}

