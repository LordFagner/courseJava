package com.FagCorps.course.entites;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String ImgUrl;
	@ManyToMany
	@JoinTable(name = "TB_Product_Category", joinColumns = @JoinColumn(name = "Product_id"), inverseJoinColumns = @JoinColumn(name = "Category_id"))
	private Set<Category> categorys = new HashSet<>();

	@OneToMany(mappedBy = "id.prod")
	private Set<OrderItem> orders = new HashSet<>();

	public Product(Long id, String name, String description, Double price, String imgUrl) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		ImgUrl = imgUrl;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", ImgUrl=" + ImgUrl + ", categorys=" + categorys + "]";
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return ImgUrl;
	}

	public void setImgUrl(String imgUrl) {
		ImgUrl = imgUrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Category> getCategorys() {
		return categorys;
	}
	@JsonIgnore	
	public Set<Order> getOrders() {
		return orders.stream().map(OrderItem::GetOrder).filter(Objects::nonNull).collect(Collectors.toSet());
	}

	
	public Set<OrderItem> GetOrderItem() {
		return orders;
		
	}
	
	
}
