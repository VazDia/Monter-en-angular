ALTER TABLE personne
ADD CONSTRAINT fk_dp FOREIGN KEY(id_dep)
REFERENCES departement(id_dep);
