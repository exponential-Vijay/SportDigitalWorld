package com.vijay.SportDigitalWorld.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sports")

public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sport_id", nullable = false, unique = true)
    private Long sportId;

    @Column(name = "sport_code", nullable = false, unique = true)
    private String sportCode;

    @Column(name = "sport_name", nullable = false)
    private String sportName;

    @CreationTimestamp
    private LocalDateTime createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSportId() {
		return sportId;
	}

	public void setSportId(Long sportId) {
		this.sportId = sportId;
	}

	public String getSportCode() {
		return sportCode;
	}

	public void setSportCode(String sportCode) {
		this.sportCode = sportCode;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Sport(Long id, Long sportId, String sportCode, String sportName, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.sportId = sportId;
		this.sportCode = sportCode;
		this.sportName = sportName;
		this.createdAt = createdAt;
	}

	public Sport() {
		super();
	}
    
    
}

