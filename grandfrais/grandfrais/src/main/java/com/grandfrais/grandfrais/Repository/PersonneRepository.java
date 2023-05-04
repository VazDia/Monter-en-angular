package com.grandfrais.grandfrais.Repository;

import com.grandfrais.grandfrais.Domain.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<Personne,Long> {
}
