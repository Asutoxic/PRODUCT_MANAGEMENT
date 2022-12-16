package views;

import utils.AppUtils;

import java.util.Scanner;

public class MemberView {
    public static void launch() {
        int option;
        do {
            System.out.println("☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
            System.out.println("☯                                                                                MEMBER MENU                                                                           ☯");
            System.out.println("☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
            System.out.println("☯                                                                                                                                                                      ☯");
            System.out.println("☯                                                                      [1] Hiển Thị Sản Phẩm                                                                           ☯");
            System.out.println("☯                                                                      [2] Tìm Kiếm Sản Phẩm                                                                           ☯");
            System.out.println("☯                                                                      [3] Sắp Xếp Sản Phẩm Theo Giá Tăng Dần                                                          ☯");
            System.out.println("☯                                                                      [4] Sắp Xếp Sản Phẩm Theo Giá Giảm Dần                                                          ☯");
            System.out.println("☯                                                                      [5] Tạo Order                                                                                   ☯");
            System.out.println("☯                                                                      [6] Xem Danh Sách Order                                                                         ☯");
            System.out.println("☯                                                                      [0] Thoát                                                                                       ☯");
            System.out.println("☯                                                                                                                                                                      ☯");
            System.out.println("☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
            Scanner scanner = new Scanner(System.in);
            ProductView productView = new ProductView();
            OrderView orderView = new OrderView();
            System.out.println("\nChọn chức năng: ");
            option = AppUtils.retryChoose(0,6);
            switch (option) {
                case 1:
                    productView.showProducts(InputOption.SHOW);
                    break;
                case 2:
                    productView.findProduct();
                    break;
                case 3:
                    productView.sortByPriceOrderByASC();
                    break;
                case 4:
                    productView.sortByPriceOrderByDESC();
                    break;
                case 5:
                    orderView.addOrder();
                    break;
                case 6:
                    orderView.showAllOrder();
                    break;
                case 0:
                    AppUtils.exit();
                    break;
                default:
                    System.err.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                    launch();
            }
        } while (true);
    }
}
