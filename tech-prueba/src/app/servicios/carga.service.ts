import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ToastContainerDirective, ToastrService } from 'ngx-toastr';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';
import { environment } from '../../environments/environment';
import { DatosCargaDto } from '../dto/DatosCarga';
import { ElementosCargaDto } from '../dto/ElementosCarga';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class CargaService {

  private Url = environment.host;


  constructor(
    private http: HttpClient,
    private toastrService: ToastrService
  ) { }


  /**
 * Handle Http operation that failed.
 * Let the app continue.
 * @param operation - name of the operation that failed
 * @param result - optional value to return as the observable result
 */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      this.toastrService.error(error.status + ' ' + error.error, 'validación');

      this.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }

  /** GET Producto by id. Will 404 if id not found */
  getCarga(id: number): Observable<DatosCargaDto> {
    const url = `${this.Url}/${id}`;
    return this.http.get<DatosCargaDto>(url).pipe(
      tap(_ => this.log(`fetched Producto id=${id}`)),
      catchError(this.handleError<DatosCargaDto>(`getProducto id=${id}`))
    );
  }

  private log(message: string) {
  }




  /** POST: add a new Producto to the server */
  procesarCarga(data: ElementosCargaDto): Observable<DatosCargaDto[]> {
    return this.http.post<DatosCargaDto[]>(this.Url + 'gestionCarga/procesar', data, httpOptions).pipe(
      tap((t: DatosCargaDto[]) => this.log('gestionCarga/procesar')),
      catchError(this.handleError<DatosCargaDto[]>('gestionCarga/procesar'))
    );
  }

  /** DELETE: delete the Producto from the server */
  deleteProducto(t: DatosCargaDto | number): Observable<DatosCargaDto> {
    const id = typeof t === 'number' ? t : t.id;
    const url = `${this.Url}/${id}`;

    return this.http.delete<DatosCargaDto>(url, httpOptions).pipe(
      tap(_ => this.log(`deleted Producto id=${id}`)),
      catchError(this.handleError<DatosCargaDto>('deleteProducto'))
    );
  }

  /* GET Productoes whose name contains search term */
  searchProductoes(term: string): Observable<DatosCargaDto[]> {
    if (!term.trim()) {
      // if not search term, return empty Producto array.
      return of([]);
    }
    return this.http.get<DatosCargaDto[]>(`api/Productoes/?name=${term}`).pipe(
      tap(_ => this.log(`found Productoes matching '${term}'`)),
      catchError(this.handleError<DatosCargaDto[]>('searchProductoes', []))
    );
  }

}
