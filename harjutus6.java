import java.util.Scanner;

public class harjutus6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Skaneer sisendi lugemiseks
        
        System.out.print("Sisesta arv: "); //väljastame teksti, et kasutaja sisestaks arvu.
        int arv = scanner.nextInt(); //loeb kasutajalt sisestatud teksti.
        
        if (arv % 2 == 0) { //kasutab jagamise jäägiga operaatorit, et kontrollida, kas arv on paarisarv
            System.out.println(arv + " on paarisarv."); //juhul kui jääk on 0, on paarisarv
        } else {
            System.out.println(arv + " on paaritu arv."); //kui jääk pole null, siis on tegemist paaritu arvuga.
        }
        
        scanner.close(); //sulgeb programmi/skaneeri
    }
}

