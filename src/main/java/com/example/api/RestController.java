package com.example.api;

import com.example.domain.Form;
import com.example.domain.FormDao;
import com.example.domain.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RestController {

    @Autowired
    private DbService dbService;

    @GetMapping("/")
    public String showForm() {
        return "form";
    }

    @GetMapping("/options")
    public ResponseEntity<Map<Long, String>> getAllOptions() {
        Map<Long, String> map = new HashMap<>();
        dbService.getSelects().forEach( select -> {
            map.put(select.getId(), select.getOption());
        });
        return new ResponseEntity<Map<Long, String>>(map, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity newForm(@RequestBody FormDao formDao) {

        Select select = dbService.getSelect(formDao.getType());

        Form form = new Form();
        form.setSelect(select);
        form.setName(formDao.getName());
        form.setSurname(formDao.getSurname());
        form.setNumber(formDao.getNumber());
        form.setRequest(formDao.getRequest());

        dbService.saveForm(form);

        return ResponseEntity.ok().build();
    }

}
