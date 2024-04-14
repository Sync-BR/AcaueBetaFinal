package Dao;

import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author SYNC
 * @Sobre Está classe tem como funcionalidade operações de contagem
 */
public class Accountant {

    /**
     * @author SYNC
     * @Acounttotalemail Tem como funcionalide contar o total de Contato
     */
    public int Totalcontato = 0;

    public void Acounttotalcontato() throws Exception {
        Connection conexao = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM acauebeta.contato";
            conexao = Conexao.getConnection();
            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Totalcontato++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.closeConnection(conexao, stm, rs);
        }
    }

    /**
     * @author SYNC
     * @Acounttotalemail Tem como funcionalide contar o total de Postagem
     */
    public int TotalPost = 0;

    public void PostageAccount() throws Exception {
        Connection conexao = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM acauebeta.postagem";
            conexao = Conexao.getConnection();
            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                TotalPost++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.closeConnection(conexao, stm, rs);
        }
    }
        /**
     * @author SYNC
     * @Acounttotalemail Tem como funcionalide contar o total de Email
     */
    public int TotalEmail = 0;

    public void Acounttotalemail() throws Exception {
        Connection conexao = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM acauebeta.cadastroemail";
            conexao = Conexao.getConnection();
            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                TotalEmail++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.closeConnection(conexao, stm, rs);
        }
    }
}
