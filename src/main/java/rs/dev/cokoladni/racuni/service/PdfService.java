package rs.dev.cokoladni.racuni.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import rs.dev.cokoladni.racuni.data.Racun;

import java.io.*;

@Service
public class PdfService {

    private TemplateEngine templateEngine;

    @Autowired
    public PdfService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public byte[] generateInvoicePdf(Racun racun) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);

        document.open();
        addInvoiceContent(document, racun);
        document.close();

        return baos.toByteArray();
    }

    private void addInvoiceContent(Document document, Racun racun) throws DocumentException {
        // Use Thymeleaf template for PDF content generation
        String htmlContent = generateHtmlContent(racun);

        // Use iText to convert HTML to PDF
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PdfWriter pdfWriter = PdfWriter.getInstance(document, outputStream);

            document.open();

            // Use iText XMLWorker to parse HTML content
            XMLWorkerHelper.getInstance().parseXHtml(pdfWriter, document, new ByteArrayInputStream(htmlContent.getBytes()));

            document.close();
            byte[] pdfBytes = outputStream.toByteArray();

            // Do something with the generated PDF bytes (e.g., save to file, return in response, etc.)
            // ...
        } catch (IOException e) {
            throw new DocumentException(e);
        }
    }

    private String generateHtmlContent(Racun racun) {
        Context context = new Context();
        context.setVariable("racun", racun);

        return templateEngine.process("invoice-template.html", context);
    }
}
