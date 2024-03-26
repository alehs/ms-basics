package com.martsinovich.aliaksandr.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.martsinovich.aliaksandr.entity.Customer;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(value = "qa")
class CustomerRepositoryIntegrationTest {

  @Autowired DataSource dataSource;

  @Autowired CustomerRepository repository;

  @Test
  void shouldBeDefaultDb() throws SQLException {
    // given
    var expectedDb = "defaultDb";

    // when
    var actualDb = dataSource.getConnection().getMetaData().getURL().replace("jdbc:h2:mem:", "");

    // then
    assertEquals(expectedDb, actualDb, "must be equal");
  }

  @Test
  void successfullySaveNewCustomer() {
    // given
    var newCustomer = new Customer(2L, "Mike", "700 Oak Street, Brockton MA 2301");
    var initCount = repository.count();

    // when
    repository.save(newCustomer);

    // then
    assertEquals(initCount + 1, repository.count(), "must be increased by one");
  }

}
