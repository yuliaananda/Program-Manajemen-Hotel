package views;

import java.util.Scanner;
import entity.KamarEntity;
import entity.PelangganEntity;
import entity.ReservasiHotelEntity;
import models.Manajemen;

public class ReservasiPage {
    private Scanner input = new Scanner(System.in);

    public void reservasiKamar() {
        System.out.println("=============== RESERVASI KAMAR ================");

        System.out.print("Masukkan No Kamar yang ingin direservasi: ");
        String noKamar = input.nextLine();

        KamarEntity kamar = Manajemen.cariKamarByNoKamar(noKamar);

        if (kamar != null) {
            if (kamar.isStatus()) {
                PelangganEntity pelanggan = inputPelangganData();

                System.out.print("Tanggal Check-In (YYYY-MM-DD): ");
                String tanggalCheckIn = input.nextLine();

                System.out.print("Tanggal Check-Out (YYYY-MM-DD): ");
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
            System.out.println("Detail Reservasi untuk Kamar No. " + noKamar);
            System.out.println("---------------------------------------");

            for (ReservasiHotelEntity reservasi : Manajemen.lihatDetailReservasi(noKamar)) {
                displayPelangganDetail(reservasi.getPelanggan());
            }
        } else {
            System.out.println("Data kamar tidak ditemukan.");
        }

        System.out.println("=========================================");
    }

    private PelangganEntity inputPelangganData() {
        System.out.print("Masukkan Nama Pelanggan: ");
        String namaPelanggan = input.nextLine();

        System.out.print("NIK Pelanggan: ");
        String nikPelanggan = input.nextLine();

        System.out.print("Alamat Pelanggan: ");
        String alamatPelanggan = input.nextLine();

        System.out.print("No. Telpon Pelanggan: ");
        String noTelpPelanggan = input.nextLine();

        System.out.print("Jenis Pembayaran (Cash/Card): ");
        String jenisPembayaran = input.nextLine();

        int durasiMenginap = inputDurasiMenginap();

        return new PelangganEntity(namaPelanggan, nikPelanggan, alamatPelanggan, noTelpPelanggan, jenisPembayaran, durasiMenginap);
    }

    private int inputDurasiMenginap() {
        int durasiMenginap;
        while (true) {
            try {
                System.out.print("Durasi Menginap (hari): ");
                durasiMenginap = Integer.parseInt(input.nextLine());
                if (durasiMenginap > 0) {
                    break;
                } else {
                    System.out.println("Durasi menginap harus lebih dari 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid.");
            }
        }
        return durasiMenginap;
    }

    private void displayPelangganDetail(PelangganEntity pelanggan) {
        System.out.println("Nama Pelanggan       : " + pelanggan.getNamaPelanggan());
        System.out.println("NIK Pelanggan        : " + pelanggan.getNik());
        System.out.println("Alamat Pelanggan     : " + pelanggan.getAlamat());
        System.out.println("No.Telpon Pelanggan  : " + pelanggan.getNoTelp());
        System.out.println("Jenis Pembayaran     : " + pelanggan.getJenisPembayaran());
        System.out.println("Durasi Menginap (hari): " + pelanggan.getDurasiMenginap());
        System.out.println("Tanggal Check-In     : " + pelanggan.getTanggalCheckIn());
        System.out.println("Tanggal Check-Out    : " + pelanggan.getTanggalCheckOut());
        System.out.println("---------------------------------------");
    }

    public void checkOutKamar() {
        if (Manajemen.getJumlahKamarTersedia() == 0) {
            System.out.println("Tidak ada kamar tersedia.");
        } else {
            System.out.println("=============== CHECK OUT KAMAR ===============");
        }
    }

        public void lihatJumlahKamarTersedia () {
            if (Manajemen.getJumlahKamarTersedia() == 0) {
                System.out.println("Tidak ada kamar tersedia.");
            } else {
                System.out.println("Jumlah kamar tersedia: " + Manajemen.getJumlahKamarTersedia());
            }
        }

}
