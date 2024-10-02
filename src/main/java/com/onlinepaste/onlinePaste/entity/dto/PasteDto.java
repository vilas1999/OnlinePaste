package com.onlinepaste.onlinePaste.entity.dto;

import jakarta.annotation.Nullable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PasteDto {

    private Long id;

    @Nullable
    private String pasteName;

    private String content;
}
