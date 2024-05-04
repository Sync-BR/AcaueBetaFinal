/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Beans.PostBeans;
import Dao.PostDao;
import static Dao.PostDao.ImagePost;
import static Dao.PostDao.Img;
import static Dao.PostDao.imagePost1;
import static Dao.PostDao.imgs;
import Util.Settings;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author SYNC
 * @Sobre Está classe tem como funcionalidade
 */
@MultipartConfig
public class UpdatePost extends HttpServlet {

    public static List<String> imgName = new ArrayList<>();

    private void addpost(HttpServletRequest request, PostBeans UpdatePost) throws IOException, ServletException {
        PostDao Update = new PostDao();
//Verificar se a imagem está nulla
        String updateImg = request.getParameter("UpdateIMG");
        if (updateImg != null && !updateImg.trim().isEmpty()) {
            UpdatePost.setImageMain(updateImg);
        } else {
            UpdatePost.setImageMain(imgs);
        }
        String updateImg1 = request.getParameter("UpdateIMG1");
        if (updateImg1 != null && !updateImg1.isEmpty()) {
            UpdatePost.setImage1(updateImg1);
        } else {
            UpdatePost.setImage1(Img.get(0));
        }

        String updateImg2 = request.getParameter("UpdateIMG2");
        if (updateImg2 != null && !updateImg2.isEmpty()) {
            UpdatePost.setImage2(updateImg2);
        } else {
            UpdatePost.setImage2(Img.get(1));
        }

        String updateImg3 = request.getParameter("UpdateIMG3");
        if (updateImg3 != null && !updateImg3.isEmpty()) {
            UpdatePost.setImage3(updateImg3);
        } else {
            UpdatePost.setImage3(Img.get(2));
        }

        String updateImg4 = request.getParameter("UpdateIMG4");
        if (updateImg4 != null && !updateImg4.isEmpty()) {
            UpdatePost.setImage4(updateImg4);
        } else {
            UpdatePost.setImage4(Img.get(3));
        }
        UpdatePost.setDescription(request.getParameter("UpdateDescricao"));
        UpdatePost.setTitle(request.getParameter("UpdateTitulo"));
        UpdatePost.setDescription1(request.getParameter("UpdateDescricao1"));
        UpdatePost.setDescription2(request.getParameter("UpdateDescricao2"));
        UpdatePost.setDescription3(request.getParameter("UpdateDescricao3"));
        UpdatePost.setDescription4(request.getParameter("UpdateDescricao4"));

        try {
            Update.UpdatePost(UpdatePost);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void Deletepost(HttpServletRequest request, PostBeans UpdatePost) throws IOException, ServletException {
        PostDao Update = new PostDao();
        UpdatePost.setTitle(request.getParameter("UpdateTitulo"));
        try {
            Update.DeletePost(UpdatePost);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     *
     * @author SYNC
     * @doPost Este codigo tem como funcionalide pegar as informações no site e
     * efetuar a atualização
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean Updatetype = false;
        processRequest(request, response);
        PostBeans UpdatePost = new PostBeans();
        PostDao Update = new PostDao();
        String alterar = request.getParameter("Alterar");
        String apagar = request.getParameter("Apagar");
        if (alterar != null) {
            //Pegar as imagens 
            try {
                UpdatePost.setImageMain(request.getPart("UpdateIMG").toString());
                UpdatePost.setImage1(request.getPart("UpdateIMG1").toString());
                UpdatePost.setImage2(request.getPart("UpdateIMG2").toString());
                UpdatePost.setImage3(request.getPart("UpdateIMG3").toString());
                UpdatePost.setImage4(request.getPart("UpdateIMG4").toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Selecionar pagina raiz do armazenamento
            String uploadDir = Settings.Upload;
            //Pegar todas imagem
            Part fileimgMain = request.getPart("UpdateIMG");
            Part fileImg1 = request.getPart("UpdateIMG1");
            Part fileImg2 = request.getPart("UpdateIMG2");
            Part fileImg3 = request.getPart("UpdateIMG3");
            Part fileImg4 = request.getPart("UpdateIMG4");
            //Armazena os dados em um array
            Part[] fileImgs = new Part[5];
            fileImgs[0] = request.getPart("UpdateIMG");
            fileImgs[1] = request.getPart("UpdateIMG1");
            fileImgs[2] = request.getPart("UpdateIMG2");
            fileImgs[3] = request.getPart("UpdateIMG3");
            fileImgs[4] = request.getPart("UpdateIMG4");
            //Armazenar os diretorio
            List<String> pathNames = new ArrayList<>();
            //pegar apenas o nome da imagem main
            String filenameImgmain = fileImgs[0].getSubmittedFileName();
            pathNames.add(uploadDir + filenameImgmain);
            String ArquivoName = fileImgs[0].getSubmittedFileName();
            UpdatePost.setImageMain(ArquivoName);
            //pegar apenas o nome da imagem 1
            String filenameImg1 = fileImgs[1].getSubmittedFileName();
            pathNames.add(uploadDir + filenameImg1);
            String ArquivoName1 = fileImgs[1].getSubmittedFileName();
            UpdatePost.setImage1(ArquivoName1);
            //pegar apenas o nome da imagem 2
            String filenameImg2 = fileImgs[2].getSubmittedFileName();
            pathNames.add(uploadDir + filenameImg2);
            String ArquivoName2 = fileImgs[2].getSubmittedFileName();
            UpdatePost.setImage2(ArquivoName2);
            //pegar apenas o nome da imagem 3
            String filenameImg3 = fileImgs[3].getSubmittedFileName();
            pathNames.add(uploadDir + filenameImg3);
            String ArquivoName3 = fileImgs[3].getSubmittedFileName();
            UpdatePost.setImage3(ArquivoName3);
            //pegar apenas o nome da imagem 4
            String filenameImg4 = fileImgs[4].getSubmittedFileName();
            pathNames.add(uploadDir + filenameImg4);
            String ArquivoName4 = fileImgs[4].getSubmittedFileName();
            UpdatePost.setImage4(ArquivoName4);
            Path[] allPath = new Path[5];
            for (int index = 0; index < 5; index++) {
                allPath[index] = Paths.get(pathNames.get(index));
            }
            //Armazena imagem 
            for (int i = 0; i < 5; i++) {            
                    try (InputStream fileContent = fileImgs[i].getInputStream()) {
                        Files.copy(fileContent, allPath[i], StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
            addpost(request, UpdatePost);
            response.sendRedirect("MenagePost.jsp");
        } else if (apagar != null) {
            Deletepost(request, UpdatePost);
            response.sendRedirect("MenagePost.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
