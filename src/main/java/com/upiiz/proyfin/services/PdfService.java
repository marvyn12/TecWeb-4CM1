package com.upiiz.proyfin.services;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.upiiz.proyfin.entities.SolicitanteEntity;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class PdfService {

    public byte[] generarConstancia(SolicitanteEntity solicitante) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Document document = new Document(PageSize.A4, 50, 50, 40, 40);
            PdfWriter.getInstance(document, out);
            document.open();

            PdfPTable headerTable = new PdfPTable(3);
            headerTable.setWidthPercentage(100);
            headerTable.setWidths(new float[]{1.5f, 4f, 1.5f});

            Image logoIpn = Image.getInstance(new ClassPathResource("static/images/IPN-Logo.png").getURL());
            logoIpn.scaleToFit(125, 125);
            PdfPCell cellIpn = new PdfPCell(logoIpn);
            cellIpn.setBorder(Rectangle.NO_BORDER);
            cellIpn.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellIpn.setVerticalAlignment(Element.ALIGN_MIDDLE);
            headerTable.addCell(cellIpn);

            Paragraph textHeader = new Paragraph();
            textHeader.setAlignment(Element.ALIGN_CENTER);
            textHeader.add(new Chunk("Instituto Politécnico Nacional\n", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
            textHeader.add(new Chunk("Unidad de Educación Continua", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));

            PdfPCell cellText = new PdfPCell(textHeader);
            cellText.setBorder(Rectangle.NO_BORDER);
            cellText.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellText.setVerticalAlignment(Element.ALIGN_MIDDLE);
            headerTable.addCell(cellText);

            Image logoUpiiz = Image.getInstance(new ClassPathResource("static/images/upiiz.png").getURL());
            logoUpiiz.scaleToFit(75, 75);
            PdfPCell cellUpiiz = new PdfPCell(logoUpiiz);
            cellUpiiz.setBorder(Rectangle.NO_BORDER);
            cellUpiiz.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellUpiiz.setVerticalAlignment(Element.ALIGN_MIDDLE);
            headerTable.addCell(cellUpiiz);

            document.add(headerTable);

            Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph title = new Paragraph("CONSTANCIA", fontTitle);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingBefore(20);
            title.setSpacingAfter(15);
            document.add(title);

            Font fontHeader = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
            Paragraph aQuien = new Paragraph("A QUIEN CORRESPONDA:", fontHeader);
            aQuien.setAlignment(Element.ALIGN_LEFT);
            aQuien.setSpacingAfter(10);
            document.add(aQuien);

            Font fontBody = FontFactory.getFont(FontFactory.HELVETICA, 12);
            Paragraph pIntro = new Paragraph("Por medio de la presente se hace constar que:", fontBody);
            pIntro.setSpacingAfter(10);
            document.add(pIntro);

            Font fontName = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            fontName.setStyle(Font.UNDERLINE);
            Paragraph name = new Paragraph(solicitante.getNombre().toUpperCase(), fontName);
            name.setAlignment(Element.ALIGN_CENTER);
            name.setSpacingAfter(15);
            document.add(name);

            String folio = String.format("%04d", solicitante.getId());
            Paragraph p1 = new Paragraph();
            p1.setAlignment(Element.ALIGN_JUSTIFIED);
            p1.setFont(fontBody);
            p1.add("con número de folio o registro ");
            p1.add(new Chunk(folio, fontHeader));
            p1.add(", se encuentra inscrito en el Curso de Preparación para el Ingreso al Nivel Superior del Instituto Politécnico Nacional (IPN).");
            p1.setSpacingAfter(10);
            document.add(p1);

            Paragraph p2 = new Paragraph();
            p2.setAlignment(Element.ALIGN_JUSTIFIED);
            p2.setFont(fontBody);
            p2.add("El curso tiene como objetivo brindar a los alumnos las herramientas y conocimientos necesarios para enfrentar con éxito el examen de admisión al nivel superior de nuestra institución. La duración del curso es de ");
            p2.add(new Chunk("120 horas", fontHeader));
            p2.add(" y se desarrolla en las instalaciones de la ");
            p2.add(new Chunk("UPIIZ-IPN", fontHeader));
            p2.add(".");
            p2.setSpacingAfter(10);
            document.add(p2);

            Paragraph p3 = new Paragraph();
            p3.setAlignment(Element.ALIGN_JUSTIFIED);
            p3.setFont(fontBody);
            p3.add("La fecha de inicio del curso fue el ");
            p3.add(new Chunk("15 de febrero de 2026", fontHeader));
            p3.add(" y la fecha de finalización prevista es el ");
            p3.add(new Chunk("15 de junio de 2026", fontHeader));
            p3.add(".");
            p3.setSpacingAfter(10);
            document.add(p3);

            Paragraph p4 = new Paragraph();
            p4.setAlignment(Element.ALIGN_JUSTIFIED);
            p4.setFont(fontBody);
            p4.add("Para cualquier información adicional, favor de comunicarse a nuestras oficinas o al teléfono ");
            p4.add(new Chunk("492 923 2952", fontHeader));
            p4.add(".");
            p4.setSpacingAfter(20);
            document.add(p4);

            Paragraph despedida = new Paragraph("Sin más por el momento, quedo a sus órdenes.", fontBody);
            despedida.setSpacingAfter(30);
            document.add(despedida);

            Paragraph atentamente = new Paragraph("Atentamente,", fontBody);
            atentamente.setAlignment(Element.ALIGN_CENTER);
            atentamente.setSpacingAfter(45);
            document.add(atentamente);

            Paragraph firmaLine = new Paragraph("______________________________________", fontBody);
            firmaLine.setAlignment(Element.ALIGN_CENTER);
            document.add(firmaLine);

            Paragraph firmaText = new Paragraph("M. en C. Director/Coordinador del Curso\nUnidad de Educación Continua\nInstituto Politécnico Nacional", fontHeader);
            firmaText.setAlignment(Element.ALIGN_CENTER);
            firmaText.setSpacingBefore(5);
            firmaText.setSpacingAfter(20);
            document.add(firmaText);

            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy", new Locale("es", "MX"));
            Paragraph dateP = new Paragraph("Zacatecas, Zac., a " + date.format(formatter), FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 12));
            dateP.setAlignment(Element.ALIGN_RIGHT);
            document.add(dateP);

            document.close();
            return out.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}