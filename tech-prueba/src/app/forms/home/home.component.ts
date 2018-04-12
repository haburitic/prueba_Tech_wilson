import { Component, ElementRef, ViewChild, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
    lista: string[];

  title = 'file reader';
  observableBatch: any = [];
  constructor() {
  }

  imageChange(input) {

    // Create a FileReader
    const reader = new FileReader();

    // Add an event listener to deal with the file when the reader is complete
    reader.addEventListener('load', (event: any) => {
      const file_src = event.target.result;
      this.lista = file_src.split('\n');
      }, false);

    reader.readAsBinaryString(input.target.files[0]);
  }
}
