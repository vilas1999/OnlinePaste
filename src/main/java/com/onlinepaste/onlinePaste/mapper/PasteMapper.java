package com.onlinepaste.onlinePaste.mapper;

import com.onlinepaste.onlinePaste.entity.Paste;
import com.onlinepaste.onlinePaste.entity.dto.PasteDto;

import java.util.Objects;

public class PasteMapper {

    public static PasteDto mapToPasteDto(Paste paste) {
        return PasteDto.builder()
                .id(paste.getId())
                .pasteName(paste.getPasteName())
                .content(paste.getContent())
                .build();
    }

    public static Paste mapToPaste(PasteDto pasteDto) {
        Paste.PasteBuilder pasteBuilder = Paste.builder()
                .content(pasteDto.getContent());

        if (!Objects.isNull(pasteDto.getPasteName())) {
            pasteBuilder.pasteName(pasteDto.getPasteName());
        }
        return pasteBuilder.build();
    }
}
