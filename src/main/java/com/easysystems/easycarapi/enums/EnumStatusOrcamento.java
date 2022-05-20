package com.easysystems.easycarapi.enums;

public enum EnumStatusOrcamento {


    INICIO(1L, "Iniciado"),
    EXECUTANDO(2L, "Executando"),
    FINALIZADO(3L, "Finalizado");

    private java.lang.String name;

    private java.lang.Long id;

    EnumStatusOrcamento(Long id, java.lang.String name) {
        this.name = name;
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.Long getId() {
        return id;
    }
}
