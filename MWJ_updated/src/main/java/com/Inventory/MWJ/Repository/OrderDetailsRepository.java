package com.Inventory.MWJ.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Inventory.MWJ.Model.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

	@Query("select NEW com.Inventory.MWJ.Model.OrderDetails(o.printername,o.couponCode,o.couponType,sum(orderquantity),sum(totalOrderAmount)) FROM OrderDetails o group by o.printername,o.couponCode,o.couponType")
	public List<OrderDetails> getAllSelectedDetails();

	@Query("select COALESCE(sum(o.orderquantity),0) from OrderDetails o where couponCode=:couponCode and couponType=:couponType")
	public Long getBySelected(@Param("couponCode") String couponCode, @Param("couponType") String couponType);

	@Query(value = "select sum(orderquantity) from orderdetails group by coupon_code,coupon_type", nativeQuery = true)
	public Long getTotalOrderQuantity();

	@Query("select COALESCE(sum(o.totalOrderAmount),0) from OrderDetails o where couponCode=:couponCode and couponType=:couponType")
	public Long getTotalOrderAmount(@Param("couponCode") String couponCode, @Param("couponType") String couponType);

}
