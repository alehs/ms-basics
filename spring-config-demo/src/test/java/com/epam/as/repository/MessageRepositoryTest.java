package com.epam.as.repository;

import jakarta.persistence.EntityManagerFactory;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.cfg.AvailableSettings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.epam.as.configuration.DatasourceConfiguration;
import com.epam.as.message.domain.Message;
import com.epam.as.message.ports.MessageRepository;

@ExtendWith(SpringExtension.class)
@Import(DatasourceConfiguration.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class MessageRepositoryTest {

	@Autowired
	EntityManagerFactory emf;

	@Autowired
	MessageRepository messageRepository;

	@Test
	public void testDatasource() throws SQLException {
		Assertions.assertEquals("jdbc:h2:mem:primaryDb", ((DataSource)emf.getProperties().get(AvailableSettings.DATASOURCE)).getConnection().getMetaData().getURL());
	}


	@Test
	public void testCRUD() {
		Message saved = messageRepository.save(new Message("Hello"));
		Assertions.assertNotNull(saved.getId());
		Assertions.assertEquals("Hello", saved.getText());
	}

}
