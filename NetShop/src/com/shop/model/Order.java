package com.shop.model;

import com.google.gson.Gson;
import com.shop.dao.GoodDao;
import com.shop.dao.implamentation.hibernate.GoodDaoHibImpl;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Transient
    private static final GoodDao goodDao = new GoodDaoHibImpl();

    @Id
    @Column(name = "order_id")
    private long orderId;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private List<Items> items = new ArrayList<>();

    private double price;

    private STATUS status;

    public Order() {

    }

    public Order(Cart cart) {
        this.user = cart.getUser();
        this.items = cart.getItems();
        this.price = cart.getPrice();
        this.status = STATUS.NOT_PAID;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String  getStatus() {
        return status.name();
    }

    public void setStatus(String  status) {
        this.status = STATUS.valueOf(status);
    }

    //    public Order(User user, Cart cart) {
////        this.userId = user.getUserId();
////        this.goods = cart.getGoods();
////        this.price = cart.getPrice();
//        status = STATUS.NOT_PAID;
//    }
//
//    public Order(long orderId, long userId, HashMap<Good, Integer> goods, double price, String status) {
//        this.orderId = orderId;
//        this.userId = userId;
//        this.goods = goods;
//        this.price = price;
//        this.status = STATUS.valueOf(status);
//    }
//
//    public long getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(long orderId) {
//        this.orderId = orderId;
//    }
//
//    public long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(long userId) {
//        this.userId = userId;
//    }
//
//    public HashMap<Good, Integer> getGoods() {
//        return goods;
//    }
//
//    public String getGoodsString() {
//        HashMap<String, String> cartMap = new HashMap<>();
//        for (Good good : goods.keySet()) {
//            String goodId = String.valueOf(good.getGoodId());
//            String amount = String.valueOf(goods.get(good));
//            cartMap.put(goodId, amount);
//        }
//        Gson gson = new Gson();
//        return gson.toJson(cartMap);
//    }
//
//    public static HashMap<Good, Integer> getGoodsMap(HashMap<String, String> goods) {
//        HashMap<Good, Integer> goodsMap = new HashMap<>();
//        for (String s : goods.keySet()) {
//            long id = Long.parseLong(s);
//            int amount = Integer.parseInt(goods.get(s));
//            Good good = goodDao.getGoodById(id).get();
//            goodsMap.put(good, amount);
//        }
//        return goodsMap;
//    }
//
//    public void setGoods(HashMap<Good, Integer> goods) {
//        this.goods = goods;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getStatus() {
//        return status.name();
//    }
//
//    public void setStatus(STATUS status) {
//        this.status = status;
//    }
//
    public enum STATUS {
        NOT_PAID,
        PAID
    }
}
