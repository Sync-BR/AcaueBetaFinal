package Dao;

import Beans.PostBeans;
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
 * @Sobre Está classe está localizado todo codigo para postagem
 */
public class PostDao {

    public static String Status;
    public boolean Posted;

    /**
     *
     * @author SYNC
     * @Post Tem como funcionalidade inserir uma postagem
     */
    public void Post(PostBeans AddPost) throws Exception {
        Posted = false;
        Status = "";
        Connection conexao = null;
        PreparedStatement stm = null;
        try {
            String sql = "INSERT INTO acauebeta.postagem (Imagem, Titulo, Descrição) VALUES (?,?,?)";
            conexao = Conexao.getConnection();
            stm = conexao.prepareStatement(sql);
            stm.setString(1, AddPost.getImageName());
            stm.setString(2, AddPost.getTitle());
            stm.setString(3, AddPost.getDescription());
            int Update = stm.executeUpdate();
            if (Update > 0) {
                Posted = true;
            } else {
                Posted = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexao.closeConnection(conexao, stm);
        }
    }

    /**
     *
     * @author SYNC
     * @UpdatePost Tem como funcionalidade retornar todas postagem
     */
    public static List<String> TitlePost = new ArrayList<>();
    public static List<String> ImagePost = new ArrayList<>();
    public static List<String> DescricaoPost = new ArrayList<>();

    public void ReturnAllPost() throws Exception {
        Connection conexao = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        TitlePost.removeAll(TitlePost);
        ImagePost.removeAll(ImagePost);
        DescricaoPost.removeAll(DescricaoPost);

        try {
            String sql = "Select * from acauebeta.postagem";
            conexao = Conexao.getConnection();
            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                TitlePost.add(rs.getString("Titulo"));
                ImagePost.add(rs.getString("Imagem"));
                DescricaoPost.add(rs.getString("Descrição"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.closeConnection(conexao, stm);
        }
    }

    /**
     *
     * @author SYNC
     * @UpdatePost Tem como funcionalidade efetuar atualização das postagem
     */
    public static boolean UpdateAtualizado;
    public static String Titulo;

    public void UpdatePost(PostBeans AddPost) throws Exception {
        Connection conexao = null;
        PreparedStatement stm = null;
        UpdateAtualizado = false;

        try {
            String sql = "UPDATE acauebeta.postagem SET Titulo = ?, Descrição= ?, Imagem=? WHERE Titulo = ?";
            conexao = Conexao.getConnection();
            stm = conexao.prepareStatement(sql);
            stm.setString(1, AddPost.getTitle());
            stm.setString(2, AddPost.getDescription());
            stm.setString(3, AddPost.getImageName());
            stm.setString(4, Titulo);
            int Result = stm.executeUpdate();
            if (Result > 0) {
                UpdateAtualizado = true;
            } else {
               UpdateAtualizado = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.closeConnection(conexao, stm);
        }
    }

    /**
     *
     * @author SYNC
     * @UpdatePostS Tem como funcionalidade efetuar retornar todas postagem por
     * titulo
     */
    public static List<String> Img = new ArrayList<>();
    public static List<String> Title = new ArrayList<>();
    public static List<String> Description = new ArrayList<>();
    public String imgs;
    public String Titles;
    public String descricao;
    public static boolean UpdateSucess;

    public void UpdatePostS(PostBeans AddPost) throws Exception {
        Connection conexao = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        UpdateSucess = false;
        try {
            String sql = "Select * from acauebeta.postagem where Titulo = ?";
            conexao = Conexao.getConnection();
            stm = conexao.prepareStatement(sql);
            stm.setString(1, PostDao.Titulo);
            rs = stm.executeQuery();
            while (rs.next()) {
                Img.add(rs.getString("Imagem"));
                Title.add(rs.getString("Titulo"));
                Description.add(rs.getString("Descrição"));
                UpdateSucess = true;
                PostDao.UpdateAtualizado = true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.closeConnection(conexao, stm, rs);
        }
    }

    
    public static boolean DeletePostSucess;
    public void DeletePost(PostBeans addpost) throws Exception {
        Connection conexao = null;
        PreparedStatement stm = null;
        DeletePostSucess = false;
        try{
        String sql = "DELETE  FROM  acauebeta.postagem where Titulo = ?";
            conexao = Conexao.getConnection();
            stm = conexao.prepareStatement(sql);
            stm.setString(1, addpost.getTitle());
            int sucesso = stm.executeUpdate();
            if(sucesso > 0){
                DeletePostSucess = true;
            } else {
                DeletePostSucess = false;
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            Conexao.closeConnection(conexao, stm);
        }
    }

}
