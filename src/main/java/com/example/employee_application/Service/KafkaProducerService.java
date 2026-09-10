// package com.example.employee_application.Service;

// import org.springframework.kafka.core.KafkaTemplate;
// import org.springframework.stereotype.Service;

// @Service
// public class KafkaProducerService {

//     private final KafkaTemplate<String, String> kafkaTemplate;

//     public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {

//         this.kafkaTemplate = kafkaTemplate;
//     }

//     public void sendDepartmentCreatedEvent(Long departmentId) {
        
//         kafkaTemplate.send(
//             "department-topic",
//             "Department Created with ID : " + departmentId);
//     }
// }
