package model.tablemodels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.entidades.Categoria;

public abstract class PaginaTable extends AbstractTableModel {

    //Códigos Do CategoriaTable
    List<Categoria> listCategorias = new ArrayList<>();

    //Códigos do PaginaTable
    private List<Categoria> listCategoriasTotal = new ArrayList<>();
    int limitePorPagina;
    int paginaAtual;
    int totalDePagina;

    public PaginaTable(List<Categoria> tabela, int limitePorPagina) {
        if (this.paginaAtual == 0) {
            this.paginaAtual = 1;
        }
        this.listCategoriasTotal = tabela;
        this.limitePorPagina = limitePorPagina;
        int quantidadeDePaginas = (int) Math.ceil(Double.parseDouble(String.valueOf(tabela.size())) / limitePorPagina);
        this.totalDePagina = (int) quantidadeDePaginas;
        adicionarLinhasDaPagina(paginaAtual);
        this.fireTableDataChanged();
    }

    public PaginaTable(List<Categoria> tabela, int limitePorPagina, int paginaAtual) {
        this.paginaAtual = paginaAtual;
        this.listCategoriasTotal = tabela;
        this.limitePorPagina = limitePorPagina;
        int quantidadeDePaginas = (int) Math.ceil(Double.parseDouble(String.valueOf(tabela.size())) / limitePorPagina);
        this.totalDePagina = (int) quantidadeDePaginas;
        adicionarLinhasDaPagina(paginaAtual);
        this.fireTableDataChanged();
    }

    public void adicionarLinhasDaPagina(int pagina) {
        listCategorias = new ArrayList<>();
        // for (int i = 0;      10       > 0; i++) {
        for (int i = 0; limitePorPagina > i; i++) {
            int numeroCategoria = (((pagina - 1) * limitePorPagina) + i);
            if (numeroCategoria != listCategoriasTotal.size()) {
                listCategorias.add(listCategoriasTotal.get(numeroCategoria));
            } else {
                break;
            }
        }
        this.fireTableDataChanged();
    }

    public void proximaPagina() {
        if (paginaAtual != totalDePagina) {
            paginaAtual++;
            adicionarLinhasDaPagina(paginaAtual);
        }

    }

    public void anteriorPagina() {
        if (paginaAtual != 1) {
            paginaAtual--;
            adicionarLinhasDaPagina(paginaAtual);
        }

    }

    public void paginaFinal() {
        int quantidadeDePaginas = (int) Math.ceil(Double.parseDouble(String.valueOf(listCategoriasTotal.size())) / limitePorPagina);
        paginaAtual = quantidadeDePaginas;
        adicionarLinhasDaPagina(paginaAtual);
    }

    public void paginaInicial() {
        paginaAtual = 1;
        adicionarLinhasDaPagina(paginaAtual);
    }

    public void alterarLimite(int limitePorPagina) {
        this.limitePorPagina = limitePorPagina;
        this.paginaAtual = 1;
        int quantidadeDePaginas = (int) Math.ceil(Double.parseDouble(String.valueOf(listCategoriasTotal.size())) / limitePorPagina);
        this.totalDePagina = quantidadeDePaginas;
        adicionarLinhasDaPagina(paginaAtual);
    }

    public boolean verificarExistenciaProxima() {
        if (paginaAtual < totalDePagina) {
            return true;
        }
        return false;
    }

    public boolean verificarExistenciaAnterior() {
        if (paginaAtual > 1) {
            return true;
        }
        return false;
    }

    public boolean verificarPrimeiraPagina() {
        return paginaAtual == 1;
    }

    public boolean verificarUltimaPagina() {
        int quantidadeDePaginas = (int) Math.ceil(Double.parseDouble(String.valueOf(listCategoriasTotal.size())) / limitePorPagina);
        if (paginaAtual < quantidadeDePaginas) {
            return true;
        }
        return false;
    }

    public void atualizarLista(List<Categoria> listNova) {
        this.listCategoriasTotal = listNova;
        System.out.println("ABRINDO: " + listCategoriasTotal.get(0).getId());
//        this.paginaAtual = 1;
        int quantidadeDePaginas = (int) Math.ceil(Double.parseDouble(String.valueOf(listCategoriasTotal.size())) / limitePorPagina);
        this.totalDePagina = (int) quantidadeDePaginas;
        adicionarLinhasDaPagina(paginaAtual);

    }

    public int getPaginaAtual() {
        return paginaAtual;
    }

    public List<Categoria> getListCategorias() {
        return listCategorias;
    }

    public List<Categoria> getListCategoriasTotal() {
        return listCategoriasTotal;
    }

    public int getLimitePorPagina() {
        return limitePorPagina;
    }

    public int getTotalDePagina() {
        return totalDePagina;
    }

    
}
