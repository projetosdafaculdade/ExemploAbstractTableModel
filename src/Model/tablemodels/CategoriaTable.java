/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.tablemodels;

import Model.entidades.Categorias;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alunos
 */
public class CategoriaTable extends AbstractTableModel{

    private List<Categorias> listCategorias = new ArrayList<>();
    static class Constantes{
        private static final String[] colunas = {"Cógigo","Nome"};
        private static final int CODIGO = 0;        
        private static final int  NOME = 1;
    }

    public CategoriaTable(List<Categorias> tabela) {
        listCategorias = tabela;
    }
    
    @Override
    public int getRowCount() {
        return listCategorias.size();
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
