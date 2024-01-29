package entity;

public class PembayaranEntity {
    private String jenisPembayaran;
    private double jumlah;
    private ReservasiHotelEntity reservasiHotel;
    private boolean status;

    public PembayaranEntity(String jenisPembayaran, double jumlah, ReservasiHotelEntity reservasiHotel, boolean status) {
        this.jenisPembayaran = jenisPembayaran;
        this.jumlah = jumlah;
        this.reservasiHotel = reservasiHotel;
        this.status = status;
    }

    public String getJenisPembayaran() {
        return jenisPembayaran;
    }

    public void setJenisPembayaran(String jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public ReservasiHotelEntity getReservasiHotel() {
        return reservasiHotel;
    }

    public void setReservasiHotel(ReservasiHotelEntity reservasiHotel) {
        this.reservasiHotel = reservasiHotel;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void dataPembayaran() {
        System.out.println("Detail Pembayaran:");
        System.out.println("Jenis Pembayaran: " + jenisPembayaran);
        System.out.println("Jumlah: " + jumlah);
        System.out.println("Detail Reservasi: " + reservasiHotel);
        System.out.println("Status: " + (status ? "Diterima" : "Menunggu"));
    }
}
