package com.jcah.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "usuario")
public  class Usuario implements Serializable {

	@Id
	private Long id_usuario;
	@NotNull
	private String nombre;
	@NotNull
	private String apellido_paterno;
	@NotNull
	private String apellido_materno;

	private String foto;

	@Temporal(TemporalType.DATE)
	@Column(name = "ingreso")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha_ingreso;

	@Temporal(TemporalType.DATE)
	@Column(name = "nacimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha_nacimiento;

	
	private String telefono;
	
	@Column(name = "ext")
	private Long extension;

	@Email
	private String correo;

	@ManyToOne
	@JoinColumn(name = "id_area")
	private Area area;
	


	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	

	public Long getExtension() {
		return extension;
	}

	public void setExtension(Long extension) {
		this.extension = extension;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}


	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellido_paterno=" + apellido_paterno
				+ ", apellido_materno=" + apellido_materno + ", foto=" + foto + ", fecha_ingreso=" + fecha_ingreso
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", telefono=" + telefono + ", extension=" + extension
				+ ", correo=" + correo + ", area=" + area + "]";
	}


	private static final long serialVersionUID = 1L;

}
