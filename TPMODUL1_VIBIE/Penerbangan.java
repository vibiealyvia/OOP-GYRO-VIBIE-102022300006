package TPMODUL1_VIBIE;

public class Penerbangan {
    private String  nomorPenerbangan;
    private String  bandaraKeberangkatan;
    private String  bandaraTujuan;
    private String  waktuKeberangkatan;
    private String  waktuKedatangan;
    private float   hargaTiket;

    public Penerbangan(
        String nomorPenerbangan, 
        String bandaraKeberangkatan, 
        String bandaraTujuan, 
        String waktuKeberangkatan, 
        String waktuKedatangan, 
        float hargaTiket
    ) {
        this.nomorPenerbangan = nomorPenerbangan;
        this.bandaraKeberangkatan = bandaraKeberangkatan;
        this.bandaraTujuan = bandaraTujuan;
        this.waktuKeberangkatan = waktuKeberangkatan;
        this.waktuKedatangan = waktuKedatangan;
        this.hargaTiket = hargaTiket;
    }    

    public String getNomorPenerbangan() { return nomorPenerbangan; }
    public String getBandaraKeberangkatan() { return bandaraKeberangkatan; }
    public String getBandaraTujuan() { return bandaraTujuan; }
    public String getWaktuKeberangkatan() { return waktuKeberangkatan; }
    public String getWaktuKedatangan() { return waktuKedatangan; }
    public float getHargaTiket() { return hargaTiket; }

    public void tampilDaftarPenerbangan() {
        System.out.println("Nomor Penerbangan       : " + nomorPenerbangan);
        System.out.println("Bandara Keberangkatan   : " + bandaraKeberangkatan);
        System.out.println("Bandara Tujuan          : " + bandaraTujuan);
        System.out.println("Waktu Keberangkatan     : " + waktuKeberangkatan);
        System.out.println("Waktu Kedatangan        : " + waktuKedatangan);
        System.out.println("Harga Tiket             : " + hargaTiket);
    }
}

