import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class h25p {

    public static void main(String[] args) {
        //Laeb õpilaste nimekirja failist "students.csv"
        List<String> students = loadStudents("students.csv");

        if (students.isEmpty()) { //kontrollib, kas õpilaste nimekiri "students" on tühi, kui nimekiri on tühi, prindib teate, et õpilaste nimekiri on tühi ning lõpetab meetodi return abil.
            System.out.println("Opilaste nimekiri on tyhi."); //väljastab teksti, et nimekiri on tühi
            return; //return lõpetab meetodi
        }

        Scanner scanner = new Scanner(System.in); //loob uue "scanner" objekti, mis võimaldab kasutajal sisendit lugeda.
        try { //try proovib selle koodi tööle panna, ning kui miski ei õnnestu, toob see veateate
            while (true) { //võimaldab programmil jääda aktiivseks ja reageerida kasutaja sisendile korduvalt.
                System.out.println("Valige toiming:");
                System.out.println("1 - Mitu opilast on nimekirjas");
                System.out.println("2 - Kuva esimesed 10 opilast");
                System.out.println("3 - Kuva kolm suvalist opilast");                   //siin väljastatakse kõik valikuvariandid.
                System.out.println("4 - Kuva ainult emailid");
                System.out.println("5 - Kuva nimede esitahed");
                System.out.println("6 - Koosta parool perenimest ja suvalisest arvust");
                System.out.println("0 - Valju");
                int choice = scanner.nextInt(); // loeb kasutaja sisestatud valiku "choice"

                switch (choice) { //see algab "switch" avaldusega, mis võimaldab programmi juhtida erinevate valikute põhjal, mille kasutaja teeb.
                    case 1:
                        //Kuvab õpilaste arvu nimekirjas
                        int studentCount = students.size();
                        System.out.println("Opilaste arv: " + studentCount);
                        break; //peatab või vahetab funktsiooni
                    case 2:
                        //Kuvab esimesed 10 õpilast
                        displayFirst10Students(students);
                        break; //peatab või vahetab funktsiooni...
                    case 3:
                        //Kuvab kolm suvalist õpilast
                        displayRandomStudents(students, 3);
                        break; //peatab funktsiooni
                    case 4:
                        //peaks kuvama aint emaile, millegipärast veidi katki
                        displayEmails(students);
                        break; //peatab funktsiooni
                    case 5:
                        //Kuvab nimede esitähed (ei toimi ka nii nagu peaks)
                        displayInitials(students);
                        break; //peatab funktsiooni
                    case 6:
                        //Loob parooli perenimest ja suvalisest arvust
                        generatePassword(scanner); //genereerib parooli
                        break;
                    case 0: //kui kasutaja valik on 0, sulgeb see programmi
                        System.out.println("Programm lopetas too."); //väljastab teksti
                        scanner.close(); //sulgeb "scanner" objekti
                        return; //lõpetab meetodi ja kogu programmi töö, juhul, kui kasutaja valib 0, lõpetab programm oma töö ja väljub
                    default: //kui kasutaja valik ei ole 0, siis see rida käivitatakse, ehk tähendab see,et kasutaja on teinud vale valiku
                        System.out.println("Viga valimisel, proovige uuesti."); //prindib välja teksti, et kasutaja on teinud viga valimisel, ning palub uuesti proovida.
                }
            }
        } catch (Exception e) { //defineerib catch ploki, mis püüab ja käitleb üldise erandi "Exception", mis võib tekkida programmitöö käigus.
            System.out.println("Viga: " + e.getMessage()); //väljastab teksti, mis sisaldab veateadet erandi kohta. 
                                                            //e.getMessage annab juurdepääsu erandist saadud sõnumile, mis aitab selgitada, mis valesti läks
        } finally { //seda plokki käivitatakse alati, olenemata sellest, kas erand tekkis või mitte.
            scanner.close(); //sulgeb scanner objekti, tagades selle õige ressursihalduse sõltumata eranditest.
        }
    }
    //Meetod õpilaste nimekirja laadimiseks failist
    private static List<String> loadStudents(String fileName) { //laeb õpilaste andmeid tekstifailist ja salvestab listi
        List<String> students = new ArrayList<>(); //loob uue tühja nimekirja
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) { //defineerib java ploki, haldab resursse, nt failide lugemiseks
            String line;
            while ((line = br.readLine()) != null) {    //vastutab õpilaste andmete lugemise ja lisamise eelnevalt avatud failist BufferedReader objekti kaudu students nimekirja.
                students.add(line);
            }
        } catch (IOException e) { //defineerib, mis tüüpi erandit catch plokk püüab.
            System.out.println("Viga lugemisel: " + e.getMessage()); //aitab käidelda võimalikke lugemisega seotud erandeid nii, et programm ei katkeks, kui tekib probleem, saab veateate.
        }
        return students; //tagastab meetodi poolt arvutatud või töödeldud andmeid
    }
    //Meetod esimeste 10 õpilaste kuvamiseks
    private static void displayFirst10Students(List<String> students) { //vastutab esimese 10 õpilase andmete kuvamise eest
        System.out.println("Esimesed 10 opilast:"); //väljastab teksti
        for (int i = 0; i < Math.min(10, students.size()); i++) { //läbib esimesed 10 õpilast
            System.out.println(students.get(i)); //väljastab iga õpilase nime
        }
    }
    //Meetod suvaliste õpilaste kuvamiseks
    private static void displayRandomStudents(List<String> students, int count) { //vastutab suvalise arvu õpilaste andmete kuvamise eest
        System.out.println(count + " suvalist opilast:"); //väljastab teksti koos "count"
        for (int i = 0; i < count; i++) { //count, mis algab nullist ja suureneb iga iteratsiooni järel
            int randomIndex = ThreadLocalRandom.current().nextInt(0, students.size()); //genereerib juhusliku indeksi "randomIndex"
            System.out.println(students.get(randomIndex)); //väljastab juhuslikult valitud õpilase nime listist "students", kasutades varem genereeritud "randomIndex"-i.
        }
    }
    //Meetod ainult emailide kuvamiseks
    private static void displayEmails(List<String> students) {
        System.out.println("Opilaste emailid:");
        for (String student : students) { //läbib kõik elemendid tsüklis
            String[] parts = student.split(","); //võtab stringi ja jagab selle komade järgi alamstringideks ning salvestab need alamstringid massiivi (parts)
            if (parts.length >= 2) { //see algab "if" avaldusega, mis kontrollib kas "parts" massiivi pikkus on suurem või võrdne 2-ga. Kontrollib, kas massiivis on vähemalt kaks elementi.
                System.out.println(parts[1]); //kui tingimus on tõene, väljastab see massiivi teise elemendi indeksiga 1.
            }
        }
    }
    //Meetod ainult esitähtede kuvamiseks (ei toimi päris õigesti)
    private static void displayInitials(List<String> students) {
        System.out.println("Nimede esitahed:");
        for (String student : students) { //läbib kõik elemendid tsüklis
            String[] parts = student.split(","); //võtab stringi ja jagab selle komade järgi alamstringideks ning salvestab need alamstringid massiivi (parts)
            if (parts.length >= 1) { //see kontrollib, kas "parts" massiivi pikkus on suurem või võrdne 1-ga.
                String name = parts[0]; //kui tingimus on tõene ehk massiivi pikkus on suurem/võrdne 1-ga, salvestab see esimese elemendi massiivist.
                String[] nameParts = name.split(" "); //see jagab stringi tühikute järgi ja salvestab tulemuse massiivi "nameParts"
                for (String namePart : nameParts) { //läbib kõiki nime osi, mis on salvestatud massiivis "nameParts"
                    System.out.print(namePart.charAt(0)); //väljastab igast nime osast esimese tähemärgi, kasutades "charAt"
                }
                System.out.println(); //väljastab tühja rea, et eraldada ühe õpilase nimede esitähed teisest
            }
        }
    }
    //Meetod parooli genereerimiseks
    private static void generatePassword(Scanner scanner) { //
        System.out.println("Sisestage perenimi:"); //väljastab teksti 
        String lastName = scanner.next(); //loeb kasutaja sisestatud perenime, kasutades "Scanner" ja meetodit "next()"
        int randomNum = ThreadLocalRandom.current().nextInt(1000, 10000); //genereerib juhusliku numbri vahemikus 1000 kuni 9999, ning salvestab selle muutujasse "randomNum"
        System.out.println("Teie parool on: " + lastName + randomNum); //väljastab teate, mis sisaldab loodud parooli kasutaja perenimest ning juhuslikust numbrist
    }
}
