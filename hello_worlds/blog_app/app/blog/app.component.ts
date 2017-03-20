import {BlogEntry} from'./blog-entry';
import {Component} from '@angular/core';

@Component({
  moduleId: module.id,
  selector: 'app-root',
  templateUrl: 'app.component.html'
})
export class AppComponent  {
    entries: Array<BlogEntry> = [];
    createBlogEntry(title: string, image: string, text: string) {
    let entry = new BlogEntry();
    entry.title = title;
    entry.image = image;
    entry.text = text;
    this.entries.push(entry);
  }
}

