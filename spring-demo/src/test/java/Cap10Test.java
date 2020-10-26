import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pers.lls.aop.Calculator;
import pers.lls.aop.Cap10MainConfig;

public class Cap10Test {
	@Test
	public void test01(){
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap10MainConfig.class);
		Calculator c = app.getBean(Calculator.class);
		int result = c.div(4, 3);
		System.out.println(result);
		app.close();
 
	}
}