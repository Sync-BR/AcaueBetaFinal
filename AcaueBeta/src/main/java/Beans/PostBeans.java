
package Beans;

/**
 *
 * @author SYNC
 */
public class PostBeans {
    public PostBeans() {
    }
    private String ImageName;
    private String Title;
    private String Description;
    
    public PostBeans(String Nome, String Titulo, String Descricao){
        this.ImageName = Nome;
        this.Title = Titulo;
        this.Description = Descricao;
    }

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String ImageName) {
        this.ImageName = ImageName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
}
