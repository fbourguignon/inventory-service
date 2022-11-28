package br.com.inventory.service;

import br.com.inventory.model.dto.ReportDTO;
import br.com.inventory.model.entity.Product;
import br.com.inventory.repository.ProductRepository;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static br.com.inventory.model.constants.ReportConstants.PRODUCT_REPORT;

@Slf4j
@Singleton
public class ProductService {

    private final ProductRepository productRepository;
    private final ReportService reportService;

    public ProductService(ProductRepository productRepository, ReportService reportService) {
        this.productRepository = productRepository;
        this.reportService = reportService;
    }

    public ReportDTO generateInventoryReport() {
        try {
            final List<Product> products = productRepository.findAll();
            return new ReportDTO(PRODUCT_REPORT,reportService.generateReport(products, PRODUCT_REPORT));
        } catch (Exception e) {
            log.error("An error has occurred on generate inventory report [{}]", e.getMessage());
            return null;
        }
    }
}