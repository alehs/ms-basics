package com.as.rest.api;

import com.as.rest.dto.SubscriptionResponseDto;
import com.as.rest.dto.UserRequestDto;
import com.as.rest.dto.UserResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link UsersApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-11-03T13:34:06.389+01:00")

public interface UsersApiDelegate {

    Logger log = LoggerFactory.getLogger(UsersApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    /**
     * @see UsersApi#createUser
     */
    default ResponseEntity<UserResponseDto> createUser(UserRequestDto body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"birthday\" : \"birthday\",  \"surname\" : \"surname\",  \"name\" : \"name\",  \"links\" : [ {    \"rel\" : \"rel\",    \"href\" : \"href\"  }, {    \"rel\" : \"rel\",    \"href\" : \"href\"  } ],  \"id\" : 0}", UserResponseDto.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UsersApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see UsersApi#deleteUser
     */
    default ResponseEntity<UserResponseDto> deleteUser(Long id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"birthday\" : \"birthday\",  \"surname\" : \"surname\",  \"name\" : \"name\",  \"links\" : [ {    \"rel\" : \"rel\",    \"href\" : \"href\"  }, {    \"rel\" : \"rel\",    \"href\" : \"href\"  } ],  \"id\" : 0}", UserResponseDto.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UsersApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see UsersApi#getAllUsers
     */
    default ResponseEntity<List<UserResponseDto>> getAllUsers() {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {  \"birthday\" : \"birthday\",  \"surname\" : \"surname\",  \"name\" : \"name\",  \"links\" : [ {    \"rel\" : \"rel\",    \"href\" : \"href\"  }, {    \"rel\" : \"rel\",    \"href\" : \"href\"  } ],  \"id\" : 0}, {  \"birthday\" : \"birthday\",  \"surname\" : \"surname\",  \"name\" : \"name\",  \"links\" : [ {    \"rel\" : \"rel\",    \"href\" : \"href\"  }, {    \"rel\" : \"rel\",    \"href\" : \"href\"  } ],  \"id\" : 0} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UsersApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see UsersApi#getUser
     */
    default ResponseEntity<UserResponseDto> getUser(Long id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"birthday\" : \"birthday\",  \"surname\" : \"surname\",  \"name\" : \"name\",  \"links\" : [ {    \"rel\" : \"rel\",    \"href\" : \"href\"  }, {    \"rel\" : \"rel\",    \"href\" : \"href\"  } ],  \"id\" : 0}", UserResponseDto.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UsersApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see UsersApi#getUserSubscriptions
     */
    default ResponseEntity<List<SubscriptionResponseDto>> getUserSubscriptions(Long id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {  \"links\" : [ {    \"rel\" : \"rel\",    \"href\" : \"href\"  }, {    \"rel\" : \"rel\",    \"href\" : \"href\"  } ],  \"id\" : 0,  \"userId\" : 6,  \"startDate\" : \"startDate\"}, {  \"links\" : [ {    \"rel\" : \"rel\",    \"href\" : \"href\"  }, {    \"rel\" : \"rel\",    \"href\" : \"href\"  } ],  \"id\" : 0,  \"userId\" : 6,  \"startDate\" : \"startDate\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UsersApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see UsersApi#updateUser
     */
    default ResponseEntity<UserResponseDto> updateUser(Long id,
        UserRequestDto body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"birthday\" : \"birthday\",  \"surname\" : \"surname\",  \"name\" : \"name\",  \"links\" : [ {    \"rel\" : \"rel\",    \"href\" : \"href\"  }, {    \"rel\" : \"rel\",    \"href\" : \"href\"  } ],  \"id\" : 0}", UserResponseDto.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default UsersApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
