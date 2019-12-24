import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-serwer',
  templateUrl: './serwer.component.html',
  styleUrls: ['./serwer.component.css']
})
export class SerwerComponent implements OnInit {

  soap='curl -X POST http://localhost:8080/ws -H \'Content-Type: text/xml\' -H \'SOAPAction: blz:getBank\' -d \'\n' +
    '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sch="https://www.praca_magister/soap_vs_rest/users.com">\n' +
    '<soapenv:Header>\n' +
    '<wsse:Security\n' +
    'xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd"\n' +
    'xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd"\n' +
    'soapenv:mustUnderstand="1">\n' +
    '<wsse:UsernameToken xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd">\n' +
    '<wsse:Username>admin</wsse:Username>\n' +
    '<wsse:Password Type="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText">secret</wsse:Password>\n' +
    '</wsse:UsernameToken>\n' +
    '<wsu:Timestamp xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd">\n' +
    '</wsu:Timestamp>\n' +
    '</wsse:Security>\n' +
    '</soapenv:Header> <soapenv:Body>\n' +
    '<sch:DeleteUserRequest>\n' +
    '<sch:id>9</sch:id>\n' +
    '</sch:DeleteUserRequest>\n' +
    '</soapenv:Body>\n' +
    '</soapenv:Envelope>\'';
  rest='curl -X DELETE localhost:8080/api/rest/user/delete/5'
  constructor() { }

  ngOnInit() {
  }

}
