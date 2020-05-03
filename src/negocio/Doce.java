/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import persistencia.DoceDAO;

/**
 *
 * @author aryel.sa
 */
public class Doce {
    private int id_doce;
    private String nome;
    private float valor;
    private int quantidade;

    public int getId_doce() {
        return id_doce;
    }

    public void setId_doce(int id_doce) {
        this.id_doce = id_doce;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public void salvar(){
        DoceDAO dao = new DoceDAO();
        dao.adiciona(this);
    }

    
}
