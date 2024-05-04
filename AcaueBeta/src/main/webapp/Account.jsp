 <%@page import="Dao.LoginDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (!LoginDao.Conectado) {
        response.sendRedirect("index.jsp");
    }
    if(LoginDao.Status == null){
        LoginDao.Status = "";
    }
%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Setting Account</title>
        <link rel="stylesheet" href="./src/css/reset.css">
        <link rel="stylesheet" href="./src/css/Style/Style.css">
        <link rel="stylesheet" href="./src/css/Painel/Account.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
    </head>
    <body>
        <header>
            <h1>Painel Administrador</h1>
            <div class="MenuAdministrador">
                <form action="./CloseConexao" method="post" class="FormConexao">
                    <button type="submit" class="CloseConexao"> 
                        <span class="material-symbols-outlined">close</span>
                    </button>
                </form>
            </div>
        </header>
        <div class="container">
            <nav>
                <ul>
                    <li><a href="./home.jsp" class="HomePage">Home page</a></li>
                    <details>
                        <summary>
                            <strong>Post</strong>
                        </summary>
                        <li><a href="./MakePost.jsp">Make post</a></li>
                        <li><a href="./MenagePost.jsp">Manage post</a></li>
                    </details>          
                    <details>
                        <summary>
                            <strong>Settings</strong>
                        </summary>
                        <li><a href="./Account.jsp">Account</a></li>
                        <li><a href="./MenageEmails.jsp">Manage Emails</a></li>
                    </details>         
                </ul>
            </nav>
            <main>
                <h2>Account setup</h2>
                <br />
                <form action="./ServletChangePassword" method="post" class="ConfigurationForm">
                    <label>
                        <p class="AccountTxT">Usuario</p>
                        <input type="text" name="UserName" class="ConfigurationFields">
                    </label>
                    <p>
                        <br>
                        <input type="checkbox" name="ChangeUser" value="true"> Alterar Usuario
                    </p>
                    <br>
                    <label>
                        <p class="AccountTxT">Old Password</p>
                        <input type="text" name="OldPassword" class="ConfigurationFields" required>
                    </label>
                    <br><br>
                    <label>
                        <p class="AccountTxT">New Password</p>
                        <input type="text" name="NewPassword" class="ConfigurationFields" required>
                    </label>
                    <br><br>
                    <label>
                        <p class="AccountTxT">Repeat Password</p> 
                        <input type="text" name="Repeatpassword" class="ConfigurationFields" required>
                    </label>
                    <br><br>
                    <button type="submit" class="ChangePassword">Change Password</button>
                    <%
                        out.println(LoginDao.Status );
                    %> 
                </form>

            </main>
        </div>
        <footer>© 2024, Emanuel. Todos os direitos reservados.</footer>

    </body>
</html>