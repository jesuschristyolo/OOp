package lesson3;

import lombok.*;

import java.util.Objects;

//@Getter
//@AllArgsConstructor
//@RequiredArgsConstructor
//@NoArgsConstructor
//@Setter
//@ToString
//@EqualsAndHashCode
@Data
public class Student {
    private final Long id;
    private final String fullName;
    private String test;
}
