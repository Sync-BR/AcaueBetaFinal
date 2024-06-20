
package Beans;

/**
 *
 * @author SYNC
 */
public class EmailBeans {

    public EmailBeans() {
    }
    
    private String Name;
    private String Email;
    private String Mensagem;
    
    public EmailBeans(String Nome, String EmailCoppy, String MensagemCoppy){
        this.Name = Nome;
        this.Email =  EmailCoppy;
        this.Mensagem = MensagemCoppy;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String Mensagem) {
        this.Mensagem = Mensagem;
    }
    
}
