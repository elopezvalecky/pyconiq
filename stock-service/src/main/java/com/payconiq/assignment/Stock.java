package com.payconiq.assignment;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private float currentPrice;

	@LastModifiedDate
	private Instant lastUpdate;

	protected Stock() {}

	public Stock(String name, float currentPrice) {
		this.name = name;
		this.currentPrice = currentPrice;
		this.lastUpdate = Instant.now();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
		this.lastUpdate = Instant.now();
	}

	public Instant getLastUpdate() {
		return lastUpdate;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", name=" + name + ", currentPrice=" + currentPrice + ", lastUpdate=" + lastUpdate + "]";
	}

}
