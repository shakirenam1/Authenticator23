package com.Authentication1.Authenticator1.service;
import com.Authentication1.Authenticator1.model.ActorAction;
import com.Authentication1.Authenticator1.repository.ServiceRequestRepository;
import com.Authentication1.Authenticator1.model.ServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;

@Service
public class ServiceRequestService {
    @Autowired
    private ServiceRequestRepository repository;

    public ServiceRequest createOrUpdateServiceRequest(ServiceRequest serviceRequest) {
        if (serviceRequest.getServiceCreationDate() == null) {
            serviceRequest.setServiceCreationDate(new Date());
        }
        return repository.save(serviceRequest);
    }

    public Optional<ServiceRequest> getServiceRequest(String id) {
        return repository.findById(id);
    }

    public ServiceRequest updateStatus(String id, String status) {
        Optional<ServiceRequest> serviceRequestOptional = repository.findById(id);
        if (serviceRequestOptional.isPresent()) {
            ServiceRequest serviceRequest = serviceRequestOptional.get();
            serviceRequest.setStatus(status);
            repository.save(serviceRequest);
            return serviceRequest;
        } else {
            // Handle not found
            throw new RuntimeException("ServiceRequest not found");
        }
    }
    public ServiceRequest addActorAction(String serviceRequestId, String actorEmail, String action) {
        Optional<ServiceRequest> serviceRequestOpt = repository.findById(serviceRequestId);
        if (serviceRequestOpt.isPresent()) {
            ServiceRequest serviceRequest = serviceRequestOpt.get();
            serviceRequest.addActorAction(new ActorAction(actorEmail, action));
            serviceRequest.setStatus(action.toUpperCase()); // Update status based on action
            return repository.save(serviceRequest);
        } else {
            throw new RuntimeException("ServiceRequest not found");
        }
    }
}
