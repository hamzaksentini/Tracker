import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AccountService} from "../_services/account.service";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit, OnDestroy {

  account: any;
  isDepositSucceeded: any;
  isWithdrawSucceeded: any;
  private sub: any;

  depositForm: any = {
    amount: null,
    label: null
  };

  withdrawForm: any = {
    amount: null,
    label: null
  };

  constructor(private _route: ActivatedRoute, private accountService: AccountService) {
  }

  ngOnInit() {
    this.sub = this._route.params.subscribe(params => {
      let accountId = +params['id'];
      this.loadAccount(accountId);
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }


  onDeposit(): void {
    const {amount, label} = this.depositForm;
    this.accountService.deposit(amount, label, this.account.id).subscribe(
      data => {
        this.loadAccount(this.account.id)
        this.isDepositSucceeded = true;
      },
      err => {

      }
    );
  }

  onWithdraw(): void {
    const {amount, label} = this.depositForm;
    this.accountService.withdraw(amount, label, this.account.id).subscribe(
      data => {
        this.loadAccount(this.account.id)
        this.isWithdrawSucceeded = true;
      },
      err => {

      }
    );
  }

  loadAccount(accountId: any) {
    this.accountService.getAccount(accountId).subscribe(
      data => {
        this.account = data;
      },
      err => {
        this.account = JSON.parse(err.error).message;
      }
    );
  }
}
