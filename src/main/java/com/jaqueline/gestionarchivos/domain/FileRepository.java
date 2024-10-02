/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jaqueline.gestionarchivos.domain;
import com.jaqueline.gestionarchivos.application.model.FileDto;
import java.util.List;
/**
 *
 * @author JAQUELINE
 */
public interface FileRepository {
    List<FileDto> listFiles();
    String saveFile(byte[] fileBytes, String fileName);
}
