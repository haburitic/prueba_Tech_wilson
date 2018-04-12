import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';
import { environment } from '../../environments/environment';
import { EmpleadoDto } from '../dto/empleado';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class EmpleadoService {

  private Url = environment.host;


  constructor(
    private http: HttpClient,
  ) { }


    /** GET Producto by id. Will 404 if id not found */
    getAll(): Observable<EmpleadoDto[]> {
      const url = this.Url + 'consultar/empleados';
      return this.http.get<EmpleadoDto[]>(url).pipe(
        tap(_ => this.log(`fetched EmpleadoDto `)),
        catchError(this.handleError<EmpleadoDto[]>(`getAllEmpleados EmpleadoDto `))
      );
    }


  private log(message: string) {
  }

  /** POST: add a new Producto to the server */
  add(data: EmpleadoDto): Observable<EmpleadoDto> {
    return this.http.post<EmpleadoDto>(this.Url + 'guardar/empleado', data, httpOptions).pipe(
      tap((t: EmpleadoDto) => this.log('add')),
      catchError(this.handleError<EmpleadoDto>('add'))
    );
  }

  /** PUT: update the element on the server */
  update(data: EmpleadoDto): Observable<any> {
    return this.http.put(this.Url, data, httpOptions).pipe(
      tap(_ => this.log(`updated Producto id=${data.id}`)),
      catchError(this.handleError<any>('updateEmpleadoDto'))
    );
  }

  /** POST: add a new Element to the server */
  procesarCarga(data: EmpleadoDto): Observable<EmpleadoDto> {
    return this.http.post<EmpleadoDto>(this.Url + 'guardar EmpleadoDto', data, httpOptions).pipe(
      tap((t: EmpleadoDto) => this.log('added EmpleadoDto')),
      catchError(this.handleError<EmpleadoDto>('add EmpleadoDto'))
    );
  }

  /** DELETE: delete  from the server */
  delete(t: EmpleadoDto | number): Observable<EmpleadoDto> {
    const id = typeof t === 'number' ? t : t.id;
    const url = `${this.Url}/${id}`;

    return this.http.delete<EmpleadoDto>(url, httpOptions).pipe(
      tap(_ => this.log(`deleted Producto id=${id}`)),
      catchError(this.handleError<EmpleadoDto>('deleteProducto'))
    );
  }

  /**
 * Handle Http operation that failed.
 * Let the app continue.
 * @param operation - name of the operation that failed
 * @param result - optional value to return as the observable result
 */
private handleError<T>(operation = 'operation', result?: T) {
  return (error: any): Observable<T> => {

    // TODO: send the error to remote logging infrastructure
    console.error(error); // log to console instead

    // TODO: better job of transforming error for user consumption
    this.log(`${operation} failed: ${error.message}`);

    // Let the app keep running by returning an empty result.
    return of(result as T);
  };
}
}
