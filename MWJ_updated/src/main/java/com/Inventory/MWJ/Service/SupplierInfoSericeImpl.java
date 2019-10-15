package com.Inventory.MWJ.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.Inventory.MWJ.Exceptions.ResourceNotFoundException;
import com.Inventory.MWJ.Model.OrderDetails;
import com.Inventory.MWJ.Model.SupplierInfo;
import com.Inventory.MWJ.Repository.OrderDetailsRepository;
import com.Inventory.MWJ.Repository.SupplierInfoRepository;

@Service
public class SupplierInfoSericeImpl implements SupplierInfoService {

	@Autowired
	private SupplierInfoRepository supplierrepo;
	@Autowired
	private OrderDetailsRepository orderrepo;

	@Override
	public SupplierInfo saveSupplierdetails(@PathVariable(value = "order_id") Integer order_id,
			SupplierInfo supplierinfo) {

		return orderrepo.findById(order_id).map(order -> {
			supplierinfo.setOrder(order);

			Long totalorderqty = orderrepo.getBySelected(supplierinfo.getCouponCode(), supplierinfo.getCouponType());
			Long totalsuppliedqty = supplierinfo.getSuppliedqty()
					+ supplierrepo.getBySelected(supplierinfo.getCouponCode(), supplierinfo.getCouponType());

			Long balance = totalorderqty - totalsuppliedqty;
			List<OrderDetails> olist = orderrepo.findAll();
			for (OrderDetails orders : olist) {
				if (balance == 0)

				{
					orders.setBalanceqty(true);

				}
			}
			if (totalorderqty > balance) {

				supplierrepo.save(supplierinfo);

			}
			System.out.println(totalorderqty);
			System.out.println(balance);
			System.out.println(totalsuppliedqty);
			return supplierrepo.save(supplierinfo);

			/*
			 * List<OrderDetails> odetails = orderrepo.findAll(); int orderqty = 0; for
			 * (OrderDetails orders : odetails) { if
			 * (orders.getCouponCode().equalsIgnoreCase(supplierinfo.getCouponCode()) &
			 * orders.getCouponType().equalsIgnoreCase(supplierinfo.getCouponType())) {
			 * orderqty += orders.getOrderquantity(); }
			 * 
			 * } int totalorderqty = orderqty; List<SupplierInfo> sdetails =
			 * supplierrepo.findAll(); Long totalsupplyqty = supplierinfo.getSuppliedqty();
			 * for (SupplierInfo supplier : sdetails) { totalsupplyqty +=
			 * supplier.getSuppliedqty(); }
			 * 
			 * Long blance = (long) (totalorderqty - totalsupplyqty);
			 * 
			 * Long s = blance; System.out.println(totalorderqty); System.out.println(s);
			 * 
			 * return supplierrepo.save(supplierinfo);
			 */
			/*
			 * ArrayList<String> hashset=new ArrayList<>();
			 * 
			 * List<OrderDetails>olist=orderrepo.findAll(); for(OrderDetails odetails:olist)
			 * { hashset.add(odetails.getCouponCode());
			 * hashset.add(odetails.getCouponType());
			 * if(supplierinfo.getCouponCode()&supplierinfo.getCouponType().equalsIgnoreCase
			 * (hashset.)) {
			 * 
			 * } }
			 * 
			 * System.out.println(hashset);
			 */
		}).orElseThrow(() -> new ResourceNotFoundException("order_id " + order_id + " not found"));

	}

	@Override
	public SupplierInfo updateSupplierdetails(SupplierInfo supplierinfo) {
		return supplierrepo.save(supplierinfo);
	}

}
