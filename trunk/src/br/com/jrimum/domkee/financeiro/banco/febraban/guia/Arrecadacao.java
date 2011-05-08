/**
 * 
 */
package br.com.jrimum.domkee.financeiro.banco.febraban.guia;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import br.com.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;

/**
 * @author misael
 *
 */
public class Arrecadacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -466289033349771721L;

	public static final TipoProduto TIPO_PRODUTO = TipoProduto.ARRECADACAO;
	
	private String titulo;
	
	private String descricao;

	/**
	 * @see #setNumeroDoDocumento(String)
	 */
	private String numeroDoDocumento;

	/**
	 * @see #setDataDoDocumento(Date)
	 */
	private Date dataDoDocumento;

	/**
	 * @see #setDataDoVencimento(Date)
	 */
	private Date dataDoVencimento;

	/**
	 * @see #setValorDocumento(BigDecimal)
	 */
	private BigDecimal valorDocumento;

	/**
	 * @see #setTipoValorReferencia(TipoValorReferencia tipoValorReferencia)
	 */
	private TipoValorReferencia tipoValorReferencia;
	
	/**
	 * @see #setValorDesconto(BigDecimal)
	 */
	private BigDecimal valorDesconto;

	/**
	 * @see #setNossoNumero(String)
	 */
	private String nossoNumero;


	/**
	 * @see #setContaBancaria(ContaBancaria)
	 */
	private Convenio convenio;

	/**
	 * @see #setOrgaoRecebedor(OrgaoRecebedor)
	 */
	private OrgaoRecebedor orgaoRecebedor;

	/**
	 * @see #setContribuinte(Contribuinte)
	 */
	private Contribuinte contribuinte;
	

	/**
	 * @param convenio
	 * @param orgaoRecebedor
	 * @param contribuinte
	 */
	public Arrecadacao(Convenio convenio, OrgaoRecebedor orgaoRecebedor,
			Contribuinte contribuinte) {
		this.convenio = convenio;
		this.orgaoRecebedor = orgaoRecebedor;
		this.contribuinte = contribuinte;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	
	/**
	 * @return the numeroDoDocumento
	 */
	public String getNumeroDoDocumento() {
		return numeroDoDocumento;
	}

	/**
	 * @param numeroDoDocumento the numeroDoDocumento to set
	 */
	public void setNumeroDoDocumento(String numeroDoDocumento) {
		this.numeroDoDocumento = numeroDoDocumento;
	}

	/**
	 * @return the dataDoDocumento
	 */
	public Date getDataDoDocumento() {
		return dataDoDocumento;
	}

	/**
	 * @param dataDoDocumento the dataDoDocumento to set
	 */
	public void setDataDoDocumento(Date dataDoDocumento) {
		this.dataDoDocumento = dataDoDocumento;
	}

	/**
	 * @return the dataDoVencimento
	 */
	public Date getDataDoVencimento() {
		return dataDoVencimento;
	}

	/**
	 * @param dataDoVencimento the dataDoVencimento to set
	 */
	public void setDataDoVencimento(Date dataDoVencimento) {
		this.dataDoVencimento = dataDoVencimento;
	}

	/**
	 * @return the valorDocumento
	 */
	public BigDecimal getValorDocumento() {
		return valorDocumento;
	}

	/**
	 * @param valorDocumento the valorDocumento to set
	 */
	public void setValorDocumento(BigDecimal valorDocumento) {
		this.valorDocumento = valorDocumento;
	}

	/**
	 * @return the valorDesconto
	 */
	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	/**
	 * @param valorDesconto the valorDesconto to set
	 */
	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	/**
	 * @return the nossoNumero
	 */
	public String getNossoNumero() {
		return nossoNumero;
	}

	/**
	 * @param nossoNumero the nossoNumero to set
	 */
	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	/**
	 * @return the convenio
	 */
	public Convenio getConvenio() {
		return convenio;
	}

	/**
	 * @param convenio the convenio to set
	 */
	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	/**
	 * @return the orgaoRecebedor
	 */
	public OrgaoRecebedor getOrgaoRecebedor() {
		return orgaoRecebedor;
	}

	/**
	 * @param orgaoRecebedor the orgaoRecebedor to set
	 */
	public void setOrgaoRecebedor(OrgaoRecebedor orgaoRecebedor) {
		this.orgaoRecebedor = orgaoRecebedor;
	}

	/**
	 * @return the contribuinte
	 */
	public Contribuinte getContribuinte() {
		return contribuinte;
	}

	/**
	 * @param contribuinte the contribuinte to set
	 */
	public void setContribuinte(Contribuinte contribuinte) {
		this.contribuinte = contribuinte;
	}	

	/**
	 * @return the tipoValorReferencia
	 */
	public TipoValorReferencia getTipoValorReferencia() {
		return tipoValorReferencia;
	}

	/**
	 * @param tipoValorReferencia the tipoValorReferencia to set
	 */
	public void setTipoValorReferencia(
			TipoValorReferencia tipoValorReferencia) {
		this.tipoValorReferencia = tipoValorReferencia;
	}
	
}
