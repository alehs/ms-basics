package com.martsinovich.aliaksandr.endpoint;

import com.martsinovich.aliaksandr.model.ConnectionMetadata;
import com.martsinovich.aliaksandr.service.ConnectionMetadataProvider;
import java.sql.SQLException;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "connectionMeta")
public class UserCredentialsEndpoint {

  private final ConnectionMetadataProvider provider;

  public UserCredentialsEndpoint(ConnectionMetadataProvider provider) {
    this.provider = provider;
  }

  @ReadOperation
  public ConnectionMetadata getConnectionMetadata() throws SQLException {
    return provider.provide();
  }
}
