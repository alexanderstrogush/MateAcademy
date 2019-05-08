package model;

import dao.GoodDao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class Cart implements Serializable {

    private static final GoodDao GOOD_DAO = new GoodDao();

    private HashMap<Good, Integer> goods;
    private double price;

    public Cart() {
        goods = new HashMap<>();
    }

    private double getGoodsPrice() {
        return goods.entrySet().stream().mapToInt((g) -> goods.get(g)).sum();
    }

    public void addGood(Good good, int amount) {
        goods.put(good, amount);
        price += good.getPrice() * amount;
    }

    public void removeGood(long goodId) {
        Good good = GOOD_DAO.getGoodById(goodId).get();
        price -= good.getPrice() * goods.get(good);
        goods.remove(good);
    }

    public void cleanCart() {
        goods.clear();
        price = 0.0;
    }

    public static Cart createCart(HashMap<String, String> cartMap) {
        Cart cart = new Cart();
        for (String idString : cartMap.keySet()) {
            Long id = Long.parseLong(idString);
            Good good = GOOD_DAO.getGoodById(id).get();
            int amount = Integer.parseInt(cartMap.get(idString));
            cart.addGood(good, amount);
        }
        return cart;
    }

    public HashMap<Good, Integer> getGoods() {
        return goods;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Double.compare(cart.price, price) == 0 &&
                Objects.equals(goods, cart.goods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goods, price);
    }
}
