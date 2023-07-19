package classes;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;

public class RelatorioPrintable implements Printable {

    private final String relatorio;
    private final Font fonteTitulo = new Font("Arial", Font.BOLD, 16);
    private final Font fonteNormal = new Font("Arial", Font.PLAIN, 12);

    public RelatorioPrintable(String relatorio) {
        this.relatorio = relatorio;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        int y = 50; // Posição inicial vertical

        // Título
        g2d.setFont(fonteTitulo);
        g2d.drawString("Adriane Perfumaria", 50, y);
        y += 20;

        // Telefone
        g2d.setFont(fonteNormal);
        g2d.drawString("Telefone: (49) 9 99573756", 50, y);
        y += 40;

        // Conteúdo do relatório
        g2d.setFont(fonteNormal);
        for (String linha : relatorio.split("\n")) {
            g2d.drawString(linha, 50, y);
            y += 20;
        }

        return Printable.PAGE_EXISTS;
    }
}
