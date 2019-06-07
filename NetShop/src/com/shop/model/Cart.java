package com.shop.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long cartId;

    @OneToOne(optional = false, cascade = CascadeType.ALL) // , fetch = FetchType.LAZY
    private User user;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
    private List<Items> items = new ArrayList<>();

    private double price;

    public Cart() {

    }

    public Cart(User user) {
        this.user = user;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
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

    public void addItem(Items items) {
        this.items.add(items);
        price += items.getGood().getPrice() * items.getAmount();
    }

    public void clean() {
        this.items = new ArrayList<>();
        price = 0.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return cartId == cart.cartId &&
                Objects.equals(user, cart.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, user);
    }
}
