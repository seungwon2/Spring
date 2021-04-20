package firstProject.core.order;

public interface OrderService {
    //retrun 값이 주문! - 주문 결과 반환하는데에 쓰임
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
