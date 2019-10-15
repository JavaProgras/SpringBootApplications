package com.Inventory.MWJ.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Inventory.MWJ.Model.UsedCoupons;

public interface UsedCouponsCRepository extends JpaRepository<UsedCoupons, Integer> {

	@Query("SELECT u FROM UsedCoupons u WHERE u.ucc_code = :ucc_code")
	public UsedCoupons find(@Param("ucc_code") String ucc_code);

	@Query(value = "select used_couponcode, count(used_couponcode) from usedcoupons group by used_couponcode", nativeQuery = true)
	public List<String> getUsedCouponCode();

	@Query(value = "select count(used_couponcode) from usedcoupons", nativeQuery = true)
	public Long usedCouponcount();

}
