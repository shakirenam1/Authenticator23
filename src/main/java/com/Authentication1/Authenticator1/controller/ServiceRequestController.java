package com.Authentication1.Authenticator1.controller;

import com.Authentication1.Authenticator1.model.ActorAction;
import com.Authentication1.Authenticator1.model.ServiceRequest;
import com.Authentication1.Authenticator1.service.ServiceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serviceRequests")
public class ServiceRequestController {
    @Autowired
    private ServiceRequestService service;

    @PostMapping("/insert")
    public ServiceRequest createServiceRequest(@RequestBody ServiceRequest serviceRequest) {
        return service.createOrUpdateServiceRequest(serviceRequest);
    }

    @GetMapping("/all")
    public List<ServiceRequest> getAllServiceRequests() {
        return service.getAllServiceRequests();
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
