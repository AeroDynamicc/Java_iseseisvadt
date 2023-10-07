 public class harjutus17 {
        public static void main(String[] args) {
            int[] arvud = {3, 5, 4, 12, 5}; //Arvude loend
            
            System.out.print("Paarisarvud: ");
            
            for (int arv : arvud) {
                if (arv % 2 == 0) {                 //kontrollib iga arvu paarisarvuks olemise suhtes ning kuvab kõik paarisarvud ühes reas.
                    System.out.print(arv + " ");
                }
            }
            
            System.out.println(); //Lihtsalt uue rea jaoks.
        }
    }
    
