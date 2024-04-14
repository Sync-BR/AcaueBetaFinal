package WebService;

import Beans.EmailBeans;
import Dao.EmailDao;
import Dao.PostDao;
import com.google.gson.Gson;
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

/*
import javax.ws.rs.core.UriBuilder;
 */
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
    public Response Cadastrar(@FormParam("Nome") String Nome,
            @FormParam("Email") String Email,
            @FormParam("Mensagem") String Mensagem) throws Exception {
        EmailBeans AddEmail = new EmailBeans();
        EmailDao Cadastrar = new EmailDao();
        AddEmail.setName(Nome);
        AddEmail.setEmail(Email);
        AddEmail.setMensagem(Mensagem);
        try {
            Cadastrar.RegisterEmail(AddEmail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @author SYNC
     * @Cadastrar Tem como funcionalidade retornar postagem cadastrado
     */
    @Path("/returnpost")
    @GET
    public String ReturnPost() {
        PostDao Returnpost = new PostDao();
        try {
            Returnpost.ReturnAllPost();
        } catch (Exception e) {
            e.printStackTrace();
        }
    List<String> titles = new ArrayList<>();
    List<String> imagem = new ArrayList<>();
    List<String> descricao = new ArrayList<>();
    
    // Adiciona os títulos dos posts à lista
    for (String title : PostDao.TitlePost) {
        titles.add(title);
    }
    for (String img : PostDao.ImagePost) {
        titles.add(img);
    }
    for (String description : PostDao.DescricaoPost) {
        titles.add(description);
    }
    
    // Converte a lista de títulos para JSON
    String jsonTitles = new Gson().toJson(titles);
    
    return jsonTitles;
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
