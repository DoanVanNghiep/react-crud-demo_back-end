package vnua.fita.sbcrudrestful.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vnua.fita.sbcrudrestful.dto.OrderDTO;
import vnua.fita.sbcrudrestful.dto.OrderRequest;
import vnua.fita.sbcrudrestful.model.Order;
import vnua.fita.sbcrudrestful.util.MySQL;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	@Query(value = MySQL.GET_ALL_ORDER, nativeQuery = true)
	List<Object[]> getAllOrder();
}
