package views;

import java.util.Scanner;
import models.Manajemen;

public class HomePage {
    private Scanner input = new Scanner(System.in);

    public void tampilkanMenu() {
        int pilihan;

        do {
            System.out.println("============ APLIKASI HOTEL ============");
            System.out.println("1. Manajemen Kamar");
            System.out.println("2. Manajemen Reservasi");
            System.out.println("3. Keluar");
            System.out.print("Pilih Menu (1/2/3): ");
            pilihan = input.nextInt();
            input.nextLine(); // Membuang newline

            switch (pilihan) {
                case 1:
                    menuManajemenKamar();
                    break;
                case 2:
                    menuManajemenReservasi();
                    break;
                case 3:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 3);
    }

    private void menuManajemenKamar() {
        KamarPage kamarPage = new KamarPage();
        int pilihan;

        do {
            System.out.println("=========== MANAJEMEN KAMAR ===========");
            System.out.println("1. Tambah Data Kamar");
            System.out.println("2. Lihat Informasi Kamar");
            System.out.println("3. Edit Data Kamar");
            System.out.println("4. Kembali ke Menu Utama");
            System.out.print("Pilih Menu (1/2/3/4): ");
            pilihan = input.nextInt();
            input.nextLine(); // Membuang newline

            switch (pilihan) {
                case 1:
                    kamarPage.tambahDataKamar();
                    break;
                case 2:
                    kamarPage.lihatInfoKamar();
                    break;
                case 3:
                    kamarPage.editDataKamar();
                    break;
                case 4:
                    System.out.println("Kembali ke Menu Utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 4);
    }

    private void menuManajemenReservasi() {
        ReservasiPage reservasiPage = new ReservasiPage();
        int pilihan;

        do {
            System.out.println("========= MANAJEMEN RESERVASI =========");
            System.out.println("1. Reservasi Kamar");
            System.out.println("2. Lihat Detail Reservasi");
            System.out.println("3. Check-Out Kamar");
            System.out.println("4. Lihat Jumlah Kamar Tersedia");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih Menu (1/2/3/4/5): ");
            pilihan = input.nextInt();
            input.nextLine(); // Membuang newline

            switch (pilihan) {
                case 1:
                    reservasiPage.reservasiKamar();
                    break;
                case 2:
                    reservasiPage.lihatDetailReservasi();
                    break;
                case 3:
                    reservasiPage.checkOutKamar();
                    break;
                case 4:
                    reservasiPage.lihatJumlahKamarTersedia();
                    break;
                case 5:
                    System.out.println("Kembali ke Menu Utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 5);
    }
}
