package io.moqit.service.generator;

import java.util.HashMap;
import java.util.Map;

import io.moqit.domain.MockType;
import io.moqit.domain.Schema;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

public interface MockGenerator {

    String JSON = "json_mock_generator";
    String CSV = "csv_mock_generator";

    @Component
    @AllArgsConstructor
    final class Factory {

        private final static Map<MockType, String> GENERATOR_MAP = new HashMap<>() {{
            put(MockType.JSON, JSON);
            put(MockType.CSV, CSV);
        }};

        private final BeanFactory beanFactory;

        public MockGenerator create(MockType type) {
            return beanFactory.getBean(MockGenerator.class, GENERATOR_MAP.get(type));
        }

    }

    String generate(Schema schema);

}
