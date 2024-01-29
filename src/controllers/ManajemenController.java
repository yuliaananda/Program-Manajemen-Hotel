package controllers;

import entity.KamarEntity;
import entity.PelangganEntity;
import models.Manajemen;
import entity.ReservasiHotelEntity;

import java.util.ArrayList;

public class ManajemenController {

    private String noKamar;

    public void toView() {
        // Implementasi tampilan dashboard admin
    }

    public ArrayList<KamarEntity> getKamarList() {
        return Manajemen.kamarList;
    }

    public void tambahDataKamar(String noKamar, String jenisBed, int hargaPerMalam) {
        Manajemen.tambahDataKamar(noKamar, jenisBed, hargaPerMalam);
    }

    public void lihatInformasiKamar(String noKamar) {
        KamarEntity kamar = Manajemen.cariKamarByNoKamar(noKamar);
        if (kamar != null) {
            // Display room information
            System.out.println("No Kamar          : " + kamar.getNoKamar());
            System.out.println("Jenis Bed         : " + kamar.getJenisBed());
            System.out.println("Harga Per Malam   : " + kamar.getHargaPerMalam());
            System.out.println("Status            : " + (kamar.isStatus() ? "Tersedia" : "Terisi"));
        } else {
            System.out.println("Data kamar tidak ditemukan.");
        }
    }

    public void editDataKamar(String noKamar, String jenisBed, int hargaPerMalam, boolean status) {
        Manajemen.editDataKamar(noKamar, jenisBed, hargaPerMalam, status);
    }

    public void reservasiKamar(String noKamar, PelangganEntity pelanggan, String tanggalCheckIn, String tanggalCheckOut) {
        Manajemen.reservasiKamar(noKamar, tanggalCheckIn, tanggalCheckOut, pelanggan);
    }

    public ArrayList<ReservasiHotelEntity> lihatDetailReservasi() {
        return Manajemen.lihatDetailReservasi(noKamar);
    }

    public ArrayList<ReservasiHotelEntity> lihatDetailReservasi(String noKamar) {
        return Manajemen.lihatDetailReservasi(noKamar);
    }

    public void checkOutKamar(String noKamar) {
        Manajemen.checkOutKamar(noKamar);
    }

    public void lihatJumlahKamarTersedia() {
        Manajemen.getJumlahKamarTersedia();
    }

    public void lihatDataPelanggan() {
        Manajemen.lihatDataPelanggan();
    }
}
