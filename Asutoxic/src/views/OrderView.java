package views;

import model.Order;
import model.OrderItem;
import model.Product;
import services.*;
import utils.AppUtils;
import utils.InstantUtils;
import utils.ValidateUtils;

import java.time.Instant;
import java.util.List;
import java.util.Scanner;

public class OrderView {

    private final IProductService productService;

    private final IOrderService orderService;

    private final IOrderItemService orderItemService;

    private final Scanner scanner = new Scanner(System.in);

    public OrderView() {
        productService = ProductService.getInstance();
        orderService = OrderService.getInstance();
        orderItemService = OrderItemService.getInstance();
    }

    public OrderItem addOrderItems(long orderId) {
        orderItemService.findAll();
        ProductView productView = new ProductView();
        productView.showProducts(InputOption.ADD);
        long id = System.currentTimeMillis() / 1000;
        System.out.println("Nhập id sản phẩm: ");
        long fruitId = AppUtils.retryParseLong();
        while (!productService.existsById(fruitId)) {
            System.out.println("Id sản phẩm không tồn tại");
            System.out.println("Nhập id sản phẩm: ");
            System.out.print(" ⭆ ");
            fruitId = AppUtils.retryParseLong();
        }
        Product product = productService.findById(fruitId);
        double price = product.getPrice();
        int oldQuantity = product.getQuantity();
        System.out.println("Nhập số lượng: ");
        int quantity = AppUtils.retryParseInt();
        while (!checkQualityFruit(product, quantity)) {
            System.out.println("Vượt quá số lượng! Vui lòng nhập lại");
            System.out.println("Nhập số lượng");
            quantity = AppUtils.retryParseInt();
        }
        String fruitName = product.getTitle();
        double total = quantity * price;
        int currentQuantity = oldQuantity - quantity;
        product.setQuantity(currentQuantity);
        productService.update(product);
        Instant creatAt = Instant.now();
        OrderItem orderItem = new OrderItem(id, price, quantity, orderId, fruitId, fruitName, total, creatAt);
        return orderItem;
    }

    public boolean checkQualityFruit(Product product, double quantity) {
        if (quantity <= product.getQuantity())
            return true;
        else
            return false;
    }

    public void addOrder() {
        try {
            orderService.findAll();
            long orderId = System.currentTimeMillis() / 1000;
            System.out.println("Nhập họ và tên (vd: Vu Tran) ");
            System.out.print(" ⭆ ");
            String name = scanner.nextLine();
            while (!ValidateUtils.isNameValid(name)) {
                System.out.println("Tên " + name + " không đúng." + " Vui lòng nhập lại!" + " (Tên phải viết hoa chữ cái đầu và không dấu)");
                System.out.println("Nhập tên (vd: Vu Tran) ");
                System.out.print(" ⭆ ");
                name = scanner.nextLine();
            }
            System.out.println("Nhập số điên thoại: ");
            System.out.print(" ⭆ ");
            String phone = scanner.nextLine();
            while (!ValidateUtils.isPhoneValid(phone)) {
                System.out.println("Số " + phone + " của bạn không đúng. Vui lòng nhập lại! " + "(Số điện thoại bao gồm 10 số và bắt đầu là số 0)");
                System.out.println("Nhập số điện thoại (vd: 0987654321)");
                System.out.print(" ⭆ ");
                phone = scanner.nextLine();
            }
            System.out.println("Nhập địa chỉ: ");
            String address;
            while (!ValidateUtils.isAddressValid(address = scanner.nextLine().trim())) {
                System.out.println("Địa chỉ " + address + " không đúng định dạng." + " Vui lòng nhập lại!");
                System.out.println("Nhập tên (vd: Le Duan-Hue) ");
                System.out.print(" ⭆ ");
            }
            OrderItem orderItem = addOrderItems(orderId);
            Order order = new Order(orderId, name, phone, address);
            orderItemService.add(orderItem);
            orderService.add(order);
            System.out.println("Tạo đơn hàng thành công!");
            do {
                System.out.println("☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
                System.out.println("☯                                                                               OPTION                                                                                 ☯");
                System.out.println("☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
                System.out.println("☯                                                                                                                                                                      ☯");
                System.out.println("☯                                                                   [1] Nhấn 'y' để tạo tiếp đơn hàng                                                                  ☯");
                System.out.println("☯                                                                   [2] Nhấn 'q' để trở lại                                                                            ☯");
                System.out.println("☯                                                                   [3] Nhấn 'p' để in hoá đơn                                                                         ☯");
                System.out.println("☯                                                                   [4] Nhấn 't' để thoát                                                                              ☯");
                System.out.println("☯                                                                                                                                                                      ☯");
                System.out.println("☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
                System.out.print(" ⭆ ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "y":
                        addOrder();
                        break;
                    case "q":
                        OrderViewLauncher.run();
                        break;
                    case "p":
                        showPaymentInfo(orderItem, order);
                        break;
                    case "t":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("Nhập không hợp lệ! Vui lòng nhập lại");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Nhập sai. vui lòng nhập lại!");
        }
    }

    public void showPaymentInfo(OrderItem orderItem, Order order) {
        try {
            System.out.println("\t\t\t\t☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
            System.out.println("\t\t\t\t☯                                                                           HÓA ĐƠN                                                                                                           ☯");
            System.out.println("\t\t\t\t☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
            System.out.printf("\t\t\t\t\t%-20s\t %-25s %16s \n", "Tên đầy đủ   :          ", order.getFullName(), "");
            System.out.printf("\t\t\t\t\t%-20s\t %-25s %16s \n", "Số điện thoại:          ", order.getPhone(), "");
            System.out.printf("\t\t\t\t\t%-20s\t %-25s %16s \n", "Địa chỉ      :          ", order.getAddress(), "");
            System.out.printf("\t\t\t\t\t%-20s\t %-25s %16s \n", "Ngày tạo     :          ", InstantUtils.instantToString(orderItem.getCreatAt()), "");
            System.out.println("\t\t\t\t☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
            System.out.printf("\t\t\t\t%-4s%-60s\t %-30s %-30s \n", "STT", "Tên sản phẩm", "Số lượng", "Giá");
            System.out.println("\t\t\t\t☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
            List<OrderItem> orderItems = orderItemService.findAll();
            double sum = 0;
            int count = 0;
            for (OrderItem orderItem1 : orderItems) {
                if (orderItem1.getOrderId() == order.getId()) {
                    sum += orderItem1.getTotal();
                    count++;
                    orderItem1.setTotal(sum);
                    orderItemService.update(orderItem1);
                    System.out.printf("\t\t\t\t %1s    %-17s\t %-25s   %-18s\n",
                            count,
                            orderItem1.getProductName(),
                            orderItem1.getQuantity(), AppUtils.doubleToVND(orderItem1.getPrice()));
                }
            }
            System.out.println("\t\t\t\t☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
            System.out.printf("\t\t\t\t                                                  Tổng: %60s  \n", AppUtils.doubleToVND(sum));
            System.out.println("\t\t\t\t☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯\n\n");
            boolean is = true;
            do {
                System.out.println("Nhấn 'q' để trở lại \t|\t 't' để thoát chương trình");
                System.out.print(" ⭆ ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "q":
                        OrderViewLauncher.run();
                        break;
                    case "t":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("Nhấn không đúng! vui lòng chọn lại");
                        is = false;
                }
            } while (!is);
        } catch (Exception e) {
            System.out.println("Nhập Không Đúng!!! Vui Lòng Nhập Lại!!!");
        }
    }

    public void showAllOrder() {
        List<Order> orders = orderService.findAll();
        List<OrderItem> orderItems = orderItemService.findAll();
        OrderItem newOrderItem = new OrderItem();
        double sum = 0;
        try {
            System.out.println("☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯LIST ORDER☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯");
            System.out.printf("☯%-15s %-15s %-12s %-20s %-65s %-20s %-20s %-20s %-20s☯\n", "   Id", "Tên khách hàng", "  SĐT", "Địa chỉ", "Tên sản phẩm", "Số lượng", "   Giá", "   Tổng", "  Ngày tạo ");
            System.out.println("☯---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------☯");
            for (Order order : orders) {
                for (OrderItem orderItem : orderItems) {
                    if (orderItem.getOrderId() == order.getId()) {
                        newOrderItem = orderItem;
                        break;
                    }
                }
                System.out.printf("☯ %-15s %-15s %-12s %-20s %-65s %-20s %-20s %-20s %-20s☯\n",
                        order.getId(),
                        order.getFullName(),
                        order.getPhone(),
                        order.getAddress(),
                        newOrderItem.getProductName(),
                        newOrderItem.getQuantity(),
                        AppUtils.doubleToVND(newOrderItem.getPrice()),
                        AppUtils.doubleToVND(newOrderItem.getPrice() * newOrderItem.getQuantity()),
                        InstantUtils.instantToString(newOrderItem.getCreatAt())
                );
                sum += newOrderItem.getPrice() * newOrderItem.getQuantity();
            }
            Order order = new Order();
            order.setGrandTotal(sum);
            System.out.println("☯-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------☯");

            System.out.printf("☯%-185s Tổng tiền: %12s        ☯\n", " ", AppUtils.doubleToVND(order.getGrandTotal()));
            System.out.println("☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯☯\n\n");
            boolean is = true;
            do {
                System.out.println("Nhấn 'q' để trở lại \t|\t 't' để thoát chương trình");
                System.out.print(" ⭆ ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "q":
                        OrderViewLauncher.run();
                        break;
                    case "t":
                        AppUtils.exit();
                        break;
                    default:
                        System.out.println("Nhấn không đúng! vui lòng chọn lại");
                        is = false;
                }
            } while (!is);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
