import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-format',
  templateUrl: './format.component.html',
  styleUrls: ['./format.component.css']
})
export class FormatComponent implements OnInit {

  soapXML = "curl -X POST http://localhost:8080/ws -H 'Content-Type: text/xml' -H 'SOAPAction: blz:getBank' -d ' <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:sch=\"https://www.praca_magister/soap_vs_rest/users.com\"> <soapenv:Header/> <soapenv:Body> <sch:AddUserRequest> <sch:firstname>tomek</sch:firstname> <sch:lastname>reda</sch:lastname> <sch:phoneNumber>123123123</sch:phoneNumber> <sch:password>password</sch:password> <sch:email>email@com.pl</sch:email> <sch:userRoles> <sch:id>1</sch:id> <sch:userRole>ADMIN</sch:userRole> </sch:userRoles> </sch:AddUserRequest> </soapenv:Body> </soapenv:Envelope>'";
  restJSON = "curl -d '{\"id\": \"\",\"firstname\": \"test\",\"lastname\": \"test\",\"email\": \"test0@op.pl\",\"phoneNumber\": 1231231,\"password\": \"GHJbnm123\",\"userRoles\": {\"id\": 1,\"userRole\": \"CASUAL_USER\"}}' -H 'Content-Type: application/json' localhost:8080/api/rest/user/add";
  restXML = "";
  restHTML = "";
  restTEXT = "";
  restYAML = "";

  constructor() {
  }

  ngOnInit() {
  }

}
