//package com.easysystems.easycarapi.models;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import java.io.Serializable;
//import java.util.List;
//import java.util.Objects;
//
//public class AcaoTecnica implements Serializable {
//
//    static final private long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private List<ServicoRealizado> servicosRealizados;
//
//    private List<Produto> produtos;
//
//
//    public AcaoTecnica() {
//    }
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public List<ServicoRealizado> getServicosRealizados() {
//        return servicosRealizados;
//    }
//
//    public void setServicosRealizados(List<ServicoRealizado> servicosRealizados) {
//        this.servicosRealizados = servicosRealizados;
//    }
//
//    public Pedido getPedido() {
//        return pedido;
//    }
//
//    public void setPedido(Pedido pedido) {
//        this.pedido = pedido;
//    }
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        AcaoTecnica that = (AcaoTecnica) o;
//        return Objects.equals(id, that.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//}
