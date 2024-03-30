package com.Authentication1.Authenticator1.repository;

import com.Authentication1.Authenticator1.model.ServiceRequest;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

@Document
public interface ServiceRequestRepository extends MongoRepository<ServiceRequest, String> {
}
