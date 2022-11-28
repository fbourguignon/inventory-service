package br.com.inventory.model.dto;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

import static br.com.inventory.model.constants.ReportConstants.*;


@Introspected
public class ReportDTO {
    private String fileName;
    private byte[] fileData;

    private Map<CharSequence,CharSequence> headers = new HashMap<>();

    public ReportDTO(@NotNull(message = "File name is required") String fileName,
                     @NotNull(message = "File data is required") byte[] fileData) {
        this.fileName = fileName;
        this.fileData = fileData;

        this.headers.put(CONTENT_TYPE_REPORT_HEADER,CONTENT_TYPE_REPORT_PDF);
        this.headers.put(FILE_NAME_REPORT_HEADER,fileName.concat(PDF_EXTENSION));
    }

    public byte[] getFileData() {
        return fileData;
    }

    public Map<CharSequence, CharSequence> getHeaders() {
        return headers;
    }
}
