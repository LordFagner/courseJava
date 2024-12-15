package com.FagCorps.course.entites;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.FagCorps.course.entites.Enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Order")
@JsonPropertyOrder({"id","status","TotalValues","cliente","payment","items","moments"})
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Instant Moment;
	
	private Integer status;
	
	
	@ManyToOne
	@JoinColumn(name = "Cliente_id")
	private User cliente;
	
	@JsonBackReference
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> Items = new HashSet<>();
	@OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
	private Payment payment;

	
	
	
	
	
	public Set<OrderItem> getItems() {
		return Items;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(Long id, Instant moment, User cliente, OrderStatus status) {
		this.id = id;
		Moment = moment;
		this.cliente = cliente;
		setStatus(status);
	}

	public OrderStatus getStatus() {
		return OrderStatus.ValueOf(status);
	}
	
	@JsonProperty("TotalValues")
	public Double getTotal() {	
		return Items.stream().mapToDouble(OrderItem ::getSubTotal).sum();
			
	}

	public void setStatus(OrderStatus status) {
		this.status = status.getCode();
	}

	public void setCliente(User cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return Moment;
	}

	public void setMoment(Instant moment) {
		Moment = moment;
	}

	public User getCliente() {
		return cliente;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", Moment=" + Moment + ", status=" + status + ", cliente=" + cliente + "]";
	}





}
