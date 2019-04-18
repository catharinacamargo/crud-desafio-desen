package com.catharina.cruddesafio.responses;

import java.util.List;

public class Responses<T> {
	
	private T data;
	private List<String> erros;
	
	public Responses(T data) {
		this.data = data;
	}
	
	public Responses(List<String> erros) {
		this.erros = erros;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}

}
