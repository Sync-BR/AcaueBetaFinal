
package Beans;

/**
 *
 * @author SYNC
 */
public class PostBeans {
    public PostBeans() {
    }
    private String imageMain;
    private String title;
    private String description;
    private String image1;
    private String description1;
    private String image2;
    private String description2;
    private String image3;
    private String description3;
    private String image4;
    private String description4;

    
    public PostBeans(String Nome, String Titulo, String Descricao, String img1, String Descricao1,String img2, String Descricao2, String img3, String Descricao3, String img4, String Descricao4){
        this.imageMain = Nome;
        this.title = Titulo;
        this.description = Descricao;
        this.image1 = img1;
        this.description1 = Descricao1;
        this.image2 = img2;
        this.description2 = Descricao2;
        this.image3 = img3;
        this.description3 = Descricao3;
        this.image4 = img4;
        this.description4 = Descricao4;

    }

    public String getImageMain() {
        return imageMain;
    }

    public void setImageMain(String imageMain) {
        this.imageMain = imageMain;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getDescription3() {
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getDescription4() {
        return description4;
    }

    public void setDescription4(String description4) {
        this.description4 = description4;
    }
    
}
