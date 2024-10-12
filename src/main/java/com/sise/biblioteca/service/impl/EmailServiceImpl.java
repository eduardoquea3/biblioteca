package com.sise.biblioteca.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.sise.biblioteca.payload.request.DataCorreo;
import com.sise.biblioteca.payload.request.EmailRequest;
import com.sise.biblioteca.service.IEmailService;
import com.sise.biblioteca.shared.EmailSender;

@Service
public class EmailServiceImpl implements IEmailService {

  @Autowired
  JavaMailSender javaMailSender;

  @Override
  public void sendNotice(EmailRequest emailRequest) throws Exception {
    new EmailSender(javaMailSender).sendEmail(emailRequest,"Gracias por su preferencia",
    notice(header(bodyNotice(emailRequest.getData())))
    );
  }

  @Override
  public void sendWelcome(EmailRequest emailRequest) throws Exception {
    new EmailSender(javaMailSender).sendEmail(emailRequest,"Gracias por su preferencia",
    notice(header(bodyWelcome(emailRequest.getData().getCliente())))
    );
  }

  private String notice(String body){
    return new StringBuilder()
    .append("""
      <!DOCTYPE PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>
      <html xmlns="http://www.w3.org/1999/xhtml">
      <head>
          <meta charset='UTF-8'>
          <meta name='viewport' content='width=device-width,initial-scale=1.0'>
          <title></title>
      </head>
      <body>
      """)
    .append(body)
    .append("""
      </body>
      </html>
      """)
    .toString();

  }


  private String header(String body){
    return new StringBuilder()
    .append("""
      <div style='width:100%;'>
        <table style='background:white;color:white;width:500px;margin-left:auto;margin-right:auto;border:1px solid #ddd;'>
          <thead>
            <tr>
              <th>
                <div style='background:#131924;color:white;border-radius:20px 20px 0 0;display:flex;align-items: center;justify-content: space-around;'>
      """)
    .append("<img src='https://drive.google.com/uc?export=view&id=1_3kGJEsVgvtJtxfpiQL4tK87-NodKmZf' alt='Image from Google Drive' style='height:100px;margin:10px 29px;'>")
    .append("""
                  <div style='height:120px;margin:auto 29px;display:grid;place-content:center;'>
                    <h1 style='height:24px'>Biblioteca</h1>
                    <p style='height:36px'>Av. Libertador 1234, Miraflores, Lima, Perú</p>
                  </div>
                </div>
              </th>
            </tr>
          </thead>
          <tbody style='color:black;'>
            <tr>
              <div style='padding:10px;'>
      """)
    .append(body)
    .append("""
              </div>
            </tr>
          </tbody>
        </table>
      """)
    .toString();
  }

  private String bodyNotice(DataCorreo data){
    int totalColumnas = data.getCabeceras().size();
    String sizeCol = 100/totalColumnas + "%";
    StringBuilder body = new StringBuilder()
    .append("""
      <table style='width:100%;'>
        <tbody>
          <tr>
            <p><strong>Cliente:</strong>""")
            .append(data.getCliente())
            .append("""
            </p>
          </tr>
          <tr>
            <p><strong>DNI:</strong>""")
            .append(data.getDni())
            .append("""
            </p>
          </tr>
          <tr>
            <p><strong>Fecha:</strong>""")
            .append(data.getFecha())
            .append("""
            </p>
          </tr>
          <tr style='width:100%;'>
            <div>
              <table style='width:100%;'>
                <tbody>
                  <tr style='width:100%;'>
        """);
      for (String cabezera : data.getCabeceras()) {
        body.append("""
                    <th style='padding:4px 6px;border-bottom:1px solid #999;width:
                    """)
                    .append(sizeCol)
                    .append("""
                    '><strong>
                    """)
                    .append(cabezera)
            .append("""
                    </strong></th>
                    """);
      }
      body.append("""
                  </tr>
                  """);

                  for (List<String> datos : data.getData()) {
                    body.append("""
                      <tr>""");
                      for (String dato : datos) {
                        body.append("""
                          <td style='padding:4px 6px;'>""")
                          .append(dato)
                          .append("""
                          </td>""");
                      }
                    body.append("""
                      </tr>
                      """);
                  }
      body.append("""
                </tbody>
              </table>
            </div>
          </tr>
          <tr>
            <h2 style='text-align:center'><strong> Gracias por su preferencia </strong></h2>
          </tr>
        </tbody>
      <table>
      """);
    return body.toString();
  }

  private String bodyWelcome(String cliente){
    StringBuilder body = new StringBuilder()
    .append("""
      <table style='width:100%;'>
        <tbody>
          <tr>
            <p>Estimado(a)<strong>""")
            .append(cliente)
            .append("""
            </strong></p>
            <p>
            Te agradecemos por ser parte de nuestra comunidad de lectores. Tu apoyo y entusiasmo al adquirir nuestros libros no solo enriquece tu vida, sino también la de todos los que comparten esta pasión por la lectura.
            <p>
            <p>
            Si tienes alguna sugerencia o comentario, no dudes en hacérnoslo saber. Tu opinión es invaluable para nosotros.
            <p>
            <h3 style='text-align:center'>
            ¡Gracias por su preferencia.!
            </h3>
            <h5 style='text-align:center'>
            No olvide devolver los libros dentro de la fecha límite.
            </h5>
          </tr>
        </tbody>
      <table>
      """);

      return body.toString();
  }
}
