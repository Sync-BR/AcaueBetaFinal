<%@page import="java.io.IOException"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Processar Arquivo no Servidor</title>
    </head>
    <body>
        <form action="" method="post" enctype="multipart/form-data">
            Selecione o arquivo: <input type="file" name="file" id="file">
            <input type="submit" value="Enviar">
        </form>
   
    </body>

</html>
