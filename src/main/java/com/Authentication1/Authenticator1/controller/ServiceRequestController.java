package com.Authentication1.Authenticator1.controller;

import com.Authentication1.Authenticator1.model.ActorAction;
import com.Authentication1.Authenticator1.model.ServiceRequest;
import com.Authentication1.Authenticator1.service.ServiceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/serviceRequests")
public class ServiceRequestController {
    @Autowired
    private ServiceRequestService service;

    @PostMapping("/")
    public ServiceRequest createServiceRequest(@RequestBody ServiceRequest serviceRequest) {
        return service.createOrUpdateServiceRequest(serviceRequest);
    }

    @GetMapping("/{id}")
    public ServiceRequest getServiceRequest(@PathVariable String id) {
        return service.getServiceRequest(id).orElseThrow(() -> new RuntimeException("ServiceRequest not found"));
    }

    @PutMapping("/{id}/status")
    public ServiceRequest updateServiceRequestStatus(@PathVariable String id, @RequestBody String status) {
        return service.updateStatus(id, status);
    }
    @PostMapping("/{id}/actions")
    public ServiceRequest addActionToServiceRequest(@PathVariable String id, @RequestBody ActorAction action) {
        return service.addActorAction(id, action.getActorEmail(), action.getAction());
    }
}
