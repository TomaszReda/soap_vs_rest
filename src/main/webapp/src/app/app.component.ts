import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'webapp';
  deleteUserSoap = '  curl -X POST http://localhost:8080/ws   -H \'Content-Type: text/xml\'   -H \'SOAPAction: blz:getBank\' -d \'\n' +
    '    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sch="https://www.praca_magister/soap_vs_rest/users.com">\n' +
    '      <soapenv:Header/>\n' +
    '      <soapenv:Body>\n' +
    '        <sch:DeleteUserRequest>\n' +
    '          <sch:id>9</sch:id>\n' +
    '        </sch:DeleteUserRequest>\n' +
    '      </soapenv:Body>\n' +
    '    </soapenv:Envelope>\'';
  addUserSoap = '  curl -X POST http://localhost:8080/ws   -H \'Content-Type: text/xml\'   -H \'SOAPAction: blz:getBank\' -d \'\n' +
    '   <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sch="https://www.praca_magister/soap_vs_rest/users.com">\n' +
    '        <soapenv:Header/>\n' +
    '        <soapenv:Body>\n' +
    '            <sch:AddUserRequest>\n' +
    '                <sch:firstname>tomek</sch:firstname>\n' +
    '                <sch:lastname>reda</sch:lastname>\n' +
    '                <sch:phoneNumber>123123123</sch:phoneNumber>\n' +
    '                <sch:password>password</sch:password>\n' +
    '                <sch:email>email@com.pl</sch:email>\n' +
    '                <sch:userRoles>\n' +
    '                    <sch:id>1</sch:id>\n' +
    '                    <sch:userRole>ADMIN</sch:userRole>\n' +
    '                </sch:userRoles>\n' +
    '            </sch:AddUserRequest>\n' +
    '        </soapenv:Body>\n' +
    '    </soapenv:Envelope>' +
    '\'';
  editUserSoap = '  curl -X POST http://localhost:8080/ws   -H \'Content-Type: text/xml\'   -H \'SOAPAction: blz:getBank\' -d \'\n' +
    '   <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sch="https://www.praca_magister/soap_vs_rest/users.com">\n' +
    '        <soapenv:Header/>\n' +
    '        <soapenv:Body>\n' +
    '            <sch:EditUserRequest>\n' +
    '            \t<sch:id>2</sch:id>\n' +
    '                <sch:firstname>tomek</sch:firstname>\n' +
    '                <sch:lastname>reda</sch:lastname>\n' +
    '                <sch:phoneNumber>123123123</sch:phoneNumber>\n' +
    '                <sch:password>password</sch:password>\n' +
    '                <sch:email>email@com.pl</sch:email>\n' +
    '                <sch:userRoles>\n' +
    '                    <sch:id>2</sch:id>\n' +
    '                    <sch:userRole>CASUAL_USER</sch:userRole>\n' +
    '                </sch:userRoles>\n' +
    '            </sch:EditUserRequest>\n' +
    '        </soapenv:Body>\n' +
    '    </soapenv:Envelope>' +
    '\'';
  findUSerSoap = '  curl -X POST http://localhost:8080/ws   -H \'Content-Type: text/xml\'   -H \'SOAPAction: blz:getBank\' -d \'\n' +
    '   <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sch="https://www.praca_magister/soap_vs_rest/users.com">\n' +
    '        <soapenv:Header/>\n' +
    '        <soapenv:Body>\n' +
    '            <sch:GetUserRequest>\n' +
    '            \t<sch:page>0</sch:page>\n' +
    '                <sch:size>10</sch:size>\n' +
    '                <sch:lastname>est</sch:lastname>\n' +
    '                <sch:firstname>4</sch:firstname>\n' +
    '            </sch:GetUserRequest>\n' +
    '        </soapenv:Body>\n' +
    '    </soapenv:Envelope>' +
    '\'';

  deleteBookSoap = '  curl -X POST http://localhost:8080/ws   -H \'Content-Type: text/xml\'   -H \'SOAPAction: blz:getBank\' -d \'\n' +
    '   <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sch="https://www.praca_magister/soap_vs_rest/books.com">\n' +
    '        <soapenv:Header/>\n' +
    '        <soapenv:Body>\n' +
    '            <sch:DeleteBookRequest>\n' +
    '            \t<sch:id>2</sch:id>\n' +
    '            </sch:DeleteBookRequest>\n' +
    '        </soapenv:Body>\n' +
    '    </soapenv:Envelope>' +
    '\'';

  editBookSoap = '  curl -X POST http://localhost:8080/ws   -H \'Content-Type: text/xml\'   -H \'SOAPAction: blz:getBank\' -d \'\n' +
    '   <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sch="https://www.praca_magister/soap_vs_rest/books.com">\n' +
    '        <soapenv:Header/>\n' +
    '        <soapenv:Body>\n' +
    '            <sch:EditBookRequest>\n' +
    '            \t<sch:id>2</sch:id>\n' +
    '            \t<sch:author>Autor</sch:author>\n' +
    '            \t<sch:title>Tytul</sch:title>\n' +
    '            \t<sch:publisher>Publikacja</sch:publisher>\n' +
    '            \t<sch:quant>4</sch:quant>\n' +
    '            \t<sch:bookSearch>BOok search</sch:bookSearch>\n' +
    '            \t<sch:description>Description</sch:description>\n' +
    '            \t<sch:isbn>isbn</sch:isbn>\n' +
    '            \t<sch:data>2002-05-30T09:00:00</sch:data>\n' +
    '            \t<sch:bookState>NOTRESERVED</sch:bookState>\n' +
    '            \t<sch:bookCategory>\n' +
    '            \t\t<sch:id>1</sch:id>\n' +
    '            \t\t<sch:categoryType>Fantasy</sch:categoryType>\n' +
    '            \t</sch:bookCategory>\n' +
    '            </sch:EditBookRequest>\n' +
    '        </soapenv:Body>\n' +
    '    </soapenv:Envelope>' +
    '\'';

  addBookSoap = '  curl -X POST http://localhost:8080/ws   -H \'Content-Type: text/xml\'   -H \'SOAPAction: blz:getBank\' -d \'\n' +
    '   <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sch="https://www.praca_magister/soap_vs_rest/books.com">\n' +
    '        <soapenv:Header/>\n' +
    '        <soapenv:Body>\n' +
    '            <sch:AddBookRequest>\n' +
    '            \t<sch:author>Autor</sch:author>\n' +
    '            \t<sch:title>Tytul</sch:title>\n' +
    '            \t<sch:publisher>Publikacja</sch:publisher>\n' +
    '            \t<sch:quant>4</sch:quant>\n' +
    '            \t<sch:bookSearch>BOok search</sch:bookSearch>\n' +
    '            \t<sch:description>Description</sch:description>\n' +
    '            \t<sch:isbn>isbn</sch:isbn>\n' +
    '            \t<sch:data>2002-05-30T09:00:00</sch:data>\n' +
    '            \t<sch:bookState>NOTRESERVED</sch:bookState>\n' +
    '            \t<sch:bookCategory>\n' +
    '            \t\t<sch:id>1</sch:id>\n' +
    '            \t\t<sch:categoryType>Fantasy</sch:categoryType>\n' +
    '            \t</sch:bookCategory>\n' +
    '            </sch:AddBookRequest>\n' +
    '        </soapenv:Body>\n' +
    '    </soapenv:Envelope>' +
    '\'';

  findBookSoap = '  curl -X POST http://localhost:8080/ws   -H \'Content-Type: text/xml\'   -H \'SOAPAction: blz:getBank\' -d \'\n' +
    '   <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sch="https://www.praca_magister/soap_vs_rest/books.com">\n' +
    '        <soapenv:Header/>\n' +
    '        <soapenv:Body>\n' +
    '            <sch:GetBookRequest>\n' +
    '           <sch:page>0</sch:page>\n' +
    '           <sch:size>10</sch:size>\n' +
    '           <sch:title>7</sch:title>\n' +
    '           <sch:author>4</sch:author>\n' +
    '            </sch:GetBookRequest>\n' +
    '        </soapenv:Body>\n' +
    '    </soapenv:Envelope>' +
    '\'';
}

