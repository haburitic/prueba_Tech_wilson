import { EmpleadoDto } from '../dto/empleado';

export class ElementosCargaDto {
  public id: number;
  public empleado: EmpleadoDto;
  public lista: string[];
constructor( ) { }
}
