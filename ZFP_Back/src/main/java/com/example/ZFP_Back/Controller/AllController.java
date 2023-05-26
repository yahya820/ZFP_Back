//package com.example.ZFP_Back.Controller;
//
//import com.example.ZFP_Back.Services.FishermanService;
//import com.example.ZFP_Back.Services.PaymentService;
//import com.example.ZFP_Back.Services.PersonalService;
//import com.example.ZFP_Back.Services.UserServices;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/api")
//public class AllController {
//    @Autowired
//    private UserServices userService;
//    @Autowired
//    private PersonalService personalService;
//    @Autowired
//    private FishermanService fishermanService;
//    @Autowired
//    private PaymentService paymentService;
//    @Autowired
//    private ModelMapper modelMapper;
//
////    @GetMapping("/users/{username}")
////    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
////        UserDTO userDTO = userService.getUserByUsername(username);
////        return ResponseEntity.ok(userDTO);
////    }
//
////    @GetMapping("/users/personal/sex/{sex}")
////    public ResponseEntity<List<UserDTO>> getUsersByPersonalSex(@PathVariable String sex) {
////        List<UserDTO> users = userService.getUsersByPersonalSex(sex);
////        return ResponseEntity.ok(users);
////    }
//
////    @GetMapping("/users/fishermen/diko/{diko}")
////    public ResponseEntity<List<UserDTO>> getUsersByFishermanDiko(@PathVariable String diko) {
////        List<UserDTO> users = userService.getUsersByFishermanDiko(diko);
////        return ResponseEntity.ok(users);
////    }
//
////    @GetMapping("/users/payments/account/{accountNo}")
////    public ResponseEntity<List<UserDTO>> getUsersByPaymentAccountNo(@PathVariable String accountNo) {
////        List<UserDTO> users = userService.getUsersByPaymentAccountNo(accountNo);
////        return ResponseEntity.ok(users);
////    }
//
////    @PostMapping("/users")
////    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
////        User user = userService.createUser(modelMapper.map(userDTO, User.class));
////        return ResponseEntity.ok(modelMapper.map(user, UserDTO.class));
////    }
//    @DeleteMapping("/users/{userId}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
//        userService.deleteUser(userId);
//        return ResponseEntity.ok().build();
//    }
//
////    @GetMapping("/users/{userId}/personal")
////    public ResponseEntity<PersonalDTO> getPersonalByUserId(@PathVariable Long userId) {
////        PersonalDTO personalDTO = personalService.getPersonalByUserId(userId);
////        return ResponseEntity.ok(personalDTO);
// //   }
//
////    @PostMapping("/users/personal")
////    public ResponseEntity<PersonalDTO> createPersonal(@RequestBody PersonalDTO personalDTO) {
////        PersonalInfo personal = personalService.createPersonal(modelMapper.map(personalDTO, PersonalInfo.class));
////        return ResponseEntity.ok(modelMapper.map(personal, PersonalDTO.class));
////    }
//
//    @DeleteMapping("/users/personal/{personalId}")
//    public ResponseEntity<Void> deletePersonal(@PathVariable Long personalId) {
//        personalService.deletePersonal(personalId);
//        return ResponseEntity.ok().build();
//    }
//
////    @GetMapping("/users/{userId}/fishermen")
////    public ResponseEntity<List<FIshermanDTO>> getFishermenByUserId(@PathVariable Long userId) {
////        List<FIshermanDTO> fishermen = fishermanService.getFishermenByUserId(userId);
////        return ResponseEntity.ok(fishermen);
////    }
//
////    @PostMapping("/users/fishermen")
////    public ResponseEntity<FIshermanDTO> createFisherman(@RequestBody FIshermanDTO fishermanDTO) {
////        Fisherman fisherman = fishermanService.createFisherman(modelMapper.map(fishermanDTO, Fisherman.class));
////        return ResponseEntity.ok(modelMapper.map(fisherman, FIshermanDTO.class));
////    }
//
//    @DeleteMapping("/users/fishermen/{fishermanId}")
//    public ResponseEntity<Void> deleteFisherman(@PathVariable Long fishermanId) {
//        fishermanService.deleteFisherman(fishermanId);
//        return ResponseEntity.ok().build();
//    }
//
////    @GetMapping("/users/payments/{accountNo}")
////    public ResponseEntity<List<PaymentDTO>> getPaymentsByAccountNo(@PathVariable String accountNo) {
////        List<PaymentDTO> payments = paymentService.getPaymentsByAccountNo(accountNo);
////
//}