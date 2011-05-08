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
 * Created at: 30/03/2008 - 18:18:19
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
 * Criado em: 30/03/2008 - 18:18:19
 * 
 */

package br.com.jrimum.utilix;

import static br.com.jrimum.utilix.ObjectUtil.isNotNull;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

/**
 * <p>
 * Esta classe tem a responsabilidade de prover serviços utilitários
 * relacionados a manipulação de <code>Strings</code>
 * </p>
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author Misael Barreto
 * @author Rômulo Augusto
 * @author <a href="http://www.nordeste-fomento.com.br">Nordeste Fomento
 *         Mercantil</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class StringUtil implements Serializable {

	public static final String WHITE_SPACE = " ";

	/**
	 * 
	 */
	private static final long serialVersionUID = 7425529940068032055L;

	/**
	 * <p>
	 * Construtor privado que previne a instanciação da classe até por
	 * reflection
	 * </p>
	 * 
	 * @since 0.2
	 */
	private StringUtil() {
		throw new AssertionError();
	}
	
	/**
	 * <p>
	 * Método privado para fins de reutilização de código.
	 * </p>
	 * <p>
	 * Verifica se a <code>String</code> passada por parâmetro não é <code>null</code>, 
	 * não é vazia (<code>StringUtils.EMPTY</code>) e não possui apenas espaços em branco. 
	 * </p>
	 * <p>
	 * Lança <code>NullPointerException</code>, com a mensagem definida em <code>messageNullPointer</code> 
	 * (segundo parâmetro String), caso o valor passado seja <code>null</code>
	 * </p>
	 * <p>
	 * Lança <code>IllegalArgumentException</code>, com a mensagem definida em <code>messageIllegalArgument</code> 
	 * (terceiro parâmetro String), caso o valor passado seja vazio ou contenha apenas espaços em branco.
	 * </p>
	 * 
	 * @param value - String analisada
	 * 
	 * @throws NullPointerException - Caso a string seja <code>null</code>.
	 * @thows IllegalArgumentException - Caso a string seja vazia ou contenha apenas espaços em branco.
	 * 
	 * @since 0.2
	 */
	private static void checkNotBlank(String value, String messageNullPointer, String messageIllegalArgument) {

		ObjectUtil.checkNotNull(value, messageNullPointer);
		
		if (StringUtils.isBlank(value)) {
			throw new IllegalArgumentException(messageIllegalArgument);
		}
	}

	/**
	 * <p>
	 * Elimina simbolos como: <pre>><,;.:!*&%+-_<>[]\/</pre>
	 * </p>
	 * 
	 * @param str
	 *            String com os símbolos a serem removidos.
	 * @return String sem símbolos.
	 * @since 0.2
	 */
	public static String eliminateSymbols(final String str) {

		String modifiedStr = str;

		if (isNotNull(modifiedStr)) {

			modifiedStr = StringUtils.replace(str, "-", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, "_", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, "=", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, "+", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, "%", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, "*", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, "@", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, "#", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, "&", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, ":", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, ".", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, ";", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, ",", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, "!", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, "?", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, "(", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, ")", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, "{", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, "}", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, "[", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, "]", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, "/", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, "\\", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, ">", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, "<", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, "\"", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, "'", StringUtils.EMPTY);
			modifiedStr = StringUtils.replace(str, "`", StringUtils.EMPTY);
		}

		return modifiedStr;
	}

	/**
	 * <p>
	 * Remove os zeros iniciais de uma <code>String</code>, seja ela numérica ou
	 * não.
	 * </p>
	 * <p>
	 * <code>removeStartWithZeros("00000") => 0</code><br />
	 * <code>removeStartWithZeros("00023") => 23</code><br />
	 * <code>removeStartWithZeros("02003") => 2003</code>
	 * <p>
	 * 
	 * @param str
	 * @return a string sem zeros inicias ou um único zero.
	 * 
	 * @since 0.2
	 */

	public static String removeStartWithZeros(final String str) {

		String withoutZeros = StringUtils.EMPTY;
		final String zero = "0";

		if (isNotNull(str)) {

			if (StringUtils.startsWith(str, zero)) {

				withoutZeros = StringUtils.removeStart(str, zero);

				while (StringUtils.startsWith(withoutZeros, zero)) {
					withoutZeros = StringUtils.removeStart(withoutZeros, zero);
				}

				if (withoutZeros.trim().length() == 0) {
					withoutZeros = zero;
				}

			} else {
				withoutZeros = str;
			}
		}

		return withoutZeros;
	}

	/**
	 * <p>
	 * Remove a acentuação do texto, que inclui os acentos:
	 * <ul>
	 * <li>Agudo. ex.: á</li>
	 * <li>Grave. ex.: à</li>
	 * <li>Til. ex.: ã</li>
	 * <li>Trema. ex.: ä</li>
	 * <li>Circunflexo. ex.: â</li>
	 * </ul>
	 * e o Cedilha (ç).
	 * </p>
	 * <p>
	 * Os acentos são removidos tanto para letras minúsculas como para letras
	 * maiúsculas.
	 * </p>
	 * 
	 * @param value
	 *            String com os caracteres a serem removidos.
	 * @return String sem acentuação.
	 * @since 0.2
	 */
	public static String eliminateAccent(final String value) {

		String modifiedValue = value;

		// Para ç e Ç
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00E7', 'c');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00C7', 'C');

		// Para à, á, â, ã e ä
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00E0', 'a');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00E1', 'a');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00E2', 'a');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00E3', 'a');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00E4', 'a');

		// Para è, é, ê e ë
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00E8', 'e');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00E9', 'e');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00EA', 'e');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00EB', 'e');

		// Para ì, í, î e ï
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00EC', 'i');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00ED', 'i');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00EE', 'i');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00EF', 'i');

		// Para ò, ó, ô, õ e ö
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00F2', 'o');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00F3', 'o');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00F4', 'o');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00F5', 'o');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00F6', 'o');

		// Para ù, ú, û e ü
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00F9', 'u');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00FA', 'u');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00FB', 'u');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00FC', 'u');

		// Para À, Á, Â, Ã e Ä
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00C0', 'A');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00C1', 'A');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00C2', 'A');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00C3', 'A');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00C4', 'A');

		// Para È, É, Ê e Ë
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00C8', 'E');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00C9', 'E');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00CA', 'E');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00CB', 'E');

		// Para Ì, Í, Î e Ï
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00CC', 'I');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00CD', 'I');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00CE', 'I');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00CF', 'I');

		// Para Ò, Ó, Ô, Õ e Ö
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00D2', 'O');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00D3', 'O');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00D4', 'O');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00D5', 'O');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00D6', 'O');

		// Para Ù, Ú, Û e Ü
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00D9', 'U');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00DA', 'U');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00DB', 'U');
		modifiedValue = StringUtils.replaceChars(modifiedValue, '\u00DC', 'U');

		return modifiedValue;
	}
	
	/**
	 * <p>
	 * Verifica se a <code>String</code> passada por parâmetro não é <code>null</code>, 
	 * não é vazia (<code>StringUtils.EMPTY</code>) e não possui apenas espaços em branco. 
	 * </p>
	 * <p>
	 * Lança exceção, com a mensagem passada por parâmetro (segundo parâmetro String), 
	 * caso não preencha estes requisitos.
	 * </p>
	 * 
	 * @param value - String analisada
	 * 
	 * @throws NullPointerException - Caso a string seja <code>null</code>.
	 * @thows IllegalArgumentException - Caso a string seja vazia ou contenha apenas espaços em branco.
	 * 
	 * @since 0.2
	 */
	public static void checkNotBlank(String value, String message) {
		checkNotBlank(value, message, message);
	}
	
	/**
	 * <p>
	 * Verifica se a <code>String</code> passada por parâmetro não é <code>null</code>, 
	 * não é vazia (<code>StringUtils.EMPTY</code>) e não possui apenas espaços em branco. 
	 * Lança exceção caso não preencha estes requisitos.
	 * </p>
	 * 
	 * @param value - String analisada
	 * 
	 * @throws NullPointerException - Caso a string seja <code>null</code>.
	 * @thows IllegalArgumentException - Caso a string seja vazia ou contenha apenas espaços em branco.
	 * 
	 * @since 0.2
	 */
	public static void checkNotBlank(String value) {
		checkNotBlank(value, "String nula", "Valor inválido. String vazia ou contendo apenas espaços em brancos");
	}
}
