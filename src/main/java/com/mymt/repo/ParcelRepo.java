package com.mymt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mymt.model.Parcel;

@Repository
public interface ParcelRepo extends JpaRepository<Parcel, Long> {

}