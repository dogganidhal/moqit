package io.moqit.service;


import io.moqit.domain.GenerateMock;
import io.moqit.service.generator.MockGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MockService {

  private final MockGenerator.Registry registry;

  public String generate(GenerateMock request) {
    return registry.resolve(request.getType()).generate(request.getSchema());
  }

}
