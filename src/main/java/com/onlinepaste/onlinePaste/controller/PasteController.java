package com.onlinepaste.onlinePaste.controller;

import com.onlinepaste.onlinePaste.entity.Paste;
import com.onlinepaste.onlinePaste.service.PasteService;
import lombok.AllArgsConstructor;
import org.apache.catalina.util.ToStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PasteController {

    @Autowired
    private final PasteService pasteService;

    @RequestMapping("/paste")
    public List<Paste> getPaste() {
        return pasteService.getPaste();
    }

    @RequestMapping("/paste/{id}")
    public Paste getPaste(@PathVariable String id) {
        return pasteService.getPaste(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/paste")
    public void addPaste(@RequestBody Paste paste) {
        pasteService.addPaste(paste);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/paste/{id}")
    public void deletePaste(@PathVariable String id) {
        pasteService.deletePaste(id);
    }
}
