package biz.korwin.web.service.home;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import biz.korwin.web.service.home.model.PaymentVO;
import biz.korwin.web.service.home.model.PaymentsVO;
import biz.korwin.web.service.home.service.IPaymentService;

/**
 * Web service implementation.
 * */
@Path("/payments")
@Component("paymentsService")
public class PaymentWSImpl implements IPaymentWS {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	
	@Autowired
	IPaymentService paymentService;
	
	@GET
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/date/{date}")
	@Override
	public PaymentsVO getPaymentsByDate(@PathParam("date") String date) {

		
		List<PaymentVO> listOfPayments = paymentService.getPaymentsByDate(date);
		PaymentsVO payments = new PaymentsVO();
		payments.setPayments(listOfPayments);
		
		return payments;
		
	}

	

	@Override
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public boolean delete(@PathParam("id") long id) {
		
		return paymentService.delete(id);
	}

	@Override
	@PUT
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public PaymentVO update(@PathParam("id") long id, 
			@FormParam("payee")String payee,
			@FormParam("payeeProduct")String payeeProduct,
			@FormParam("cycle")int cycle,
			@FormParam("amountInCents")int amountInCents,
			@FormParam("dueDate")String dueDate,
			@FormParam("paymentLimitDate")String paymentLimitDate,
			@FormParam("deprecated")boolean deprecated) {
		
		PaymentVO updatePayment = new PaymentVO();
		
		updatePayment.setId(id);
		updatePayment.setPayee(payee);
		updatePayment.setPayeeProduct(payeeProduct);
		updatePayment.setCycle(cycle);
		updatePayment.setAmountInCents(amountInCents);
		updatePayment.setDueDate(dueDate);
		updatePayment.setPaymentLimitDate(paymentLimitDate);
		//updatePayment.setPaidDate(paidDate);
		updatePayment.setDeprecated(deprecated);
		
		
		PaymentVO paymentUpdated = paymentService.update(updatePayment);
		
		return paymentUpdated;
	}

	@GET
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}")
	@Override
	public PaymentVO getPaymentById(@PathParam("id") long id) {
		
		PaymentVO payment = paymentService.getPaymentById(id);

		return payment;
	}



	@Override
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public PaymentVO create(@FormParam("payee")String payee,
			@FormParam("payeeProduct")String payeeProduct,
			@FormParam("cycle")int cycle,
			@FormParam("amountInCents")int amountInCents,
			@FormParam("dueDate")String dueDate,
			@FormParam("paymentLimitDate")String paymentLimitDate,
			@FormParam("deprecated")boolean deprecated) {
		
		PaymentVO payment = new PaymentVO();
		payment.setAmountInCents(amountInCents);
		payment.setCycle(cycle);
		payment.setDueDate(dueDate);
		payment.setPaidDate(null);
		payment.setPayee(payee);
		payment.setPayeeProduct(payeeProduct);
		payment.setPaymentLimitDate(paymentLimitDate);
		
		PaymentVO createdPayment = paymentService.create(payment);
		
		return createdPayment;
	}

	
}
