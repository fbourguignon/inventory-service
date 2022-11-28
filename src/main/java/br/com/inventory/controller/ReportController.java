package br.com.inventory.controller;

import br.com.inventory.service.ProductService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("reports")
@ExecuteOn(TaskExecutors.IO)
public class ReportController {

    private final ProductService productService;

    public ReportController(ProductService productService) {
        this.productService = productService;
    }

    @Get(value = "inventory")
    public HttpResponse<byte[]> inventoryReport() {

        log.info("Handle request to generate inventory report");

        final var reportDTO = productService.generateInventoryReport();

        return HttpResponse.ok(reportDTO.getFileData())
                .headers(reportDTO.getHeaders());

    }
}
