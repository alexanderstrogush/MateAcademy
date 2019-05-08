package model;

import com.google.gson.Gson;
import dao.GoodDao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class Order implements Serializable {

    private static final GoodDao GOOD_DAO = new GoodDao();

    private long orderId;
    private long userId;
    private HashMap<Good, Integer> goods;
    private double price;
    private STATUS status;

    public Order(User user, Cart cart) {
        this.userId = user.getUser_id();
        this.goods = cart.getGoods();
        this.price = cart.getPrice();
        status = STATUS.NOT_PAID;
    }

    public Order(long orderId, long userId, HashMap<Good, Integer> goods, double price, String status) {
        this.orderId = orderId;
        this.userId = userId;
        this.goods = goods;
        this.price = price;
        this.status = STATUS.valueOf(status);
    }

    public long getOrderId() {
        return orderId;
    }

    public long getUserId() {
        return userId;
    }

    public HashMap<Good, Integer> getGoods() {
        return goods;
    }

    public String getGoodsString() {
        HashMap<String, String> cartMap = new HashMap<>();
        for (Good good : goods.keySet()) {
            String goodId = String.valueOf(good.getGoodId());
            String amount = String.valueOf(goods.get(good));
            cartMap.put(goodId, amount);
        }
        Gson gson = new Gson();
        return gson.toJson(cartMap);
    }

    public static HashMap<Good, Integer> getGoodsMap(HashMap<String, String> goods) {
        HashMap<Good, Integer> goodsMap = new HashMap<>();
        for (String s : goods.keySet()) {
            long id = Long.parseLong(s);
            int amount = Integer.parseInt(goods.get(s));
            Good good = GOOD_DAO.getGoodById(id).get();
            goodsMap.put(good, amount);
        }
        return goodsMap;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status.name();
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setGoods(HashMap<Good, Integer> goods) {
        this.goods = goods;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId &&
                userId == order.userId &&
                Double.compare(order.price, price) == 0 &&
                goods.equals(order.goods) &&
                status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, userId, goods, price, status);
    }

    public enum STATUS {
        NOT_PAID,
        PAID
    }
}
