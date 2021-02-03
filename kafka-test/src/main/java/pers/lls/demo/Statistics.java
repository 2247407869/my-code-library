package pers.lls.demo;

import lombok.Data;

@Data
public class Statistics {
    private Long count;
    private Long sum;
    private Long avg;

    public Statistics() {
    }

    public Statistics(Long count, Long sum, Long avg) {
        this.count = count;
        this.sum = sum;
        this.avg = avg;
    }
}
