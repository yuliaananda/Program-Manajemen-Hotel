// Menu.java
package views;

import controllers.AdminController;

import java.util.Scanner;

public class Menu {
    private Scanner input = new Scanner(System.in);
    private AdminController admin = new AdminController();

    public void menu() {
        String pilih;
        do {
            System.out.println("""
                    1. Login
                    2. Exit
                    """);
            System.out.print("Masukkan Pilihan Anda = ");
            pilih = input.nextLine();

            switch (pilih) {
                case "1":
                    login();
                    break;
                case "2":
                    exit();
                    break;
                default:
                    System.out.println("Inputan Tidak Ada");
                    break;
            }
        } while (!pilih.equals("2"));
    }

    private void login() {
        try {
            System.out.print("Masukkan ID Admin: ");
            String id = input.nextLine();
            System.out.print("Masukkan Password: ");
            String password = input.nextLine();

            boolean statusLogin = admin.loginAdmin(id, password);
            if (statusLogin) {
                System.out.println("Anda berhasil login!");
                new HomePage().tampilkanMenu();
            } else {
                System.out.println("ID / Password Salah");
            }
        } catch (Exception e) {
            System.err.println("Terjadi kesalahan saat login: " + e.getMessage());
        }
    }

    private void exit() {
        System.out.println("Terima kasih. Sampai jumpa!");
        System.exit(0);
    }
}
