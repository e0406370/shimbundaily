import { HttpClient, HttpParams } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { ShimbunArticle } from '../models/shimbun-article';
import { ShimbunQuery } from '../models/shimbun-query';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private httpClient = inject(HttpClient);

  public retrieveAvailableCategories(): Promise<any> {

    return firstValueFrom(this.httpClient.get<any>('/api/available/categories'));
  }

  public retrieveAvailableCountries(): Promise<any> {

    return firstValueFrom(this.httpClient.get<any>('/api/available/countries'));
  }

  public retrieveAvailableLanguages(): Promise<any> {

    return firstValueFrom(this.httpClient.get<any>('/api/available/languages'));
  }

  public retrieveLatestNews(language: string): Promise<ShimbunArticle[]> {

    const queryParams = new HttpParams()
      .set('language', language);

    return firstValueFrom(this.httpClient.get<ShimbunArticle[]>('/api/news/latest', { params: queryParams }));
  }

  public retrieveNewsBySearch(query: ShimbunQuery): Promise<ShimbunArticle[]> {
    
    const queryParams = new HttpParams()
      .set('category', query.category)
      .set('country', query.country)
      .set('language', query.language)
      .set('startDate', query.startDate)
      .set('endDate', query.endDate);

    return firstValueFrom(this.httpClient.get<ShimbunArticle[]>('/api/news/search', { params: queryParams }));
  }
}
