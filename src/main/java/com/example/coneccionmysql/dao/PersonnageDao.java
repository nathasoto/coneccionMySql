package com.example.coneccionmysql.dao;

import com.example.coneccionmysql.model.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnageDao extends JpaRepository<Personnage,Long > {
     //Personnage findByIdAndNom;
}
