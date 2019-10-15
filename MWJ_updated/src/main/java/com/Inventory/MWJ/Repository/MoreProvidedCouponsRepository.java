package com.Inventory.MWJ.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Inventory.MWJ.Model.MoreProvidedCoupons;

public interface MoreProvidedCouponsRepository extends JpaRepository<MoreProvidedCoupons, Integer>{

	MoreProvidedCoupons save(Integer sumupdate);

}
