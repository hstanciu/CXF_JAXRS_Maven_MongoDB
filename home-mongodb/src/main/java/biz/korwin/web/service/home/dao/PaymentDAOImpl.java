package biz.korwin.web.service.home.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import biz.korwin.web.service.home.model.PaymentTO;

/**
 * DAO implementation for accessing the Payments data source.
 * */
@Repository
public class PaymentDAOImpl implements IPaymentDAO{

	static final Logger logger = LoggerFactory.getLogger(PaymentDAOImpl.class);
		
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public PaymentTO getPaymentById(long id) {
		
		PaymentTO paymentTO = mongoTemplate.findById(id, PaymentTO.class, "payments");
		return paymentTO;
		
	}

	@Override
	public PaymentTO create(PaymentTO newPayment) {
		
		mongoTemplate.insert(newPayment);
		
		Query query = new Query();
		
		String payee = newPayment.getPayee();
		String payeeProduct = newPayment.getPayeeProduct();
		int cycle = newPayment.getCycle();
		long amountInCents = newPayment.getAmountInCents();
		String dueDate = newPayment.getDueDate();
		String paymentLimitDate = newPayment.getPaymentLimitDate();
		
		query.addCriteria(Criteria.where("payee").is(payee).and("payeeProduct").is(payeeProduct)
				.and("cycle").is(cycle).and("amountInCents").is(amountInCents)
				.and("dueDate").is(dueDate).and("paymentLimitDate").is(paymentLimitDate)
				.and("paidDate").is(null).and("deprecated").is(false));
		
		PaymentTO paymentTO = mongoTemplate.findOne(query, PaymentTO.class);
		
		return paymentTO;
		
	}

	@Override
	public boolean delete(long id) {
		
		Query query = new Query();
		
		query.addCriteria(Criteria.where("id").is(id));
		
		PaymentTO paymentTO = mongoTemplate.findAndRemove(query, PaymentTO.class);
		
		if(null == paymentTO){
			return false;
		}else{
			return true;
		}
		
	}

	@Override
	public PaymentTO update(PaymentTO updatePayment) {

		Query query = new Query();
		
		query.addCriteria(Criteria.where("id").is(updatePayment.getId()));
		
		String payee = updatePayment.getPayee();
		String payeeProduct = updatePayment.getPayeeProduct();
		int cycle = updatePayment.getCycle();
		long amountInCents = updatePayment.getAmountInCents();
		String dueDate = updatePayment.getDueDate();
		String paymentLimitDate = updatePayment.getPaymentLimitDate();
		String paidDate = updatePayment.getPaidDate();
		boolean deprecated = updatePayment.isDeprecated();
		
		
		Update update = new Update();
		update.set("payee", payee);
		update.set("payeeProduct", payeeProduct);
		update.set("cycle", cycle);
		update.set("amountInCents", amountInCents);
		update.set("dueDate", dueDate);
		update.set("paymentLimitDate", paymentLimitDate);
		update.set("paidDate", paidDate);
		update.set("deprecated", deprecated);
		

		mongoTemplate.updateFirst(query, update, PaymentTO.class);
		
		PaymentTO paymentTO = mongoTemplate.findOne(query, PaymentTO.class);
		
		return paymentTO;
	}

	@Override
	public List<PaymentTO> getPaymentsByDate(String date) {
		
		Query query = new Query();
		
		query.addCriteria(Criteria.where("paymentLimitDate").is(date));
		List<PaymentTO> listOfPayments = mongoTemplate.find(query, PaymentTO.class, "payments");
		
		return listOfPayments;
	}

}
