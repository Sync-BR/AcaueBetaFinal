package Ftp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import javax.servlet.http.Part;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author SYNC
 */
public class FTPUpload {

    //Variavel de configuração  de conta 
    private String Host = "storage.bunnycdn.com";
    private int Port = 21;
    private String Usuario = "acauebeta";
    private String Pass = "e17c1ffd-c175-4074-9d4b62655d38-a882-4d22";
    //Variavel para armazena imagem
    //Variavel configuração de armazenamento
    private String remoteFilePath = "/acauebeta/";

    public void UploadImg(Path[] imgs) {
        Path[] allPath = new Path[5];
        //Pegar todas imagens enviadas
        for (int index = 0; index < imgs.length; index++) {
            allPath[index] = imgs[index];
        }
        System.out.println("Total de imagens: " + allPath.length);
        // Acessando os arquivos e fazendo o upload
        for (Path path : allPath) {
            //Verificar se as imagens estão nulla.
            if (path != null) {
                //Criar instância do FTP
                FTPClient ftpCliente = new FTPClient();

                try {
                    //Configurar a conexao com o servidor
                    ftpCliente.connect(Host, Port);
                    System.out.println("Efetuando conexao com a host e port");
                    //Efetuar o login
                    boolean login = ftpCliente.login(Usuario, Pass);
                    if (login) {
                        System.out.println("Efetuando Login");
                        //Definir o modo de transferencia para passivo.
                        ftpCliente.enterLocalPassiveMode();
                        //Definir o tipo de arquivo a ser transferido.
                        ftpCliente.setFileType(FTP.BINARY_FILE_TYPE);
                        //Verificar o tamanho total de arquivos
                        //for (int index = 0; index < 4; index++) {

                            //Abre o fluxo de entrada para o arquivo a ser enviado
                            try (InputStream inputStream = new FileInputStream(path.toFile())) {
                                boolean done = ftpCliente.storeFile(remoteFilePath + path.getFileName().toString(), inputStream);
                                if (done) {
                                    System.out.println("Enviado com sucesso.");
                                } else {
                                    System.out.println("Falhou ao enviar arquivo");
                                }
                         //   }
                        }
                    } else {
                        System.out.println("Falhou na autenticação.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (ftpCliente.isConnected()) {
                            ftpCliente.logout();
                            ftpCliente.disconnect();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            } else {
                System.out.println("Sem imagens");
            }
        }
    }

}
