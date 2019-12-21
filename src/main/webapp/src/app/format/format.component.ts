import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-format',
  templateUrl: './format.component.html',
  styleUrls: ['./format.component.css']
})
export class FormatComponent implements OnInit {

  soapXML = "curl -X POST http://localhost:8080/ws -H 'Content-Type: text/xml' -H 'SOAPAction: blz:getBank' -d ' <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:sch=\"https://www.praca_magister/soap_vs_rest/users.com\"> <soapenv:Header/> <soapenv:Body> <sch:AddUserRequest> <sch:firstname>tomek</sch:firstname> <sch:lastname>reda</sch:lastname> <sch:phoneNumber>123123123</sch:phoneNumber> <sch:password>password</sch:password> <sch:email>email@com.pl</sch:email> <sch:userRoles> <sch:id>1</sch:id> <sch:userRole>ADMIN</sch:userRole> </sch:userRoles> </sch:AddUserRequest> </soapenv:Body> </soapenv:Envelope>'";
  soapXMLUserCOnfig = "<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:tns=\"https://www.praca_magister/soap_vs_rest/users.com\"\n" +
    "           targetNamespace=\"https://www.praca_magister/soap_vs_rest/users.com\" elementFormDefault=\"qualified\">\n" +
    "    \n" +
    "    <xs:element name=\"AddUserRequest\">\n" +
    "        <xs:complexType>\n" +
    "            <xs:sequence>\n" +
    "                <xs:element name=\"firstname\" type=\"xs:string\"/>\n" +
    "                <xs:element name=\"lastname\" type=\"xs:string\"/>\n" +
    "                <xs:element name=\"email\" type=\"xs:string\"/>\n" +
    "                <xs:element name=\"phoneNumber\" type=\"xs:string\"/>\n" +
    "                <xs:element name=\"password\" type=\"xs:string\"/>\n" +
    "                <xs:element name=\"userRoles\" type=\"tns:UserRoles\"/>\n" +
    "            </xs:sequence>\n" +
    "        </xs:complexType>\n" +
    "    </xs:element>\n" +
    "\n" +
    "    <xs:complexType name=\"UserRoles\">\n" +
    "        <xs:sequence>\n" +
    "            <xs:element name=\"id\" type=\"xs:long\"/>\n" +
    "            <xs:element name=\"userRole\" type=\"tns:UserRoleEnum\"/>\n" +
    "        </xs:sequence>\n" +
    "    </xs:complexType>\n" +
    "\n" +
    "    <xs:simpleType name=\"UserRoleEnum\">\n" +
    "        <xs:restriction base=\"xs:string\">\n" +
    "            <xs:enumeration value=\"ADMIN\"/>\n" +
    "            <xs:enumeration value=\"CASUAL_USER\"/>\n" +
    "        </xs:restriction>\n" +
    "    </xs:simpleType>\n" +
    "\n" +
    "</xs:schema>";

  restJSON = "curl -d '{\"id\": \"\",\"firstname\": \"test\",\"lastname\": \"test\",\"email\": \"test0@op.pl\",\"phoneNumber\": 1231231,\"password\": \"GHJbnm123\",\"userRoles\": {\"id\": 1,\"userRole\": \"CASUAL_USER\"}}' -H 'Content-Type: application/json' localhost:8080/api/rest/user/add";
  restXML = "<div><?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
    "<root>\n" +
    "   <Id />\n" +
    "   <email>test0@op.pl</email>\n<br/>" +
    "   <firstname>test</firstname>\n<br/>" +
    "   <lastname>test</lastname>\n<br/>" +
    "   <password>GHJbnm123</password>\n" +
    "   <phoneNumber>1231231</phoneNumber>\n" +
    "   <userRoles>\n" +
    "      <id>1</id>\n" +
    "      <userRole>CASUAL_USER</userRole>\n" +
    "   </userRoles>\n" +
    "</root>" +
    "</div>";
  restHTML = "<table class=\"table table-bordered table-hover table-condensed\">\n" +
    "<thead><tr><th title=\"Field #1\">Id</th>\n" +
    "<th title=\"Field #2\">firstname</th>\n" +
    "<th title=\"Field #3\">lastname</th>\n" +
    "<th title=\"Field #4\">email</th>\n" +
    "<th title=\"Field #5\">phoneNumber</th>\n" +
    "<th title=\"Field #6\">password</th>\n" +
    "<th title=\"Field #7\">userRoles/id</th>\n" +
    "<th title=\"Field #8\">userRoles/userRole</th>\n" +
    "</tr></thead>\n" +
    "<tbody><tr>\n" +
    "<td> </td>\n" +
    "<td>test</td>\n" +
    "<td>test</td>\n" +
    "<td>test0@op.pl</td>\n" +
    "<td align=\"right\">1231231</td>\n" +
    "<td>GHJbnm123</td>\n" +
    "<td>1</td>\n" +
    "<td>CASUAL_USER</td>\n" +
    "</tr>\n" +
    "</tbody></table>";
  restTEXT = "Id \n" +
    "firstname test\n" +
    "lastname test\n" +
    "email test0@op.pl\n" +
    "phoneNumber 1231231\n" +
    "password GHJbnm123\n" +
    "userRoles\n" +
    "id 1\n" +
    "userRole CASUAL_USER\n";
  restYAML = "---\n" +
    "Id: ''\n" +
    "firstname: test\n" +
    "lastname: test\n" +
    "email: test0@op.pl\n" +
    "phoneNumber: 1231231\n" +
    "password: GHJbnm123\n" +
    "userRoles:\n" +
    "  id: 1\n" +
    "  userRole: CASUAL_USER\n";

  constructor() {
  }

  ngOnInit() {
  }

}
