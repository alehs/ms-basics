package com.as.rest.api;

import com.as.rest.dto.SubscriptionRequestDto;
import com.as.rest.dto.SubscriptionResponseDto;
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
 * A delegate to be called by the {@link SubscriptionsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-11-03T13:34:06.389+01:00")

public interface SubscriptionsApiDelegate {

    Logger log = LoggerFactory.getLogger(SubscriptionsApi.class);

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
     * @see SubscriptionsApi#createSubscription
     */
    default ResponseEntity<SubscriptionResponseDto> createSubscription(SubscriptionRequestDto body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"links\" : [ {    \"rel\" : \"rel\",    \"href\" : \"href\"  }, {    \"rel\" : \"rel\",    \"href\" : \"href\"  } ],  \"id\" : 0,  \"userId\" : 6,  \"startDate\" : \"startDate\"}", SubscriptionResponseDto.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default SubscriptionsApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see SubscriptionsApi#getAllSubscriptions
     */
    default ResponseEntity<List<SubscriptionResponseDto>> getAllSubscriptions() {
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
            log.warn("ObjectMapper or HttpServletRequest not configured in default SubscriptionsApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see SubscriptionsApi#getSubscription
     */
    default ResponseEntity<SubscriptionResponseDto> getSubscription(Long id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"links\" : [ {    \"rel\" : \"rel\",    \"href\" : \"href\"  }, {    \"rel\" : \"rel\",    \"href\" : \"href\"  } ],  \"id\" : 0,  \"userId\" : 6,  \"startDate\" : \"startDate\"}", SubscriptionResponseDto.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default SubscriptionsApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see SubscriptionsApi#updateSubscription
     */
    default ResponseEntity<SubscriptionResponseDto> updateSubscription(Long id,
        SubscriptionRequestDto body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"links\" : [ {    \"rel\" : \"rel\",    \"href\" : \"href\"  }, {    \"rel\" : \"rel\",    \"href\" : \"href\"  } ],  \"id\" : 0,  \"userId\" : 6,  \"startDate\" : \"startDate\"}", SubscriptionResponseDto.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default SubscriptionsApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
