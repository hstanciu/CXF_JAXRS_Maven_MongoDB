package biz.korwin.web.service.home.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Model class. Represents a payment.
 * 
 * */
@Document
public class PaymentTO {
	@Id
	/* Payment ID*/
	private long id;
	/* Who will be paid; ex: Canada Bank*/
	private String payee;
	/* The payment product; ex: Master Card Petro-Points */
	private String payeeProduct;
	/* The number of days a new statement will be issued, or -1 if is not cyclical*/
	private int cycle;
	/* Amount to be paid (in cents) */
	private int amountInCents;
	/* Due date */
	private String dueDate;
	/* In order for payment to occur at due date, the payment should occur 
	 * in advance with a couple of days. This date is the limit date when
	 * this occurs in order for due date not to be passed.*/
	private String paymentLimitDate;
	/* Date when payment happened. If it didn't happen yet,
	 * then this attribute will be null.*/	
	private String paidDate;
	/* If true, the payment is not actual.*/
	private boolean deprecated;
	
	public PaymentTO(){}
	
	public 	PaymentTO(long id,
			String payee,
			String payeeProduct,
			int cycle,
			int amountInCents,
			String dueDate,
			String paymentLimitDate,
			String paidDate,
			boolean deprecated){
		
		this.id = id;
		this.payee = payee;
		this.payeeProduct =  payeeProduct;
		this.cycle =  cycle;
		this.amountInCents =  amountInCents;
		this.dueDate =  dueDate;
		this.paymentLimitDate =  paymentLimitDate;
		this.paidDate =  paidDate;
		this.deprecated =  deprecated;
	}
	
	public 	PaymentTO(
			String payee,
			String payeeProduct,
			int cycle,
			int amountInCents,
			String dueDate,
			String paymentLimitDate,
			String paidDate,
			boolean deprecated){
		
		this.id = -1;
		this.payee = payee;
		this.payeeProduct =  payeeProduct;
		this.cycle =  cycle;
		this.amountInCents =  amountInCents;
		this.dueDate =  dueDate;
		this.paymentLimitDate =  paymentLimitDate;
		this.paidDate =  paidDate;
		this.deprecated =  deprecated;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPayee() {
		return payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}
	public String getPayeeProduct() {
		return payeeProduct;
	}
	public void setPayeeProduct(String payeeProduct) {
		this.payeeProduct = payeeProduct;
	}
	public int getCycle() {
		return cycle;
	}
	public void setCycle(int cycle) {
		this.cycle = cycle;
	}
	public int getAmountInCents() {
		return amountInCents;
	}
	public void setAmountInCents(int amountInCents) {
		this.amountInCents = amountInCents;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getPaymentLimitDate() {
		return paymentLimitDate;
	}
	public void setPaymentLimitDate(String paymentLimitDate) {
		this.paymentLimitDate = paymentLimitDate;
	}
	public String getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(String paidDate) {
		this.paidDate = paidDate;
	}
	public boolean isDeprecated() {
		return deprecated;
	}
	public void setDeprecated(boolean deprecated) {
		this.deprecated = deprecated;
	}

	@Override
	public String toString() {
		return "PaymentTO [id=" + id + ", payee=" + payee + ", payeeProduct="
				+ payeeProduct + ", cycle=" + cycle + ", amountInCents="
				+ amountInCents + ", dueDate=" + dueDate
				+ ", paymentLimitDate=" + paymentLimitDate + ", paidDate="
				+ paidDate + ", deprecated=" + deprecated + "]";
	}
}
