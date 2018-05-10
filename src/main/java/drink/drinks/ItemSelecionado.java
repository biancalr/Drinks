/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drink.drinks;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Bianca
 */
@Entity
@Table(name = "TB_ITEM")
public class ItemSelecionado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, 
            optional = false)
    @JoinColumn(name = "ID_BEBIDA", referencedColumnName = "ID")
    private Bebida bebida;
    @Min(value = 0)
    @NotBlank
    @Column(name = "NUM_QUANTIDADE", nullable = false)
    private Integer quantidade;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, 
            optional = false)
    @JoinColumn(name = "ID_PEDIDO", referencedColumnName = "ID")
    private Pedido pedido;

    public ItemSelecionado(Bebida bebida, Integer quant){
        this.verificaEstoque(bebida, quant);
    }
    
    public Long getId() {
        return id;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }
    
    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public final void subtraiDoEstoque(Integer reserva){
        bebida.subtraiDoEstoque(reserva);
    }
    
    public void adicionaNoEstoque(Integer reserva){
        bebida.adicionaNoEstoque(reserva);
    }

    private void verificaEstoque(Bebida bebida, Integer quant) {
        if (bebida.getEstoque() > 0 && this.quantidade <= bebida.getEstoque()) {
            this.bebida = bebida;
            this.quantidade = quant;
            this.subtraiDoEstoque(quant);
            this.calculaSubTotal();
        } else {
            this.bebida = bebida;
            this.quantidade = bebida.getEstoque();
            this.subtraiDoEstoque(quant);
            this.calculaSubTotal();
        }
    }
    
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
        this.subtraiDoEstoque(quantidade);
    }
    
    public Double calculaSubTotal(){
        return this.bebida.preco * this.quantidade;
    }
    
    /**
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     *
     * @param obj
     * @return true or false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemSelecionado other = (ItemSelecionado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return Class.toString
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Item: \n");
        sb.append(" ID:");
        sb.append(this.id);
        sb.append("\n Bebida:");
        sb.append(this.bebida);
        sb.append("\n Quantidade:");
        sb.append(this.quantidade);
        sb.append("\n Subtotal:");
        sb.append(this.calculaSubTotal());
        return sb.toString();
    }

    
}
