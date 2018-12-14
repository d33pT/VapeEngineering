import { Component, OnInit } from '@angular/core';
import {Product} from './product';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  products: Product[];

  constructor() { }// weiter hier!!!

  ngOnInit() {
  }

}
