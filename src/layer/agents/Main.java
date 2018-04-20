package layer.agents;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 
 * @author Hamid Mcheick
 *
 */
public class Main {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("spring.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		MasterAgent ma = (MasterAgent) factory.getBean("MasterAgent");
		ma.start();
	}
}
