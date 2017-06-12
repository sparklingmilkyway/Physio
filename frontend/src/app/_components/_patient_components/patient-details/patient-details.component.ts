import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PatientService} from "../../../_services/patient.service";

@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.css'],
  providers: [PatientService]
})
export class PatientDetailsComponent implements OnInit {

  id: number;
  private sub: any;


  constructor(private route: ActivatedRoute, private patientService: PatientService, private router: Router) {}

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id'];

      this.patientService.getPatient(this.id).subscribe(data => this.sub = data);

    });
  }

  goBack() {
    this.router.navigateByUrl('/patient');
  }

  change() {
  }
}
