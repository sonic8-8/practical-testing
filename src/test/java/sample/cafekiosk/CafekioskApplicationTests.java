package sample.cafekiosk;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import sample.cafekiosk.spring.CafekioskApplication;

@ActiveProfiles("test")
@SpringBootTest(classes = CafekioskApplication.class)
class CafekioskApplicationTests {

	@Test
	void contextLoads() {
	}

}
