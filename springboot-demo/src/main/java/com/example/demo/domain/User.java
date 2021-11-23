package pers.lls.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    private Integer id;

    private String name;

    private String status;

    private static final long serialVersionUID = 1L;
}