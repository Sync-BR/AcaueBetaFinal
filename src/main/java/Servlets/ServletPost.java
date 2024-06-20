package Servlets;

import Beans.PostBeans;
import Dao.PostDao;
import Ftp.FTPUpload;
import Util.Settings;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import jdk.jpackage.internal.IOUtils;

/**
 *
 * @author SYNC
 * @Sobre Está classe tem como funcionalidade Enviar
 */
@MultipartConfig

public class ServletPost extends HttpServlet {

    /**
     *
     * @author SYNC
     * @addposts Está classe tem como funcionalidade adicionar as postagem no
     * PostBeans
     */
    private void addposts(HttpServletRequest request, PostBeans AddPost) throws IOException, ServletException {
        PostDao Post = new PostDao();
        System.out.println("teste 5");

        AddPost.setImageMain(Settings.Imagefolder + AddPost.getImageMain() + Settings.ImagefolderKey);
        AddPost.setTitle(request.getParameter("Title"));
        AddPost.setDescription(request.getParameter("Description"));
        AddPost.setImage1(Settings.Imagefolder + AddPost.getImage1() + Settings.ImagefolderKey);
        AddPost.setDescription1(request.getParameter("Description1"));
        AddPost.setImage2(Settings.Imagefolder + AddPost.getImage2() + Settings.ImagefolderKey);
        AddPost.setDescription2(request.getParameter("Description2"));
        AddPost.setImage3(Settings.Imagefolder + AddPost.getImage3() + Settings.ImagefolderKey);
        AddPost.setDescription3(request.getParameter("Description3"));
        AddPost.setImage4(Settings.Imagefolder + AddPost.getImage4() + Settings.ImagefolderKey);
        AddPost.setDescription4(request.getParameter("Description4"));
        try {
            Post.Post(AddPost);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Post.Posted) {
            PostDao.Status = "Publicação efetuada com êxito!";
        } else {
            PostDao.Status = "A postagem não foi realizada com sucesso.";
        }
    }

    /**
     *
     * @author SYNC
     * @processRequest Está classe tem como funcionalidade adicionar as imagem
     * na pasta
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PostBeans AddPost = new PostBeans();
        PostDao Post = new PostDao();
        Path[] allPath = new Path[5];
        // Obtém a parte do arquivo do formulário

        //Pegar os dados da imagem
        try {
            AddPost.setImageMain(request.getPart("Upload1").toString());
            AddPost.setImage1(request.getPart("Upload2").toString());
            AddPost.setImage2(request.getPart("Upload3").toString());
            AddPost.setImage3(request.getPart("Upload4").toString());
            AddPost.setImage4(request.getPart("Upload5").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Pegar todas imagem
        /*
        Part fileimgMain = request.getPart("Upload1");
        Part fileImg1 = request.getPart("Upload2");
        Part fileImg2 = request.getPart("Upload3");
        Part fileImg3 = request.getPart("Upload4");
        Part fileImg4 = request.getPart("Upload5");
        //Armazena os dados em um array
         */
        Part[] fileImgs = new Part[5];

        fileImgs[0] = request.getPart("Upload1");
        fileImgs[1] = request.getPart("Upload2");
        fileImgs[2] = request.getPart("Upload3");
        fileImgs[3] = request.getPart("Upload4");
        fileImgs[4] = request.getPart("Upload5");
        //Armazenar os diretorio
        List<String> pathNames = new ArrayList<>();
        //pegar apenas o nome da imagem main
        String filenameImgmain = fileImgs[0].getSubmittedFileName();
        pathNames.add(filenameImgmain);

        String ArquivoName = fileImgs[0].getSubmittedFileName();
        AddPost.setImageMain(ArquivoName);
        //pegar apenas o nome da imagem 1
        String filenameImg1 = fileImgs[1].getSubmittedFileName();
        pathNames.add(filenameImg1);
        String ArquivoName1 = fileImgs[1].getSubmittedFileName();
        AddPost.setImage1(ArquivoName1);
        //pegar apenas o nome da imagem 2
        String filenameImg2 = fileImgs[2].getSubmittedFileName();
        pathNames.add(filenameImg2);
        String ArquivoName2 = fileImgs[2].getSubmittedFileName();
        AddPost.setImage2(ArquivoName2);
        //pegar apenas o nome da imagem 3
        String filenameImg3 = fileImgs[3].getSubmittedFileName();
        System.out.println("Nome: " + filenameImg3);
        pathNames.add(filenameImg3);
        String ArquivoName3 = fileImgs[3].getSubmittedFileName();
        AddPost.setImage3(ArquivoName3);
        //pegar apenas o nome da imagem 4
        String filenameImg4 = fileImgs[4].getSubmittedFileName();
        pathNames.add(filenameImg4);
        String ArquivoName4 = fileImgs[4].getSubmittedFileName();
        AddPost.setImage4(ArquivoName4);

        for (int index = 0; index < 5; index++) {
            allPath[index] = Paths.get(pathNames.get(index));
        }
        for (int i = 0; i < 5; i++) {
            Path path = allPath[i];
            if (Files.exists(path)) {
                continue; // Pula a cópia se o arquivo já existir
            }
            //Armazenar imagem
            try (InputStream fileContent = fileImgs[i].getInputStream()) {
                Files.copy(fileContent, allPath[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FTPUpload ftp = new FTPUpload();
        //Transeferir arquivo por ftp
        try {
            ftp.UploadImg(allPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        addposts(request, AddPost);
        response.sendRedirect("MakePost.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     *
     * @author SYNC
     * @Sobre Está classe tem como funcionalidade Enviar
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
