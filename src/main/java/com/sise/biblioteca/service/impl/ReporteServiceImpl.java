package com.sise.biblioteca.service.impl;


import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import java.util.List;
import org.springframework.stereotype.Service;

import com.sise.biblioteca.payload.request.ReporteCabeceraRequest;
import com.sise.biblioteca.payload.request.ReporteMaestroRequest;
import com.sise.biblioteca.payload.request.ReporteTablaRequest;
import com.sise.biblioteca.service.IReporteService;
import com.itextpdf.html2pdf.HtmlConverter;

@Service
public class ReporteServiceImpl implements IReporteService {

      @Override
      public byte[] reporteMaestro(ReporteMaestroRequest reporteMaestroRequest) {
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

             StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<style>")
                .append(buildCSS()) // Llamada al CSS
                .append("</style>")
                .append("</head>")
                .append("<body>")
                .append(buildHeaderPdf()) // Llamada al encabezado
                .append(buildCabeceraReporte(reporteMaestroRequest.getCabeceras())) // Cabecera del cliente
                .append(buildTablaReporte(reporteMaestroRequest.getTabla())) // Tabla de datos
                .append("</body>")
                .append("</html>");

        HtmlConverter.convertToPdf(htmlBuilder.toString(), byteArrayOutputStream);

        return byteArrayOutputStream.toByteArray();
    }

    // Encabezado de la biblioteca
    private String buildHeaderPdf() {
        return new StringBuilder()
            .append("<div class=\"header-pdf\">")
            .append("<h1>Biblioteca</h1>")
            .append("<p>Av. Libertador 1234, Miraflores, Lima, Perú</p>")
            .append("</div>")
            .toString();
    }

    // Cabecera que contiene los datos del cliente (Cliente, DNI, Fecha) de forma vertical
    private String buildCabeceraReporte(List<ReporteCabeceraRequest> reporteCabeceraRequests) {
        if (reporteCabeceraRequests == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"cabecera-reporte\">");

        // Estilo para el texto alineado a la izquierda
        sb.append("<p><strong>Cliente:</strong> ")
                .append(reporteCabeceraRequests.get(0).getContenido())
                .append("</p>");
        sb.append("<p><strong>DNI:</strong> ")
                .append(reporteCabeceraRequests.get(1).getContenido())
                .append("</p>");
        sb.append("<p><strong>Fecha:</strong> ")
                .append(reporteCabeceraRequests.get(2).getContenido())
                .append("</p>");

        sb.append("</div>");

        return sb.toString();
    }

    // Tabla con los libros prestados
    private String buildTablaReporte(ReporteTablaRequest reporteTablaRequest) {
        if (reporteTablaRequest == null) {
            return "<p>No hay datos</p>";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"contenedor\">");
        sb.append("<table class=\"tabla-reporte\">")
                .append("<thead class= \"tabla\">")
                .append("<tr>");

        if (reporteTablaRequest.getCabeceras() != null) {
            for (String cabecera : reporteTablaRequest.getCabeceras()) {
                sb.append("<th>")
                    .append(cabecera)
                    .append("</th>");
            }
        }

        sb.append("</tr>")
            .append("</thead>")
            .append("<tbody class = \"datos\">");

        if (reporteTablaRequest.getData() != null) {
            for (List<String> datos : reporteTablaRequest.getData()) {
                sb.append("<tr>");
                for (String dato : datos) {
                    sb.append("<td>")
                        .append(dato)
                        .append("</td>");
                }
                sb.append("</tr>");
            }
        }

        sb.append("</tbody>")
            .append("</table>");
        sb.append("</div>");

        return sb.toString();
    }

    // CSS para el diseño del PDF
    private String buildCSS() {
        return new StringBuilder()
            .append("body {")
            .append("font-family: helvetica;")
            .append("margin: 0;")
            .append("padding: 0;")
            .append("}")
            .append(".header-pdf {")
            .append("text-align: center;")  // Centrar el encabezado
            .append("padding: 10px;")
            .append("}")
            .append(".header-pdf h1 {")
            .append("font-size: 2rem;")
            .append("margin-bottom: 0.5rem;")
            .append("}")
            .append(".header-pdf p {")
            .append("font-size: 1rem;")  // Tamaño de fuente más pequeño para la dirección
            .append("}")
            .append(".cabecera-reporte {")
            .append("margin-top: 10px;")
            .append("padding-left: 20px;")  // Alinear margen izquierdo
            .append("}")
            .append(".cabecera-reporte p {")
            .append("font-size: 1rem;")  // Ajuste del tamaño de fuente
            .append("margin: 5px 0;")  // Separación entre líneas
            .append("}")
            .append(".tabla-reporte {")
            .append("width: 100%;")
            .append("border-collapse: collapse;") // Simplificar la tabla
            .append("}")
            .append(".tabla-reporte th, .tabla-reporte td {")
            .append("border-bottom: 1px solid #000;")
            .append("padding: 8px;")  // Ajustar padding
            .append("text-align: left;")  // Alinear a la izquierda
            .append("}")
            .append(".tabla-reporte th {")
            .append("background-color: #f2f2f2;")
            .append("}")
            .toString();
         }
         }
     
  
  
      
             

     

