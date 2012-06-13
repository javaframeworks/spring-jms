package br.com.javaframeworks.springjms.listener;

import org.apache.commons.logging.*;
import org.springframework.stereotype.Component;

import br.com.javaframeworks.springjms.model.Cliente;

import java.util.Map;

/**
 * Classe configurada para ser o listener da fila "jsmClienteDestino"
 *
 * @see - applicationContext.xml
 * @author Wagner Rondon - Java Frameworks
 *
 */
@Component
public class ListenerConsumidorDeMensagem {

	private Log log = LogFactory.getLog(getClass());

	/**
	 * Recebe a mensagem através de um Map
	 * @param message
	 * @throws Exception
	 */
	public void recebeMensagem(Map<String, Object> message) throws Exception {
		String nome = (String) message.get("nome");
		String sobreNome = (String) message.get("sobreNome");
		String email = (String) message.get("email");
		Long id = (Long) message.get("id");
		Cliente cliente = new Cliente(id, nome, sobreNome, email);
		log.info("recebendo mensagem de cliente: " + cliente);
	}
}