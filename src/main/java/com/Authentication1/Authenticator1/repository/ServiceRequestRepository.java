package com.Authentication1.Authenticator1.repository;

import com.Authentication1.Authenticator1.model.ServiceRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

// This is the correct place for your repository interface
public interface ServiceRequestRepository extends MongoRepository<ServiceRequest, String> {
    // Method to find Service Requests by creatorEmail

}
