package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name="profesores")
public class Profesor implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre", nullable=false, length=200)
	private String nombre;
	
	@Email
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String password;
	
	@Column(length=2000)
	private String foto;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="profesor_id")
	private List<Curso> cursos = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name="profesor_lenguaje",
				joinColumns = @JoinColumn(name ="profesor_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name ="lenguaje_id", referencedColumnName = "id"))
	private List<Lenguaje> lenguajes = new ArrayList<Lenguaje>();
	
	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}
	
	public void addLenguaje(Lenguaje lenguaje) {
		lenguajes.add(lenguaje);
	}
}
