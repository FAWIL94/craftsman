package ch.zhaw.craftsman.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CraftsmanCustomerAggregationDTO {
    private String id;
    private List<String> craftsmanIds;
    private Double totalEarnings;
}
