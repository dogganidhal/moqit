package io.moqit.service.generator;

import io.moqit.domain.MockType;
import io.moqit.domain.Schema;
import io.moqit.domain.Table;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

public interface MockGenerator {

  String generate(Schema schema);

  String generate(Table table);

  @Component
  @AllArgsConstructor
  final class Registry {

    private static final String BEAN_SUFFIX = "_mock_generator";

    private final ConfigurableBeanFactory beanFactory;

    public void register(MockType type, MockGenerator generator) {
      beanFactory.registerSingleton(type.name().toLowerCase() + BEAN_SUFFIX, generator);
    }

    public MockGenerator resolve(MockType type) {
      return beanFactory.getBean(type.name().toLowerCase() + BEAN_SUFFIX, MockGenerator.class);
    }

  }

}
