/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import net.htmlparser.jericho.Renderer;
import net.htmlparser.jericho.Source;

import java.io.*;

/**
 * Clase que se encarga de transformar un HTML a un archivo de texto
 */
class ConvertidorTXT {

    private String texto;

    /**
     * Constructor de la clase ConvertidorTXT
     *
     * @param dirHTML
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception
     */
    public ConvertidorTXT(String dirHTML) throws Exception {
        InputStream inp = new FileInputStream(dirHTML);
        Renderer preTexto = new Source(inp).getRenderer();
        preTexto.setMaxLineLength(0);
        preTexto.setTableCellSeparator(";");
        preTexto.setNewLine("\n");
        this.texto = "ID;" + preTexto.toString();
        System.out.println("Preprocesado de texto listo");
    }

    /**
     * Escribe en un archivo texto los datos
     *
     * @throws Exception
     */
    public void toTxt() throws IOException {
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter("descargas/medicamentos.txt"));
        bw.write(this.texto);
        bw.close();
    }

}
