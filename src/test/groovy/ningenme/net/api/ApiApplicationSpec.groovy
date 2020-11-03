package ningenme.net.api

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification;


@SpringBootTest
public class ApiApplicationSpec extends Specification{
	def sampleTest() {
		expect:
		1 == 1
	}
}
