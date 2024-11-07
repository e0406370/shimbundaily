import { Component, inject, OnInit } from '@angular/core';
import { ApiService } from './services/api.service';
import { ShimbunQuery } from './models/shimbun-query';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent implements OnInit {

  title: string = 'shimbundaily';
  
  testData = {
    language: 'japanese',
    query: {
      category: 'general',
      country: 'japan',
      language: 'japanese',
      startDate: '',
      endDate: '',
    } as ShimbunQuery
  };

  private apiSvc = inject(ApiService);

  ngOnInit(): void {
    this.apiSvc.retrieveAvailableCategories().then((categories) => {
      console.info(categories);
    });

    this.apiSvc.retrieveAvailableCountries().then((countries) => {
      console.info(countries);
    });

    this.apiSvc.retrieveAvailableLanguages().then((languages) => {
      console.info(languages);
    });

    this.apiSvc.retrieveLatestNews(this.testData.language).then((news) => {
      console.info(news);
      console.info(JSON.stringify(news));
    });

    this.apiSvc.retrieveNewsBySearch(this.testData.query).then((news) => {
      console.info(news);
      console.info(JSON.stringify(news));
    });
  }
}
