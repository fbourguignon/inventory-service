package br.com.inventory.service;

import br.com.inventory.model.constants.ReportConstants;
import io.micronaut.core.io.ResourceLoader;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.*;
import java.util.*;

import static java.lang.String.format;

@Slf4j
@Singleton
public class ReportService {

    private final ResourceLoader resourceLoader;

    public ReportService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public byte[] generateReport(Collection elements, String reportName) throws JRException, IOException {

        try (InputStream resourceAsStream = loadCompiledJasperReport(reportName)) {

            Map<String, Object> parameters = new HashMap<>();
            JasperPrint jasperPrint = JasperFillManager.fillReport(resourceAsStream, parameters, new JRBeanCollectionDataSource(elements));
            return JasperExportManager.exportReportToPdf(jasperPrint);

        } catch (Exception e) {
            log.error("An error has occurred on generate report [{}]", e.getMessage());
            throw e;
        }

    }

    private InputStream loadCompiledJasperReport(String fileName){
        return resourceLoader.getResourceAsStream(format(ReportConstants.REPORT_CLASSPATH,fileName))
                .orElseThrow();
    }
}
