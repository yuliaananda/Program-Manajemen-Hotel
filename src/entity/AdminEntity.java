package entity;

public class AdminEntity extends IdentitasEntity{
    private String namaAdmin;
    private String id;
    private String password;

    public String getId(){
        return id;
    }
    public String getPassword(){
        return password;
    }
    public AdminEntity(String namaAdmin, String id, String password){
        this.namaAdmin = namaAdmin;
        this.id = id;
        this.password = password;
    }
    public void dataAdmin(){
        System.out.println("Nama Admin : " + namaAdmin);
        System.out.println("ID Admin : " + id);
        System.out.println("Password : " + password);
    }

    public String getNamaAdmin() {
        return namaAdmin;
    }

    public void setNamaAdmin(String namaAdmin) {
        this.namaAdmin = namaAdmin;
    }
}
