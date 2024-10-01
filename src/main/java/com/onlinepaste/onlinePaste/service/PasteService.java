package com.onlinepaste.onlinePaste.service;

import com.onlinepaste.onlinePaste.entity.Paste;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PasteService {

    private List<Paste> list = new ArrayList<>();

    public void addPaste(Paste paste) {
        list.add(paste);
    }

    public Paste getPaste(String id) {
        return list
                .stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst().orElse(Paste.builder()
                        .content("no paste found")
                        .build());
    }

    public List<Paste> getPaste() {
        return list;
    }

    public void deletePaste(String id) {
        list = list
                .stream()
                .filter(paste -> !paste.getId().equals(id))
                .toList();
    }
}
