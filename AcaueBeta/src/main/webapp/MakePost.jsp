<%@page import="Dao.PostDao"%>
<%
    PostDao Reset = new PostDao();
    Reset.Posted = false;
%>

<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Make Post</title>
        <link rel="stylesheet" href="./src/css/reset.css">
        <link rel="stylesheet" href="./src/css/Style/Style.css">
        <link rel="stylesheet" href="./src/css/Painel/MakePost.css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
    </head>
    <body>
        <!-- Fazer o campo de tags -->
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
                <h2>Submit Post</h2>
                <form action="./ServletPost" method="post" enctype="multipart/form-data">
                    <label>
                        <strong>Imagem:</strong>
                        <input type="file" name="Upload1"  accept="image/png, image/jpeg" multiple>
                    </label>
                    <br><br>
                    <label>

                        <strong>Titulo:</strong><br>
                        <input type="text" name="Title" required>
                    </label>
                    <br><br>
                    <label >
                        <strong>Texto:</strong><br>
                        <textarea name="Description"></textarea>
                    </label>
                    <br>
                    <label>
                        <strong>Imagem 1:</strong>
                        <input type="file" name="Upload2"  accept="image/png, image/jpeg" multiple>
                    </label>
                    <label >
                        <strong>Descrição</strong><br>
                        <textarea name="Description1"></textarea>
                    </label>
                    <br>
                    <label>
                        <strong>Imagem 2:</strong>
                        <input type="file" name="Upload3"  accept="image/png, image/jpeg" multiple>
                    </label>
                    <label >
                        <strong>Descrição</strong><br>
                        <textarea name="Description2"></textarea>
                    </label>
                    <br>
                    <label>
                        <strong>Imagem 3:</strong>
                        <input type="file" name="Upload4"  accept="image/png, image/jpeg" multiple>
                    </label>
                    <label >
                        <strong>Descrição</strong><br>
                        <textarea name="Description3"></textarea>
                    </label>
                    <br>
                    <label>
                        <strong>Imagem 4:</strong>
                        <input type="file" name="Upload5"  accept="image/png, image/jpeg" multiple>
                    </label>
                    <label >
                        <strong>Descrição</strong><br>
                        <textarea name="Description4" ></textarea>
                    </label>
                    <button type="submit">Enviar</button>
                    <%
                        if (PostDao.Status != null) {
                            out.print(PostDao.Status);
                        } else {
                            out.print("");
                        }


                    %>
                </form>
            </main>
        </div>
        <footer>© 2024, Emanuel. Todos os direitos reservados.</footer>
    </body>
</html>