package com.wanchopi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

import javax.validation.constraints.Email;

/**
 * Player entity
 * @author Wanchopi
 *
 */
@Entity
@Table(name = "PLAYERS")
public @Data class Player {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Setter @Getter
	private Long id;
	
	@Column(name = "NAME")	
	@NotNull
    @Size(min=5, max=24)
	//@Setter @Getter
	private String name;
	
	@Column(name = "EMAIL")
	@NotNull
	@Email
	//@Setter @Getter
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TEAM")
	@NotNull
	//@Setter @Getter
	private Team team;

}
