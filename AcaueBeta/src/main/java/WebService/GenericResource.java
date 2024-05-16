package WebService;
import com.google.gson.Gson;
import Beans.EmailBeans;
import Beans.Registerpopup;
import Dao.EmailDao;
import Dao.PostDao;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author SYNC
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    public GenericResource() {
    }

    /**
     * @author SYNC
     * @Cadastrar Tem como funcionalidade efetuar o cadastro pela url e
     * redirecionar para pagina de fehcamento
     */
    @Path("/Cadastrar")
    @POST
    public Response Cadastrar(@FormParam("name") String name,
            @FormParam("email") String email,
            @FormParam("message") String message) throws Exception {  
        EmailBeans AddEmail = new EmailBeans();
        EmailDao Cadastrar = new EmailDao();
        AddEmail.setName(name);
        AddEmail.setEmail(email);
        AddEmail.setMensagem(message);
        try {
            Cadastrar.RegisterEmail(AddEmail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @author SYNC
     * @Cadastrar Tem como funcionalidade efetuar o cadastro pela url e
     * redirecionar para pagina de fehcamento
     */
    @Path("/RegisterPopup")
    @POST
    public String Registerpopup(@FormParam("name") String name,
            @FormParam("surname") String surname,
            @FormParam("email") String email) throws Exception {
        System.out.println("Nome " +name);
        System.out.println("Sobre " +surname);
        System.out.println("Email " +email);
        Registerpopup AddMail = new Registerpopup();
        EmailDao Cadastrar = new EmailDao();
        AddMail.setName(name);
        AddMail.setSurname(surname);
        AddMail.setEmail(email);
        try {
            Cadastrar.Registerpopup(AddMail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String teste = "ola";
        return teste;
    }

    /**
     * @author SYNC
     * @Cadastrar Tem como funcionalidade retornar postagem cadastrado
     */
    @Path("/returnpost")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String ReturnPost() {
        PostDao Returnpost = new PostDao();
        try {
            Returnpost.ReturnAllPost();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Array para adicionar as informações
        List<List<String>> postArrays = new ArrayList<>();

        for (int i = 0; i < PostDao.TitlePost.size(); i++) {
            List<String> post = new ArrayList<>();
            post.add(PostDao.PostID.get(i));
            post.add(PostDao.TitlePost.get(i));
            post.add(PostDao.DescricaoPost.get(i));
            post.add(PostDao.ImagePost.get(i));
            post.add(PostDao.imagePost1.get(i));
            post.add(PostDao.Description1.get(i));
            post.add(PostDao.imagePost2.get(i));
            post.add(PostDao.Description2.get(i));
            post.add(PostDao.imagePost3.get(i));
            post.add(PostDao.Description3.get(i));
            post.add(PostDao.imagePost4.get(i));
            post.add(PostDao.Description4.get(i));
            postArrays.add(post);
        }
        
        String jsonPosts = new Gson().toJson(postArrays);
        
        return jsonPosts;
    }

    /**
     * Retrieves representation of an instance of WebService.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

}
