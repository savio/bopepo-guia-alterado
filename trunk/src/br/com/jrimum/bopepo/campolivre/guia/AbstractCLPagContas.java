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
 * Created at: 30/03/2008 - 18:07:47
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
 * Criado em: 30/03/2008 - 18:07:47
 * 
 */


package br.com.jrimum.bopepo.campolivre.guia;

import br.com.jrimum.domkee.financeiro.banco.febraban.guia.Arrecadacao;
import br.com.jrimum.domkee.financeiro.banco.febraban.guia.TipoSeguimento;

/**
 * 
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:erisvaldojunior@gmail.com">Erisvaldo Júnior</a>
 * 
 * @since 0.3
 * 
 * @version 0.3
 */
abstract class AbstractCLPagContas extends AbstractCampoLivre {
	
	/**
	 *
	 */
	private static final long serialVersionUID = -7324315662526104153L;


	protected AbstractCLPagContas(Integer fieldsLength, TipoSeguimento tipoSeguimento) {
		super(fieldsLength, tipoSeguimento);
	}

	
	static CampoLivre create(Arrecadacao arrecadacao) throws NotSupportedCampoLivreException {			
		
		CampoLivre campoLivre = null;
		TipoSeguimento tipoSeguimento = null;
		
		tipoSeguimento = arrecadacao.getOrgaoRecebedor().getTipoSeguimento();
		
		campoLivre = new CLPagContas(arrecadacao);	
		

		return campoLivre;
	}
	
}
