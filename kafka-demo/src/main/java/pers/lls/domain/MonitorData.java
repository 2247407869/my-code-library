package pers.lls.domain;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Accessors(chain = true)
public class MonitorData implements Serializable {

    private String node;
    private List<DataInner> metrics = Lists.newArrayList();

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class DataInner implements Serializable {
        private String metric;
        private Map<String, String> tags;
        private long timestamp;
        private Double value;
    }
}
