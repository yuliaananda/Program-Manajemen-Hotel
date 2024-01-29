// LoginPage.java
package views;

import controllers.AdminController;

import java.util.Scanner;

public class LoginPage {
    private Scanner input = new Scanner(System.in);
    private AdminController admin = new AdminController();

    public LoginPage() {
        int pil;
        do {
            System.out.print("""
                    1. Login
                    2. Exit
                    Pilih (1/2): """);
            pil = input.nextInt();
            input.nextLine();

            switch (pil) {
                case 1:
                    login();
                    break;
                case 2:
                    exit();
                    break;
                default:
                    System.out.println("Tidak valid");
                    break;
            }
        } while (pil != 2);
    }

    private void exit() {
        System.out.println("Terima kasih. Sampai jumpa!");
        System.exit(0);
    }

    private void login() {
        try {
            System.out.print("Masukkan ID Admin: ");
            String id = input.nextLine();
            System.out.print("Masukkan Password: ");
            String password = input.nextLine();

            boolean statusLogin = admin.loginAdmin(id, password);
            if (statusLogin) {
                new HomePage().tampilkanMenu();
            } else {
                System.out.println("ID / Password Salah");
            }
        } catch (Exception e) {
            System.err.println("Terjadi kesalahan saat login: " + e.getMessage());
        }
    }
}
