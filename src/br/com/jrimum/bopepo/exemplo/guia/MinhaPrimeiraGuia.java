package br.com.jrimum.bopepo.exemplo.guia;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.text.ParseException;

import br.com.jrimum.bopepo.guia.BancoSuportado;
import br.com.jrimum.bopepo.guia.Guia;
import br.com.jrimum.bopepo.view.guia.GuiaViewer;
import br.com.jrimum.domkee.financeiro.banco.febraban.guia.Arrecadacao;
import br.com.jrimum.domkee.financeiro.banco.febraban.guia.Contribuinte;
import br.com.jrimum.domkee.financeiro.banco.febraban.guia.Convenio;
import br.com.jrimum.domkee.financeiro.banco.febraban.guia.OrgaoRecebedor;
import br.com.jrimum.domkee.financeiro.banco.febraban.guia.TipoSeguimento;
import br.com.jrimum.domkee.financeiro.banco.febraban.guia.TipoValorReferencia;
import br.com.jrimum.utilix.DateUtil;
import br.com.jrimum.utilix.ObjectUtil;

public class MinhaPrimeiraGuia {
	
	
	public static void main(String[] args) throws ParseException, MalformedURLException, IOException {
	
		Image imageOrgaoRecebedor = null;
		// Linux: imageOrgaoRecebedor = ImageIO.read(new File("/home/user/JRiLogo.png"));
		// Windows: imageOrgaoRecebedor = ImageIO.read(new File("C:/JRiLogo.png"));
		
		File templatePersonalizado = null;
		// Linux: templatePersonalizado = new File("/home/user/MeuTemplate.pdf");
		// Windows:templatePersonalizado = new File("C:/MeuTemplate.pdf");
		
		
		/*
		 * ======================================
		 * Informando  os dados do contribuinte
		 * ======================================
		 */
		Contribuinte contribuinte = new Contribuinte("Welson de Sousa Santos", "023.473.683-62");
		
		
		/*
		 * ======================================
		 * Informando os dados do orgao/empresa
		 * recebedor
		 * ======================================
		 */			
		OrgaoRecebedor orgaoRecebedor = new OrgaoRecebedor("COLÉGIO MÉRITO D'MARTONE", "05.521.312/0002-45", TipoSeguimento.CARNES_E_ASSEMELHADOS_OU_DEMAIS);		
		// Se houver uma imagem(Ex: logo) do órgão recebedor... 
		if (ObjectUtil.isNotNull(imageOrgaoRecebedor)) {
			orgaoRecebedor.setImgLogo(imageOrgaoRecebedor);
		}
		
		/*
		 * ======================================
		 * Informando os dados do convênio
		 * ======================================
		 */		
		Convenio convenio = new Convenio(BancoSuportado.PAG_CONTAS.create(), 39318520);
		
		
		/*
		 * ======================================
		 * Informando dados da Arrecadação
		 * ======================================
		 */				
		Arrecadacao arrecadacao = new Arrecadacao(convenio, orgaoRecebedor, contribuinte);
		arrecadacao.setTitulo("RECIBO DO ALUNO");
		arrecadacao.setDescricao("Guia de Recebimento de alunos do " +
				"Colegio Mérito D'Martone");
		
		arrecadacao.setNossoNumero("0748002412798");
		arrecadacao.setValorDocumento(BigDecimal.valueOf(230.00));
		arrecadacao.setTipoValorReferencia(TipoValorReferencia.QUANTIDADE_DE_MOEDA_COM_DV_MODULO_10);
		arrecadacao.setDataDoDocumento(DateUtil.FORMAT_DD_MM_YYYY.parse("20/10/2010"));				
		arrecadacao.setDataDoVencimento(DateUtil.FORMAT_DD_MM_YYYY.parse("28/10/2010"));
	
		
		/*
		 * ======================================
		 * Informando dados da Guia
		 * ======================================
		 */				
		Guia guia = new Guia(arrecadacao);
		guia.setInstrucaoAoCaixa1("PAGAMENTO EM QUALQUER AGENCIA DO PAGCONTAS.");
		guia.setInstrucaoAoCaixa2("PREFERENCIAMENTE DEVE SER PAGA NOS TERMINAIS DE AUTO-ATENDIMENTO,");
		guia.setInstrucaoAoCaixa3("CORRESPONDENTES BANCÁRIOS E INTERNET");

		// GuiaViewer é o responsável por prover uma visualização da guia.
		GuiaViewer guiaViewer = new GuiaViewer(guia);
		
		// Se houver um template personalizado, com campos extras, novas informações podem
		// ser adicionadas.
		if (ObjectUtil.isNotNull(templatePersonalizado)) {
			guia.addTextosExtras("txtCampoExtraOpcaoCargo", "Cargo: Developer - Lotação: Natal-RN");
			guia.addTextosExtras("txtCampoExtraNumeroInscricao", "666");
			guia.addTextosExtras("txtCampoExtraVersaoSistema", "Sistema Gerador de Guias (versão 1.0)");

			guiaViewer.setTemplate(templatePersonalizado);
		}
	

		// Gerando o arquivo. No caso o arquivo mencionado será salvo na mesma
		// pasta do projeto. Outros exemplos:
		// WINDOWS: boletoViewer.getAsPDF("C:/Temp/MeuBoleto.pdf");
		// LINUX: boletoViewer.getAsPDF("/home/temp/MeuBoleto.pdf");
		File arquivoPdf = guiaViewer.getPdfAsFile("MinhaPrimeiraGuia.pdf");

		// Mostrando o boleto gerado na tela.
		mostreGuiaNaTela(arquivoPdf);		
	}
	
	
	private static void mostreGuiaNaTela(File arquivoPDF) {

		java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
		
		try {
			desktop.open(arquivoPDF);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}	
	
}
