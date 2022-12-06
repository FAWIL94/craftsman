package ch.zhaw.craftsman.model;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CustomerCreateDTO {
    private String name;
    private String email;
}
