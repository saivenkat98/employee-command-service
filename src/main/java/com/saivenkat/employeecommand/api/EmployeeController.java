package com.saivenkat.employeecommand.api;

// import com.saivenkat.employeecommand.events.EmployeeCreatedEvent;
import com.saivenkat.employee.contracts.events.EmployeeCreatedEvent;
import com.saivenkat.employeecommand.events.EmployeeEventProducer;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeEventProducer producer;

    public EmployeeController(EmployeeEventProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@Valid @RequestBody CreateEmployeeRequest req){
        String employeeId = UUID.randomUUID().toString();
        String eventId = UUID.randomUUID().toString();
        long now = java.time.Instant.now().toEpochMilli();

        EmployeeCreatedEvent event = new EmployeeCreatedEvent(
            eventId,
            employeeId,
            req.name(),
            req.department(),
            req.email(),
            now,
            1
        );
        
        producer.publishEmployeeCreated(employeeId, event);

        return ResponseEntity.accepted().body(
            new CreateEmployeeResponse(employeeId, eventId)
        );
        
    }
    
    public record CreateEmployeeResponse(String employeeId, String eventId) {}
}
