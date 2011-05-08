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
 * Created at: 30/03/2008 - 18:04:37
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
 * Criado em: 30/03/2008 - 18:04:37
 * 
 */


package br.com.jrimum.bopepo.guia;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import br.com.jrimum.utilix.AbstractLineOfFields;
import br.com.jrimum.utilix.Field;
import br.com.jrimum.utilix.ObjectUtil;
import br.com.jrimum.utilix.StringUtil;
import br.com.jrimum.vallia.digitoverificador.GuiaLinhaDigitavelDV;


/**
 * 
 * 
 * @see br.com.jrimum.bopepo.guia.CodigoDeBarras
 * 
 * @author Misael Barreto 
 * 
 * @since 0.3
 * 
 * @version 0.3
 */
public final class LinhaDigitavel extends AbstractLineOfFields {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3834406645384269082L;

	private static Logger log = Logger.getLogger(LinhaDigitavel.class);
	
	/**
	 * 
	 */
	private static final Integer FIELDS_LENGTH = 4;
	
	/**
	 * <p>
	 * Tamanho dos campos mais os espaços entre eles. <br/>
	 * 44 posições do código de barras <br/>
	 * + <font color="red">4 dígitos verificadores</font><br/>
	 * + 4 espaços em branco (entre cada campo e seu dígito verificador): <br/>
	 * + 3 espaços em branco (para separar os campos): <br/>
	 * Ex: 89610000001 <font size="4" color="red">8</font>
	 *     00000001011 <font size="4" color="red">6</font>
	 *     05449201004 <font size="4" color="red">3</font>
	 *     26011145220 <font size="4" color="red">7</font>
	 *     <br/>
 	 * </p>
	 */
	private static final Integer STRING_LENGTH = 55;

	/**
	 * 
	 */
	private Field<InnerCampo1> innerCampo1;
	
	/**
	 * 
	 */
	private Field<InnerCampo2> innerCampo2;
	
	/**
	 * 
	 */
	private Field<InnerCampo3> innerCampo3;
	
	/**
	 * 
	 */
	private Field<InnerCampo4> innerCampo4;


	/**
	 * <p>
	 * Cria uma linha digitável com a partir do código de barras passado.
	 * </p>
	 * 
	 * @param codigoDeBarras
	 * 
	 * @see br.com.jrimum.bopepo.guia.CodigoDeBarras
	 * 
	 * @since 0.3
	 */
	LinhaDigitavel(CodigoDeBarras codigoDeBarras) {
		super(FIELDS_LENGTH,STRING_LENGTH);
		
		if(log.isTraceEnabled())
			log.trace("Instanciando Linha Digitável");
		
		if(log.isDebugEnabled())
			log.debug("codigoDeBarra instance : "+codigoDeBarras);
		
		
		// Cada InnerCampo possui 2 campos internos, com um total de 
		// 13 caracteres ao final (11 dígitos do CB + " " + DV).
		innerCampo1 = new Field<InnerCampo1>(new InnerCampo1(2,13),13);
		innerCampo2 = new Field<InnerCampo2>(new InnerCampo2(2,13),13);
		innerCampo3 = new Field<InnerCampo3>(new InnerCampo3(2,13),13);
		innerCampo4 = new Field<InnerCampo4>(new InnerCampo4(2,13),13);
		
		add(innerCampo1);
		add(innerCampo2);
		add(innerCampo3);
		add(innerCampo4);
		
		this.innerCampo1.getValue().load(codigoDeBarras);
		this.innerCampo2.getValue().load(codigoDeBarras);
		this.innerCampo3.getValue().load(codigoDeBarras);
		this.innerCampo4.getValue().load(codigoDeBarras);
		
		if(log.isDebugEnabled() || log.isTraceEnabled())
			log.debug("Linha digitável instanciada : " + this.write());
	}

	/**
	 * Escreve a linha digitável foramatada (com espaço entre os campos).
	 * 
	 * @see br.com.jrimum.utilix.AbstractLineOfFields#write()
	 */
	@Override
	public String write(){
		StringBuilder lineOfFields = new StringBuilder(innerCampo1.write()).
			append(StringUtil.WHITE_SPACE).
			append(innerCampo2.write()).
			append(StringUtil.WHITE_SPACE).
			append(innerCampo3.write()).
			append(StringUtil.WHITE_SPACE).
			append(innerCampo4.write());
		
		isConsistent(lineOfFields);
		return lineOfFields.toString();
	}

	
	
	private abstract class InnerCampo extends AbstractLineOfFields {		
		/**
		 * 
		 */
		private static final long serialVersionUID = -5345299360636304482L;
		
		private Integer numeroCampo;
		
		private InnerCampo(Integer fieldsLength, Integer stringLength, Integer numeroCampo) {
			super(fieldsLength, stringLength);
			this.numeroCampo = numeroCampo;
		}
		
		/**
		 * <p>
		 * 
		 * Aplicação do seguinte requisito da FEBRABAN: <br/>
		 * Em cada campo o dígito verificador deverá ser separado do conteúdo 
		 * restante através de um espaço em branco " ". <br/><br/>
		 * Exemplo: <br/>
		 * Campo não formatado: 896100000018 (Dígito Verificador = 8) <br/>
		 * Campo formatado:  89610000001 8
		 * </p>
		 * 
		 * @see br.com.jrimum.utilix.AbstractLineOfFields#write()
		 */
		@Override
		public String write(){
			StringBuilder lineOfFields = new StringBuilder(StringUtils.EMPTY);
			
			for(Field<?> field : this)
				lineOfFields.append(field.write());
			
			lineOfFields.insert(11, "-");
			isConsistent(lineOfFields);

			return lineOfFields.toString();
		}
		
		/**
		 * @param CodigoDeBarras codigoDeBarras
		 */
		public void load(CodigoDeBarras codigoDeBarras){
			// Obtendo o mesmo módulo utilizado pelo código de barras para realizar
			// o cálculo do dígito verificador.
			GuiaLinhaDigitavelDV calculadorDV = new GuiaLinhaDigitavelDV(codigoDeBarras.getModuloParaCalculoDV());
			
			if(log.isTraceEnabled())
				log.trace("Compondo campo " + this.numeroCampo + " da Linha Digitável");

				// Obtendo o trecho do código de barras que servirá de base para
				// a montagem da linha digitável. Casa classe filha definirá
				// que trecho é esse.
				String trechoCodigoDeBarras = getTrechoCodigoDeBarras(codigoDeBarras);
				add(  new Field<String>(trechoCodigoDeBarras, 11)  );
				add(  new Field<Integer>(calculadorDV.calcule(trechoCodigoDeBarras), 1)  );
				
				if(log.isDebugEnabled())
					log.debug("Digito verificador do Field " + this.numeroCampo + " da Linha Digitável: "+ get(1).getValue());

				if(log.isDebugEnabled() || log.isTraceEnabled())
					log.debug("Field " + this.numeroCampo + " da Linha Digitável composto : "+ this.write());
		}
		
		protected abstract String getTrechoCodigoDeBarras(CodigoDeBarras codigoDeBarras); 
	}
	
	
	private class InnerCampo1 extends InnerCampo {
		/**
		 * 
		 */
		private static final long serialVersionUID = -780242445964556753L;

		private InnerCampo1(Integer fieldsLength, Integer stringLength) {
			super(fieldsLength, stringLength, 1);
		}

		@Override
		protected String getTrechoCodigoDeBarras(CodigoDeBarras codigoDeBarras) {
			// Posição 01 a 11 do código de barras
			return codigoDeBarras.write().substring(0, 11);
		}
	}
	
	
	
	private class InnerCampo2 extends InnerCampo {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 382377306835578506L;

		private InnerCampo2(Integer fieldsLength, Integer stringLength) {
			super(fieldsLength, stringLength, 2);
		}

		@Override
		protected String getTrechoCodigoDeBarras(CodigoDeBarras codigoDeBarras) {
			// Posição 12 a 22 do código de barras
			return codigoDeBarras.write().substring(11, 22);
		}
	}	
	
	
	
	private class InnerCampo3 extends InnerCampo {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -5589288171927030864L;

		private InnerCampo3(Integer fieldsLength, Integer stringLength) {
			super(fieldsLength, stringLength, 3);
		}

		@Override
		protected String getTrechoCodigoDeBarras(CodigoDeBarras codigoDeBarras) {
			// Posição 23 a 33 do código de barras
			return codigoDeBarras.write().substring(22, 33);
		}
	}		

	
	
	private class InnerCampo4 extends InnerCampo {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7559169854185810900L;

		private InnerCampo4(Integer fieldsLength, Integer stringLength) {
			super(fieldsLength, stringLength, 4);
		}

		@Override
		protected String getTrechoCodigoDeBarras(CodigoDeBarras codigoDeBarras) {
			// Posição 34 a 44 do código de barras
			return codigoDeBarras.write().substring(33, 44);
		}
	}		
	
	

	@Override
	public String toString() {
		return ObjectUtil.toString(this);
	}
}
