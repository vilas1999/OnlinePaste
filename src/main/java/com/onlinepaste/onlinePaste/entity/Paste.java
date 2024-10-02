package com.onlinepaste.onlinePaste.entity;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@Setter
@Entity
@NoArgsConstructor
public class Paste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "paste_name")
    private String pasteName;

    @Column(name = "content")
    private String content;

    @Column(name = "user_id")
    private String userId;
}
