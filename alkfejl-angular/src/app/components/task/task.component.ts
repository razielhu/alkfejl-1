import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Task } from '../../classes/task';
import { TaskService } from '../../services/task.service';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css'],
  providers: [TaskService]
})
export class TaskComponent implements OnInit {
  @Input()
  public task: Task;

  constructor(
    private taskService: TaskService
  ) { 
    console.log("Task: "+ this.task);
  }

  ngOnInit() {
  }

}
