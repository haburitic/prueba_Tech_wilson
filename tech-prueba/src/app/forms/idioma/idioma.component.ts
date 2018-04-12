import { Component, OnInit } from '@angular/core';
import {TranslateService} from '@ngx-translate/core';

@Component({
  selector: 'app-idioma',
  templateUrl: './idioma.component.html',
  styleUrls: ['./idioma.component.css']
})
export class IdiomaComponent implements OnInit {

  constructor(private translate: TranslateService) {
    translate.setDefaultLang('es');
    translate.use('es');

   }

  ngOnInit() {
  }

  changeLanguage(data: string) {
    this.translate.setDefaultLang(data);
    this.translate.use(data);
  }
}
