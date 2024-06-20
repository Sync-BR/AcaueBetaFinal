
package Beans;

/**
 *
 * @author SYNC
 */
public class Registerpopup {

    public Registerpopup() {
    }
    
    private String Name;
    private String Surname;
    private String Email;


    
    public Registerpopup(String nome, String Sobre, String email){
        this.Name = nome;
        this.Surname = Sobre;
        this.Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
    
}
