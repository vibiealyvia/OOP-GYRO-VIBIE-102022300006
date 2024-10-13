package TPMODUL1_VIBIE;

import java.util.ArrayList;
import java.util.Scanner;

public class Pembelian {
    public static void main(String[] args) {
        ArrayList<Penerbangan> daftarPenerbangan = new ArrayList<>();
        ArrayList<Penumpang> daftarPenumpang = new ArrayList<>();

        daftarPenerbangan.add(
            new Penerbangan(
                "GA101", 
                "CGK, JAKARTA", 
                "DPS, Bali", 
                "06:30", 
                "08:15", 
                1200000
            )
        );
        daftarPenerbangan.add(
            new Penerbangan(
                "QZ202", 
                "SUB, Surabaya", 
                "KNO, Medan", 
                "09:00", 
                "11:45", 
                1350000
            )
        );

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== EAD TICKET BOOKING SYSTEM ===");

        while (true) {
            System.out.println("1. Tampilkan Daftar Penerbangan");
            System.out.println("2. Beli Tiket");
            System.out.println("3. Tampilkan Pesanan Tiket");
            System.out.println("4. Exit");
            System.out.print("Silahkan pilih menu: ");

            int pilihanMenu = scanner.nextInt();
            scanner.nextLine();

            switch (pilihanMenu) {
                case 1:
                    int index = 1;
                    for (Penerbangan penerbangan : daftarPenerbangan) {
                        System.out.println();
                        System.out.println(index);
                        penerbangan.tampilDaftarPenerbangan();
                        index++;
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    System.out.print("Masukkan NIK: ");
                    String NIK = scanner.nextLine();

                    System.out.print("Masukkan Nama Depan: ");
                    String namaDepan = scanner.nextLine();

                    System.out.print("Masukkan Nama Belakang: ");
                    String namaBelakang = scanner.nextLine();

                    System.out.println("\nTerima kasih telah mengisi data pelanggan. Silahkan pilih tiket penerbangan yang tersedia");

                    index = 1;
                    for (Penerbangan penerbangan : daftarPenerbangan) {
                        System.out.println();
                        System.out.println(index);
                        penerbangan.tampilDaftarPenerbangan();
                        index++;
                    }

                    System.out.print("\nPilih nomor penerbangan (ex 1): ");
                    int pilihanPenerbangan = scanner.nextInt();
                    scanner.nextLine();

                    if (pilihanPenerbangan > 0 && pilihanPenerbangan <= daftarPenerbangan.size()) {
                        String nomorPenerbangan = daftarPenerbangan.get(pilihanPenerbangan - 1).getNomorPenerbangan();

                        daftarPenumpang.add(
                            new Penumpang(
                                NIK,
                                namaDepan,
                                namaBelakang,
                                nomorPenerbangan
                            )
                        );

                        System.out.println("\nPemesanan tiket berhasil dilakukan, cek pesanan tiket pada menu (3)");
                    } else {
                        System.out.println("\nPilihan tidak valid.");
                    }
                    break;
                case 3:
                    System.out.println();
                    if (daftarPenumpang.isEmpty()) {
                        System.out.println("Tidak ada pesanan tiket.");
                    } else {
                        index = 1;
                        for (Penumpang penumpang : daftarPenumpang) {
                            System.out.println(index);
                            String nomorPenerbangan = penumpang.getNomorPenerbangan();
                            Penerbangan matchingPenerbangan = null;
                
                            for (Penerbangan penerbangan : daftarPenerbangan) {
                                if (penerbangan.getNomorPenerbangan().equals(nomorPenerbangan)) {
                                    matchingPenerbangan = penerbangan;
                                    break;
                                }
                            }
                
                            System.out.println("NIK                     : " + penumpang.getNIK());
                            System.out.println("Nama                    : " + penumpang.getNamaDepan() + " " + penumpang.getNamaBelakang());
                            if (matchingPenerbangan != null) {
                                matchingPenerbangan.tampilDaftarPenerbangan();
                            }
                            index++;
                        }
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Maaf, menu tersebut belum tersedia.\n");
            }
        }
    }
}