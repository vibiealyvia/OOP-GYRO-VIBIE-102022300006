package TPMODUL2_VIBIE;



public class Burung extends Hewan {

    private String warnaBulu;

    public Burung(String nama, int umur, String warnaBulu) {

        super(nama, umur);

        this.warnaBulu = warnaBulu;

    }

    @Override

    public void suara() {

        System.out.println(nama + " berkicau");

    }


    @Override

    public void infoHewan() {

        System.out.println("Nama: " + nama + ", Umur: " + umur + " tahun, Warna bulu: " + warnaBulu);

    }

}