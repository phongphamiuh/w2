package com.phamquiphong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.phamquiphong.entity.CreditCard;
@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer>{
	
	@Query("from CreditCard c join c.person p where p.id =: personId")
	public List<CreditCard> findAllByPersonId(@Param("personId") Integer personId);
	
	@Query("from CreditCard c join c.person p where c.id =:id and p.id =:personId")
	public CreditCard getCreditCardByPersonId(int id, int personId);
	
	@Query(value ="delete from credit_card c where c.id =:id",nativeQuery = true)
	public void deleteCreditCardWithId(@Param("id") int id);
}
