package com.easysystems.easycarapi.services;

import com.easysystems.easycarapi.models.OrdemServico;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;


@Service
public class RelatorioService {

    private Document document = new Document();
    private String caminhoRelatorio = "RelatorioPDF.pdf";

    public File gerarPDF(OrdemServico os){
            try {
                    PdfWriter.getInstance(document, new FileOutputStream(caminhoRelatorio));
                    document.open();
                Paragraph p = new Paragraph("Ordem de Serviço Gerada");
                p.setAlignment(1);
                document.add(p);
                p = new Paragraph(" ");
                document.add(p);


                PdfPTable table = new PdfPTable(3);

                PdfPCell cell1 = new PdfPCell(new Paragraph("Cliente"));
                PdfPCell cell2 = new PdfPCell(new Paragraph("Veículo"));
                PdfPCell cell3 = new PdfPCell(new Paragraph("Atendente"));
                PdfPCell cell4 = new PdfPCell(new Paragraph("Problemas"));

                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);

                 cell1 = new PdfPCell(new Paragraph(os.getCliente().getNome()));
                 cell2 = new PdfPCell(new Paragraph(os.getVeiculo().getModelo()));
                 cell3 = new PdfPCell(new Paragraph("Carlos"));
                 cell4 = new PdfPCell(new Paragraph(os.getProblemas()));

                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);

                document.add(table);
                document.close();

                return new File(caminhoRelatorio);

            } catch (Exception e ) {
                return null;
            }

    }

}
