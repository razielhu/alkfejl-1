import { Injectable } from '@angular/core';
import { Folder } from '../classes/folder';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { api } from '../config/api';

@Injectable()
export class FolderService {

  constructor(
    private httpClient: HttpClient
  ) { }

  public getFolders(): Observable<Folder[]> {
    return this.httpClient.get(api + 'folder');
  }

  public getFolder(id: number): Observable<Folder> {
    return this.httpClient.get(api + 'folder/' + id);
  }

}
