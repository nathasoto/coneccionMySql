package com.example.coneccionmysql.service;

import com.example.coneccionmysql.dao.PersonnageDao;
import com.example.coneccionmysql.model.Personnage;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class PersonageServiceImpl implements PersonnageService {


    private final PersonnageDao personnageDao;

    public PersonageServiceImpl(PersonnageDao personnageDao) {
        this.personnageDao = personnageDao;
    }

    @Override
    @Transactional(readOnly = true)//solo lectura
    public List<Personnage> findAll() {
        return personnageDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Personnage> findById(int id) {
        return personnageDao.findById(Long.valueOf(id));//int to long
    }

    @Override
    @Transactional //cambia datos
    public Personnage save(Personnage personnage) {
        return personnageDao.save(personnage);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
       personnageDao.deleteById(Long.valueOf(id));
    }
}
