package com.easysystems.easycarapi.enums;

public enum TiposServicos {
    FREIO_COMPLETO("freio completo"),
    FREIO_DIANTEIRO("freio dianteiro"),
    FREIO_TRASEIRO("freio traseiro"),
    SUSPENSAO("suspensão"),
    REVISAO("revisao"),
    MOTOR("motor");


    private String descricao;

    TiposServicos(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
