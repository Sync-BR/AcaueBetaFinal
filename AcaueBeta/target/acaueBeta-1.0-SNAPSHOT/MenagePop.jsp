<%@page import="Dao.LoginDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dao.EmailDao"%>

<%
    //Limpar Matrix

    EmailDao EmptyMatrix = new EmailDao();
    EmptyMatrix.EmptyMatrix();

%>
<%    if (!LoginDao.Conectado) {
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Menage Emails</title>
        <link rel="stylesheet" href="./src/css/reset.css">
        <link rel="stylesheet" href="./src/css/Style/Style.css">
        <link rel="stylesheet" href="./src/css/Painel/MenageEmails.css">
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
              
                <table class="tableMenage" >
                    <tr>
                    <thead class="MenageThead">
                    <th scope="col" class="MenageTH">Nome</th>
                    <th scope="col" class="MenageTH">Sobre</th>
                    <th scope="col" class="MenageTH">Email</th>
                    </thead>
                    </tr>
                    <tbody>
                        <%
                            EmailDao ReturnEmails = new EmailDao();
                            ReturnEmails.ReturnRegisteredEmail();
                            for (int index = 0; index < EmailDao.CadEmail.size(); index++) {
                                out.print("<tr>");
                                out.print("<th scope=\"row\" class=\"MenageTD\">" + EmailDao.CadName.get(index) + "</th>");
                                out.print("<td class=\"MenageTD\">" + EmailDao.CadSobre.get(index) + "</td>");
                                out.print("<td class=\"MenageTD\">" + EmailDao.CadEmail.get(index) + "</td>");;
                                out.print("</tr>");
                            }
                        %> 

                    </tbody>
                </table>
            </main>
        </div>
        <footer>© 2024, Emanuel. Todos os direitos reservados.</footer>

    </body>
</html>