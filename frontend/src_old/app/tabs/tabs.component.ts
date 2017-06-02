import {AfterContentInit, Component, ContentChildren, Input, OnInit, QueryList} from '@angular/core';

@Component({
  selector: 'app-tab',
  template:
            '<div *ngIf="active"> <ng-content></ng-content> </div>'
})
export class TabComponent{
  @Input() title: string;

  active: boolean;

  constructor(){
    this.active = false;
  }
}

@Component({
  selector: 'app-tabs',
  templateUrl: 'tabs.component.html'
})

export class TabsComponent implements AfterContentInit{
  @ContentChildren(TabComponent) tabs: QueryList<TabComponent>;

  ngAfterContentInit(){
    this.tabs.first.active= true;
  }

  activate(tab){
    for(const tab of this.tabs.toArray()){
      tab.active = false
    }
    tab.active = true;
  }
}

