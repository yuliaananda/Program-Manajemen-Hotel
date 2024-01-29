package models;

import java.util.ArrayList;
import entity.KamarEntity;
import entity.ReservasiHotelEntity;
import entity.PelangganEntity;

public class Manajemen {

    public static ArrayList<KamarEntity> kamarList = new ArrayList<>();
    public static ArrayList<ReservasiHotelEntity> reservasiList = new ArrayList<>();

    public static void tambahDataKamar(String noKamar, String jenisBed, int hargaPerMalam) {
        KamarEntity newKamar = new KamarEntity();
        newKamar.setNoKamar(noKamar);
        newKamar.setJenisBed(jenisBed);
        newKamar.setHargaPerMalam(hargaPerMalam);
        newKamar.setStatus(true);
        kamarList.add(newKamar);
        System.out.println("Data kamar berhasil ditambahkan.");
    }

    public static KamarEntity cariKamarByNoKamar(String noKamar) {
        for (KamarEntity kamar : kamarList) {
            if (kamar.getNoKamar().equals(noKamar)) {
                return kamar;
            }
        }
        return null;
    }

    public static void editDataKamar(String noKamar, String jenisBed, int hargaPerMalam, boolean status) {
        KamarEntity kamar = cariKamarByNoKamar(noKamar);
        if (kamar != null) {
            kamar.setJenisBed(jenisBed);
            kamar.setHargaPerMalam(hargaPerMalam);
            kamar.setStatus(status);
            System.out.println("Data kamar berhasil diubah.");
        } else {
            System.out.println("Kamar tidak ditemukan.");
        }
    }

    public static void reservasiKamar(String noKamar, String tanggalCheckIn, String tanggalCheckOut, PelangganEntity pelanggan) {
        KamarEntity kamar = cariKamarByNoKamar(noKamar);
        if (kamar != null && kamar.isStatus()) {
            ReservasiHotelEntity reservasi = new ReservasiHotelEntity(pelanggan, kamar, 0, 0, tanggalCheckIn, tanggalCheckOut, false);
            reservasiList.add(reservasi);
            kamar.setStatus(false);
            System.out.println("Reservasi berhasil dilakukan.");
        } else {
            System.out.println("Kamar tidak tersedia atau tidak ditemukan.");
        }
    }


    public static ArrayList<ReservasiHotelEntity> lihatDetailReservasi(String noKamar) {
        ArrayList<ReservasiHotelEntity> detailReservasiList = new ArrayList<>();
        for (ReservasiHotelEntity reservasi : reservasiList) {
            if (reservasi.getKamar().getNoKamar().equals(noKamar)) {
                detailReservasiList.add(reservasi);
            }
        }
        return detailReservasiList;
    }

    public static PelangganEntity checkOutKamar(String noKamar) {
        for (ReservasiHotelEntity reservasi : reservasiList) {
            if (reservasi.getKamar().getNoKamar().equals(noKamar) && !reservasi.isStatus()) {
                reservasi.setStatus(true);
                return reservasi.getPelanggan();
            }
        }
        return null;
    }

    public static int getJumlahKamarTersedia() {
        int jumlahKamarTersedia = 0;
        for (KamarEntity kamar : kamarList) {
            if (kamar.isStatus()) {
                jumlahKamarTersedia++;
            }
        }
        return jumlahKamarTersedia;
    }

    public static void lihatDataPelanggan() {
        for (ReservasiHotelEntity reservasi : reservasiList) {
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
    }
}
