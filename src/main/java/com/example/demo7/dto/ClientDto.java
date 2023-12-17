package com.example.demo7.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ClientDto {
    private long id;
    @NotEmpty(message = "le nom ne peux pas être vide")
    private String name;
    private String photoUrl;
    private String comment;
    private LocalDateTime joined;
}
