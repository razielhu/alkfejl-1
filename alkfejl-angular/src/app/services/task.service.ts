import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Task } from '../classes/task';
import { Folder } from '../classes/folder';
import { api } from '../config/api';

@Injectable()
export class TaskService {

  constructor(
    private httpClient: HttpClient
  ) { }

  public addTask(folder: Folder, task: Task): Observable<any> {
    return this.httpClient.post(api + 'task/add', {folder,task});
  }

  public getTasks(): Observable<Task[]> {
    return this.httpClient.get(api + 'folder' + "/list");
  }
}
