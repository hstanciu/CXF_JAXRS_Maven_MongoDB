package biz.korwin.web.service.home;

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

import biz.korwin.web.service.home.model.PaymentVO;
import biz.korwin.web.service.home.model.PaymentsVO;

@Path("/payments")
public interface IPaymentWS {
	/* Returns the list of payments that have the same payment limit date. */
	@GET
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/date/{date}")
	public PaymentsVO getPaymentsByDate(@PathParam("date") String date);
	
	/* Returns a payment by payment ID. */
	@GET
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}")
	public PaymentVO getPaymentById(@PathParam("id") long id);
	
	/* Creates a payment. */
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public PaymentVO create(@FormParam("payee")String payee,
							@FormParam("payeeProduct")String payeeProduct,
							@FormParam("cycle")int cycle,
							@FormParam("amountInCents")int amountInCents,
							@FormParam("dueDate")String dueDate,
							@FormParam("paymentLimitDate")String paymentLimitDate,
							@FormParam("deprecated")boolean deprecated);
	
	/* Deletes a payment. */
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response delete(@PathParam("id") long id);	
	
	/* Updates a payment. */
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
			@FormParam("deprecated")boolean deprecated);	
}
