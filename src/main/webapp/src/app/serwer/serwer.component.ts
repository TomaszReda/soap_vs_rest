import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-serwer',
  templateUrl: './serwer.component.html',
  styleUrls: ['./serwer.component.css']
})
export class SerwerComponent implements OnInit {

  soap='curl -X POST http://localhost:8080/ws -H \'Content-Type: text/xml\' -H \'SOAPAction: blz:getBank\' -d \'\n' +
    '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sch="https://www.praca_magister/soap_vs_rest/users.com">\n' +
    '<soapenv:Header/>\n' +
    '<soapenv:Body>\n' +
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
