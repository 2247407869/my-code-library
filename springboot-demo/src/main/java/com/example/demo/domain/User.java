package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * user
 * @author 
 */
@Data
@Entity
@Table(name = "users")
public class User implements Serializable {
    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "slkdjflkajd")
    private Long id;

    @Size(max = 123, message = "lskdjflkaj")
    private String name;

    // skldjflkajdl
    @Size(max = 123, message = "lskdjflkaj")
    private String status;

//    private List<Hand> hand;

    private static final long serialVersionUID = 1L;

//    @Data
//    private static class Hand {
//        private String finger;
//    }
}