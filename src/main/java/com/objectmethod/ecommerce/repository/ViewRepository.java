package com.objectmethod.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.objectmethod.ecommerce.entity.view.VMyView;
@Repository
public interface ViewRepository extends JpaRepository<VMyView, String>{

	@Query(value = "select * from my_view where id_carrello = :idCarrello ", nativeQuery = true)
	public List<VMyView> getAllView(Long idCarrello);
}
