package com.restapi.jsonschema.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restapi.jsonschema.domain.Customer;
import com.restapi.jsonschema.domain.Transactions;
@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long>{
	@Query("FROM Transactions Where customer_id=:customer_id")
	List<Transactions> findBycustomer_id(Long customer_id);
	@Query("FROM Transactions Where fruit_id=:fruit_id")
	List<Transactions> findByfruit_id(Long fruit_id);
	//List<Transactions> findBynameAndcustomer(String name, String customer);
	@Query("FROM Transactions Where name=:name AND customer=:customer")
	List<Transactions> findBynameAndcustomer(String name, String customer);
	@Query("FROM Transactions Where fruit_id=:fruit_id AND customer_id=:customer_id")
	List<Transactions> findBycustomer_idAndfruit_id(Long customer_id, Long fruit_id);
}
