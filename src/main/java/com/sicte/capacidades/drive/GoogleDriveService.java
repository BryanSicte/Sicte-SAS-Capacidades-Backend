package com.sicte.capacidades.drive;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Collections;

public class GoogleDriveService {
    private static final String APPLICATION_NAME = "MyApp";

    private static Drive getDriveService() throws Exception {
        String credentialsJson = System.getenv("GOOGLE_CREDENTIALS");
        if (credentialsJson == null) {
            throw new RuntimeException("La variable de entorno GOOGLE_CREDENTIALS no está definida.");
        }

        // Crear un archivo temporal para guardar las credenciales
        java.io.File tempFile = java.io.File.createTempFile("credentials", ".json");
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write(credentialsJson);
        }

        InputStream in = new FileInputStream(tempFile);
        GoogleCredential credential = GoogleCredential.fromStream(in)
                .createScoped(Collections.singleton(DriveScopes.DRIVE));

        return new Drive.Builder(
                credential.getTransport(),
                credential.getJsonFactory(),
                credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static String uploadFile(MultipartFile file, String folderId) throws Exception {
        Drive driveService = getDriveService();

        File fileMetadata = new File();
        fileMetadata.setName(file.getOriginalFilename());
        fileMetadata.setParents(Collections.singletonList(folderId));

        FileContent mediaContent = new FileContent(file.getContentType(), convertMultiPartToFile(file));
        File uploadedFile = driveService.files().create(fileMetadata, mediaContent)
                .setFields("id")
                .execute();

        return "https://drive.google.com/file/d/" + uploadedFile.getId() + "/view";
    }

    private static java.io.File convertMultiPartToFile(MultipartFile file) throws Exception {
        java.io.File convFile = new java.io.File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convFile)) {
            fos.write(file.getBytes());
        }
        return convFile;
    }

    public static void listFilesInFolder(String folderId) throws Exception {
        Drive driveService = getDriveService();

        FileList result = driveService.files().list()
                .setQ("'" + folderId + "' in parents and trashed=false")
                .setFields("files(id, name, webViewLink, mimeType)")
                .execute();

        for (File file : result.getFiles()) {
            System.out.println("📄 " + file.getName() + " (" + file.getWebViewLink() + ")");
        }
    }
}
