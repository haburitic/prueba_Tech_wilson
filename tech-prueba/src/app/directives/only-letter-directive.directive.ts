import { Directive, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Validator, AbstractControl, Validators, NG_VALIDATORS } from '@angular/forms';

/**
 * This validator works like "required" but it does not allow whitespace either
 *
 * @export
 * @class NoWhitespaceDirective
 * @implements {Validator}
 */

@Directive({
    selector: '[appOnlyletter]',
    providers: [{ provide: NG_VALIDATORS, useExisting: OnlyLetterDirective, multi: true }]
})
export class OnlyLetterDirective  {

    validate(control: AbstractControl): { [key: string]: any } {
      let datos = '';
      const valido = /^[a-zA-Z\s]*$/.test(control.value);
      if (!valido) {
        datos = control.value.match(/[a-zA-Z]$/);
        control.setValue(datos);
      }
        return null;
    }
}
