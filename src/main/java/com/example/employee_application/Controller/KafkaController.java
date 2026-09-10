// package com.example.employee_application.Controller;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.employee_application.Service.KafkaProducerService;

// @RestController
// @RequestMapping("/kafka")
// public class KafkaController {

//     private final KafkaProducerService kafkaProducerService;

//     public KafkaController(KafkaProducerService kafkaProducerService) {
//         this.kafkaProducerService = kafkaProducerService;
//     }

//     @GetMapping("/send")
//     public String sendMessage() {
        
//         kafkaProducerService.sendDepartmentCreatedEvent(1L);
//         return "Message Sent";
//     }
// }
