package com.employee.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.management.entity.RequestResponseLog;

public interface RequestResponseLogRepository extends JpaRepository<RequestResponseLog, Long> {
	Optional<RequestResponseLog> findByRequestId(String requestId);
}
