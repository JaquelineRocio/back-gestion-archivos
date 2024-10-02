/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jaqueline.gestionarchivos.controllers;

import com.jaqueline.gestionarchivos.application.FileService;
import com.jaqueline.gestionarchivos.application.model.FileDto;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author JAQUELINE
 */
@RestController
@RequestMapping("/files")
public class GestionArchivosRestController {

   private final FileService fileService;

    @Autowired
    public GestionArchivosRestController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping
    public ResponseEntity<List<FileDto>> listFiles() {
        List<FileDto> files = fileService.listAllFiles();
        return ResponseEntity.ok(files); 
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String fileId = fileService.uploadFile(file.getBytes(), file.getOriginalFilename());
        return ResponseEntity.ok("Archivo subido correctamente con ID: " + fileId);
    }
}
