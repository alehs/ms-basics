package com.as.rest.api;

import org.springframework.stereotype.Controller;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-11-03T13:34:06.389+01:00")

@Controller
public class UsersApiController implements UsersApi {

    private final UsersApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public UsersApiController(UsersApiDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public UsersApiDelegate getDelegate() {
        return delegate;
    }
}
