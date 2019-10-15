package com.Inventory.MWJ.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Inventory.MWJ.Model.PaymentDetails;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Integer> {

	
	@Query("select COALESCE(sum(p.amountpaid),0) from PaymentDetails p where couponCode=:couponCode and couponType=:couponType")
	public Long getTotalOrderAmount(@Param("couponCode") String couponCode, @Param("couponType") String couponType);
	
}
