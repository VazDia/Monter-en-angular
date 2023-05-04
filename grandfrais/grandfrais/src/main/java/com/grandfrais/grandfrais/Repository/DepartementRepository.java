package com.grandfrais.grandfrais.Repository;

import com.grandfrais.grandfrais.Domain.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Departement,Long> {
}
