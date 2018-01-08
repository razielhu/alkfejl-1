import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import { Task } from '../../classes/Task';

@Component({
  selector: 'app-tasklist',
  templateUrl: './tasklist.component.html',
  styleUrls: ['./tasklist.component.css']
})
export class TasklistComponent implements OnInit {
  @Input()
  public tasks: Task[];
  
  constructor() { }

  ngOnInit() {
  }

}
