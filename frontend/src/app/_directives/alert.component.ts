import { Component } from '@angular/core';

import { AlertService } from '../_services/index';

@Component({
    moduleId: module.id,
    selector: 'alert',
    templateUrl: 'alert.component.html'
})


/**
 * The alert component passes alert messages to the template whenever a message is received from the alert service.
 * It does this by subscribing to the alert service's getMessage() method which returns an Observable.
 * */
 export class AlertComponent {
    message: any;

    constructor(private alertService: AlertService) { }

    ngOnInit() {
        this.alertService.getMessage().subscribe(message => { this.message = message; });
    }
}
