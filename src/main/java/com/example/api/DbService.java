package com.example.api;

import com.example.db.FormRepository;
import com.example.db.SelectRepository;
import com.example.domain.Form;
import com.example.domain.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DbService {

    @Autowired
    FormRepository formRepository;

    @Autowired
    SelectRepository selectRepository;

    public List<Select> getSelects(){
        List<Select> selectList = new ArrayList<>();
        selectRepository.findAll().forEach( select -> {
            selectList.add(select);
        });
        return selectList;
    }

    public Select getSelect(Long id){
        return selectRepository.findById(id).get();
    }

    public void saveForm(Form form){
        formRepository.save(form);
    }

}
