package com.as.rest.impl.v2and3;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.as.rest.api.SubscriptionService;
import com.as.rest.api.UserService;
import com.as.rest.api.UsersApiDelegate;
import com.as.rest.dto.SubscriptionResponseDto;
import com.as.rest.dto.UserRequestDto;
import com.as.rest.dto.UserResponseDto;

/**
 * RMM L2 and L3 are the same except HATEOAS.
 * I add HATEOAS on application level using Spring HATEOAS.
 * so there is no difference in controllers implementation.
 */
@Component
public class UserApiDelegateImpl implements UsersApiDelegate {

	final UserService userService;
	final SubscriptionService subscriptionService;

	public UserApiDelegateImpl(UserService userService, SubscriptionService subscriptionService) {
		this.userService = userService;
		this.subscriptionService = subscriptionService;
	}

	@Override
	public ResponseEntity<UserResponseDto> getUser(Long id) {
		UserResponseDto user = userService.getById(id);
		user.addLinksItem(new com.as.rest.dto.Link().rel("self").href("/users/" + id));
		user.addLinksItem(new com.as.rest.dto.Link().rel("subscriptions").href("/users/" + id + "/subscriptions"));

		return Optional.ofNullable(user)
				.map(u -> ResponseEntity.ok(u))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<List<SubscriptionResponseDto>> getUserSubscriptions(Long id) {
		return ResponseEntity.ok(subscriptionService.getByUserId(id));
	}

	@Override
	public ResponseEntity<UserResponseDto> createUser(UserRequestDto body) {
		UserResponseDto saved = userService.save(body);
		saved.addLinksItem(new com.as.rest.dto.Link().rel("self").href("/users/" + saved.getId()));
		saved.addLinksItem(new com.as.rest.dto.Link().rel("subscriptions").href("/users/" + saved.getId() + "/subscriptions"));
		return ResponseEntity.created(URI.create("/users/" + saved.getId())).body(saved);
	}

	@Override
	public ResponseEntity<List<UserResponseDto>> getAllUsers() {
		List<UserResponseDto> users = userService.getAll();
		users.stream().forEach(u -> {
			u.addLinksItem(new com.as.rest.dto.Link().rel("self").href("/users/" + u.getId()));
			u.addLinksItem(new com.as.rest.dto.Link().rel("subscriptions").href("/users/" + u.getId() + "/subscriptions"));
		});
		return ResponseEntity.ok(users);
	}
}
