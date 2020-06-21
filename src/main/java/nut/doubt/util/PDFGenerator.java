package nut.doubt.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class PDFGenerator {

    public static void generatePDF(List<String> doubtList, String userId) {
        Document pdfDocument = new Document();

        try {
            FileOutputStream out = new FileOutputStream(new File("reports/doubt" + userId + ".pdf"));

            PdfWriter writer = PdfWriter.getInstance(pdfDocument, out);
            pdfDocument.open();
            for(String doubt: doubtList) {
                pdfDocument.add(new Paragraph(doubt));
            }
            pdfDocument.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }


}
