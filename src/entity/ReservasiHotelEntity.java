package entity;

public class ReservasiHotelEntity {
    private PelangganEntity pelanggan;
    private KamarEntity kamar;
    private PembayaranEntity pembayaran;
    private int berapaMalam;
    private int totalHarga;
    private String tanggalCheckIn;
    private String tanggalCheckOut;
    private boolean status;

    public ReservasiHotelEntity(PelangganEntity pelanggan, KamarEntity kamar, PembayaranEntity pembayaran, int berapaMalam, int totalHarga, String tanggalCheckIn, String tanggalCheckOut, boolean status) {
        this.pelanggan = pelanggan;
        this.kamar = kamar;
        this.pembayaran = pembayaran;
        this.berapaMalam = berapaMalam;
        this.totalHarga = totalHarga;
        this.tanggalCheckIn = tanggalCheckIn;
        this.tanggalCheckOut = tanggalCheckOut;
        this.status = status;
    }

    public ReservasiHotelEntity(PelangganEntity pelanggan, KamarEntity kamar, int i, int berapaMalam, String tanggalCheckIn, String tanggalCheckOut, boolean b) {
    }

    public void dataReservasiHotel(){
        System.out.println("Berapa Malam Menginap : " + berapaMalam);
        System.out.println("Total Harga : " + totalHarga);
        System.out.println("Tanggal CheckIn : " + tanggalCheckIn);
        System.out.println("Tanggal CheckOut : " + tanggalCheckOut);
    }

    public PelangganEntity getPelanggan() {
        return pelanggan;
    }

    public KamarEntity getKamar() {
        return kamar;
    }

    public PembayaranEntity getPembayaran() {
        return pembayaran;
    }

    public void setKamar(KamarEntity kamar) {
        this.kamar = kamar;
    }

    public int getBerapaMalam() {
        return berapaMalam;
    }

    public void setBerapaMalam(int berapaMalam) {
        this.berapaMalam = berapaMalam;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getTanggalCheckIn() {
        return tanggalCheckIn;
    }

    public void setTanggalCheckIn(String tanggalCheckIn) {
        this.tanggalCheckIn = tanggalCheckIn;
    }

    public String getTanggalCheckOut() {
        return tanggalCheckOut;
    }

    public void setTanggalCheckOut(String tanggalCheckOut) {
        this.tanggalCheckOut = tanggalCheckOut;
    }
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
