import { Pipe, PipeTransform } from '@angular/core';
import * as moment from 'moment';
import { FormatDate } from '../../enums/format-date.enum';

@Pipe({
  name: 'formatDate'
})
export class FormatDatePipe implements PipeTransform {

  transform(value: any, args?: any): string {
    return  moment(value).format(FormatDate.YYYY_MM_DD)
    ;
  }

}
