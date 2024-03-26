package com.as.ssd.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class UserLoginGuard extends AuditableEntity {
	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	private User user;

	private int failedAttempts;

	@NotNull
	private boolean blocked;

	private LocalDateTime blockedTill;

}
