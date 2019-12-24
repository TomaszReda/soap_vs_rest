import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data-size',
  templateUrl: './data-size.component.html',
  styleUrls: ['./data-size.component.css']
})
export class DataSizeComponent implements OnInit {

  soap='curl -X POST http://localhost:8080/ws -H \'Content-Type: text/xml\' -H \'SOAPAction: blz:getBank\' -d \'\n' +
    '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sch="https://www.praca_magister/soap_vs_rest/books.com">\n' +
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
    '<sch:AddBookRequest>\n' +
    '<sch:author>Autor</sch:author>\n' +
    '<sch:title>Tytul</sch:title>\n' +
    '<sch:publisher>Publikacja</sch:publisher>\n' +
    '<sch:quant>4</sch:quant>\n' +
    '<sch:bookSearch>BOok search</sch:bookSearch>\n' +
    '<sch:description>Description</sch:description>\n' +
    '<sch:isbn>isbn</sch:isbn>\n' +
    '<sch:data>2002-05-30T09:00:00</sch:data>\n' +
    '<sch:bookState>NOTRESERVED</sch:bookState>\n' +
    '<sch:bookCategory>\n' +
    '<sch:id>1</sch:id>\n' +
    '<sch:categoryType>Fantasy</sch:categoryType>\n' +
    '</sch:bookCategory>\n' +
    '</sch:AddBookRequest>\n' +
    '</soapenv:Body>\n' +
    '</soapenv:Envelope>\'';

  rest='curl -d \'\n' +
    '{\n' +
    '"id": "",\n' +
    '"author": "author4",\n' +
    '"title": "title4",\n' +
    '"publisher": "publisher4",\n' +
    '"date": "2019-12-01","isbn": "isbn4",\n' +
    '"quant": 4,\n' +
    '"bookSearch": "bookSearch4",\n' +
    '"description": "description4",\n' +
    '"bookState": "NOTRESERVED",\n' +
    '"bookCategory": [\n' +
    '{\n' +
    '"id": 1,\n' +
    '"categoryType": "Fantasy"\n' +
    '}\n' +
    ']\n' +
    '}\n' +
    '\' -H \'Content-Type: application/json\' localhost:8080/api/rest/book/add';
  constructor() { }

  ngOnInit() {
  }

}
