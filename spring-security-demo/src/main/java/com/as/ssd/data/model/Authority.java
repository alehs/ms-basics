package com.as.ssd.data.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "authorities")
@Data
public class Authority extends AuditableEntity {

	@NotNull
	@Size(max = 50)
	@Id
	@Column(length = 50)
	private String name;

}
