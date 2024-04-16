/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduar
 */
public class Arquivos {
    public static void main(String[] args) {
        ArrayList <String> ArchivesNames = new ArrayList<>();
        String diretorio = Settings.Upload;
        String Pastaname = "Post";
        System.out.println("Diretorio:" +diretorio);
        File ArchivesName = new File(diretorio);
        File [] Readfiles = ArchivesName.listFiles();
        
        //Escrever os diretorios no console
        for(File ArchivesDir : Readfiles){
            ArchivesNames.add(ArchivesDir.getName());
            System.out.println("Nome do arquivo" +ArchivesDir.getName());
            System.out.println("Total de arquivos" +ArchivesNames.size());
        
        }
        
        //Verificar o nome da pasta
        boolean Igual = false;
        for(int index = 0; index < ArchivesNames.size(); index++){
            if(ArchivesNames.get(index) == Pastaname){
                
            }
        }
    }
}
