import {AfterContentInit, Component, ContentChildren, Input, OnInit, QueryList} from '@angular/core';

@Component({
  selector: 'app-sub-tab',
  template:
    '<div *ngIf="active"> <ng-content></ng-content> </div>'
})
export class SubTabComponent{
  @Input() title: string;

  active: boolean;

  constructor(){
    this.active = false;
  }
}

@Component({
  selector: 'app-sub-tabs',
  templateUrl: './sub-tabs.component.html',
  styleUrls: ['./sub-tabs.component.css']
})

export class SubTabsComponent implements AfterContentInit {
  @ContentChildren(SubTabComponent) subtabs: QueryList<SubTabComponent>;

  ngAfterContentInit(){
    this.subtabs.first.active= true;
  }

  activate(subtab){
    for(const subtab of this.subtabs.toArray()){
      subtab.active = false
    }
    subtab.active = true;
  }
}
