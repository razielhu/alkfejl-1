import { Component, OnInit } from '@angular/core';
import { Task } from '../../classes/task';
import { Folder } from '../../classes/folder';
import { FolderService } from '../../services/folder.service';
import { TaskService } from '../../services/task.service';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-folder-view',
  templateUrl: './folder-view.component.html',
  styleUrls: ['./folder-view.component.css'],
  providers: [FolderService, TaskService, AuthService]
})
export class FolderViewComponent implements OnInit {
  
  private _folder: Folder[];
  private _task: Task[];

  public addTask(folder: Folder, task: Task): void {
    this.taskService.addTask(folder, task).subscribe(() => {
      this.taskService.getTasks().subscribe((tasks: Task[]) => {
        this._task = tasks;
      });
    });
  }

  constructor(
    private taskService: TaskService,
    private folderService: FolderService,
    private authService: AuthService,
  ) { }

  ngOnInit() {
    this.folderService.getFolders().subscribe((folder: Folder[]) => {
      this._folder = folder;
    });
    this.taskService.getTasks().subscribe((task: Task[]) => {
      this._task = task;
    });
  }

}

