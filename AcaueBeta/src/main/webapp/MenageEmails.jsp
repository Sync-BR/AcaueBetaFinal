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
                <!-- <form action="./teste" method="post">
                <select name="Usuarios" size="2" >
                <%
                    EmailDao AddEmails = new EmailDao();
                    AddEmails.ReturnRegisteredUsers();

                    for (int index = 0; index < EmailDao.Email.size(); index++) {
                        out.print("<option>" + EmailDao.Email.get(index) + "</option>");

                    }
                %>
    </select>
    <input type="submit" value="Pesquisar" name="Pesquisar" />
     </form> -->
                <table class="tableMenage" >
                    <tr>
                    <thead class="MenageThead">
                    <th scope="col" class="MenageTH">Nome</th>
                    <th scope="col" class="MenageTH">Email</th>
                    <th scope="col" class="MenageTH">Mensagem</th>
                    </thead>
                    </tr>
                    <tbody>
                         <%
                            EmailDao ReturnEmails = new EmailDao();
                            ReturnEmails.ReturnRegisteredEmail();
                             
                            for (int index = 0; index < EmailDao.Email.size(); index++) {
                                out.print("<form action=\"./ServletDeleteEmail\" method=\"POST\">");
                                    out.print("<tr>");
                                    out.print("<th scope=\"row\" class=\"MenageTD\"  value=\"teste\">" + EmailDao.Name.get(index) + "</th>");
                                    out.print("<td class=\"MenageTD\">" + EmailDao.Email.get(index) + "</td>");
                                    out.print("<td class=\"MenageTD\">" + EmailDao.Mensagem.get(index) + "</td>");
                                    out.print("<td class=\"MenageTD\"><button  type=\"submit\"  name=\"User\" value=\""+EmailDao.Name.get(index)+"\"  /> Deletar</button></td>");
                                    out.print("<br>");
                                    
                                    out.print("</tr>");
                                     out.print("</form>");
                                

                            }
                            

                        %> 
              
                       

                    </tbody>
                </table>
                <style type="text/css">
                    .Paginas li {
                        
                        list-style: none;
                    }
                        .Paginas ul {
                        display: flex;
                        flex-direction: row;
                        list-style: none;
                    }
                    .Paginas a{
                        color: black;
                        margin-left: 1vw;
                    }
                </style>
                <div class="Paginas">
                    <ul >
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                    </ul>


                </div>
            </main>
        </div>
        <footer>© 2024, Emanuel. Todos os direitos reservados.</footer>

    </body>
</html>