

<%@page import="Util.Settings"%>
<%@page import="com.mysql.cj.x.protobuf.MysqlxCrud.Update"%>
<%@page import="Dao.LoginDao"%>
<%@page import="Dao.PostDao"%>

<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Menage Post</title>
        <link rel="stylesheet" href="./src/css/reset.css">
        <link rel="stylesheet" href="./src/css/Style/Style.css">
        <link rel="stylesheet" href="./src/css/Painel/MenagePost.css">
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
                <h2>Menage Posts</h2>
                <br><br>

                <form method="POST" action="./ServeletsChangePost">
                    <select name="PostagemCadastrada">
                        <%
                            PostDao ReturnPostagens = new PostDao();
                            ReturnPostagens.ReturnAllPost();
                            for (int index = 0; index < PostDao.TitlePost.size(); index++) {
                                out.print("<option name=\"Usuarios\">" + PostDao.TitlePost.get(index) + "</option>");
                            }

                        %>

                    </select>
                    <input type="submit" value="Editar" />
                </form>



                <br>
                <section class="Content"> 
                    <%                        if (PostDao.UpdateAtualizado) {
                            PostDao Retornar = new PostDao();
                            ReturnPostagens.ReturnAllPost();
                            out.println("<form action=\"./UpdatePost\" method=\"post\">");
                            out.println("<label>Arquivo</label><input  type=\"file\" name=\"UpdateIMG\" style=\"width: 100%\"\"><br>");
 
                            out.println("<label>Titulo: </label><input type=\"text\" name=\"UpdateTitulo\"  style=\"width: 100%\" value=\"" + PostDao.Titles + "\"><br>");
                            out.println("<label>Descrição</label><input value=\"" + PostDao.description + "\" type=\"text\" name=\"UpdateDescricao\" style=\"height: 100px; width: 100%\"><br>");
                            
                            //Alterar informações da coleção
                                out.println("<label>Arquivo</label><input type=\"file\" name=\"UpdateIMG1\" style=\"width: 100%\"><br>");
                                out.println("<label>Descrição</label><input value=\"" + PostDao.Description.get(0) + "\" type=\"text\" name=\"UpdateDescricao1\" style=\"height: 100px; width: 100%\"><br>");
                                out.println("<label>Arquivo</label><input type=\"file\" name=\"UpdateIMG2\" style=\"width: 100%\"><br>");
                                out.println("<label>Descrição</label><input value=\"" + PostDao.Description.get(1) + "\" type=\"text\" name=\"UpdateDescricao2\" style=\"height: 100px; width: 100%\"><br>");
                                out.println("<label>Arquivo</label><input type=\"file\" name=\"UpdateIMG3\" style=\"width: 100%\"><br>");
                                out.println("<label>Descrição</label><input value=\"" + PostDao.Description.get(2) + "\" type=\"text\" name=\"UpdateDescricao3\" style=\"height: 100px; width: 100%\"><br>");
                                out.println("<label>Arquivo</label><input type=\"file\" name=\"UpdateIMG4\" style=\"width: 100%\"><br>");
                                out.println("<label>Descrição</label><input value=\"" + PostDao.Description.get(3) + "\" type=\"text\" name=\"UpdateDescricao4\" style=\"height: 100px; width: 100%\"><br>");

                            

                            out.println("<input type=\"submit\" value=\"Alterar\" style=\"width: 100%\" name=\"Alterar\" />");
                            out.println("<input type=\"submit\" value=\"Apagar\" style=\"width: 100%\" name=\"Apagar\" />");
                        }
                        PostDao.UpdateAtualizado = false;
                    %> 
                    <%
                        System.out.println("Boolean " + PostDao.UpdateSucess);
/*
                        if (PostDao.UpdateSucess) {
                            if (PostDao.Img.size() > 0) {
                                for (int index = 0; index < PostDao.Img.size(); index++) {
                                    out.print("<div class=\"Content-Post\">");
                                    out.print("<img src=\"../frontend/src/images/PostImg/" + PostDao.Img.get(index) + "\" alt=\"Post\">");
                                    out.print("<strong>" + PostDao.Title.get(index) + "</strong>");
                                    out.print("<p>" + PostDao.Description.get(index) + "</p>");
                                    out.print("</div>");
                                }
                                for (int index = 0; index < PostDao.Img.size(); index++) {
                                    PostDao.Img.remove(index);
                                    PostDao.Title.remove(index);
                                    PostDao.Description.remove(index);
                                }
                            } else {
                                out.print("<div class=\"Content-Post\">");
                                out.print("<img src=\"../frontend/src/images/PostImg/  \" alt=\"Post\">");
                                out.print("<strong></strong>");
                                out.print("<p></p>");
                                out.print("</div>");

                            }

                        }
                        */


                    %>


                    <%                        if (PostDao.DeletePostSucess) {
                            out.print(PostDao.Status);
                        }
                    %>
                </section>
            </main>
        </div>
        <footer>Â© 2024, Emanuel. Todos os direitos reservados.</footer>

    </body>
</html>