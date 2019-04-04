package model.tablemodels;

import java.util.List;
import model.entidades.Categoria;

public class CategoriasTable extends PaginaTable {

    public CategoriasTable(List<Categoria> tabela, int limitePorPagina) {
        super(tabela, limitePorPagina);
    }

    public CategoriasTable(List<Categoria> tabela, int limitePorPagina, int paginaAtual) {
        super(tabela, limitePorPagina, paginaAtual);
    }

    static class Constantes {
        private static final String[] colunas = {"Código", "Nome"};
        private static final int CODIGO = 0;
        private static final int NOME = 1;

    }

    @Override
    public int getRowCount() {
        return listCategorias.size();
    }

    @Override
    public int getColumnCount() {
        return Constantes.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case Constantes.CODIGO:
                return listCategorias.get(rowIndex).getId();
            case Constantes.NOME:
                return listCategorias.get(rowIndex).getNome();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return Constantes.colunas[column];
    }

    public Categoria getRow(int row) {
        return row >= 0 ? listCategorias.get(row) : null;
    }

    public void addRow(Categoria c) {
        listCategorias.add(c);
        this.fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void removeRow(int row) {
        listCategorias.remove(row);
        this.fireTableRowsUpdated(row, row);
    }

    public void updateRow(int row, Categoria c) {
        listCategorias.set(row, c);
        this.fireTableRowsUpdated(row, row);
    }

// ================================================================================
}
