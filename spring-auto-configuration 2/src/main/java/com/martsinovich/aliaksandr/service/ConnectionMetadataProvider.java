package com.martsinovich.aliaksandr.service;

import com.martsinovich.aliaksandr.model.ConnectionMetadata;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.stereotype.Service;

@Service
public class ConnectionMetadataProvider {

  private final DataSource dataSource;

  public ConnectionMetadataProvider(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public ConnectionMetadata provide() throws SQLException {
    final var metadata =  dataSource.getConnection().getMetaData();

    return new ConnectionMetadata(metadata.getUserName(), metadata.getURL());
  }
}
