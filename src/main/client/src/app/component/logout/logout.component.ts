import {Component, OnInit} from '@angular/core';
import {ConfirmationService} from "primeng/primeng";

@Component({
  selector: 'logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private confirmationService: ConfirmationService) { }

  ngOnInit() {
  }

  //You can only use JavaScript to close a window/tab that was spawned via JavaScrip
  public logout() {
    this.confirmationService.confirm({
      message: 'Are you sure that you want to proceed?',
      header: 'Confirmation',
      icon: 'fa fa-question-circle',
      accept: () => {
        window.open('about:blank', '_self').close();
      },
    });
  }

}
