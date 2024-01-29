package views;

import java.util.ArrayList;
import java.util.Scanner;
import entity.KamarEntity;
import entity.PelangganEntity;
import entity.ReservasiHotelEntity;
import models.Manajemen;

public class KamarPage {
    private Scanner input = new Scanner(System.in);

    public void tambahDataKamar() {
        System.out.println("TAMBAH DATA KAMAR ");

        System.out.print("No Kamar        : ");
        String noKamar = input.nextLine();

        System.out.print("Jenis Bed       : ");
        String jenisBed = input.nextLine();

        System.out.print("Harga Per Malam : ");
        int hargaPerMalam = input.nextInt();
        input.nextLine(); // Membuang newline

        Manajemen.tambahDataKamar(noKamar, jenisBed, hargaPerMalam);

        System.out.println("Data kamar berhasil ditambahkan.");

        System.out.println("=================================================");
    }

    public void lihatInfoKamar() {
        System.out.println(" INFORMASI KAMAR ");

        for (KamarEntity kamar : Manajemen.kamarList) {
            System.out.println("---------------------------------------");
            System.out.println("No Kamar        : " + kamar.getNoKamar());
            System.out.println("Jenis Bed       : " + kamar.getJenisBed());
            System.out.println("Harga Per Malam : " + kamar.getHargaPerMalam());
            System.out.println("Status          : " + (kamar.isStatus() ? "Tersedia" : "Terisi"));
        }

        System.out.println("---------------------------------------");

        System.out.print("Lanjut ...");
        input.nextLine(); // Menunggu input apapun
        System.out.println();
    }

    public void editDataKamar() {
        System.out.println("=============== EDIT DATA KAMAR ================");

        System.out.print("Masukkan No Kamar yang ingin diubah: ");
        String noKamar = input.nextLine();

        KamarEntity kamar = Manajemen.cariKamarByNoKamar(noKamar);

        if (kamar != null) {
            System.out.print("Masukkan Harga Baru: ");
            int hargaBaru = input.nextInt();
            input.nextLine(); // Membuang newline

            Manajemen.editDataKamar(noKamar, kamar.getJenisBed(), hargaBaru, kamar.isStatus());
            System.out.println("Berhasil mengubah data kamar.");
        } else {
            System.out.println("Data kamar tidak ditemukan.");
        }

        System.out.println("=================================================");
    }

    public void reservasiKamar(PelangganEntity pelanggan) {
        System.out.println("=============== RESERVASI KAMAR ================");

        System.out.print("Masukkan No Kamar yang ingin direservasi: ");
        String noKamar = input.nextLine();

        KamarEntity kamar = Manajemen.cariKamarByNoKamar(noKamar);

        if (kamar != null) {
            if (kamar.isStatus()) {
                System.out.print("Masukkan Nama Pelanggan: ");
                String namaPelanggan = input.nextLine();

                System.out.print("Jenis Pembayaran (Cash/Card): ");
                String jenisPembayaran = input.nextLine();

                System.out.print("Tanggal Check-In (dd/mm/yyyy): ");
                String tanggalCheckIn = input.nextLine();

                System.out.print("Tanggal Check-Out (dd/mm/yyyy): ");
                String tanggalCheckOut = input.nextLine();

                Manajemen.reservasiKamar(noKamar, tanggalCheckIn, tanggalCheckOut, pelanggan);
                System.out.println("Reservasi berhasil dilakukan.");
            } else {
                System.out.println("Maaf, kamar tersebut sudah terisi.");
            }
        } else {
            System.out.println("Data kamar tidak ditemukan.");
        }

        System.out.println("=================================================");
    }

    public void lihatDetailReservasi() {
        System.out.println("========= DETAIL RESERVASI KAMAR =========");

        System.out.print("Masukkan No Kamar: ");
        String noKamar = input.nextLine();

        KamarEntity kamar = Manajemen.cariKamarByNoKamar(noKamar);

        if (kamar != null) {
            ArrayList<ReservasiHotelEntity> detailReservasiList = Manajemen.lihatDetailReservasi(noKamar);

            if (!detailReservasiList.isEmpty()) {
                for (ReservasiHotelEntity reservasi : detailReservasiList) {
                    System.out.println("---------------------------------------");
                    System.out.println("No Kamar            : " + noKamar);
                    System.out.println("Nama Pelanggan      : " + reservasi.getPelanggan().getNamaPelanggan());
                    System.out.println("Jenis Pembayaran    : " + reservasi.getPelanggan().getJenisPembayaran());
                    System.out.println("Tanggal Check-In    : " + reservasi.getTanggalCheckIn());
                    System.out.println("Tanggal Check-Out   : " + reservasi.getTanggalCheckOut());
                    System.out.println("Berapa Malam        : " + reservasi.getBerapaMalam() + " hari");
                    System.out.println("Total Harga         : " + reservasi.getTotalHarga());
                    System.out.println("---------------------------------------");
                }
            } else {
                System.out.println("Tidak ada reservasi untuk kamar ini.");
            }
        } else {
            System.out.println("Data kamar tidak ditemukan.");
        }

        System.out.println("=========================================");
    }




    public void checkOutKamar() {
        System.out.println("=============== CHECK-OUT KAMAR ================");

        System.out.print("Masukkan No Kamar yang ingin di-check-out: ");
        String noKamar = input.nextLine();

        PelangganEntity pelanggan = Manajemen.checkOutKamar(noKamar);

        if (pelanggan != null) {
            System.out.println("Check-out berhasil dilakukan untuk pelanggan: " + pelanggan.getNamaPelanggan());
        } else {
            System.out.println("Kamar tidak ditemukan atau belum melakukan check-in.");
        }

        System.out.println("=================================================");
    }

    public void lihatJumlahKamarTersedia() {
        System.out.println("========= JUMLAH KAMAR TERSEDIA =========");

        int jumlahTersedia = Manajemen.getJumlahKamarTersedia();
        System.out.println("Jumlah kamar tersedia saat ini: " + jumlahTersedia);

        System.out.println("=========================================");
    }

    public void lihatDataPelanggan() {
        System.out.println("=============== DATA PELANGGAN ================");

        for (ReservasiHotelEntity reservasi : Manajemen.reservasiList) {
            System.out.println("---------------------------------------");
            System.out.println("Nama Pelanggan      : " + reservasi.getPelanggan().getNamaPelanggan());
            System.out.println("No Kamar            : " + reservasi.getKamar().getNoKamar());
            System.out.println("Jenis Pembayaran    : " + reservasi.getPelanggan().getJenisPembayaran());
            System.out.println("Tanggal Check-In    : " + reservasi.getTanggalCheckIn());
            System.out.println("Tanggal Check-Out   : " + reservasi.getTanggalCheckOut());
            System.out.println("Durasi Menginap     : " + reservasi.getBerapaMalam() + " hari");
            System.out.println("Total Harga         : " + reservasi.getTotalHarga());
        }

        System.out.println("---------------------------------------");

        System.out.print("Lanjut ...");
        input.nextLine(); // Menunggu input apapun
        System.out.println();
    }
}
