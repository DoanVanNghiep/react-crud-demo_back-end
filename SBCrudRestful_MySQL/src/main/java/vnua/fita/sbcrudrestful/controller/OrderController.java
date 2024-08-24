package vnua.fita.sbcrudrestful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import vnua.fita.sbcrudrestful.dto.OrderDTO;
import vnua.fita.sbcrudrestful.dto.OrderRequest;
import vnua.fita.sbcrudrestful.model.Order;
import vnua.fita.sbcrudrestful.model.OrderDetail;
import vnua.fita.sbcrudrestful.model.OrderResponse;
import vnua.fita.sbcrudrestful.model.User;
import vnua.fita.sbcrudrestful.repository.OrderRepository;
import vnua.fita.sbcrudrestful.repository.UserRepository;
import vnua.fita.sbcrudrestful.service.CustomUserDetailsService;
import vnua.fita.sbcrudrestful.service.OrderService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    
    @PostMapping("/create")
    public Order createOrder(@RequestBody OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        List<OrderDetail> orderDetails = orderRequest.getOrderDetails();
        return orderService.createOrder(order, orderDetails);
    }
    @GetMapping("/getAll")
    public List<Map<String, Object>> getOrders() {
        List<Object[]> results = orderRepository.getAllOrder();
        List<Map<String, Object>> orders = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> orderData = new HashMap<>();
            orderData.put("orderId", result[0]);
            orderData.put("orderDate", result[1]);
            orderData.put("totalAmount", result[2]);
            orderData.put("address", result[3]);
            orderData.put("phone", result[4]);
            orderData.put("note", result[5]);
            orderData.put("status", result[6]);
            orderData.put("username", result[7]);
            orderData.put("empName", result[8]);
            orderData.put("quantity", result[9]);
            orderData.put("price", result[10]);

            orders.add(orderData);
        }

        return orders;
    }
    @GetMapping("/getAllOrderDetail")
    public List<OrderDetail> getAllOrderDetail(){
    	return orderService.getAllOrderDetail();
    }
}
