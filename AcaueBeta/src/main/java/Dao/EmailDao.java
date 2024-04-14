package Dao;

import Beans.EmailBeans;
import Beans.PostBeans;
import static Dao.PostDao.DeletePostSucess;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SYNC
 * @Sobre Está classe tem como classe efetuar alterações no Email
 */
public class EmailDao {
    
    
       public void DeleteContato(EmailBeans DeleteEmail) throws Exception {
        Connection conexao = null;
        PreparedStatement stm = null;
        try{
        String sql = "DELETE  FROM  acauebeta.contato where name = ?";
            conexao = Conexao.getConnection();
            stm = conexao.prepareStatement(sql);
            stm.setString(1, DeleteEmail.getName());
            int sucesso = stm.executeUpdate();
  
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            Conexao.closeConnection(conexao, stm);
        }
    }
    /**
     *
     * @author SYNC
     * @ReturnRegisteredUsers Está funcionalidade efetuar o retornor dos  cadastrado Email
     * dentro do arraylist
     */
    public static List<String> CadName = new ArrayList<>();
    public static List<String> CadSobre = new ArrayList<>();
    public static List<String> CadEmail = new ArrayList<>();
    public void ReturnRegisteredEmail() throws Exception {
        Connection conexao = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        CadName.removeAll(CadName);
        CadSobre.removeAll(CadSobre);
        CadEmail.removeAll(CadEmail);
        try {
            String sql = "SELECT * FROM acauebeta.cadastroemail";
            conexao = Conexao.getConnection();
            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                CadName.add(rs.getString("name"));
                CadSobre.add(rs.getString("SobreNome"));
                CadEmail.add(rs.getString("Email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.closeConnection(conexao, stm, rs);
        }
    }
    /**
     *
     * @author SYNC
     * @ReturnRegisteredUsers Está funcionalidade efetuar o retornor dos email
     * dentro do arraylist
     */
    public static List<String> Name = new ArrayList<>();
    public static List<String> Email = new ArrayList<>();
    public static List<String> Mensagem = new ArrayList<>();
    public void ReturnRegisteredUsers() throws Exception {
        Connection conexao = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Name.removeAll(Name);
        Email.removeAll(Email);
        Mensagem.removeAll(Mensagem);
        try {
            String sql = "SELECT * FROM acauebeta.contato";
            conexao = Conexao.getConnection();
            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Name.add(rs.getString("name"));
                Email.add(rs.getString("email"));
                Mensagem.add(rs.getString("message"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.closeConnection(conexao, stm, rs);
        }
    }

    /**
     * @author SYNC
     * @RegisterEmail Esta funcionalidade efetuar o cadastro de um novo email
     */
    public void RegisterEmail(EmailBeans AddMail) throws Exception {
        Connection conexao = null;
        PreparedStatement stm = null;
        try {
            conexao = Conexao.getConnection();
            String sql = "INSERT INTO acauebeta.contato  (name , email, message)  VALUES (?,?,?)";
            stm = conexao.prepareStatement(sql);
            stm.setString(1, AddMail.getName());
            stm.setString(2, AddMail.getEmail());
            stm.setString(3, AddMail.getMensagem());
            stm.executeUpdate();
         
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            Conexao.closeConnection(conexao, stm);
        }

    }

    /**
     * @author SYNC
     * @SearchEmail Tem como funcionalidade buscar um email especifico.
     */
    public void SearchEmail(EmailBeans AddMail) throws Exception {
        System.out.println("Passei aqui");
        Connection conexao = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conexao = Conexao.getConnection();
            String sql = "Select * from acauebeta.email where contato = ?";
            stm = conexao.prepareStatement(sql);
            stm.setString(1, AddMail.getEmail());
            rs = stm.executeQuery();
            if (rs.next()) {
                AddMail.setName(rs.getString("Nome"));
                AddMail.setEmail(rs.getString("Email"));
                AddMail.setMensagem(rs.getString("Mensagem"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            Conexao.closeConnection(conexao, stm, rs);
        }
    }

    /**
     * @author SYNC
     * @EmptyMatrix Limpar os arraylist.
     */
    public void EmptyMatrix() {
        if (Email.size() > 0) {
            for (int index = 0; index < Email.size(); index++) {
                Name.remove(index);
                Email.remove(index);
                Mensagem.remove(index);
            }
        }
    }
}
