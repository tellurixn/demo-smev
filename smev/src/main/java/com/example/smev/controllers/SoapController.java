package com.example.smev.controllers;

import com.example.smev.models.Response;
import com.example.smev.models.Request;
import com.example.smev.service.SoapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoapController {

    private final SoapService soapService;

    @Autowired
    public SoapController(SoapService soapService) {
        this.soapService = soapService;
    }

    @PostMapping("/send")
    public ResponseEntity<Response> sendMessage(@RequestBody Request request) {
        Response response = soapService.sendMessage(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public String index(){
        Request req = new Request();
        req.setMessage("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"urn://x-artefacts-smev-gov-ru/services/service-adapter/types\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <typ:ClientMessage xmlns:ct=\"urn://x-artefacts-oiv002/license/3.0.0\" >\n" +
                "      <typ:itSystem>test_cert</typ:itSystem>\n" +
                "      <typ:RequestMessage>\n" +
                "        <typ:RequestMetadata>\n" +
                "          <typ:clientId>59de6bde-b85a-4491-aced-1be8e96415c4</typ:clientId>          \n" +
                "        </typ:RequestMetadata>\n" +
                "         <RequestContent>\n" +
                "                  <content>\n" +
                "                     <MessagePrimaryContent>\n" +
                "                        <tns:licenseRequest xmlns:tns=\"urn://x-artefacts-oiv002/license/3.0.0\">\n" +
                "                           <tns:issue>\n" +
                "                              <tns:licenceHolder>\n" +
                "                                 <ns1:legalUnitName xmlns:ns1=\"urn://x-artefacts-oiv002/common-types/3.0.0\">тест запрос</ns1:legalUnitName>\n" +
                "                                 <ns1:legalUnitOGRN xmlns:ns1=\"urn://x-artefacts-oiv002/common-types/3.0.0\">1234567890123</ns1:legalUnitOGRN>\n" +
                "                              </tns:licenceHolder>\n" +
                "                              <tns:validityPeriod>\n" +
                "                                 <tns:startDate>2022-12-22</tns:startDate>\n" +
                "                                 <tns:expireDate>2024-12-22</tns:expireDate>\n" +
                "                              </tns:validityPeriod>\n" +
                "                           </tns:issue>\n" +
                "                        </tns:licenseRequest>\n" +
                "                     </MessagePrimaryContent>\n" +
                "                  </content>\n" +
                "               </RequestContent>\n" +
                "      </typ:RequestMessage>\n" +
                "    </typ:ClientMessage>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>");

        Response res = soapService.sendMessage(req);

        return "index";
    }


}