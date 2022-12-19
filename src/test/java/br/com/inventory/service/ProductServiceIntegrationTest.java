package br.com.inventory.service;

import br.com.inventory.model.dto.ReportDTO;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
public class ProductServiceIntegrationTest {

    @Inject
    private ProductService productService;

    @Test
    @DisplayName(value = "Should return a reportDTO with success")
    public void shouldReturnProductsWithSuccess(){
        final ReportDTO reportDTO = productService.generateInventoryReport();

        assertNotNull(reportDTO);
        assertNotNull(reportDTO.getFileData());
    }
}
