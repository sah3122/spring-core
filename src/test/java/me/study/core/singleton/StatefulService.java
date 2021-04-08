package me.study.core.singleton;

public class StatefulService {
    private int price;

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 공유되는 상태값을 변경하는것은 문제가 발생한다.
    }

    public int order2(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price; // 항상 stateless 로 유지하자.
    }

    public int getPrice() {
        return price;
    }
}
