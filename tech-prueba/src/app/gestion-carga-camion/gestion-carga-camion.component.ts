import { FormularioCargaDto } from '../dto/FormularioCargaDto';
import { Component, OnInit } from '@angular/core';
import { CargaService } from '../servicios/carga.service';
import { ElementosCargaDto } from '../dto/ElementosCarga';
import { EmpleadoService } from '../servicios/empleado.service';
import { EmpleadoDto } from '../dto/empleado';

@Component({
  selector: 'app-gestion-carga-camion',
  templateUrl: './gestion-carga-camion.component.html',
  styleUrls: ['./gestion-carga-camion.component.css']
})
export class GestionCargaCamionComponent implements OnInit {
  formularioCargoDto: FormularioCargaDto = new FormularioCargaDto();
  dto: ElementosCargaDto = new ElementosCargaDto();
  constructor(
    private cargaService: CargaService,
    private empleadoService: EmpleadoService
  ) {}
  msgError: string;

  ngOnInit() {
    this.cargarEmpleados();
  }

  imageChange(input) {
    if (input.target.files.length === 0) {
      this.formularioCargoDto.listaCarga = [];
      this.formularioCargoDto.empleadoSeleccionado = null;

      return;
    }
    // Create a FileReader
    const reader = new FileReader();

    // Add an event listener to deal with the file when the reader is complete
    reader.addEventListener('load',
      (event: any) => {
        const file_src = event.target.result;
        this.formularioCargoDto.listaCarga = file_src.split('\n');
      },
      false
    );

    reader.readAsBinaryString(input.target.files[0]);
  }

  procesar() {
    this.cargaService
      .procesarCarga(this.armarDto())
      .subscribe(
        rt => (this.formularioCargoDto.datosRespuestaCarga = rt),
        error => (this.msgError = <any>error),
        () => console.log('Terminado')
      );
  }

  armarDto(): ElementosCargaDto {
    this.dto.empleado = this.formularioCargoDto.empleadoSeleccionado;
    this.dto.lista = this.formularioCargoDto.listaCarga;
    return this.dto;
  }

  cargarEmpleados() {
    this.empleadoService
      .getAll()
      .subscribe(
        listaEmpleados =>
          (this.formularioCargoDto.listaEmpleados = listaEmpleados),
        error => (this.msgError = <any>error)
      );
  }

  limpiarForm() {
    this.formularioCargoDto = new FormularioCargaDto();

  }
}
