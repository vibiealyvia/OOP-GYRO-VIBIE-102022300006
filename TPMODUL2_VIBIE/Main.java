package TPMODUL2_VIBIE;

public class Main {



        public static void main(String[] args) {

            System.out.println("Detail Hewan");


            Kucing kucing = new Kucing("Marlo", 2, "Scottish Fold");

            System.out.println("\nIni adalah Marlo");

            kucing.suara();

            kucing.makan();

            kucing.makan("Catfood");


            Burung burung = new Burung("Miki", 2, "Kuning");

            System.out.println("\nIni adalah Miki");

            burung.suara();

            burung.makan();

            burung.makan("Jagung");


            System.out.println();

            kucing.infoHewan();

            burung.infoHewan();

        }

    }
