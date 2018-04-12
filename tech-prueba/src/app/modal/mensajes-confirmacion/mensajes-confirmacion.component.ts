import { Component, OnInit, Input, Inject } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import {TranslateService} from '@ngx-translate/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { Messages } from '../../dto/MessagesDto';
@Component({
  selector: 'app-mensajes-confirmacion',
  templateUrl: './mensajes-confirmacion.component.html',
  styleUrls: ['./mensajes-confirmacion.component.css']
})
export class MensajesConfirmacionComponent implements OnInit {

  private modalRef: any;
  messages: Messages = new Messages();
  constructor(

    public dialogRef: MatDialogRef<MensajesConfirmacionComponent>,
     @Inject(MAT_DIALOG_DATA) public data: Messages
    ) {}


  ngOnInit() {
   this.messages = this.data;
   this.messages.ngClass = this.selectorMessages(this.data.typeMessages);
  }

  selectorMessages(type: string): string {
    let varTemp = '';
    switch (type) {
      case 'success':
      varTemp = 'alert alert-success';
        break;
        case 'info':
        varTemp = 'alert alert-info';

        break;
        case 'warning':
        varTemp = 'alert alert-warning';

        break;
        case 'danger':
        varTemp = 'alert alert-danger';
        break;
    }
    return varTemp;

  }
  cerrar() {
    this.dialogRef.close();

  }
}
