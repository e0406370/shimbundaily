import { Component, inject } from '@angular/core';
import { ApiService } from './services/api.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
  
export class AppComponent {

  title = "shimbundaily";

  private apiSvc = inject(ApiService);

  ngOnInit(): void {

    this.apiSvc.retrieveAvailableCategories()
      .then(categories => {
        console.info(categories);
      })
    
    this.apiSvc.retrieveAvailableCountries()
      .then(countries => {
        console.info(countries);
      })
    
    this.apiSvc.retrieveAvailableLanguages()
      .then(languages => {
        console.info(languages);
      })
  }
}
