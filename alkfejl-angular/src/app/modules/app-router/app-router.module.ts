import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ShopViewComponent } from '../../components/shop-view/shop-view.component';
import { FamilyViewComponent } from '../../components/family-view/family-view.component';
import { FamilyMemberViewComponent } from '../../components/family-member-view/family-member-view.component';
import { LoginViewComponent } from '../../components/login-view/login-view.component';
import { FolderViewComponent } from '../../components/folder-view/folder-view.component';
import { TaskComponent } from '../../components/task/task.component';
import { RouteGuardService } from '../../services/route-guard.service';
import { AuthService } from '../../services/auth.service';

const appRoutes: Routes = [
  { path: '', canActivateChild: [RouteGuardService], children: [
    { path: '', component: ShopViewComponent },
    { path: 'family', component: FamilyViewComponent, data: { roles: ['USER', 'ADMIN'] } },
    { path: 'family/:id', component: FamilyMemberViewComponent, data: { roles: ['ADMIN'] } },
    { path: 'login', component: LoginViewComponent },
    { path: 'folder', component: FolderViewComponent },
    { path: 'folder/:id', component: TaskComponent }
  ]}
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ],
  declarations: [],
  providers: [RouteGuardService, AuthService]
})
export class AppRouterModule { }
