package hello.hello_spring.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
