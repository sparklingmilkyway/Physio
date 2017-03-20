/**
 * Created by Jonas on 20.03.2017.
 */

import {BlogEntry} from'./blog-entry';
import {Component, Input} from '@angular/core';

@Component({
    moduleId: module.id,
    selector: 'app-blog-entry',
    templateUrl: 'blog-entry.component.html'
})
export class BlogEntryComponent{
    @Input() entry:BlogEntry;
}

