package model;

import com.google.gson.Gson;
import utils.RandomHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class User {

    private long user_id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private ROLE role;
    private Cart cart;
    private ArrayList<Order> orders;
    private String salt;

    public User(String username, String firstName, String lastName, String email, String password, String role) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = ROLE.valueOf(role);
        this.cart = new Cart();
        this.orders = new ArrayList<>();
        this.salt = RandomHelper.getRandomSalt();
    }

    public User(String username, String firstName, String lastName, String email, String password, String role, Cart cart) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = ROLE.valueOf(role);
        this.cart = cart;
        this.orders = new ArrayList<>();
        this.salt = RandomHelper.getRandomSalt();
    }

    public User(long user_id, String username, String firstName, String lastName, String email, String password, Cart cart, String role, String salt) {
        this.user_id = user_id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.cart = cart;
        this.role = ROLE.valueOf(role);
        this.orders = new ArrayList<>();
        this.salt = salt;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleNumber() {
        return role.ordinal() + 1;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = ROLE.valueOf(role);
    }

    public Cart getCart() {
        return cart;
    }

    public String getStringCart() {
        HashMap<String, String> cartMap = new HashMap<>();
        for (Good good : cart.getGoods().keySet()) {
            String goodId = String.valueOf(good.getGoodId());
            String amount = String.valueOf(cart.getGoods().get(good));
            cartMap.put(goodId, amount);
        }
        Gson gson = new Gson();
        return gson.toJson(cartMap);
    }

    public Optional<Order> getOrderById(long id) {
        for (Order order : orders) {
            if (order.getOrderId() == id) {
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) &&
                role == user.role &&
                password.equals(user.password);
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, username, firstName, lastName, email, password, role, cart, orders);
    }

    @Override
    public String toString() {
        return user_id + " " +
                username + " " +
                firstName + " " +
                lastName + " " +
                email + " " +
                password + "\n";
    }

    public enum ROLE {
        ADMIN,
        USER
    }
}
