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
    const headers = new HttpHeaders({'Content-Type': 'application/json; charset=utf-8','dddd': 'bbbb'});
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
      this.http.post(this.url + '/rest/user/add', body, {headers: headers})._subscribe((x) => {
        console.log(x);
      });

    }
    const dataAfter = new Date();
    const dif = (dataAfter.getTime() - dataBefore.getTime()) / 1000 + '';
    this.addUserRest = dif;
  }


  addUserSOAPFunction() {

    const headers = new HttpHeaders({
      'Content-Type': 'text/xml; charset=utf-8',
      'Access-Control-Allow-Origin':'*',
      'Access-Control-Allow-Methods':'PUT, GET, POST, DELETE, OPTIONS',
      'Access-Control-Allow-Headers':'Origin, X-Requested-With, Content-Type, Accept',
    })

    const body = 'cos tam';
    this.http.post('http://localhost:8080/ws', body, {headers: headers})._subscribe((x) => {
      console.log(x);
    });
  }

}



