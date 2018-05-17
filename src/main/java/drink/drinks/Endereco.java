/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drink.drinks;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Bianca
 */
@Embeddable
public class Endereco implements Serializable {

    @Column(name = "END_TXT_LOGRADOURO", length = 100, nullable = false)
    private String logradouro;
    @Column(name = "END_TXT_BAIRRO", length = 100, nullable = false)
    private String bairro;
    @Column(name = "END_TXT_COMPLEMENTO", length = 50, nullable = false)
    private String complemento;
    @Column(name = "END_TXT_CEP", length = 20, nullable = false)
    private String cep;
    @Column(name = "END_TXT_CIDADE", length = 50, nullable = false)
    private String cidade;
    @Column(name = "END_TXT_ESTADO", length = 30, nullable = false)
    private String estado;
    @Column(name = "END_NUMERO", length = 5, nullable = false)
    private Integer numero;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    @Override
    public String toString() {
        return "drink.drinks.Endereco[ cep=" + cep + " ]";
    }
    
}
