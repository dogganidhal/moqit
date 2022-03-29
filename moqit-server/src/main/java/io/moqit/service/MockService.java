package io.moqit.service;


import io.moqit.domain.GenerateMock;
import io.moqit.service.generator.MockGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MockService {

    private final MockGenerator.Factory mockGeneratorFactory;

    public String generate(GenerateMock request) {
        return mockGeneratorFactory.create(request.getType()).generate(request.getSchema());
    }

}
