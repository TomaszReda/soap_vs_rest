import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-dane',
  templateUrl: './dane.component.html',
  styleUrls: ['./dane.component.css']
})
export class DaneComponent implements OnInit {


  soapWsdl = '<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:tns="https://www.praca_magister/soap_vs_rest/users.com"\n' +
    '           targetNamespace="https://www.praca_magister/soap_vs_rest/users.com" elementFormDefault="qualified">\n' +
    '    <xs:element name="GetUserRequest">\n' +
    '        <xs:complexType>\n' +
    '            <xs:sequence>\n' +
    '                <xs:element name="page" type="xs:int"/>\n' +
    '                <xs:element name="size" type="xs:int"/>\n' +
    '                <xs:element name="lastname" type="xs:string" />\n' +
    '                <xs:element name="firstname" type="xs:string"/>\n' +
    '\n' +
    '            </xs:sequence>\n' +
    '        </xs:complexType>\n' +
    '    </xs:element>\n' +
    '\n' +
    '    <xs:element name="GetUserResponse">\n' +
    '        <xs:complexType>\n' +
    '            <xs:sequence>\n' +
    '                <xs:element name="size" type="xs:int"/>\n' +
    '                <xs:element name="totalPages" type="xs:int"/>\n' +
    '                <xs:element name="number" type="xs:int"/>\n' +
    '                <xs:element name="numberOfElements" type="xs:int"/>\n' +
    '                <xs:element name="totalElements" type="xs:long"/>\n' +
    '                <xs:element name="User" type="tns:User" minOccurs="0" maxOccurs="unbounded"/>\n' +
    '            </xs:sequence>\n' +
    '        </xs:complexType>\n' +
    '    </xs:element>\n' +
    '\n' +
    '\n' +
    '    <xs:complexType name="User">\n' +
    '        <xs:sequence>\n' +
    '            <xs:element name="id" type="xs:long"/>\n' +
    '            <xs:element name="firstname" type="xs:string"/>\n' +
    '            <xs:element name="lastname" type="xs:string"/>\n' +
    '            <xs:element name="email" type="xs:string"/>\n' +
    '            <xs:element name="phoneNumber" type="xs:string"/>\n' +
    '            <xs:element name="password" type="xs:string"/>\n' +
    '            <xs:element name="userRoles" type="tns:UserRoles"/>\n' +
    '        </xs:sequence>\n' +
    '    </xs:complexType>\n' +
    '\n' +
    '\n' +
    '    <xs:complexType name="UserRoles">\n' +
    '        <xs:sequence>\n' +
    '            <xs:element name="id" type="xs:long"/>\n' +
    '            <xs:element name="userRole" type="tns:UserRoleEnum"/>\n' +
    '        </xs:sequence>\n' +
    '    </xs:complexType>\n' +
    '\n' +
    '\n' +
    '    <xs:simpleType name="UserRoleEnum">\n' +
    '        <xs:restriction base="xs:string">\n' +
    '            <xs:enumeration value="ADMIN"/>\n' +
    '            <xs:enumeration value="CASUAL_USER"/>\n' +
    '        </xs:restriction>\n' +
    '    </xs:simpleType>\n' +
    '</xs:schema>';

  soapCOntrooler='   @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetBookRequest")\n' +
    '    @ResponsePayload\n' +
    '    public soap.GetBookResponse getBook(@RequestPayload soap.GetBookRequest request) {\n' +
    '        return bookServiceSoap.getBook(request);\n' +
    '    }';

  restController = '    @GetMapping("/find")\n' +
    '    public ResponseEntity<Page<Book>> find(Pageable pageable, Predicate predicate) {\n' +
    '        return bookService.find(pageable, predicate);\n' +
    '    }\n';


  constructor() {
  }

  ngOnInit() {
  }

}
