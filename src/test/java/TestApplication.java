import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mongodb.MongoDBApplication;
import com.mongodb.services.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MongoDBApplication.class)
@WebAppConfiguration
public class TestApplication {

	final static Logger logger = LoggerFactory.getLogger(TestApplication.class);
	
	@Autowired
	BookService bookService;
	
	@Test
	public void findAllDocuments(){
		logger.info("All Books : "+bookService.getAllBooks());
	}
}
