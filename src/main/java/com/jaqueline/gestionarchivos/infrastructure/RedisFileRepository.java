/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jaqueline.gestionarchivos.infrastructure;

import com.jaqueline.gestionarchivos.application.model.FileDto;
import com.jaqueline.gestionarchivos.domain.FileRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JAQUELINE
 */
@Repository
public class RedisFileRepository implements FileRepository {

    @Autowired
    private RedisTemplate<String, byte[]> redisTemplate;

@Override
public List<FileDto> listFiles() {
    Set<String> keys = redisTemplate.keys("*");  
    List<FileDto> files = new ArrayList<>();
    
    if (keys != null) {
        for (String key : keys) {
            String name = (String) redisTemplate.opsForHash().get(key, "name");
            
            if (name != null) {
                files.add(new FileDto(key, name)); 
            }
        }
    }

    return files;
}

 
    @Override
    public String saveFile(byte[] fileBytes, String fileName) {
        String fileId = UUID.randomUUID().toString();
        redisTemplate.opsForHash().put(fileId, "name", fileName);
        redisTemplate.opsForHash().put(fileId, "data", fileBytes);
        return fileId;
    }
}
