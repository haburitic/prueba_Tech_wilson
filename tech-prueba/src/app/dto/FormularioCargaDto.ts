import { DateDto } from './DateDto';
import { EmpleadoDto } from '../dto/empleado';
import { DatosCargaDto } from './DatosCarga';

export class FormularioCargaDto {
  public empleadoSeleccionado: EmpleadoDto = new EmpleadoDto();
  public listaCarga: string[];
  listaEmpleados: EmpleadoDto[];
  datosRespuestaCarga: DatosCargaDto[];
  constructor( ) { }
}
