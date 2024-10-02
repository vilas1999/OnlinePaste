package com.onlinepaste.onlinePaste.service;

import com.onlinepaste.onlinePaste.entity.Paste;
import com.onlinepaste.onlinePaste.entity.dto.PasteDto;
import com.onlinepaste.onlinePaste.exception.PasteNotFoundException;
import com.onlinepaste.onlinePaste.mapper.PasteMapper;
import com.onlinepaste.onlinePaste.repository.PasteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PasteService {

    @Autowired
    private final PasteRepository pasteRepository;

    public PasteDto addPaste(PasteDto pasteDto) {
        if (Objects.isNull(pasteDto.getPasteName()) || pasteDto.getPasteName().isEmpty()) {
            pasteDto.setPasteName(String.valueOf(Instant.now().toEpochMilli()));
        }
        Paste paste = PasteMapper.mapToPaste(pasteDto);
        Paste savedPaste = pasteRepository.save(paste);
        return PasteMapper.mapToPasteDto(savedPaste);
    }

    public PasteDto getPaste(Long id) {
        Paste paste = pasteRepository
                .findById(id)
                .orElseThrow(() -> new PasteNotFoundException("Paste not found with id: " + id));
        return PasteMapper.mapToPasteDto(paste);
    }

    public List<PasteDto> getPaste() {
        List<PasteDto> pasteList = new ArrayList<>();
        pasteRepository
                .findAll()
                .stream()
                .map(PasteMapper::mapToPasteDto)
                .forEach(pasteList::add);
        return pasteList;
    }

    public void deletePaste(Long id) {
        pasteRepository.deleteById(id);
    }
}
