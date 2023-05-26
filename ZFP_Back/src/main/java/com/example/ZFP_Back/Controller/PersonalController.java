//package com.example.ZFP_Back.Controller;
//
//import com.example.ZFP_Back.Dto.PersonalDTO;
//import com.example.ZFP_Back.Model.PersonalInfo;
//import com.example.ZFP_Back.Services.PersonalService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/personal")
//public class PersonalController {
//    @Autowired
//    private PersonalService personalService;
//
//    @PostMapping("/post")
//   public ResponseEntity<PersonalInfo> create (@RequestBody PersonalDTO personalDTO){
//        PersonalInfo personalInfo = personalService.addInformation(personalDTO);
//        return ResponseEntity.ok(personalInfo);
//    }
//    @GetMapping("/get")
//    public List<PersonalInfo> getInformation(){
//        return personalService.getInfo();
//    }
//    @GetMapping("/get/{id}")
//    public ResponseEntity<?> findById(@PathVariable long id){
//        return ResponseEntity.ok(personalService.findId(id));
//    }
////    @GetMapping("/get/{username}")
////    public ResponseEntity<?> findbyusername(@PathVariable String username){
////        return ResponseEntity.ok(personalService.findByusername(username));
////    }
//}
