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
@Document("craftsman")
public class Craftsman {
    @Id
    private String id;
    @NonNull
    private String companyName;
    @NonNull
    private String street;
    @NonNull
    private String plz;
    @NonNull
    private String place;
    @NonNull
    private Double price;
}
