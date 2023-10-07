
import java.util.Scanner;

public class harjutus5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Kas takistused on ühendatud jadamisi või rööpselt? (j/r)?: ");
        char uhenduseTyyp = scanner.nextLine().charAt(0); //Kasutajavalik ühendustüübi kohta.
        
        System.out.println("Mitu takistust on ühendatud?");
        int takistusteArv = scanner.nextInt(); //Kasutaja sisestatud takistuste arv.
        
        double[] takistused = new double[takistusteArv]; //massiiv takistuste väärtuste salvestamiseks.
        
        for (int i = 0; i < takistusteArv; i++) {
            System.out.println("Sisesta takisti väärtus " + (i + 1) + " (ohmid):");
            takistused[i] = scanner.nextDouble(); //Kasutaja sisestatud takistuse väärtus.
        }
        
        double kogutakistus = 0.0; //algseisund kogutakistuse arvutamiseks.
        
        if (uhenduseTyyp == 'j' || uhenduseTyyp == 'J') { 
            for (int i = 0; i < takistusteArv; i++) { //Jadamisi ühendatud kogutakistuse arvutamine.
                kogutakistus += takistused[i];
            }
        } else if (uhenduseTyyp == 'r' || uhenduseTyyp == 'R') { //rööpselt ühendatud kogutakistuse arvutamine.
            for (int i = 0; i < takistusteArv; i++) {
                kogutakistus += 1.0 / takistused[i];
            }
            kogutakistus = 1.0 / kogutakistus;
        } else {
            System.out.println("Vale ühenduse tüüp. Kasuta 'j' jadamisi või 'r' rööpselt.");
            return;
        }
        
        System.out.println("Kogutakistus on " + kogutakistus + " ohmi."); //kogutakistuse väljund.
        
        scanner.close();
    }
}
