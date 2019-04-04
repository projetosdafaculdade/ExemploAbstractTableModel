package dao;

import interfaces.DaoI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.entidades.Categoria;

public class CategoriaDao extends Dao implements DaoI<Categoria> {

    /**
     * Metódo cadastra no Banco de Dados<p>
     * Retorna o valor do ID(Primary Key) criado
     *
     * @param obj
     * @return int
     */
    @Override
    public int cadastrar(Categoria obj) {
        PreparedStatement stmt;
        String sql = "insert into categoria(nome, ativado) values (?,?)";
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, obj.getNome());
            stmt.setInt(2, obj.getAtivo());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return (rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar produto: " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public boolean alterar(Categoria obj) {
        PreparedStatement stmt;
        String sql = "update categoria set nome = ?, ativado = ? where id = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setInt(2, obj.getAtivo());
            stmt.setInt(3, obj.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao alterar produto: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deletar(Categoria obj) {
         PreparedStatement stmt;
        String sql = "delete from categoria where id = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar produto: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Categoria> pesquisarPor(String pesquisa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categoria> pesquisarTodos() {
            PreparedStatement stmt;
        List<Categoria> categorias = new ArrayList<>();
        String sql = "select * from categoria where ativado = 1";
        try {
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt(1));
                categoria.setNome(rs.getString(2));
                categoria.setAtivo(rs.getInt(3));
                categorias.add(categoria);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar produto: " + ex.getMessage());
        }
        return categorias; 
    }

    @Override
    public Categoria buscarPorId(int id) {
        PreparedStatement stmt;
        Categoria categoria = new Categoria();
        String sql = "select * from categoria where id = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                categoria.setId(rs.getInt(1));
                categoria.setNome(rs.getString(2));
                categoria.setAtivo(rs.getInt(3));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar produto: " + ex.getMessage());
        }
        return categoria;
    }
}
