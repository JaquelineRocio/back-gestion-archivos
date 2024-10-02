/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jaqueline.gestionarchivos.application;
import com.jaqueline.gestionarchivos.application.model.FileDto;
import com.jaqueline.gestionarchivos.domain.FileRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author JAQUELINE
 */
@Service
public class FileService {
     private final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

   public List<FileDto> listAllFiles() {
        return fileRepository.listFiles(); 
    }
    public String uploadFile(byte[] fileBytes, String fileName) {
       return fileRepository.saveFile(fileBytes, fileName);
    }  
}
