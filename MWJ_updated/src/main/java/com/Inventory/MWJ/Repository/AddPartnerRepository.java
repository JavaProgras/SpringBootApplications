package com.Inventory.MWJ.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Inventory.MWJ.Model.AddPartner;

public interface AddPartnerRepository extends JpaRepository<AddPartner, Integer> {

	/*
	 * @Query(value = "SELECT * FROM AddPartner ORDER BY partner_id", countQuery =
	 * "SELECT count(*) FROM AddPartner", nativeQuery = true) Page<AddPartner>
	 * findAllParnersWithPagination(Pageable pageable);
	 */

	@Query("SELECT u FROM AddPartner u WHERE u.coupon_code_input = :coupon_code_input")
	public AddPartner find(@Param("coupon_code_input") String coupon_code_input);

}
