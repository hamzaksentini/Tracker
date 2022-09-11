import {Component, OnInit} from '@angular/core';
import {AccountService} from "../_services/account.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-board-client',
  templateUrl: './board-client.component.html',
  styleUrls: ['./board-client.component.css']
})
export class BoardClientComponent implements OnInit {

  accounts?: Array<any>;

  constructor(private accountService: AccountService, private _router: Router) {
  }

  ngOnInit(): void {
    this.accountService.getAccounts().subscribe(
      data => {
        this.accounts = data;
      },
      err => {
        this.accounts = JSON.parse(err.error).message;
      }
    );
  }

  openAccountDetails(accountId: number): void {
    this._router.navigate([`account/${accountId}`]);
  }

}
