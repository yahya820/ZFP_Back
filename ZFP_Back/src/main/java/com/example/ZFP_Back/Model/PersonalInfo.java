//package com.example.ZFP_Back.Model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Data
//@Entity
//@Table( name = "PersonalInfo")
//public class PersonalInfo {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long personalId;
////    @Lob
////    private byte[] image;
////    @Column ( name = "work")
////    private String work;
////    @Column ( name = "address")
////    private String address;
////    @Column ( name = "phone_no")
////    private String phone_no;
////    @Column ( name = "id_card")
////    private Long id_card;
////    @Column ( name = "nationality")
////    private String nationality;
////    @Column ( name = "sex")
////    private String sex;
////    @Column ( name = "age")
////    private int age;
//
////    @OneToOne(cascade = CascadeType.ALL)
////    @JoinTable( name = "user_information",
////            joinColumns  = {
////                    @JoinColumn ( name = "personalID", referencedColumnName = "personalId")
////            },
////            inverseJoinColumns = {
////                    @JoinColumn (name = "userID", referencedColumnName = "userId")
////            })
////    private User user;
//
//    @OneToOne(cascade =  CascadeType.ALL)
//    @JoinColumn ( name = "UserID", referencedColumnName = "userId")
//    private User user;
//
//
//}
