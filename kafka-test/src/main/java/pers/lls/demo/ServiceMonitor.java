package pers.lls.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@Accessors(chain = true)
public class ServiceMonitor implements Serializable {

    private String metric;
    private long timestamp;
    private Double value;
    private Map<String, String> tags;
}
