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
 * Created at: 30/03/2008 - 18:09:27
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
 * Criado em: 30/03/2008 - 18:09:27
 * 
 */


package br.com.jrimum.bopepo.campolivre;

import br.com.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import br.com.jrimum.domkee.financeiro.banco.febraban.Titulo;
import br.com.jrimum.utilix.Field;
import br.com.jrimum.utilix.Filler;

/**
 * 
 * O campo livre do bradesco deve seguir esta forma:
 * 
 * <table border="1" cellpadding="0" cellspacing="0" style="border-collapse:
 * collapse" bordercolor="#111111" width="60%" id="campolivre">
 * <tr> <thead>
 * <th >Posição </th>
 * <th >Tamanho</th>
 * <th >Picture</th>
 * <th >Conteúdo</th>
 * </thead> </tr>
 * <tr>
 * <td >20-23</td>
 * <td >4</td>
 * <td >9(4) </td>
 * <td >Código da Agência (sem dígito)</td>
 * </tr>
 * <tr>
 * <td >24-25</td>
 * <td >2</td>
 * <td >9(2) </td>
 * <td >Código da Carteira</td>
 * </tr>
 * <tr>
 * <td >26-36</td>
 * <td >11</td>
 * <td >&nbsp;9(11) </td>
 * <td >Nosso Número (sem dígito)</td>
 * </tr>
 * <tr>
 * <td >37-43</td>
 * <td >7</td>
 * <td >&nbsp;9(7) </td>
 * <td >Conta do Cedente (sem dígito)</td>
 * </tr>
 * <tr>
 * <td >44-44</td>
 * <td >1</td>
 * <td >9 </td>
 * <td >Zero Fixo</td>
 * </tr>
 * </table>
 * 
 * 
 * @see br.com.jrimum.bopepo.campolivre.AbstractCampoLivre
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author Misael Barreto 
 * @author Rômulo Augusto
 * @author <a href="http://www.nordeste-fomento.com.br">Nordeste Fomento Mercantil</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
class CLBradesco extends AbstractCLBradesco {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1253549781074159862L;

	/**
	 * 
	 */
	private static final Integer FIELDS_LENGTH = 5;
	
	/**
	 * <p>
	 *   Dado um título, cria um campo livre para o padrão do Banco Bradesco.
	 * </p>
	 * @param titulo título com as informações para geração do campo livre
	 */
	CLBradesco(Titulo titulo){
		super(FIELDS_LENGTH, STRING_LENGTH);
		
		ContaBancaria conta = titulo.getContaBancaria();
		String nossoNumero = titulo.getNossoNumero();
		
		this.add(new Field<Integer>(conta.getAgencia().getCodigo(), 4, Filler.ZERO_LEFT));
		
		this.add(new Field<Integer>(conta.getCarteira().getCodigo(), 2, Filler.ZERO_LEFT));
		this.add(new Field<String>(nossoNumero, 11, Filler.ZERO_LEFT));
		
		this.add(new Field<Integer>(conta.getNumeroDaConta().getCodigoDaConta(), 7, Filler.ZERO_LEFT));
		
		this.add(new Field<Integer>(0, 1));
		
	}
	
}
