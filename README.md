# Painel Administrador Acauebeta

## Sobre
 O Painel Administrador Acauebeta permite ao administrador visualizar e gerenciar os dados da plataforma de maneira eficiente. Entre as funcionalidades, estão a consulta do total de usuários cadastrados (via POPUP), total de e-mails cadastrados e total de postagens efetuadas. Também é possível adicionar novas postagens e gerenciar os arquivos com facilidade. Após o upload, os arquivos são salvos em uma pasta e posteriormente transferidos para uma hospedagem.


    

## Requisitos
* JDK 22 [Download Oracle](https://www.oracle.com/br/java/technologies/downloads/)
* GlashFish 4.0 ou 4.1.1 [Download Drive](https://drive.google.com/file/d/1pvwr6xSWcjZ_A_dO6OJ3xM7QgakjUlog/view?usp=drive_link)
## Técnlogias usadas.
* Maven
* MySQL
* Servlet
* FTP
* JavaServer Pages (JSP)
* WebService
* API REST
### Dependências
    <dependencies>
        <dependency>
            <groupId>commons-net</groupId>
            <artifactId>commons-net</artifactId>
            <version>3.11.0</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.29</version>
        </dependency>

        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.10.1</version>
            <type>jar</type>
        </dependency>
        
        <dependency>
            <groupId>com.sun.jersey</groupId>
            <artifactId>jersey-bundle</artifactId>
            <version>1.19.4</version>
        </dependency>
        <dependency>
            <groupId>javax</groupId>
            <artifactId>javaee-web-api</artifactId>
            <version>7.0</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

### Configuração do Maven
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                    <compilerArguments>
                        <endorseddirs>${endorsed.dir}</endorseddirs>
                    </compilerArguments>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>3.3.1</version>
                <configuration>
                    <failOnMissingWebXml>false</failOnMissingWebXml>
                </configuration>
            </plugin>
