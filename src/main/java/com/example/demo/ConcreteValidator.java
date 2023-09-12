package com.example.demo;

import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ConcreteValidator extends ResourceValidator {
    public static ConcreteValidator makeDefault() {
        return ConcreteValidator.builder()
                .validationConstraints(
                        Map.of( "key", Range.between(1,1))
                )
                .build();
    }
}
