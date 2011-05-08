
/* 
 * Copyright 2008 JRimum Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * 
 * Created at: 18/05/2008 - 21:15:39
 *
 * ================================================================================
 *
 * Direitos autorais 2008 JRimum Project
 *
 * Licenciado sob a Licença Apache, Versão 2.0 ("LICENÇA"); você não pode 
 * usar esse arquivo exceto em conformidade com a esta LICENÇA. Você pode obter uma 
 * cópia desta LICENÇA em http://www.apache.org/licenses/LICENSE-2.0 A menos que 
 * haja exigência legal ou acordo por escrito, a distribuição de software sob esta 
 * LICENÇA se dará “COMO ESTÁ”, SEM GARANTIAS OU CONDIÇÕES DE QUALQUER TIPO, sejam 
 * expressas ou tácitas. Veja a LICENÇA para a redação específica a reger permissões 
 * e limitações sob esta LICENÇA.
 * 
 * Criado em: 18/05/2008 - 21:15:39
 * 
 */
	
package br.com.jrimum.bopepo.exemplo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.jrimum.bopepo.BancoSuportado;
import br.com.jrimum.bopepo.Boleto;
import br.com.jrimum.domkee.comum.pessoa.endereco.CEP;
import br.com.jrimum.domkee.comum.pessoa.endereco.Endereco;
import br.com.jrimum.domkee.comum.pessoa.endereco.UnidadeFederativa;
import br.com.jrimum.domkee.financeiro.banco.febraban.Agencia;
import br.com.jrimum.domkee.financeiro.banco.febraban.Carteira;
import br.com.jrimum.domkee.financeiro.banco.febraban.Cedente;
import br.com.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import br.com.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import br.com.jrimum.domkee.financeiro.banco.febraban.Sacado;
import br.com.jrimum.domkee.financeiro.banco.febraban.SacadorAvalista;
import br.com.jrimum.domkee.financeiro.banco.febraban.TipoDeTitulo;
import br.com.jrimum.domkee.financeiro.banco.febraban.Titulo;
import br.com.jrimum.domkee.financeiro.banco.febraban.Titulo.EnumAceite;


/**
 * 
 * <p>
 * DEFINIÇÃO DA CLASSE
 * </p>
 * 
 * <p>
 * OBJETIVO/PROPÓSITO
 * </p>
 * 
 * <p>
 * EXEMPLO: 
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */

public class ExemplosUtil {


	
	/**
	 * <p>
	 * Devolve uma lista com mais de um boleto.
	 * </p>
	 * 
	 * @return List<Boleto>
	 * 
	 * @since 0.2
	 */
		
	public static List<Boleto> getVariosBoletos() {
		
		List<Boleto> boletos = new ArrayList<Boleto>(5);
		
		Titulo titulo;

		final Date VENCIMENTO = new GregorianCalendar(2000, Calendar.JULY, 3).getTime();
		
		final Date DATA_DO_DOCUMENTO =  new GregorianCalendar(2000, Calendar.APRIL, 14).getTime();

		Sacado sacado = new Sacado("Fulano da Silva Sauro Perdido e Desempregado", "222.222.222-22");
		
		Endereco endereco = new Endereco();
		endereco.setUF(UnidadeFederativa.RN);
		endereco.setLocalidade("Natal");
		endereco.setCep(new CEP("59064-120"));
		endereco.setBairro("Grande Centro");
		endereco.setLogradouro("Rua Poeta das Princesas");
		endereco.setNumero("1");
		
		sacado.addEndereco(endereco);
		
		Cedente cedente = new Cedente("Empresa Lucrativa para Todo Sempre Ilimitada", "00.000.208/0001-00");
	
		ContaBancaria contaBancaria = new ContaBancaria(BancoSuportado.BANCO_DO_BRASIL.create());
		
		contaBancaria.setAgencia(new Agencia(1234, "7"));
		contaBancaria.setCarteira(new Carteira(5));
		contaBancaria.setNumeroDaConta(new NumeroDaConta(6789, "12"));

		cedente.addContaBancaria(contaBancaria);
		
		SacadorAvalista sacadorAvalista = new SacadorAvalista("Banco do Brasil", "00.000.000/0001-91");
		
		Endereco endereco2 = new Endereco();
		endereco2.setUF(UnidadeFederativa.DF);
		endereco2.setLocalidade("Brasília");
		endereco2.setCep(new CEP("00000-000"));
		endereco2.setBairro("Grande Centro");
		endereco2.setLogradouro("Rua Principal Para Sempre");
		endereco2.setNumero("001");

		sacadorAvalista.addEndereco(endereco2);
		
		// Fim Código em teste

		titulo = new Titulo(contaBancaria,sacado, cedente, sacadorAvalista);
		titulo.setNumeroDoDocumento("123456789");
		titulo.setNossoNumero("1234567890");
		titulo.setDigitoDoNossoNumero("5");
		titulo.setValor(BigDecimal.valueOf(100.23));
		titulo.setDataDoDocumento(DATA_DO_DOCUMENTO);
		titulo.setDataDoVencimento(VENCIMENTO);
		titulo.setTipoDeDocumento(TipoDeTitulo.DM_DUPLICATA_MERCANTIL);
		titulo.setAceite(EnumAceite.A);
	
		Boleto b1,b2,b3,b4,b5;
		b1 = new Boleto(titulo);
		
		b1.setLocalPagamento("Pagável preferencialmente na Rede X ou em qualquer Banco até o Vencimento.");
		b1.setInstrucaoAoSacado("Senhor sacado, sabemos sim que o valor cobrado é injusto e esperamos seu pagamento assim mesmo.");
		b1.setInstrucao1("PARA PAGAMENTO 1 ");
		b1.getTitulo().getSacado().setNome("Misael Martins Motriz");
	
		b2 = new Boleto(titulo);
		
		b2.setLocalPagamento(b1.getLocalPagamento());
		b2.setInstrucaoAoSacado(b1.getInstrucaoAoSacado());
		b2.setInstrucao1("PARA PAGAMENTO 2 ");
		b2.getTitulo().getSacado().setNome("Samuca Meu Carro");
		
		b3 = new Boleto(titulo);
		
		b3.setLocalPagamento(b1.getLocalPagamento());
		b3.setInstrucaoAoSacado(b1.getInstrucaoAoSacado());
		b3.setInstrucao1("PARA PAGAMENTO 3 ");
		b3.getTitulo().getSacado().setNome("Romulo O Namorador");
		
		b4 = new Boleto(titulo);
		
		b4.setLocalPagamento(b1.getLocalPagamento());
		b4.setInstrucaoAoSacado(b1.getInstrucaoAoSacado());
		b4.setInstrucao1("PARA PAGAMENTO 4 ");
		b1.getTitulo().getSacado().setNome("Michelx E Seus Irmãos");
		
		b5 = new Boleto(titulo);
		
		b5.setLocalPagamento(b1.getLocalPagamento());
		b5.setInstrucaoAoSacado(b1.getInstrucaoAoSacado());
		b5.setInstrucao1("PARA PAGAMENTO 5 ");
		b5.getTitulo().getSacado().setNome("É o doido o que sobrescreveu.");
		
		boletos.add(b1);
		boletos.add(b2);
		boletos.add(b3);
		boletos.add(b4);
		boletos.add(b5);

		return boletos;
	}

}
