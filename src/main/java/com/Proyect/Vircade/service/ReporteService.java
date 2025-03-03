package com.Proyect.Vircade.service;

import com.Proyect.Vircade.modelo.Asesor;
import com.Proyect.Vircade.repository.AsesorRepository;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.kernel.pdf.PdfDocument;

import com.itextpdf.layout.properties.TextAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ReporteService {
    @Autowired
    private AsesorRepository asesorRepository;

    public byte[] generarReporte() {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(baos);
            Document document = new Document(new PdfDocument(writer));
            document.add(new Paragraph("Reporte de Asesores y Clientes")
                    .setFontSize(18)
                    .setTextAlignment(TextAlignment.CENTER));

            List<Asesor> asesores = asesorRepository.findAll();
            for (Asesor asesor : asesores) {
                Paragraph asesorTitulo = new Paragraph("Asesor: " + asesor.getPNomAsesor() + " " + asesor.getPApeAsesor())
                        .setFontSize(18)
                        .setBackgroundColor(ColorConstants.LIGHT_GRAY)
                        .setPadding(20)
                        .setTextAlignment(TextAlignment.CENTER);
                document.add(asesorTitulo);

                Table table = new Table(new float[]{2, 2, 3, 4, 5});
                table.setTextAlignment(TextAlignment.CENTER);
                table.setPadding(8);
                table.setBorder(new SolidBorder(1));

                String[] headers = {"Fecha", "Hora", "Cliente","Correo Cliente", "Tipo de Cita"};
                for (String header : headers) {
                    Cell headerCell = new Cell().add(new Paragraph(header)
                            .setFontSize(14)
                            .setBackgroundColor(ColorConstants.BLACK)
                            .setFontColor(ColorConstants.WHITE)
                            .setTextAlignment(TextAlignment.CENTER)
                            .setPadding(8));
                    table.addHeaderCell(headerCell);
                }
                asesor.getCita().forEach(cita -> {
                    table.addCell(new Cell().add(new Paragraph(cita.getFecha()))
                            .setKeepTogether(true)
                            .setPadding(8));
                    table.addCell(new Cell().add(new Paragraph(cita.getHora()))
                            .setKeepTogether(true)
                            .setPadding(8));
                    table.addCell(new Cell().add(new Paragraph(
                            cita.getClienteRelacionado().getPrimerNombre() + " " +
                            cita.getClienteRelacionado().getPrimerApellido())
                            .setKeepTogether(true)
                            .setPadding(8)));
                    table.addCell(new Cell().add(new Paragraph(cita.getClienteRelacionado().getCorreo()))
                            .setKeepTogether(true)
                            .setPadding(8));
                    table.addCell(new Cell().add(new Paragraph(cita.getTipoCita()))
                            .setKeepTogether(true)
                            .setPadding(8));
                });

                document.add(table);
                document.add(new Paragraph("\n"));
            }

            document.close();
            return baos.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error generando el PDF", e);
        }
    }
}