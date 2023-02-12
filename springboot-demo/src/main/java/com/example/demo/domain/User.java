package com.example.demo.domain;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * user
 * @author 
 */
@Data
//@Entity
public class User implements Serializable {
    /**
     * 用户id
     */
    @Id
    @GeneratedValue
    @NotBlank(message = "slkdjflkajd")
    private Long id;

    @Size(max = 123, message = "lskdjflkaj")
    private String name;

    // skldjflkajdl
    private String status;

    private List<Hand> hand;

    private static final long serialVersionUID = 1L;

    @Data
    private static class Hand {
        private String finger;
    }
}