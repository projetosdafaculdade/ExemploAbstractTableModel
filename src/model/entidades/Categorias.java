/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

/**
 *
 * @author Alunos
 */
public class Categorias {
    public int id;
    public String nome;
    public int ativo;

    public Categorias() {
        this.ativo = 1;
    }

    public Categorias(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Categorias(int id, String nome, int ativo) {
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
    }
    
    
    
}
