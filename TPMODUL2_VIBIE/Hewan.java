package TPMODUL2_VIBIE;

public class Hewan {

        protected String nama;

        protected int umur;

        public Hewan(String nama, int umur) {
            this.nama = nama;
            this.umur = umur;
        }

        public void suara() {}

        public void makan() {

            System.out.println(nama + " sedang makan");

        }

        public void makan(String makanan) {

            System.out.println(nama + " sedang makan " + makanan);

        }
        
        public void infoHewan() {}
    }
