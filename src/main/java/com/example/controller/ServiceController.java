package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class ServiceController {

    @GetMapping("/services")
    public List<ServiceDto> getServices() {
        return Arrays.asList(
                new ServiceDto("Manicure", "Cuidado y esmaltado", 15.0),
                new ServiceDto("Facial", "Limpieza profunda", 30.0)
        );
    }

    @PostMapping("/contact")
    public ResponseEntity<InboxResponse> contact(@RequestBody ContactRequest request) {
        // Aquí podrías guardar en BD, enviar correo, etc.
        return ResponseEntity.ok(new InboxResponse("ok", "Mensaje recibido"));
    }

    // DTOs simples (mover a archivos propios si lo prefieres)
    public static class ServiceDto {
        public String name;
        public String description;
        public double price;
        public ServiceDto() {}
        public ServiceDto(String name, String description, double price) {
            this.name = name; this.description = description; this.price = price;
        }
    }

    public static class ContactRequest {
        public String name;
        public String email;
        public String message;
        public ContactRequest() {}
    }

    public static class InboxResponse {
        public String status;
        public String message;
        public InboxResponse() {}
        public InboxResponse(String status, String message) {
            this.status = status; this.message = message;
        }
    }
}