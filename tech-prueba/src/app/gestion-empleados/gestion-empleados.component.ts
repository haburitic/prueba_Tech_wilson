import { Component, OnInit } from '@angular/core';
import { FormularioEmpleadoDto} from '../dto/FormularioEmpleadosDto';
import { EmpleadoService } from '../servicios/empleado.service';
import { EmpleadoDto } from '../dto/empleado';
import { ToastContainerDirective, ToastrService } from 'ngx-toastr';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-gestion-empleados',
  templateUrl: './gestion-empleados.component.html',
  styleUrls: ['./gestion-empleados.component.css']
})
export class GestionEmpleadosComponent implements OnInit {
  msgError: any;
public formularioEmpleadoDto: FormularioEmpleadoDto = new FormularioEmpleadoDto();


  constructor(private empleadoService: EmpleadoService,
    private toastr: ToastrService,
    private translateService: TranslateService

  ) { }
  empleadoDto: EmpleadoDto =  new EmpleadoDto();

  ngOnInit() {
  }
  guardar() {
    this.empleadoService.add(this.armarDto()).
    subscribe(
      rt => {
        this.mensajeGuardado(rt);
      },
      error => this.msgError = <any>error,
      () => console.log('Terminado'),
    );
  }

  mensajeGuardado(data) {
    this.toastr.success(this.translateService.instant('app.messages.confirmation'));
    this.limpiar();
  }

  armarDto(): EmpleadoDto {
    this.empleadoDto.identificacion = this.formularioEmpleadoDto.nombreCargo;
    this.empleadoDto.nombre = this.formularioEmpleadoDto.nombreEmpleado;
    return this.empleadoDto;
  }

  limpiar() {
    this.formularioEmpleadoDto.nombreCargo = '';
    this.formularioEmpleadoDto.nombreEmpleado = '';
  }
}
