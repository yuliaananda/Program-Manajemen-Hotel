package entity;

public class PelangganEntity extends IdentitasEntity {
    private String namaPelanggan;
    private String nik;
    private String alamat;
    private String noTelp;
    private String jenisPembayaran;
    private int durasiMenginap;
    private String tanggalCheckIn;
    private String tanggalCheckOut;

    // Konstruktor yang sesuai dengan atribut yang ada
    public PelangganEntity(String namaPelanggan, String nik, String alamat, String noTelp, String jenisPembayaran, int durasiMenginap) {
        this.namaPelanggan = namaPelanggan;
        this.nik = nik;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.jenisPembayaran = jenisPembayaran;
        this.durasiMenginap = durasiMenginap;
        this.tanggalCheckIn = tanggalCheckIn;
        this.tanggalCheckOut = tanggalCheckOut;
    }

    public void dataPelanggan() {
        System.out.println("Nama Pelanggan       : " + namaPelanggan);
        System.out.println("NIK Pelanggan        : " + nik);
        System.out.println("Alamat Pelanggan     : " + alamat);
        System.out.println("No.Telpon Pelanggan  : " + noTelp);
        System.out.println("Jenis Pembayaran     : " + jenisPembayaran);
        System.out.println("Durasi Menginap (hari): " + durasiMenginap);
        System.out.println("Tanggal Check-In     : " + tanggalCheckIn);
        System.out.println("Tanggal Check-Out    : " + tanggalCheckOut);
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getJenisPembayaran() {
        return jenisPembayaran;
    }

    public String getNik() {
        return nik;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public int getDurasiMenginap() {
        return durasiMenginap;
    }

    public String getTanggalCheckIn() {
        return tanggalCheckIn;
    }

    public String getTanggalCheckOut() {
        return tanggalCheckOut;
    }
}
