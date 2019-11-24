package net.kzn.shoppingbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.ws.rs.DefaultValue;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String code;
	@NotBlank(message="Please enter the product name!")
	private String name;
	@NotBlank(message="Please enter the brand name!")
	private String brand;
	@NotBlank(message="Please enter the description!")
	private String description;
	@Min(value=1, message="Unit price cannot be less than 1")
	private Double unit_price;
	private Integer quantity;
	private Boolean is_active;
	private Integer category_id;
	private Integer supplier_id;
//	@Column(name="purchases",nullable=false,columnDefinition = "int default 0")
	private Integer purchases=0;
//	@Column(name="views",nullable=false,columnDefinition = "int default 0")
	private Integer views=0;
	@Transient
	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public Product() {
		this.code = "PID"+UUID.randomUUID().toString().substring(26);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(Double unit_price) {
		this.unit_price = unit_price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Boolean getIs_active() {
		return is_active;
	}
	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public Integer getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(Integer supplier_id) {
		this.supplier_id = supplier_id;
	}
	public Integer getPurchases() {
		return purchases;
	}
	public void setPurchases(Integer purchases) {
		this.purchases = purchases;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", description="
				+ description + ", unit_price=" + unit_price + ", quantity=" + quantity + ", is_active=" + is_active
				+ ", category_id=" + category_id + ", supplier_id=" + supplier_id + ", purchases=" + purchases
				+ ", views=" + views + "]";
	}
	
	
}
