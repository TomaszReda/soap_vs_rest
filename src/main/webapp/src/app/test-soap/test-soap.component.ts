import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-test-soap',
  templateUrl: './test-soap.component.html',
  styleUrls: ['./test-soap.component.css']
})
export class TestSoapComponent implements OnInit {

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

  constructor() {
  }

  ngOnInit() {
  }


  onSubmit() {
  }

  addUserRest() {

  }

}
