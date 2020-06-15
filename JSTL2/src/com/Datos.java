package com;
import java.io.*;
import java.io.Serializable;
import java.util.Date;

public class Datos implements Serializable{
	private static final long serialVersionUID = 1L;
	private String mensaje;
	private String expresion;
	private Date fecha;
	private int contador;
	public Datos() {
		this.mensaje="Hola mundo";
		this.expresion="Esto es una expresíon";
		this.fecha=new Date();
		this.contador=7;
	}
	public void setMensaje(String mensaje) {
		this.mensaje=mensaje;
	}
	public void setExpresion(String expresion) {
		this.expresion=expresion;
	}
	public void setFecha(int fecha) {
	}
	public void setContador(int contador) {
		this.contador=contador;
	}
	public String getMensaje() {
		return mensaje;
	}
	public String getExpresion() {
		return expresion;
	}
	public Date getFecha() {
		return fecha;
	}
	public int getContador() {
		return contador;
	}
}

