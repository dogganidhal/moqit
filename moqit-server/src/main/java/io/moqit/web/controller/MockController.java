package io.moqit.web.controller;

import io.moqit.domain.GenerateMock;
import io.moqit.service.MockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/mock")
public class MockController {

    private final MockService mockService;

    @PostMapping
    public String generateMock(@RequestBody GenerateMock request) {
        return mockService.generate(request);
    }

}
