<%@page import="Beans.LoginBeans"%>
<%@page import="Dao.LoginDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> -->

<!DOCTYPE html>
<html>
    <head>
        <title>Painel de Controle</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./src/css/reset.css">
        <link rel="stylesheet" href="./src/css/Style/Style.css">
        <link rel="stylesheet" href="./src/css/index.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    </head>
    <body>
        <header>
            <h1>Painel Administrador</h1>
        </header>
        <main>
            <form method="post" action="./ServletLogin">
                <div class="Fildbox">
                    <div class="FildboxLabel">
                        <label>Usuário:&nbsp;</label>
                        <br>
                        <label>&nbsp;&nbsp;Senha:&nbsp;</label>
                    </div>
                    <div class="Filds">
                        <input type="text" name="UserField" id="UserField" required>
                        <br>
                        <input type="password" name="FieldPassword" id="FieldPassword" required>
                    </div>                  
                </div>
                <br>
                <br>
                <button type="submit" value="Conectar" >Conectar</button>
                <br>
                <button type="reset" value="Conectar" >Limpar</button>
                <br>
                <p>
                    
                    <%
                        if(!LoginDao.Conectado){
                            out.print(LoginDao.Status);
                        }
                        
                    %>
                </p>

            </form>

        </main>
        <footer>
            <p>
                © 2024, Emanuel. Todos os direitos reservados.
            </p>
        </footer>
    </body>

</html>
