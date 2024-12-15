package com.FagCorps.course.entites;

import java.io.Serializable;
import java.util.Objects;
import java.util.jar.Attributes.Name;

import com.FagCorps.course.entites.Pk.OrderItemPk;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_OrderITem")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private OrderItemPk id = new OrderItemPk();
	
	private Integer Qauantity;

	private Double price;

	public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	public OrderItem(Order order, Product product, Integer qauantity, Double price) {
		id.setOrder(order);
		id.setProd(product);
		Qauantity = qauantity;
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}

	
	public Order GetOrder() {

		return id.getOrder();

	}

	public void SetOrder(Order order) {

		id.setOrder(order);

	}

	public void SetProduct(Product pro) {

		id.setProd(pro);

	}

	@JsonManagedReference
	@JsonProperty("DescriptionProduct")

	public Product GetProduct() {

		return id.getProd();

	}

	public Integer getQauantity() {
		return Qauantity;
	}

	public void setQauantity(Integer qauantity) {
		Qauantity = qauantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}


public Double getSubTotal() {
	
	
	return Qauantity * price;
	
}



}
