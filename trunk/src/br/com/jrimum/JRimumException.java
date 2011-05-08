/*
 * Copyright 2008 JRimum Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * Created at: 30/03/2008 - 16:16:24
 * 
 * ================================================================================
 * 
 * Direitos autorais 2008 JRimum Project
 * 
 * Licenciado sob a Licença Apache, Versão 2.0 ("LICENÇA"); você não pode usar
 * esse arquivo exceto em conformidade com a esta LICENÇA. Você pode obter uma
 * cópia desta LICENÇA em http://www.apache.org/licenses/LICENSE-2.0 A menos que
 * haja exigência legal ou acordo por escrito, a distribuição de software sob
 * esta LICENÇA se dará “COMO ESTÁ”, SEM GARANTIAS OU CONDIÇÕES DE QUALQUER
 * TIPO, sejam expressas ou tácitas. Veja a LICENÇA para a redação específica a
 * reger permissões e limitações sob esta LICENÇA.
 * 
 * Criado em: 30/03/2008 - 16:16:24
 * 
 */


package br.com.jrimum;


/**
 * <p>
 * Classe que representa um problema ocorrido dentro de qualquer parte (pacote)
 * do projeto <tt>JRimum</tt>
 * </p>
 * 
 * 
 * <p>
 * Qualquer exceção que ocorra dentro do componente <tt>JRimum</tt> é sempre
 * <em>wrapped</em> por uma instância de uma <code>JRimumException</code>.
 * </p>
 * 
 * 
 * <pre>
 * try {
 * 	execute();
 * } catch (IllegalArgumentException e) {
 * 	throw new JRimumException(&quot;Problema&quot;, e);
 * }
 * </pre>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 * 
 * @see java.lang.RuntimeException
 */

public class JRimumException extends RuntimeException {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @see java.lang.RuntimeException#RuntimeException()
	 * 
	 * @since 0.2
	 */
	public JRimumException() {
		super();
		// Nothing to do.
	}

	/**
	 * @param message
	 * @param cause
	 * 
	 * @see java.lang.RuntimeException#RuntimeException(String, Throwable)
	 * 
	 * @since 0.2
	 */
	public JRimumException(String message, Throwable cause) {
		super(message, cause);
		// Nothing to do.
	}

	/**
	 * @param message
	 * 
	 * @see java.lang.RuntimeException#RuntimeException(String)
	 * 
	 * @since 0.2
	 */
	public JRimumException(String message) {
		super(message);
		// Nothing to do.
	}

	/**
	 * @param cause
	 * 
	 * @see java.lang.RuntimeException#RuntimeException(Throwable)
	 * 
	 * @since 0.2
	 */
	public JRimumException(Throwable cause) {
		super(cause);
		// Nothing to do.
	}

}
