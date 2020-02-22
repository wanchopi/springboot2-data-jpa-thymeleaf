package com.wanchopi.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


/**
 * Team entity
 * @author Wanchopi
 *
 */
@Entity
@Table(name = "TEAMS")
public class Team {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter @Getter
	private Long id;
	
	@Column(name = "NAME")
	@Setter @Getter
	private String name;
	
	@Column(name = "CITY")
	@Setter @Getter
	private String city;
	
	@OneToMany(mappedBy = "team")
	@Setter @Getter
	private List<Player> players = new ArrayList<Player>();

}
