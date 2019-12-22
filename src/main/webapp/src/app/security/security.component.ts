import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-security',
  templateUrl: './security.component.html',
  styleUrls: ['./security.component.css']
})
export class SecurityComponent implements OnInit {

   loginRest='curl -d \'{"email" : "test@op.pl","password" :"test"}\' -H \'Content-Type: application/json\' http://localhost:8080/api/rest/login';
  secureEndNoSecure='curl -v localhost:8080/api/rest/secure';
  secureEndpointSecure='curl -v localhost:8080/api/rest/secure H \'x-auth-token: {Tu wklejamy wczesniej uzyskany token}\''
  constructor() { }

  ngOnInit() {
  }

}
