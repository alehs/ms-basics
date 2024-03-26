package com.as.rest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.as.rest.domain.Subscription;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
	List<Subscription> findAllByUserId(Long userId);
}
