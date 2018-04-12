import * as moment from 'moment';
import { FormatDate } from '../enums/format-date.enum';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';

export class DateDto {
    public fecha: NgbDateStruct;

  constructor( ) {}

  formatearDate(): Date {
    const date: string = moment(this.fecha.year + '-' + this.fecha.month + '-' + this.fecha.day).format(FormatDate.YYYY_MM_DD);
     return new Date(date);
  }

  ingresarDate(data: Date): void {
    const temp = moment(data);
    this.fecha = { day: temp.dayOfYear(), month: temp.month(), year: temp.year()};

  }

}
