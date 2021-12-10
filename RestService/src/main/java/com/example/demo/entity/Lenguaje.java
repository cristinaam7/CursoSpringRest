package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name="lenguaje")
public class Lenguaje implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nombre;
	
	@Column(name="created_at")
	@JsonFormat(pattern = "YYYY-mm-dd")
	private Date createdAt;
	
	@ManyToMany
	@JoinTable(name="profesor_lenguaje",
				joinColumns = @JoinColumn(name ="lenguaje_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name ="profesor_id", referencedColumnName = "id"))
	private Set<Profesor> profesores = new HashSet<Profesor>();

}
