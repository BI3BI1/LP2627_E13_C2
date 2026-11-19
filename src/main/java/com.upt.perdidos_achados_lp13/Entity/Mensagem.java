package com.upt.perdidos_achados_lp13.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String texto;

    @Column(length = 1000)
    private String resposta;

    @Column(nullable = false)
    private LocalDateTime data = LocalDateTime.now();
    
    @Column(nullable = false)
    private String canal;

    @ManyToOne(optional = false)
    private Cliente cliente;

    @ManyToOne(optional = false)
    private Objeto objeto;

    @ManyToOne
    private Funcionario funcionario;

    public Mensagem() {}

    public Mensagem(Cliente cliente, Objeto objeto, String texto, String canal) {
        this.cliente = cliente;
        this.objeto = objeto;
        this.texto = texto;
        this.canal = canal;
    }

    public void responder(Funcionario funcionario, String resposta) {
        this.funcionario = funcionario;
        this.resposta = resposta;
    }
    public String getCanal() {
    	return canal;
    }
    public Long getId() { 
    	return id; 
    }
    public String getTexto() { 
    	return texto; 
    }
    public String getResposta() { 
    	return resposta; 
    }
    public Cliente getCliente() { 
    	return cliente; 
    
    }
    public Objeto getObjeto() { 
    	return objeto; 
    }
}
