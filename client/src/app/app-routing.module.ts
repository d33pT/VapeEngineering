import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {PostComponent} from './post/post.component';
import {ConfiguratorComponent} from './configurator/configurator.component';
import {AboutUsComponent} from './aboutUs/about-us.component';

const routes: Routes = [
  {path: 'post', component: PostComponent},
  {path: 'configurator', component: ConfiguratorComponent},
  {path: 'aboutUs', component: AboutUsComponent},
  // {path: 'forum', component: ForumComponent}
  /*{path: 'infos', component: InfoComponent}*/
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
