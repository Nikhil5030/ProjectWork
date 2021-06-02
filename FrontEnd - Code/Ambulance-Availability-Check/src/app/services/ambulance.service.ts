import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ambulance } from '../Model/ambulance';

@Injectable({
  providedIn: 'root'
})
export class AmbulanceService {

  baseUrl = 'http://localhost:8040/api/ambulances';

  constructor(private httpClient: HttpClient) {}

  getAllAmbulances(): Observable<Ambulance[]>{
    return this.httpClient.get<Ambulance[]>(this.baseUrl);
  }

  insertAmbulance(ambulance:Ambulance): Observable<Ambulance> {
    return this.httpClient.post<Ambulance>(this.baseUrl,ambulance);
  }
  getAmbulanceById(id:number): Observable<Ambulance>{
   return this.httpClient.get<Ambulance>(this.baseUrl+'/'+id);
  }

  deleteAmbulanceById(id:number): Observable<Ambulance>{
   return this.httpClient.delete<Ambulance>(this.baseUrl+'/'+id);
  }

  updateAmbulance(ambulance: Ambulance): Observable<Ambulance> {
   return this.httpClient.put<Ambulance>(this.baseUrl,ambulance);
  } 
}
