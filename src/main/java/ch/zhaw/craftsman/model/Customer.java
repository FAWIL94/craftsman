package ch.zhaw.craftsman.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@NoArgsConstructor
@Document("customer")

public class Customer {
    @Id
    private String id;
    @NonNull
    private String email;
    @NonNull
    private String name;

}
