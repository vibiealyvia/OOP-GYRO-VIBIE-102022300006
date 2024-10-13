package TPMODUL1_VIBIE;

public class Penumpang {
    private String  NIK;
    private String  namaDepan;
    private String  namaBelakang;
    private String  nomorPenerbangan;

    public Penumpang(String NIK, String namaDepan, String namaBelakang, String nomorPenerbangan) {
        this.NIK = NIK;
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.nomorPenerbangan = nomorPenerbangan;
    }

    public String getNIK() { return NIK; }
    public String getNamaDepan() { return namaDepan; }
    public String getNamaBelakang() { return namaBelakang; }
    public String getNomorPenerbangan() { return nomorPenerbangan; }
}
