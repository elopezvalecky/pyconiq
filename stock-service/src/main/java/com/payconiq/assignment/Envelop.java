package com.payconiq.assignment;

class Envelop<T> {

	private final Iterable<T> data;
	private final Long count;

	public Envelop(Iterable<T> data, Long count) {
		this.data = data;
		this.count = count;
	}

	public Iterable<T> getData() {
		return data;
	}

	public Long getCount() {
		return count;
	}

}
