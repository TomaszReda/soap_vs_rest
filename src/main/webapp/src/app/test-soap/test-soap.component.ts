import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";


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
  addTestDataOnlySendRest: number = 0;
  addTestDataOnlySendSoap: number = 0;
  addTestDataSendAndReceivRest: number = 0;
  addTestDataOnlySendAndReceivSoap: number = 0;
  bodyRest = '';
  bodySoapReceiv = '';
  bodySoapSend = '';


  resetAll(type: string) {
    if (type == "REST")
      this.addTestDataOnlySendRest = 0;
    if (type == "SOAP")
      this.addTestDataOnlySendSoap = 0;
    if (type == "REST_SEND")
      this.addTestDataSendAndReceivRest = 0;
    if (type == "SOAP_SEND")
      this.addTestDataOnlySendAndReceivSoap = 0;
  }

  public getTranslation(data: string): Observable<any> {
    return this.http.get(data);
  }

  ngOnInit() {
    this.getTranslation('./assets/testREST.txt').subscribe((x: any) => {
      this.bodyRest = x;
    });
    this.http.get('./assets/TestRequestSendOnlySOAP.txt', {responseType: 'text'})
      .subscribe(data => {
        this.bodySoapSend = data;
      });
    this.http.get('./assets/TestRequestSendAndReceivRequestSOAP.txt', {responseType: 'text'})
      .subscribe(data => {
        this.bodySoapReceiv = data;
      });


  }
  divdeFromNumber() {
    this.addTestDataOnlySendRest /= this.number2;
    this.addTestDataOnlySendSoap /= this.number2;
    this.addTestDataSendAndReceivRest /= this.number2;
    this.addTestDataOnlySendAndReceivSoap /= this.number2;

  }


  onSubmitTestSoapOnlySend() {
    this.resetAll("SOAP");
    this.addTestSoapOnlySend();

  }

  onSubmitTestRestOnlySend() {
    this.resetAll("REST");
    this.addTestRestFunctionSendOnly();
  }

  onSubmitTestSOAPFunctionSendAndReceiv() {
    this.resetAll("SOAP_SEND");
    this.addTestSoapSendAndReceiv();
  }

  onSubmitTestRestFunctionSendAndReceiv() {
    this.resetAll("REST_SEND");
    this.addTestRestFunctionSendAndReceiv();
  }


  delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
  }

  addTestRestFunctionSendOnly() {
    const headers = new HttpHeaders({'Content-Type': 'application/json; charset=utf-8'});
    const dataBefore = new Date();
    for (let i = 0; i < this.number2; i++) {
      this.http.post(this.url + '/rest/test/send-only', this.bodyRest, {headers: headers}).subscribe((x: any) => {
        const dataAfter = new Date();
        const dif = (dataAfter.getTime() - dataBefore.getTime()) / 1000;
        this.addTestDataOnlySendRest = dif;
      });
    }

  }


  addTestRestFunctionSendAndReceiv() {
    const headers = new HttpHeaders({'Content-Type': 'application/json; charset=utf-8'});
    const dataBefore = new Date();
    for (let i = 0; i < this.number2; i++) {
      this.http.post(this.url + '/rest/test/send-and-receiv', this.bodyRest, {headers: headers}).subscribe((x: any) => {
        const dataAfter = new Date();
        const dif = (dataAfter.getTime() - dataBefore.getTime()) / 1000;
        this.addTestDataSendAndReceivRest = dif;
      });
    }

  }

  addTestSoapOnlySend() {
    const dataBefore = new Date();

    const headers = new HttpHeaders({
      'Content-Type': 'text/xml; charset=utf-8',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'PUT, GET, POST, DELETE, OPTIONS',
      'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept',
    });
    for (let i = 0; i < this.number2; i++) {
      this.http.post('http://localhost:8080/ws', this.bodySoapSend, {
        headers: headers,
        responseType: "text"
      }).subscribe(x => {
        const dataAfter = new Date();
        const dif = (dataAfter.getTime() - dataBefore.getTime()) / 1000;
        this.addTestDataOnlySendSoap = dif;
      });
    }

  }


  addTestSoapSendAndReceiv() {
    const dataBefore = new Date();

    const headers = new HttpHeaders({
      'Content-Type': 'text/xml; charset=utf-8',
      'Accept': 'text/xml',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'PUT, GET, POST, DELETE, OPTIONS',
      'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept',
    });

    for (let i = 0; i < this.number2; i++) {
      this.http.post('http://localhost:8080/ws', this.bodySoapReceiv, {
        headers: headers,
        responseType: "text"
      }).subscribe(x => {
        const dataAfter = new Date();
        const dif = (dataAfter.getTime() - dataBefore.getTime()) / 1000;
        this.addTestDataOnlySendAndReceivSoap = dif;
      });
    }


  }


}



