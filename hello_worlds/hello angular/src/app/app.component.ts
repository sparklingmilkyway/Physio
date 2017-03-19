import { Component } from '@angular/core';

@Component({
  selector: 'This is the selector of app.comenent.ts',
  template: `<h1>Hello {{name}}</h1>`,
})
export class AppComponent  { name = 'Angular-World!'; }
