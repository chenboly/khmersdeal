package com.khmersdeal.khmersdeal.controllers.restcontrollers;

import com.khmersdeal.khmersdeal.services.impl.FileUploadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/fileupload")
public class FileUploadRestController {

    private FileUploadService fileUploadService;

    public FileUploadRestController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping
    public Map<String, String> upload(@RequestParam("files") MultipartFile files){


        Map<String, String> response = new HashMap<>();

        String filename = this.fileUploadService.upload(files, null);
        response.put("filename", filename);

        return response;
    }
//    @PostMapping
//    public List<String> upload(@RequestParam("files") List<MultipartFile> files){
//        return this.fileUploadService.upload(files, null);
//    }

}
