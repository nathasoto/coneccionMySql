package com.example.coneccionmysql.service;

import com.example.coneccionmysql.model.Personnage;
import java.util.List;
import java.util.Optional;

public interface PersonnageService {
    public List<Personnage> findAll();

    public Optional<Personnage> findById(int id);

    public Personnage save(Personnage personnage);

    public void deleteById(int id);
}
