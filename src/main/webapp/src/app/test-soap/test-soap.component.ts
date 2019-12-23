import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-test-soap',
  templateUrl: './test-soap.component.html',
  styleUrls: ['./test-soap.component.css']
})
export class TestSoapComponent implements OnInit {

  url = 'http://localhost:8080/api';
  soap = 'http://localhost:8080/ws';

  constructor(private http: HttpClient) {
  }

  number2: number = 1;
  addUserRest = '';
  addUserSoap = '';
  editUserRest = '';
  editUserSoap = '';
  searchUserRest = '';
  searchUserSoap = '';
  deleteUserRest = '';
  deleteUserSoap = '';
  addBookRest = '';
  addBookSoap = '';
  editBookRest = '';
  editBookSoap = '';
  searchBookRest = '';
  searchBookSoap = '';
  deleteBookRest = '';
  deleteBookSoap = '';


  resetAll() {
    this.addUserRest = '';
    this.addUserSoap = '';
    this.editUserRest = '';
    this.editUserSoap = '';
    this.searchUserRest = '';
    this.searchUserSoap = '';
    this.deleteUserRest = '';
    this.deleteUserSoap = '';
    this.addBookRest = '';
    this.addBookSoap = '';
    this.editBookRest = '';
    this.editBookSoap = '';
    this.searchBookRest = '';
    this.searchBookSoap = '';
    this.deleteBookRest = '';
    this.deleteBookSoap = '';
  }

  ngOnInit() {
  }


  onSubmit() {
    this.resetAll();
    this.addUserRestFunction();
    this.addUserSOAPFunction();

  }

  addUserRestFunction() {
    console.log('aa');
    const headers = new HttpHeaders({'Content-Type': 'application/json; charset=utf-8', 'dddd': 'bbbb'});
    const dataBefore = new Date();
    for (let i = 0; i < this.number2; i++) {
      const body = '{\n' +
        '\t"id": "",\n' +
        '\t"firstname": "test",\n' +
        '\t"lastname": "test",\n' +
        '\t"email": "test0@op.pl",\n' +
        '\t"phoneNumber": 1231231,\n' +
        '\t"password": "GHJbnm123",\n' +
        '\t"userRoles": {"id": 1,"userRole": "CASUAL_USER"}\n' +
        '}';
      this.http.post(this.url + '/rest/user/add', body, {headers: headers})._subscribe((x: any) => {
      });
    }
    const dataAfter = new Date();
    const dif = (dataAfter.getTime() - dataBefore.getTime()) / 1000 + '';
    this.addUserRest = dif;
  }


  addUserSOAPFunction() {
    const dataBefore = new Date();

    const headers = new HttpHeaders({
      'Content-Type': 'text/xml; charset=utf-8',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'PUT, GET, POST, DELETE, OPTIONS',
      'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept',
    })
    for (let i = 0; i < this.number2; i++) {
      const body = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sch="https://www.praca_magister/soap_vs_rest/users.com">\n' +
        '<soapenv:Header>\n' +
        '  <wsse:Security \n' +
        '    xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" \n' +
        '    xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd"\n' +
        '    soapenv:mustUnderstand="1">\n' +
        '    \n' +
        '    <wsse:UsernameToken xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd">\n' +
        '      <wsse:Username>admin</wsse:Username>\n' +
        '      <wsse:Password Type="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText">secret</wsse:Password>\n' +
        '    </wsse:UsernameToken>\n' +
        '    \n' +
        '\t<wsu:Timestamp xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd">\n' +
        '\t</wsu:Timestamp>\n' +
        '    \n' +
        '  </wsse:Security>\n' +
        '</soapenv:Header>\n' +
        '   \n' +
        '<soapenv:Body>\n' +
        '<sch:AddUserRequest>\n' +
        '<sch:firstname>tomek</sch:firstname>\n' +
        '<sch:lastname>reda</sch:lastname>\n' +
        '<sch:phoneNumber>123123123</sch:phoneNumber>\n' +
        '<sch:password>password</sch:password>\n' +
        '<sch:email>email@com.pl</sch:email>\n' +
        '<sch:userRoles>\n' +
        '<sch:id>1</sch:id>\n' +
        '<sch:userRole>ADMIN</sch:userRole>\n' +
        '</sch:userRoles>\n' +
        '</sch:AddUserRequest>\n' +
        '</soapenv:Body>\n' +
        '</soapenv:Envelope>';
      this.http.post('http://localhost:8080/ws', body, {headers: headers})._subscribe(x => {
      });
    }
    const dataAfter = new Date();
    const dif = (dataAfter.getTime() - dataBefore.getTime()) / 1000 + '';
    this.addUserSoap = dif;
  }

}



