package com.example.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RestController {

    @Autowired
    private FormRepository formRepository;

    @Autowired SelectRepository selectRepository;

    @GetMapping("/")
    public String showForm() {
        return "form";
    }

    @GetMapping("/options")
    public ResponseEntity<Map<Long, String>> getAllOptions() {
        Map<Long, String> map = new HashMap<>();
        selectRepository.findAll().forEach( select -> {
            map.put(select.id, select.option);
        });
        return new ResponseEntity<Map<Long, String>>(map, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity newForm(@RequestBody FormDao formDao) {

        Select select = selectRepository.findById(formDao.getType()).get();

        Form form = new Form();
        form.setSelect(select);
        form.setName(formDao.getName());
        form.setSurname(formDao.getSurname());
        form.setNumber(formDao.getNumber());
        form.setRequest(formDao.getRequest());

        formRepository.save(form);

        return ResponseEntity.ok().build();
    }

}
