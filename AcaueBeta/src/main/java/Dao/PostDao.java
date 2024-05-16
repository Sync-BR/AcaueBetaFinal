package Dao;

import Beans.PostBeans;
import Util.Conexao;
import Util.Settings;
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
            String sql = "INSERT INTO " + Settings.Db + ".posts (name, imageMain, descriptionMain, image1, description1,image2, description2,image3, description3,image4, description4) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            conexao = Conexao.getConnection();
            stm = conexao.prepareStatement(sql);
            stm.setString(1, AddPost.getTitle());
            stm.setString(2, AddPost.getImageMain());
            stm.setString(3, AddPost.getDescription());
            stm.setString(4, AddPost.getImage1());
            stm.setString(5, AddPost.getDescription1());
            stm.setString(6,  AddPost.getImage2());
            stm.setString(7, AddPost.getDescription2());
            stm.setString(8, AddPost.getImage3());
            stm.setString(9, AddPost.getDescription3());
            stm.setString(10,  AddPost.getImage4());
            stm.setString(11, AddPost.getDescription4());

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
    public static List<String> PostID = new ArrayList<>();
    public static List<String> TitlePost = new ArrayList<>();
    public static List<String> ImagePost = new ArrayList<>();
    public static List<String> DescricaoPost = new ArrayList<>();
    public static List<String> imagePost1 = new ArrayList<>();
    public static List<String> Description1 = new ArrayList<>();
    public static List<String> imagePost2 = new ArrayList<>();
    public static List<String> Description2 = new ArrayList<>();
    public static List<String> imagePost3 = new ArrayList<>();
    public static List<String> Description3 = new ArrayList<>();
    public static List<String> imagePost4 = new ArrayList<>();
    public static List<String> Description4 = new ArrayList<>();

    public void ReturnAllPost() throws Exception {
        Connection conexao = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        PostID.removeAll(PostID);
        TitlePost.removeAll(TitlePost);
        ImagePost.removeAll(ImagePost);
        DescricaoPost.removeAll(DescricaoPost);
        imagePost1.removeAll(imagePost1);
        Description1.removeAll(Description1);
        imagePost2.removeAll(imagePost2);
        Description2.removeAll(Description2);
        imagePost3.removeAll(imagePost3);
        Description3.removeAll(Description3);
        imagePost4.removeAll(imagePost4);
        Description4.removeAll(Description4);

        try {
            String sql = "Select * from " + Settings.Db + ".posts";
            conexao = Conexao.getConnection();
            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                PostID.add(String.valueOf(rs.getString("id")));
                TitlePost.add(rs.getString("name"));
                ImagePost.add(rs.getString("imageMain"));
                DescricaoPost.add(rs.getString("descriptionMain"));
                imagePost1.add(rs.getString("image1"));
                Description1.add(rs.getString("description1"));
                imagePost2.add(rs.getString("image2"));
                Description2.add(rs.getString("description2"));
                imagePost3.add(rs.getString("image3"));
                Description3.add(rs.getString("description3"));
                imagePost4.add(rs.getString("image4"));
                Description4.add(rs.getString("description4"));
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
     * @UpdatePost Tem como funcionalidade efetuar atualização das postagem e
     * todos seu componente
     */
    public static boolean UpdateAtualizado;
    public static String Titulo;

    public void UpdatePost(PostBeans AddPost) throws Exception {
        Connection conexao = null;
        PreparedStatement stm = null;
        UpdateAtualizado = false;
        String sql = "UPDATE " + Settings.Db + ".posts SET name = ?, descriptionMain= ?, imageMain=?, image1=?, description1=?,image2=?, description2=?,image3=?, description3=? ,image4=?, description4=? WHERE name = ?";
        try {

            conexao = Conexao.getConnection();
            stm = conexao.prepareStatement(sql);
            stm.setString(1, AddPost.getTitle());
            stm.setString(2, AddPost.getDescription());
            stm.setString(3,  AddPost.getImageMain());
            stm.setString(4, AddPost.getImage1());
            stm.setString(5, AddPost.getDescription1());
            stm.setString(6,  AddPost.getImage2());
            stm.setString(7, AddPost.getDescription2());
            stm.setString(8,AddPost.getImage3());
            stm.setString(9, AddPost.getDescription3());
            stm.setString(10,AddPost.getImage4());
            stm.setString(11, AddPost.getDescription4());
            stm.setString(12, Titulo);
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
     * @UpdatePost Tem como funcionalidade efetuar atualização das descrição das
     * postagem
     */
    public void Updatedescriptiononly(PostBeans AddPost) throws Exception {
        Connection conexao = null;
        PreparedStatement stm = null;
        UpdateAtualizado = false;

        try {
            String sql = "UPDATE " + Settings.Db + ".posts SET name = ?, descriptionMain= ?, description1=?, description2=?, description3=? , description4=? WHERE name = ?";
            conexao = Conexao.getConnection();
            stm = conexao.prepareStatement(sql);
            stm.setString(1, AddPost.getTitle());
            stm.setString(2, AddPost.getDescription());
            stm.setString(3, AddPost.getDescription1());
            stm.setString(4, AddPost.getDescription2());
            stm.setString(5, AddPost.getDescription3());
            stm.setString(6, AddPost.getDescription4());
            stm.setString(7, Titulo);
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
    public static String imgs;
    public static String Titles;
    public static String description;
    public static boolean UpdateSucess;

    public void UpdatePostS(PostBeans AddPost) throws Exception {
        Connection conexao = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        UpdateSucess = false;
        Img.clear();
        Description.clear();
        try {
            String sql = "Select * from " + Settings.Db + ".posts where name = ?";
            conexao = Conexao.getConnection();
            stm = conexao.prepareStatement(sql);
            stm.setString(1, AddPost.getTitle());
            rs = stm.executeQuery();
            while (rs.next()) {
                imgs = rs.getString("imageMain");
                Titles = rs.getString("name");
                description = rs.getString("descriptionMain");
                Img.add(rs.getString("image1"));
                Img.add(rs.getString("image2"));
                Img.add(rs.getString("image3"));
                Img.add(rs.getString("image4"));
                Description.add(rs.getString("description1"));
                Description.add(rs.getString("description2"));
                Description.add(rs.getString("description3"));
                Description.add(rs.getString("description4"));
                UpdateSucess = true;
                PostDao.UpdateAtualizado = true;

            }
            for (int i = 0; i < Img.size(); i++) {
                System.out.println("IMG: " + Img.get(i));
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
        try {
            String sql = "DELETE  FROM  " + Settings.Db + ".posts where name = ?";
            conexao = Conexao.getConnection();
            stm = conexao.prepareStatement(sql);
            stm.setString(1, addpost.getTitle());
            int sucesso = stm.executeUpdate();
            if (sucesso > 0) {
                DeletePostSucess = true;
            } else {
                DeletePostSucess = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.closeConnection(conexao, stm);
        }
    }



}
