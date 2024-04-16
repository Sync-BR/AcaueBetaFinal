package Servlets;

import Beans.PostBeans;
import Dao.PostDao;
import Util.Settings;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author SYNC
 * @Sobre Está classe tem como funcionalidade Enviar 
 */
@MultipartConfig

public class ServletPost extends HttpServlet {
    private void AddIMG(HttpServletRequest request,  PostBeans AddPost) throws IOException, ServletException {
        PostDao Post = new PostDao();
        AddPost.setImageName(AddPost.getImageName());
        AddPost.setTitle(request.getParameter("Title"));
        AddPost.setDescription(request.getParameter("Description"));
        try {
            Post.Post(AddPost);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(Post.Posted){
            PostDao.Status = "Publicação efetuada com êxito!";
        } else {
            PostDao.Status = "A postagem não foi realizada com sucesso.";
        }

    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PostBeans AddPost = new PostBeans();
        
        try{
            AddPost.setImageName(request.getPart("Upload").toString());
        } catch(Exception e){
            e.printStackTrace();
        }
        
        String uploadDir = Settings.Upload;
        Part filePart = request.getPart("Upload");
        String fileName = filePart.getSubmittedFileName();
        String filePath = uploadDir + fileName;
        String ArquivoName =  filePart.getSubmittedFileName();
        AddPost.setImageName(ArquivoName);
        Path path = Paths.get(filePath);
        File file = path.toFile();
  
        try (InputStream fileContent = filePart.getInputStream()) {
            Files.copy(fileContent, path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AddIMG(request, AddPost);

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
    }// </editor-fold>

}
