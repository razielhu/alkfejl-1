import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { UiModule } from './modules/ui/ui.module';
import { AppRouterModule } from './modules/app-router/app-router.module';
import { HttpClientModule } from '@angular/common/http'; 

import { AppComponent } from './app.component';
import { ShoplistComponent } from './components/shoplist/shoplist.component';
import { AddformComponent } from './components/addform/addform.component';
import { ShopitemComponent } from './components/shopitem/shopitem.component';
import { FamilyViewComponent } from './components/family-view/family-view.component';
import { ShopViewComponent } from './components/shop-view/shop-view.component';
import { FamilyMemberViewComponent } from './components/family-member-view/family-member-view.component';
import { LoginViewComponent } from './components/login-view/login-view.component';
import { FolderViewComponent } from './components/folder-view/folder-view.component';
import { TasklistComponent } from './components/tasklist/tasklist.component';
import { TaskComponent } from './components/task/task.component';
import { NewtaskComponent } from './components/newtask/newtask.component';

@NgModule({
  declarations: [
    AppComponent,
    ShoplistComponent,
    AddformComponent,
    ShopitemComponent,
    FamilyViewComponent,
    ShopViewComponent,
    FamilyMemberViewComponent,
    LoginViewComponent,
    FolderViewComponent,
    TasklistComponent,
    TaskComponent,
    NewtaskComponent,
  ],
  imports: [
    BrowserModule, 
    UiModule,
    AppRouterModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
