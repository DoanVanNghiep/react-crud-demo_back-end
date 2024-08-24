package vnua.fita.sbcrudrestful.model;

import java.util.List;

public class OrderResponse {
    private Order order;
    private User user;
    private List<OrderDetail> orderDetails;

    // Constructor
    public OrderResponse(Order order, User user, List<OrderDetail> orderDetails) {
        this.order = order;
        this.user = user;
        this.orderDetails = orderDetails;
    }

    // Getter và Setter
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}

