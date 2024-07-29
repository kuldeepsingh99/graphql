package com.portal.graphql.repository;

import com.portal.graphql.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    public Optional<Address> findByName(String address);
}
