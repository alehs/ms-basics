package com.as.rest.api;

import org.springframework.stereotype.Controller;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-11-03T13:34:06.389+01:00")

@Controller
public class SubscriptionsApiController implements SubscriptionsApi {

    private final SubscriptionsApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public SubscriptionsApiController(SubscriptionsApiDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public SubscriptionsApiDelegate getDelegate() {
        return delegate;
    }
}
