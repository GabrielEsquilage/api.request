package com.eecplise.api.request.dto;

import lombok.Data;
import java.util.List;

@Data
public class CnpjResponseDTO {
    private String cnpj;
    private String razao_social;
    private String nome_fantasia;
    private String natureza_juridica;
    private String capital_social;
    private String data_inicio;
    private String porte;
    private String tipo;
    private String telefone1;
    private String telefone2;
    private String email;

    private Situacao situacao;
    private Endereco endereco;
    private Simples simples;
    private Mei mei;
    private Atividade atividade_principal;
    private List<Atividade> atividades_secundarias;
    private List<Socio> socios;

    @Data
    public static class Situacao {
        private String nome;
        private String data;
        private String motivo;
    }

    @Data
    public static class Endereco {
        private String tipo_logradouro;
        private String logradouro;
        private String numero;
        private String complemento;
        private String bairro;
        private String cep;
        private String uf;
        private String municipio;
    }

    @Data
    public static class Simples {
        private String optante_simples;
        private String data_opcao;
        private String data_exclusao;
    }

    @Data
    public static class Mei {
        private String optante_mei;
        private String data_opcao;
        private String data_exclusao;
    }

    @Data
    public static class Socio {
        private String nome;
        private String cpf_cnpj;
        private String data_entrada;
        private String qualificacao;
    }

    @Data
    public static class Atividade {
        private String codigo;
        private String descricao;
    }
}
