package edu.miu.waa.ministore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class LineItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	private int quantity;
	private double price;

	// @OneToOne(cascade = CascadeType.ALL)
	@ManyToOne // (cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Product product;

	@Override
	public String toString() {
		return "quantity : " + quantity + "\n\t price : " + price + "\n\t product : " + product;
	}
}
