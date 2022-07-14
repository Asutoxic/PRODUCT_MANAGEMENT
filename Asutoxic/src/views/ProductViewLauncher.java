package views;

import utils.AppUtils;

import java.util.Scanner;

public class ProductViewLauncher {
    public static void run() {
        int choice;
        do {
            Scanner scanner = new Scanner(System.in);
            ProductView productView = new ProductView();
            MainLauncher.productMenu();
            System.out.print("Chọn chức năng");
            choice = AppUtils.retryChoose(0, 8);
            switch (choice) {
                case 1:
                    productView.showProducts(InputOption.SHOW);
                    break;
                case 2:
                    productView.add();
                    break;
                case 3:
                    productView.update();
                    break;
                case 4:
                    productView.remove();
                    break;
                case 5:
                    productView.findProduct();
                    break;
                case 6:
                    productView.sortByPriceOrderByASC();
                    break;
                case 7:
                    productView.sortByPriceOrderByDESC();
                    break;
                case 8:
                    break;
                case 0:
                    AppUtils.exit();
                    break;
                default:
                    System.err.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                    run();
            }
        } while (choice != 8);
    }
}
