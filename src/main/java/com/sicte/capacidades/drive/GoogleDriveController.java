package com.sicte.capacidades.drive;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/drive")
public class GoogleDriveController {
    private final String folderId = "1514Cz3GVufGhvpKo7pWiPXCPAzmJCC9p";

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, 
                             @RequestParam("filename") String filename, 
                             @RequestParam("folderId") String folderId) {
        try {
            return GoogleDriveService.uploadFile(file, filename, folderId);
        } catch (Exception e) {
            return "Error al subir archivo: " + e.getMessage();
        }
    }

    @GetMapping("/list")
    public void listFiles() {
        try {
            GoogleDriveService.listFilesInFolder(folderId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
