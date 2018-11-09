package com.juanfelipebalcero.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.juanfelipebalcero.backend.models.Ave;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AveRepository extends CrudRepository<Ave, Integer> {
	@Query(value = "Select * From tont_aves where dsnombre_comun like  %:nombre% Or"
			+ " dsnombre_cientifico like %:nombre%", nativeQuery = true)
	public abstract List<Ave> findAvesForName(@Param("nombre") String nombre);

	@Query(value = "Select a.cdave, a.dsnombre_comun, a.dsnombre_cientifico "
			+ "From tont_aves a inner join tont_aves_pais ap on a.cdave = ap.cdave "
			+ "inner join tont_paises p on ap.cdpais = p.cdpais "
			+ "inner join tont_zonas z on p.cdzona = z.cdzona "
			+ "Where z.cdzona = :zona", nativeQuery = true)
	public List<Ave> findAvesbyZona(@Param("zona") String zona);
}