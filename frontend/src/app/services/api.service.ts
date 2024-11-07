import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
  
export class ApiService {

  private httpClient = inject(HttpClient);

  public retrieveAvailableCategories(): Promise<any> {
    
    return firstValueFrom(this.httpClient.get<any>("/api/available/categories"));
  }

  public retrieveAvailableCountries(): Promise<any> {
    
    return firstValueFrom(this.httpClient.get<any>("/api/available/countries"));
  }

  public retrieveAvailableLanguages(): Promise<any> {
    
    return firstValueFrom(this.httpClient.get<any>("/api/available/languages"));
  }
}
