package com.cg.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.lms.entity.LoanEntity;

@Repository
public interface ILoanRepository extends JpaRepository<LoanEntity, Long> {

}
