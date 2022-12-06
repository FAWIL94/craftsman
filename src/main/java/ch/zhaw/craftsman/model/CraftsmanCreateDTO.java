package ch.zhaw.craftsman.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CraftsmanCreateDTO {
    private String companyname;
    private String street;
    private String plz;
    private String place;
    private Double price;
}
