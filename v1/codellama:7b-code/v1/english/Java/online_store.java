

//The store has products and users. Products have a name and description. A user can have many orders but he must be logged in to make one. Users have a username and password to login, the password is encrypted with bcrypt. When a new order arrives you should send an email for each product to confirm it.
//Your API should have methods:
//Get all products
//Add a product
//Get all users
//Login as a user by username & password
//Create a shopping cart
//Add an item to the shopping cart
//Get orders of logged in user
//Get order history of logged in user
//When logging out, the session should be removed.

//The database should have a few products and users for testing.

package ru.job4j.store;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Online store.
 */
public class Store {
    private static final Logger LOG = LogManager.getLogger(Store.class);
    /**
     * Users.
     */
    private volatile Map<String, User> users;
    /**
     * Products.
     */
    private volatile List<Product> products;
    /**
     * Cart.
     */
    private final Collection<CartItem> cart = new CopyOnWriteArrayList<>();
    /**
     * Unique order number.
     */
    private AtomicInteger uniqueOrderNumber = new AtomicInteger();

    public Store() {
        this.users = new ConcurrentHashMap<>();
        this.products = new CopyOnWriteArrayList<>();
    }

    /**
     * Get users.
     * @return Users.
     */
    public Map<String, User> getUsers() {
        return users;
    }

    /**
     * Add user.
     * @param user User.
     */
    public void addUser(final User user) {
        if (user != null && !this.users.containsKey(user.getUsername())) {
            this.users.put(user.getUsername(), user);
        } else {
            LOG.warn("This username is already in use.");
        }
    }

    /**
     * Delete user by name.
     * @param username Username.
     */
    public void deleteUserByName(final String username) {
        if (this.users.containsKey(username)) {
            this.users.remove(username);
        } else {
            LOG.warn("This username is not in use.");
        }
    }

    /**
     * Get products.
     * @return Products.
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Add product to list.
     * @param product Product.
     */
    public void addProduct(final Product product) {
        if (product != null && !this.products.contains(product)) {
            this.products.add(product);
        } else {
            LOG.warn("This product is already in use.");
        }
    }

    /**
     * Create cart item for specified user.
     * @param username Username.
     */
    public void createCartItem(final String username) {
        final User user = this.users.get(username);
        if (user == null || !cart.contains(new CartItem(null, user))) {
            cart.add(new CartItem(this.uniqueOrderNumber.incrementAndGet(), user));
        }
    }

    /**
     * Add product to cart by order number and username.
     * @param order Number of order.
     * @param username Username.
     * @param product Product.
     */
    public void addProduct(final int order, final String username, final Product product) {
        if (product != null && this.users.containsKey(username)) {
            CartItem cartItem = new CartItem(order, this.users.get(username));
            for (CartItem item : cart) {
                if (item.equals(cartItem)) {
                    item.addProduct(product);
                }
            }
        } else {
            LOG.warn("This username is not in use.");
        }
    }

    /**
     * Delete product by name from cart by order number and username.
     * @param order Number of order.
     * @param username Username.
     * @param name Name of product.
     */
    public void deleteProductByName(final int order, final String username, final String name) {
        if (this.users.containsKey(username)) {
            CartItem cartItem = new CartItem(order, this.users.get(username));
            for (CartItem item : cart) {
                if (item.equals(cartItem)) {
                    item.deleteProductByName(name);
                }
            }
        } else {
            LOG.warn("This username is not in use.");
        }
    }

    /**
     * Get orders of logged in user.
     * @param username Username.
     * @return Orders.
     */
    public List<CartItem> getOrders(final String username) {
        if (this.users.containsKey(username)) {
            final CartItem cartItem = new CartItem(null, this.users.get(username));
            List<CartItem> orders = new ArrayList<>();
            for (CartItem item : cart) {
                if (item.equals(cartItem)) {
                    orders.add(item);
                }
            }
            return orders;
        } else {
            LOG.warn("This username is not in use.");
            return new ArrayList<>();
        }
    }

    /**
     * Get order history of logged in user.
     * @param username Username.
     * @return Order history.
     */
    public List<CartItem> getOrderHistory(final String username) {
        if (this.users.containsKey(username)) {
            final CartItem cartItem = new CartItem(null, this.users.get(username));
            List<CartItem> orders = new ArrayList<>();
            for (CartItem item : cart) {
                if (item.equals(cartItem)) {
                    if (item.isCompleted()) {
                        orders.add(item);
                    }
                }
            }
            return orders;
        } else {
            LOG.warn("This username is not in use.");
            return new ArrayList<>();
        }
    }

    /**
     * Get cart.
     * @return Cart.
     */
    public Collection<CartItem> getCart() {
        return this.cart;
    }

    /**
     * Checkout orders of logged in user.
     * @param username Username.
     */
    public void checkout(final String username) {
        if (this.users.containsKey(username)) {
            CartItem cartItem = new CartItem(null, this.users.get(username));
            for (CartItem item : cart) {
                if (item.equals(cartItem)) {
                    item.complete();
                }
            }
        } else {
            LOG.warn("This username is not in use.");
        }
    }
}
