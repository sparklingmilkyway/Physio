import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {UserService} from "../../_services/user.service";
import {Therapeut} from "../../_classes/Therapeut";


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  moduleId: module.id,

})
export class HomeComponent implements OnInit {

  currentUser: Therapeut;
  users: Therapeut[] = [];

  constructor(private userService: UserService, private router : Router) {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  ngOnInit() {
    this.loadAllUsers();
  }

  deleteUser(id: number) {
    this.userService.delete(id).subscribe(() => { this.loadAllUsers() });
  }

  private loadAllUsers() {
    this.userService.getAll().subscribe(users => { this.users = users; });
  }


  login() {
    this.router.navigateByUrl("/login");
  }


}


