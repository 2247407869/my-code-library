package com.example.demo.dto;

import com.example.demo.domain.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * user
 * @author 
 */
@Data
public class UserDTO implements Serializable {
    /**
     * 用户id
     */
    private Long id;

    private String name;

    private String status;

    private static final long serialVersionUID = 1L;

    public static UserDTO formPO(User user){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }
}