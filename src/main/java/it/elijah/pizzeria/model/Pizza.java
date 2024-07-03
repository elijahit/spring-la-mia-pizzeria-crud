package it.elijah.pizzeria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="pizze")
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Il nome non può essere vuoto")
	@Column(nullable = false)
	private String nome;
	
	
	@NotBlank(message = "La descrizione non può essere vuota")
	@Column(nullable = false)
	private String descrizione;
	
	@NotBlank(message = "L'URL non può essere vuoto")
	@Column(name="foto_url", nullable=false)
	private String fotoUrl;
	
	@Positive(message = "L'importo non può essere negativo.")
	@Column(nullable = false)
	private double prezzo;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getFotoUrl() {
		return fotoUrl;
	}
	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
}
