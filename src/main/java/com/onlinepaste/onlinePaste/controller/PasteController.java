package com.onlinepaste.onlinePaste.controller;

import com.onlinepaste.onlinePaste.entity.dto.PasteDto;
import com.onlinepaste.onlinePaste.service.PasteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PasteController {

    @Autowired
    private final PasteService pasteService;

    @RequestMapping("/paste")
    public List<PasteDto> getPaste() {
        return pasteService.getPaste();
    }

    @RequestMapping("/paste/{id}")
    public ResponseEntity<PasteDto> getPaste(@PathVariable Long id) {
        return ResponseEntity.ok(pasteService.getPaste(id));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/paste")
    public ResponseEntity<PasteDto> addPaste(@RequestBody PasteDto pasteDto) {
        return new ResponseEntity<>(pasteService.addPaste(pasteDto), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/paste/{id}")
    public void deletePaste(@PathVariable Long id) {
        pasteService.deletePaste(id);
    }
}
