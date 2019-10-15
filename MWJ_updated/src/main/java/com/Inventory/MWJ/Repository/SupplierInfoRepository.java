package com.Inventory.MWJ.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Inventory.MWJ.Model.SupplierInfo;

public interface SupplierInfoRepository extends JpaRepository<SupplierInfo, Integer> {

	@Query("select COALESCE(sum(s.suppliedqty),0) from SupplierInfo s where couponCode=:couponCode and couponType=:couponType")
	public Long getBySelected(@Param("couponCode") String couponCode, @Param("couponType") String couponType);

}
