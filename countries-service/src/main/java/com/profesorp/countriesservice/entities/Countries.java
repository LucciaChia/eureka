package com.profesorp.countriesservice.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Countries {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	@NotNull
	private String countryShortcut;
	
	@Column 
	@NotNull
	private String countryName;

	@Column 
	@NotNull
	private String currency;
	
	@Column 
	@NotNull
	private String currencySymbol;

	@Column 
	@NotNull
	private String language;
	
	@Column 
	@NotNull
	private String capital;
	
	@Transient
	int port;
}
