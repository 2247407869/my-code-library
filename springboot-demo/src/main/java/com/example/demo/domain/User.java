package com.example.demo.domain;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * user
 * @author 
 */
@Data
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String status;

    private static final long serialVersionUID = 1L;
}