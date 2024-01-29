package models;

import entity.AdminEntity;

import java.util.ArrayList;

public class Admin {
    public static ArrayList<AdminEntity> adminList = new ArrayList<>();
    private static AdminEntity adminLogin = null;

    public static void initialAdmin(){
        AdminEntity admin = new AdminEntity("YIYI", "1", "1");

        adminList.add(admin);
    }
    public static ArrayList<AdminEntity> all() {
        return adminList;
    }
    public static AdminEntity getAdminLogin(){
        return adminLogin;
    }
    public static void setAdminLogin(AdminEntity adminLogin){
        Admin.adminLogin = adminLogin;
    }
}
