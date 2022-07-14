package views;

import utils.AppUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainLauncher {
    public static void launch() {
        LoginView loginView = new LoginView();
        loginView.login();
    }

    public static void menuOption() {
        do {
            mainMenu();
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\nChọn chức năng ");
                System.out.print("⭆ ");
                int number = scanner.nextInt();
                switch (number) {
                    case 1:
                        UserViewLauncher.launch();
                        break;
                    case 2:
                        ProductViewLauncher.run();
                        break;
                    case 3:
                        OrderViewLauncher.run();
                        break;
                    case 0:
                        AppUtils.exit();
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        menuOption();
                }

            } catch (InputMismatchException io) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static void productMenu() {
        System.out.println("☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
        System.out.println("☯                                          QUẢN LÝ SẢN PHẨM                                            ☯");
        System.out.println("☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
        System.out.println("☯                                                                                                      ☯");
        System.out.println("☯                                   [1] Hiển thị danh sách sản phẩm                                    ☯");
        System.out.println("☯                                   [2] Thêm sản phẩm                                                  ☯");
        System.out.println("☯                                   [3] Sửa sản phẩm                                                   ☯");
        System.out.println("☯                                   [4] Xóa sản phẩm                                                   ☯");
        System.out.println("☯                                   [5] Tìm kiếm sản phẩm                                              ☯");
        System.out.println("☯                                   [6] Sắp xếp sản phẩm theo giá tăng dần                             ☯");
        System.out.println("☯                                   [7] Sắp xếp sản phẩm theo giá giảm dần                             ☯");
        System.out.println("☯                                   [8] Quay lại                                                       ☯");
        System.out.println("☯                                   [0] Thoát                                                          ☯");
        System.out.println("☯                                                                                                      ☯");
        System.out.println("☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
    }

    public static void mainMenu() {
        System.out.println("☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
        System.out.println("☯                                              MAIN MENU                                               ☯");
        System.out.println("☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
        System.out.println("☯                                                                                                      ☯");
        System.out.println("☯                                        [1] Quản Lý Người DÙng                                        ☯");
        System.out.println("☯                                        [2] Quản Lý Sản Phẩm                                          ☯");
        System.out.println("☯                                        [3] Quản Lý Đơn Đặt Hàng                                      ☯");
        System.out.println("☯                                        [0] Thoát                                                     ☯");
        System.out.println("☯                                                                                                      ☯");
        System.out.println("☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
    }

    public static void userMenu() {
       System.out.println("☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
        System.out.println("☯                                           QUẢN LÝ NGƯỜI DÙNG                                         ☯");
        System.out.println("☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
        System.out.println("☯                                                                                                      ☯");
        System.out.println("☯                                        [1] Thêm Người Dùng                                           ☯");
        System.out.println("☯                                        [2] Sửa Thông tin Người Dùng                                  ☯");
        System.out.println("☯                                        [3] Hiển Thị Danh Sách Người Dùng                             ☯");
        System.out.println("☯                                        [4] Xóa Người Dùng                                            ☯");
        System.out.println("☯                                        [5] Quay Lại                                                  ☯");
        System.out.println("☯                                        [0] Thoát                                                     ☯");
        System.out.println("☯                                                                                                      ☯");
        System.out.println("☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
    }

    public static void orderMenu() {
        System.out.println("☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
        System.out.println("☯                                              ORDER MENU                                              ☯");
        System.out.println("☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
        System.out.println("☯                                                                                                      ☯");
        System.out.println("☯                                         [1] Tạo Order                                                ☯");
        System.out.println("☯                                         [2] Xem Danh Sách Order                                      ☯");
        System.out.println("☯                                         [3] Quay Lại                                                 ☯");
        System.out.println("☯                                         [0] Thoát                                                    ☯");
        System.out.println("☯                                                                                                      ☯");
        System.out.println("☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
    }
}
