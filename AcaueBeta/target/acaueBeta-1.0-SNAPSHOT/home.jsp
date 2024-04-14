<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="Dao.LoginDao"%>
<%@page import="Dao.Accountant"%>
<%
    if (!LoginDao.Conectado) {
        response.sendRedirect("index.jsp");
    }
    if(LoginDao.Status == null){
        LoginDao.Status = "";
    }
%>

<!DOCTYPE html>

<html lang="pt-BR" xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Painel de controle</title>
        <link rel="stylesheet" href="./src/css/reset.css">
        <link rel="stylesheet" href="./src/css/Style/Style.css">
        <link rel="stylesheet" href="./src/css/Painel/Home.css">
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
                        <li><a href="./MenageEmails.jsp">Manage Contato</a></li>
                        <li><a href="./MenagePop.jsp">Manage Emails</a></li>
                    </details>
                </ul>
            </nav>
            <main>
                <div class="InterfacePadrao">
                    <div class="interface">
                        <img src="./src/img/Icon_Email.png" alt="Contato">
                        <br>
                        <Strong>Total Contato cadastrado</Strong>
                        <%
                            Accountant Account = new Accountant();
                            Account.Acounttotalcontato();
                            out.print("<p>" + Account.Totalcontato + "</p>");                        
                        %>

                    </div>
                    <div class="interface">
                        <img src="./src/img/Icon_Post.png" alt="Postagem">
                        <br>
                        <Strong>Total Postagem cadastrado</Strong>
                            <%
                                Account.PostageAccount();
                                out.print("<p>" + Account.TotalPost + "</p>");
                            %> 
                    </div>
                    <div class="interface">
                        <img src="./src/img/Icon_Email2.png" alt="Email">
                        <br>
                        <Strong>Total Email cadastrado</Strong>
                            <%
                                Account.Acounttotalemail();
                                out.print("<p>" + Account.TotalEmail+ "</p>");
                            %> 
                    </div>
                </div>

            </main>
        </div>
        <footer>�2024, Emanuel. Todos os direitos reservados.</footer>
    </body>

</html>