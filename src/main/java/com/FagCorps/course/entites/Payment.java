package com.FagCorps.course.entites;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "Tb_Payment")
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Long Id;

	private Instant date;

	@JsonIgnore	
	@OneToOne
	@MapsId //marcar que o id sera dependente do id do orders , alterando o comportamento do generated value
	private Order order;

	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(Long id, Instant date, Order order) {
		Id = id;
		this.date = date;
		this.order = order;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Long getId() {
		return Id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(Id, other.Id);
	}

	@Override
	public String toString() {
		return "Payment [Id=" + Id + ", date=" + date + ", order=" + order + "]";
	}

}