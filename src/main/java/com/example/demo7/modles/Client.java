package com.example.demo7.modles;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

//@ToString
@Entity
@Builder
@Data @AllArgsConstructor @NoArgsConstructor
//@Table(name = "client")
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long Id;
        @NotEmpty(message = "le nom ne peux pas être vide")
        private String name;
        private String photoUrl;
        private String comment;
        @DateTimeFormat(pattern = "yyyy-MM-dd")

        private LocalDateTime joined;
    }
