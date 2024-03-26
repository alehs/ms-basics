package com.as.ssd.data.model;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class AuditableEntity implements Serializable {

	@Column(name = "created_at")
	LocalDateTime createdAt;
	@Column(name = "updated_at")
	LocalDateTime updatedAt;
}
