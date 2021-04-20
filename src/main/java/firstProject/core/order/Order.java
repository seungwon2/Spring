package firstProject.core.order;

public class Order {

    //주문에 필요한 정보들 선언
    private long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;

    //생성자
    public Order(long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    //아이템 가격 계산
    public int calculatePrice(){
        return itemPrice - discountPrice;
    }

    //getter들 작성
    public long getMemberId() {
        return memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    //객체 출력
    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
