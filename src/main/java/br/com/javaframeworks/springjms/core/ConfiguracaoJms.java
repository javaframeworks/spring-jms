package br.com.javaframeworks.springjms.core;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jms.connection.*;
import org.springframework.jms.core.JmsTemplate;
import javax.jms.ConnectionFactory;

/**
 * Classe que substitui a configuração de beans a partir de XMLs
 * @see - http://blog.springsource.org/2009/12/22/configuration-simplifications-in-spring-3-0/
 * @author Wagner Rondon - Java Frameworks
 */
@Configuration
public class ConfiguracaoJms {

	@Value("${broker.url}")
	private String brokerUrl;

	/**
	 * Fábria de conexão para mensageria 
	 * @return
	 */
	@Bean
	public ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL(this.brokerUrl);
		return new CachingConnectionFactory(activeMQConnectionFactory);
	}

	/**
	 * Gerenciador de transação
	 * @return
	 */
	@Bean
	public JmsTransactionManager gerenciadorDeTransacaoJms() {
		return new JmsTransactionManager(this.connectionFactory());
	}


	/**
	 * Template JMS
	 * @return
	 */
	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(this.connectionFactory());
	}

}
