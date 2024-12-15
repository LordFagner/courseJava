package com.FagCorps.course.entites.Pk;

import java.io.Serializable;
import java.util.Objects;

import com.FagCorps.course.entites.Order;
import com.FagCorps.course.entites.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class OrderItemPk implements Serializable {
 
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "pk_Order")
	private Order order;
	@ManyToOne
	@JoinColumn(name = "pK_product")
	private Product prod;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProd() {
		return prod;
	}
	public void setProd(Product prod) {
		this.prod = prod;
	}
	@Override
	public int hashCode() {
		return Objects.hash(order, prod);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPk other = (OrderItemPk) obj;
		return Objects.equals(order, other.order) && Objects.equals(prod, other.prod);
	}
	

	
}
