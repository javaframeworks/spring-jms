package br.com.javaframeworks.springjms.core;

import org.apache.commons.logging.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.jms.core.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.javaframeworks.springjms.model.Cliente;

import javax.jms.*;

/**
 * Componente Spring responsável pelo envio de mensagens para a fila ActiveMQ
 *
 * @author Wagner Rondon - Java Frameworks
 *
 */
@Component
public class Produtor {

	@Value("${jms.cliente.destino}")
	private String jmsClienteDestino;

	@Autowired
	private JmsTemplate jmsTemplate;

	private Log log = LogFactory.getLog(getClass());

	/**
	 * Recebe o bean cliente e envia para a fila "jmsClienteDestino", configurada no jms.properties
	 * @param customer
	 * @throws Exception
	 */
	@Transactional
	  public void sendCustomerUpdate(final Cliente cliente) throws Exception {
	    this.jmsTemplate.send(this.jmsClienteDestino, new MessageCreator() {
	      @Override
	      public Message createMessage(Session session) throws JMSException {
	           log.info("Enviando dados do cliente " + cliente);
	           MapMessage mapMessage = session.createMapMessage();
	           mapMessage.setLong("id", cliente.getId());
	           mapMessage.setString("nome", cliente.getNome());
	           mapMessage.setString("sobreNome", cliente.getSobreNome());
	           mapMessage.setString("email", cliente.getEmail());
	           return mapMessage;
	      }
	    });
	  }

}
