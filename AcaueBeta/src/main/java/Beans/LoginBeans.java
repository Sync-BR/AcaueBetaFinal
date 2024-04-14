
package Beans;

/**
 *
 * @author SYNC
 */
public class LoginBeans {

    public LoginBeans() {
    }
    
    private String Usuario;
    private String Password;
    
    public LoginBeans(String Login, String Senha){
        this.Usuario = Login;
        this.Password = Senha;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
}
