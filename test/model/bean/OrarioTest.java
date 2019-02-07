package model.bean;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrarioTest {
	Orario orario;
	@BeforeEach
	void setUp() throws Exception {
		 orario = new Orario(new Timestamp(2019, 2, 11, 15, 0, 0, 0), new Timestamp(2019, 2, 11, 17, 0, 0, 0));
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetGiorno() {
	String giorno=	orario.getGiorno();
	assertEquals("Lunedì",giorno);
	}

}
