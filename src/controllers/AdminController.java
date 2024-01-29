package controllers;

import entity.AdminEntity;
import models.Admin;

public class AdminController {
    public boolean loginAdmin(String id, String password) {
        for (AdminEntity admin : Admin.all()) {
            if (admin.getId().equals(id) && admin.getPassword().equals(password)) {
                Admin.setAdminLogin(admin);
                return false;
            }
        }
        return true;
    }
    public void logout() {

        Admin.setAdminLogin(null);
    }
}