package br.com.javaframeworks.springjms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.javaframeworks.springjms.core.Produtor;
import br.com.javaframeworks.springjms.model.Cliente;

/**
 * Classe principal que carregará o contexto do Spring e fará algumas simulações de envio de mensagens
 * 
 * @author Wagner Rondon - Java Frameworks
 * 
 */
public class Iniciar {

	public static void main(String[] args) throws Exception {
		
		//1. Inicia contexto Spring
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		//2. Simula envio de mensagem para Listener
		Produtor produtor = (Produtor) applicationContext.getBean("produtor");
		produtor.sendCustomerUpdate(new Cliente(1l, "Andre", "Castro", "acastro@gmail.com"));
		
		//3. Força a finalização da aplicação (exclusivo para este exemplo, pois o listener ativo não terá mais utilidade)
		System.exit(1);
		
	}
}
