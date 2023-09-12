package com.example.demo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.micronaut.core.annotation.Introspected;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class ResourceValidator {
    @Builder.Default
    protected Map<String, Validator> validationConstraints = new HashMap<>();

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            property = "validation-type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Range.class, name = "Range")
    })
    public interface Validator {
        void ensureValid(String name, Object value);
    }

    @Data
    @Builder
    @Introspected(classes = Number.class)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Range implements Validator {
        private Number min;
        private Number max;
        private boolean optional = false;

        public static Range between(Number min, Number max) {
            return new Range(min, max, false);
        }

        @Override
        public void ensureValid(String name, Object o) {
            // do something
        }
    }

}
