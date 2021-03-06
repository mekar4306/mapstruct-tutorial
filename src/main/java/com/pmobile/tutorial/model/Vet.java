package com.pmobile.tutorial.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vets")
public class Vet extends Person {

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "specialty_id"))
	private Set<Specialty> specialties = new HashSet<>();;

	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
	}

	public Set<Specialty> getSpecialties() {
		return this.specialties;
	}

	public int getNrOfSpecialties() {
		return specialties.size();
	}

	public void addSpecialty(Specialty specialty) {
		specialties.add(specialty);
	}

}